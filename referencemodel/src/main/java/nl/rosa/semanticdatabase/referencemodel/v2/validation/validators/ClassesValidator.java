package nl.rosa.semanticdatabase.referencemodel.v2.validation.validators;

import nl.rosa.semanticdatabase.message.MessageLogger;
import nl.rosa.semanticdatabase.referencemodel.persistence.validation.RMDefinitions;
import nl.rosa.semanticdatabase.referencemodel.persistence.validation.MessageIds;
import nl.rosa.semanticdatabase.referencemodel.v2.persistence.PRMClass;
import nl.rosa.semanticdatabase.referencemodel.v2.persistence.PRMGenericParameter;
import nl.rosa.semanticdatabase.referencemodel.v2.persistence.PRMProperty;
import nl.rosa.semanticdatabase.referencemodel.v2.persistence.PRMSchema;
import nl.rosa.semanticdatabase.referencemodel.v2.validation.RMRepository;
import nl.rosa.semanticdatabase.referencemodel.v2.validation.RMValidation;
import nl.rosa.semanticdatabase.referencemodel.v2.validation.RMValidationResult;
import org.springframework.util.StringUtils;

import java.util.Map;

public class ClassesValidator extends ValidatorBase implements RMValidation {

    private RMValidationResult RMValidationResult;
    private RMRepository RMRepository;
    private PRMSchema schema;
    private PropertyValidator propertyValidator;

    @Override
    public void validate(RMValidationResult RMValidationResult, RMRepository RMRepository, MessageLogger logger, PRMSchema schema) {

        setLogger(logger);
        this.RMValidationResult = RMValidationResult;
        this.RMRepository = RMRepository;
        this.schema = schema;
        propertyValidator = new PropertyValidator(logger, schema);

        schema.doAllClasses( pBmmClass -> {
            validateClass(pBmmClass);
        });
    }

    public void validateClass(PRMClass pClass) {
        //check that all ancestors exist
        pClass.getAncestorTypeNames().forEach(ancestorClassName -> {
            if(StringUtils.isEmpty(ancestorClassName)) {
                addValidityError(schema, pClass.getSourceSchemaId(), MessageIds.EC_ANCESTOR_NAME_EMPTY, pClass.getSourceSchemaId(), pClass.getName());
            } else if (!ancestorClassName.equalsIgnoreCase("Any") && schema.findClassOrPrimitiveDefinition(RMDefinitions.typeNameToClassKey(ancestorClassName)) == null) {
                addValidityError(schema, pClass.getSourceSchemaId(), MessageIds.EC_ANCESTOR_DOES_NOT_EXIST, pClass.getSourceSchemaId(), pClass.getName(), ancestorClassName);
            }
        });

        if(!logger.hasErrors()) {
            validateGenericParameters(pClass);
        }

        // validate the properties
        for(PRMProperty property:pClass.getProperties().values()) {
            propertyValidator.validateProperty(pClass, property);
        }
    }

    private void validateGenericParameters(PRMClass pBmmClass) {
        //check that all generic parameter.conforms_to_type exist exists
        if(pBmmClass.isGeneric()) {
            Map<String, PRMGenericParameter> genericParameterDefinitions = pBmmClass.getGenericParameterDefs();

            for(PRMGenericParameter pBmmGenericParameter: genericParameterDefinitions.values()) {

                String conformsToType = pBmmGenericParameter.getConformsToType();
                if(conformsToType != null && !schema.hasClassOrPrimitiveDefinition(conformsToType)) {

                    addValidityError(schema, pBmmClass.getSourceSchemaId(), MessageIds.EC_GENERIC_PARAMETER_CONSTRAINT_DOES_NOT_EXIST,
                            pBmmClass.getSourceSchemaId(),
                            pBmmClass.getName(),
                            pBmmGenericParameter.getName(),
                            conformsToType);

                }
            }

        }

    }

}
