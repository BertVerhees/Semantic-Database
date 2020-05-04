package nl.rosa.semanticdatabase.referencemodel.v2.validation.validators;

import nl.rosa.semanticdatabase.message.MessageLogger;
import nl.rosa.semanticdatabase.referencemodel.persistence.validation.MessageIds;
import nl.rosa.semanticdatabase.referencemodel.persistence.validation.RMDefinitions;
import nl.rosa.semanticdatabase.referencemodel.v2.persistence.PRMSchema;
import nl.rosa.semanticdatabase.referencemodel.v2.validation.RMRepository;
import nl.rosa.semanticdatabase.referencemodel.v2.validation.RMValidation;
import nl.rosa.semanticdatabase.referencemodel.v2.validation.RMValidationResult;

import java.util.ArrayList;
import java.util.List;

public class CreatedSchemaValidation implements RMValidation {
    @Override
    public void validate(RMValidationResult RMValidationResult, RMRepository RMRepository, MessageLogger logger, PRMSchema schema) {
        List<String> packageNames = new ArrayList<>();

        //check top-level names - package names cannot contain each other and be siblings
        packageNames.addAll(schema.getPackages().keySet());
        schema.getPackages().keySet().forEach(name1 -> {
            boolean invalidSiblings = packageNames.stream().anyMatch(name2 ->
                    (!name1.equalsIgnoreCase(name2)) && (name1.startsWith(name2) || name2.startsWith(name1))
            );
            if(invalidSiblings) {
                logger.addError(MessageIds.EC_ILLEGAL_TOP_LEVEL_SIBLING_PACKAGES, schema.getSchemaId());
            }
        });

        //duplicate properties don't have to be checked - Jackson already does this

        //validate package & class structure
        schema.doRecursivePackages(persistedPackage -> {
            //check for lower-down qualified names
            if((!schema.getPackages().containsKey(persistedPackage.getName())) && persistedPackage.getName().indexOf(RMDefinitions.PACKAGE_NAME_DELIMITER) >=0) {
                logger.addError(MessageIds.EC_ILLEGAL_QUALIFIED_PACKAGE_NAME,
                        schema.getSchemaId(),
                        persistedPackage.getName());
            }
            for(String persistedClass: persistedPackage.getClasses()) {
                if(persistedClass.isEmpty()) {
                    logger.addError(MessageIds.ec_class_name_empty,
                            schema.getSchemaId(),
                            persistedPackage.getName());
                } else if(!schema.hasClassOrPrimitiveDefinition(persistedClass)) {
                    logger.addError(MessageIds.ec_class_not_in_definitions,
                            schema.getSchemaId(),
                            persistedClass,
                            persistedPackage.getName());
                }
            }
        });

        if(!logger.hasErrors()) {
            logger.addInfo(MessageIds.SCHEMA_CREATED,schema.getSchemaId(),
                    ""+schema.getPrimitiveTypes().size(),
                    ""+schema.getClassDefinitions().size());

        }
    }

}
