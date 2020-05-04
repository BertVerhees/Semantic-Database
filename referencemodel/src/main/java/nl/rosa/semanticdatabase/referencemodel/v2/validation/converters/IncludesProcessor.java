package nl.rosa.semanticdatabase.referencemodel.v2.validation.converters;


import nl.rosa.semanticdatabase.message.MessageLogger;
import nl.rosa.semanticdatabase.referencemodel.persistence.validation.MessageIds;
import nl.rosa.semanticdatabase.referencemodel.v2.persistence.IncludeSpec;
import nl.rosa.semanticdatabase.referencemodel.v2.persistence.PRMClass;
import nl.rosa.semanticdatabase.referencemodel.v2.persistence.PRMPackage;
import nl.rosa.semanticdatabase.referencemodel.v2.persistence.PRMSchema;
import nl.rosa.semanticdatabase.referencemodel.v2.validation.RMRepository;
import nl.rosa.semanticdatabase.referencemodel.v2.validation.RMSchemaConverter;
import nl.rosa.semanticdatabase.referencemodel.v2.validation.RMValidationResult;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class IncludesProcessor {

    public List<String> getIncludeIds(PRMSchema schema) {

        return schema.getIncludes().values().stream()
                .map( includeSpec -> includeSpec.getId()).collect(Collectors.toCollection(ArrayList::new));
    }

    public void cloneSchemaAndAddIncludes(RMValidationResult RMValidationResult, RMRepository RMRepository, MessageLogger logger) {
        //step 1: check that all includes exist
        PRMSchema schema = RMValidationResult.getOriginalSchema();
        for(IncludeSpec include: schema.getIncludes().values()) {
            if(!RMRepository.containsPersistentSchema(include.getId())) {
                logger.addError(MessageIds.ec_schema_included_schema_not_found, include.getId());
            }
        }

        if(!logger.hasErrors()) {
            PRMSchema clone = (PRMSchema) schema.clone();
            RMValidationResult.setSchemaWithMergedIncludes(clone);
            //step 2: get all BMM Models for all includes and merge into BmmModel
            for (IncludeSpec include : schema.getIncludes().values()) {
                //check if already included. If so, don't include again.
                // This prevents double includes plus a potential infinite loop
                if(!RMValidationResult.getMergedSchemas().contains(include.getId()) || RMValidationResult.getFailedMergedSchemas().contains(include.getId())) {

                    RMValidationResult included = RMRepository.getModel(include.getId());
                    if(included == null) {
                        PRMSchema persistentSchema = RMRepository.getPersistentSchema(include.getId());
                        RMSchemaConverter bmmRMSchemaConverter = new RMSchemaConverter(RMRepository);
                        included = bmmRMSchemaConverter.validateConvertAndAddToRepo(persistentSchema);
                    }
                    if(!included.passes()) {
                        logger.addError(MessageIds.ec_schema_includes_valiidation_failed, schema.getSchemaId(), included.getLogger().toString());
                        RMValidationResult.addFailedMerge(include.getId());
                    } else {
                        mergeIncluded(RMValidationResult, included);
                    }
                }
            }
        }
    }

    private void mergeIncluded(RMValidationResult includingRMValidationResult, RMValidationResult includedValidation) {
        PRMSchema including = includingRMValidationResult.getSchemaWithMergedIncludes();
        PRMSchema included = includedValidation.getSchemaWithMergedIncludes();
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

        for(Map.Entry<String, PRMPackage> packageEntry:includedValidation.getCanonicalPackages().entrySet()) {
            if(includingRMValidationResult.getCanonicalPackages().containsKey(packageEntry.getKey())) {
                PRMPackage persistedBmmPackage = includingRMValidationResult.getCanonicalPackages().get(packageEntry.getKey());
                merge(persistedBmmPackage, packageEntry.getValue());
            } else {
                includingRMValidationResult.getCanonicalPackages().put(packageEntry.getKey(), (PRMPackage) packageEntry.getValue().clone());
            }
        }

        //If a package already exist, merge its classes, for each child package repeat...
        //Merge class definitions first. If you see a class with the same name, log it (complain) - OpenEHR has no notion of namespaces. Need to fix spec to support them.
        //this automatically includes primitive types
        for(String className:included.getClassDefinitions().keySet()) {
            PRMClass bmmClass = included.getClassDefinitions().get(className);
            including.getClassDefinitions().put(className, (PRMClass) bmmClass.clone());
        }
        for(String primitiveTypeName:included.getPrimitiveTypes().keySet()) {
            PRMClass pClass = included.getPrimitiveTypes().get(primitiveTypeName);
            including.getPrimitiveTypes().put(primitiveTypeName, (PRMClass) pClass.clone());
        }

        includingRMValidationResult.addMergedSchema(included.getSchemaId().toUpperCase());


    }

    private void merge(PRMPackage including, PRMPackage included) {
        LinkedHashSet<String> newClasses = new LinkedHashSet<>(including.getClasses());
        newClasses.addAll(included.getClasses());
        including.setClasses(new ArrayList<>(newClasses));
        included.getPackages().values().forEach(p -> {
            PRMPackage sourcePackage = including.getPackages().get(p.getName());
            if(sourcePackage != null) {
                merge(sourcePackage, p);
            } else {
                including.getPackages().put(p.getName().toUpperCase(), (PRMPackage) p.clone());
            }
        });
    }
}
