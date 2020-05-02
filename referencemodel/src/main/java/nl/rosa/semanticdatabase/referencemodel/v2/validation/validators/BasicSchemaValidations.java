package nl.rosa.semanticdatabase.referencemodel.v2.validation.validators;


import nl.rosa.semanticdatabase.message.MessageLogger;
import nl.rosa.semanticdatabase.referencemodel.persistence.validation.Definitions;
import nl.rosa.semanticdatabase.referencemodel.persistence.validation.MessageIds;
import nl.rosa.semanticdatabase.referencemodel.v2.persistence.PPackage;
import nl.rosa.semanticdatabase.referencemodel.v2.persistence.PPackageContainer;
import nl.rosa.semanticdatabase.referencemodel.v2.persistence.PSchema;
import nl.rosa.semanticdatabase.referencemodel.v2.validation.Repository;
import nl.rosa.semanticdatabase.referencemodel.v2.validation.Validation;
import nl.rosa.semanticdatabase.referencemodel.v2.validation.ValidationResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BasicSchemaValidations implements Validation {


    @Override
    public void validate(ValidationResult validationResult, Repository repository, MessageLogger logger, PSchema schema) {
        //Check that RM shema release is valid
        if(!Definitions.isValidStandardVersion(schema.getRmRelease())) {
            logger.addError(MessageIds.EC_RM_RELEASE_INVALID, schema.getSchemaId(), schema.getRmRelease());
        }
        //check archetype parent class in list of class names
        if(schema.getArchetypeParentClass() != null && schema.getClassDefinition(schema.getArchetypeParentClass()) ==  null) {
            logger.addError(MessageIds.EC_ARCHETYPE_PARENT_CLASS_UNDEFINED, schema.getSchemaId(), schema.getArchetypeParentClass());
        }

        //check that all models refer to declared packages
        schema.getArchetypeRmClosurePackages().forEach(closurePackage -> {
            if(!hasCanonicalPackagePath(validationResult, schema, closurePackage)) {
                logger.addError(MessageIds.ec_MDLPK, schema.getSchemaId(), closurePackage);
            }
        });

        Map<String, String> packageClassList = new HashMap<>();

        //1. check that no duplicate class names are found in packages
        validationResult.getCanonicalPackages().forEach((packageName, canonicalPackage) -> {
            canonicalPackage.doRecursiveClasses((persistedBmmPackage, className) -> {
                String classNameStr = className.toLowerCase();
                if(packageClassList.containsKey(classNameStr)) {
                    logger.addError(BmmMessageIds.EC_DUPLICATE_CLASS_IN_PACKAGES, schema.getSchemaId(), className, persistedBmmPackage.getName(), packageClassList.get(classNameStr));
                } else {
                    packageClassList.put(classNameStr, persistedBmmPackage.getName());
                }
            });
        });

        List<String> classNameList = new ArrayList<>();
        //2. check that every class is in a package
        schema.doAllClasses( persistedBmmClass -> {
            String className = persistedBmmClass.getName().toLowerCase();
            if(!packageClassList.containsKey(className)) {
                logger.addError(BmmMessageIds.EC_CLASS_NOT_DECLARED_IN_PACKAGES, schema.getSchemaId(), persistedBmmClass.getName());
            } else if(classNameList.contains(className)) {
                logger.addError(BmmMessageIds.EC_DUPLICATE_CLASS_DEFINITION, schema.getSchemaId(), persistedBmmClass.getName());
            } else {
                classNameList.add(className);
            }
        });
    }

    public boolean hasCanonicalPackagePath(ValidationResult validationResult, PSchema schema, String aPath) {

        if(aPath.isEmpty()) {
            return false;
        } else {
            String[] packageNames = aPath.toUpperCase().split("\\" + Definitions.PACKAGE_NAME_DELIMITER);

            //fake a PBmmPackageContgainer because the canonical packages doesn't have one
            //maybe we should add it instead to the validationResult instead of a map?
            PPackageContainer currentPackage = new PPackageContainer() {
                @Override
                public Map<String, PPackage> getPackages() {
                    return validationResult.getCanonicalPackages();
                }
            };

            for(String packageName:packageNames) {
                currentPackage = currentPackage.getPackages().get(packageName);
                if(currentPackage == null) {
                    return false;
                }
            }
            return true;
        }
    }

}
