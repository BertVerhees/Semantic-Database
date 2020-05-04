package nl.rosa.semanticdatabase.referencemodel.v2.validation.validators;


import nl.rosa.semanticdatabase.message.MessageLogger;
import nl.rosa.semanticdatabase.referencemodel.persistence.validation.RMDefinitions;
import nl.rosa.semanticdatabase.referencemodel.persistence.validation.MessageIds;
import nl.rosa.semanticdatabase.referencemodel.v2.persistence.PRMPackage;
import nl.rosa.semanticdatabase.referencemodel.v2.persistence.PRMPackageContainer;
import nl.rosa.semanticdatabase.referencemodel.v2.persistence.PRMSchema;
import nl.rosa.semanticdatabase.referencemodel.v2.validation.RMRepository;
import nl.rosa.semanticdatabase.referencemodel.v2.validation.RMValidation;
import nl.rosa.semanticdatabase.referencemodel.v2.validation.RMValidationResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BasicSchemaValidations implements RMValidation {


    @Override
    public void validate(RMValidationResult RMValidationResult, RMRepository RMRepository, MessageLogger logger, PRMSchema schema) {
        //Check that RM shema release is valid
        if(!RMDefinitions.isValidStandardVersion(schema.getRmRelease())) {
            logger.addError(MessageIds.EC_RM_RELEASE_INVALID, schema.getSchemaId(), schema.getRmRelease());
        }
        //check archetype parent class in list of class names
        if(schema.getArchetypeParentClass() != null && schema.getClassDefinition(schema.getArchetypeParentClass()) ==  null) {
            logger.addError(MessageIds.EC_ARCHETYPE_PARENT_CLASS_UNDEFINED, schema.getSchemaId(), schema.getArchetypeParentClass());
        }

        //check that all models refer to declared packages
        schema.getArchetypeRmClosurePackages().forEach(closurePackage -> {
            if(!hasCanonicalPackagePath(RMValidationResult, schema, closurePackage)) {
                logger.addError(MessageIds.ec_MDLPK, schema.getSchemaId(), closurePackage);
            }
        });

        Map<String, String> packageClassList = new HashMap<>();

        //1. check that no duplicate class names are found in packages
        RMValidationResult.getCanonicalPackages().forEach((packageName, canonicalPackage) -> {
            canonicalPackage.doRecursiveClasses((persistedBmmPackage, className) -> {
                String classNameStr = className.toLowerCase();
                if(packageClassList.containsKey(classNameStr)) {
                    logger.addError(MessageIds.EC_DUPLICATE_CLASS_IN_PACKAGES, schema.getSchemaId(), className, persistedBmmPackage.getName(), packageClassList.get(classNameStr));
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
                logger.addError(MessageIds.EC_CLASS_NOT_DECLARED_IN_PACKAGES, schema.getSchemaId(), persistedBmmClass.getName());
            } else if(classNameList.contains(className)) {
                logger.addError(MessageIds.EC_DUPLICATE_CLASS_DEFINITION, schema.getSchemaId(), persistedBmmClass.getName());
            } else {
                classNameList.add(className);
            }
        });
    }

    public boolean hasCanonicalPackagePath(RMValidationResult RMValidationResult, PRMSchema schema, String aPath) {

        if(aPath.isEmpty()) {
            return false;
        } else {
            String[] packageNames = aPath.toUpperCase().split("\\" + RMDefinitions.PACKAGE_NAME_DELIMITER);

            //fake a PBmmPackageContgainer because the canonical packages doesn't have one
            //maybe we should add it instead to the validationResult instead of a map?
            PRMPackageContainer currentPackage = new PRMPackageContainer() {
                @Override
                public Map<String, PRMPackage> getPackages() {
                    return RMValidationResult.getCanonicalPackages();
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
