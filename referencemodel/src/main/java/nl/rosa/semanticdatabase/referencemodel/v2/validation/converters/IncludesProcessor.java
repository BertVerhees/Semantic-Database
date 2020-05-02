package nl.rosa.semanticdatabase.referencemodel.v2.validation.converters;


import nl.rosa.semanticdatabase.message.MessageLogger;
import nl.rosa.semanticdatabase.referencemodel.persistence.validation.MessageIds;
import nl.rosa.semanticdatabase.referencemodel.v2.persistence.IncludeSpec;
import nl.rosa.semanticdatabase.referencemodel.v2.persistence.PClass;
import nl.rosa.semanticdatabase.referencemodel.v2.persistence.PPackage;
import nl.rosa.semanticdatabase.referencemodel.v2.persistence.PSchema;
import nl.rosa.semanticdatabase.referencemodel.v2.validation.Repository;
import nl.rosa.semanticdatabase.referencemodel.v2.validation.SchemaConverter;
import nl.rosa.semanticdatabase.referencemodel.v2.validation.ValidationResult;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class IncludesProcessor {

    public List<String> getIncludeIds(PSchema schema) {

        return schema.getIncludes().values().stream()
                .map( includeSpec -> includeSpec.getId()).collect(Collectors.toCollection(ArrayList::new));
    }

    public void cloneSchemaAndAddIncludes(ValidationResult validationResult, Repository repository, MessageLogger logger) {
        //step 1: check that all includes exist
        PSchema schema = validationResult.getOriginalSchema();
        for(IncludeSpec include: schema.getIncludes().values()) {
            if(!repository.containsPersistentSchema(include.getId())) {
                logger.addError(MessageIds.ec_schema_included_schema_not_found, include.getId());
            }
        }

        if(!logger.hasErrors()) {
            PSchema clone = (PSchema) schema.clone();
            validationResult.setSchemaWithMergedIncludes(clone);
            //step 2: get all BMM Models for all includes and merge into BmmModel
            for (IncludeSpec include : schema.getIncludes().values()) {
                //check if already included. If so, don't include again.
                // This prevents double includes plus a potential infinite loop
                if(!validationResult.getMergedSchemas().contains(include.getId()) || validationResult.getFailedMergedSchemas().contains(include.getId())) {

                    ValidationResult included = repository.getModel(include.getId());
                    if(included == null) {
                        PSchema persistentSchema = repository.getPersistentSchema(include.getId());
                        SchemaConverter bmmSchemaConverter = new SchemaConverter(repository);
                        included = bmmSchemaConverter.validateConvertAndAddToRepo(persistentSchema);
                    }
                    if(!included.passes()) {
                        logger.addError(MessageIds.ec_schema_includes_valiidation_failed, schema.getSchemaId(), included.getLogger().toString());
                        validationResult.addFailedMerge(include.getId());
                    } else {
                        mergeIncluded(validationResult, included);
                    }
                }
            }
        }
    }

    private void mergeIncluded(ValidationResult includingValidationResult, ValidationResult includedValidation) {
        PSchema including = includingValidationResult.getSchemaWithMergedIncludes();
        PSchema included = includedValidation.getSchemaWithMergedIncludes();
        //archetype parent class: only merge if nothing already in the higher-level schema
        if(included.getArchetypeParentClass() != null &&  including.getArchetypeParentClass() == null) {
            including.setArchetypeParentClass(included.getArchetypeParentClass());
        }

        //archetype data value parent class: only merge if nothing already in the higher-level schema
        if(included.getArchetypeDataValueParentClass() != null && including.getArchetypeDataValueParentClass() == null) {
            including.setArchetypeDataValueParentClass(including.getArchetypeDataValueParentClass());
        }

        //archetype closures
        LinkedHashSet<String> newClosurePackages = new LinkedHashSet<>();
        newClosurePackages.addAll(included.getArchetypeRmClosurePackages());
        newClosurePackages.addAll(including.getArchetypeRmClosurePackages());
        included.setArchetypeRmClosurePackages(new ArrayList<>(newClosurePackages));

        for(Map.Entry<String, PPackage> packageEntry:includedValidation.getCanonicalPackages().entrySet()) {
            if(includingValidationResult.getCanonicalPackages().containsKey(packageEntry.getKey())) {
                PPackage persistedBmmPackage = includingValidationResult.getCanonicalPackages().get(packageEntry.getKey());
                merge(persistedBmmPackage, packageEntry.getValue());
            } else {
                includingValidationResult.getCanonicalPackages().put(packageEntry.getKey(), (PPackage) packageEntry.getValue().clone());
            }
        }

        //If a package already exist, merge its classes, for each child package repeat...
        //Merge class definitions first. If you see a class with the same name, log it (complain) - OpenEHR has no notion of namespaces. Need to fix spec to support them.
        //this automatically includes primitive types
        for(String className:included.getClassDefinitions().keySet()) {
            PClass bmmClass = included.getClassDefinitions().get(className);
            including.getClassDefinitions().put(className, (PClass) bmmClass.clone());
        }
        for(String primitiveTypeName:included.getPrimitiveTypes().keySet()) {
            PClass pClass = included.getPrimitiveTypes().get(primitiveTypeName);
            including.getPrimitiveTypes().put(primitiveTypeName, (PClass) pClass.clone());
        }

        includingValidationResult.addMergedSchema(included.getSchemaId().toUpperCase());


    }

    private void merge(PPackage including, PPackage included) {
        LinkedHashSet<String> newClasses = new LinkedHashSet<>(including.getClasses());
        newClasses.addAll(included.getClasses());
        including.setClasses(new ArrayList<>(newClasses));
        included.getPackages().values().forEach(p -> {
            PPackage sourcePackage = including.getPackages().get(p.getName());
            if(sourcePackage != null) {
                merge(sourcePackage, p);
            } else {
                including.getPackages().put(p.getName().toUpperCase(), (PPackage) p.clone());
            }
        });
    }
}
