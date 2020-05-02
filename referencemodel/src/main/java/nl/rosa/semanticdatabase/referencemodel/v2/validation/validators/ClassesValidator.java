package nl.rosa.semanticdatabase.referencemodel.v2.validation.validators;

import nl.rosa.semanticdatabase.message.MessageLogger;
import nl.rosa.semanticdatabase.referencemodel.persistence.validation.Definitions;
import nl.rosa.semanticdatabase.referencemodel.persistence.validation.MessageIds;
import nl.rosa.semanticdatabase.referencemodel.v2.persistence.PClass;
import nl.rosa.semanticdatabase.referencemodel.v2.persistence.PGenericParameter;
import nl.rosa.semanticdatabase.referencemodel.v2.persistence.PProperty;
import nl.rosa.semanticdatabase.referencemodel.v2.persistence.PSchema;
import nl.rosa.semanticdatabase.referencemodel.v2.validation.Repository;
import nl.rosa.semanticdatabase.referencemodel.v2.validation.Validation;
import nl.rosa.semanticdatabase.referencemodel.v2.validation.ValidationResult;
import org.springframework.util.StringUtils;

import java.util.Map;

public class ClassesValidator extends ValidatorBase implements Validation {

    private ValidationResult validationResult;
    private Repository repository;
    private PSchema schema;
    private PropertyValidator propertyValidator;

    @Override
    public void validate(ValidationResult validationResult, Repository repository, MessageLogger logger, PSchema schema) {

        setLogger(logger);
        this.validationResult = validationResult;
        this.repository = repository;
        this.schema = schema;
        propertyValidator = new PropertyValidator(logger, schema);

        schema.doAllClasses( pBmmClass -> {
            validateClass(pBmmClass);
        });
    }

    public void validateClass(PClass pClass) {
        //check that all ancestors exist
        pClass.getAncestorTypeNames().forEach(ancestorClassName -> {
            if(StringUtils.isEmpty(ancestorClassName)) {
                addValidityError(schema, pClass.getSourceSchemaId(), MessageIds.EC_ANCESTOR_NAME_EMPTY, pClass.getSourceSchemaId(), pClass.getName());
            } else if (!ancestorClassName.equalsIgnoreCase("Any") && schema.findClassOrPrimitiveDefinition(Definitions.typeNameToClassKey(ancestorClassName)) == null) {
                addValidityError(schema, pClass.getSourceSchemaId(), MessageIds.EC_ANCESTOR_DOES_NOT_EXIST, pClass.getSourceSchemaId(), pClass.getName(), ancestorClassName);
            }
        });

        if(!logger.hasErrors()) {
            validateGenericParameters(pClass);
        }

        // validate the properties
        for(PProperty property:pClass.getProperties().values()) {
            propertyValidator.validateProperty(pClass, property);
        }
    }

    private void validateGenericParameters(PClass pBmmClass) {
        //check that all generic parameter.conforms_to_type exist exists
        if(pBmmClass.isGeneric()) {
            Map<String, PGenericParameter> genericParameterDefinitions = pBmmClass.getGenericParameterDefs();

            for(PGenericParameter pBmmGenericParameter: genericParameterDefinitions.values()) {

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
