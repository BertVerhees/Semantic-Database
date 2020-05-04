package nl.rosa.semanticdatabase.referencemodel.v2.validation.validators;

import nl.rosa.semanticdatabase.message.MessageLogger;
import nl.rosa.semanticdatabase.referencemodel.persistence.validation.MessageIds;
import nl.rosa.semanticdatabase.referencemodel.persistence.validation.RMDefinitions;
import nl.rosa.semanticdatabase.referencemodel.v2.persistence.*;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;

public class PropertyValidator extends ValidatorBase {

    private final PRMSchema schema;
    private MessageLogger logger;

    private ConformanceChecker conformanceChecker = new ConformanceChecker();

    public PropertyValidator(MessageLogger logger, PRMSchema schema) {
        super(logger);
        this.logger = logger;
        this.schema = schema;
    }

    public void validateProperty(PRMClass pRMClass, PRMProperty pRMProperty) {
        //first check if any property replicates a property from a parent class
        validateOverriddenPropertyType(pRMClass, pRMProperty);

        //For single properties, check if property type is empty or not defined in the schema
        if(pRMProperty instanceof PRMSingleProperty) {
            validateSingleProperty(pRMClass, pRMProperty);
        } else if(pRMProperty instanceof PRMSinglePropertyOpen) {
            validateSimpleOpenProperty(pRMClass, pRMProperty);
        } else if(pRMProperty instanceof PRMContainerProperty) {
            validateContainerProperty(pRMClass, pRMProperty);
        } else if (pRMProperty instanceof PRMGenericProperty){
            validateGenericProperty(pRMClass, pRMProperty);
        }
    }


    private void validateGenericProperty(PRMClass pRMClass, PRMProperty pRMProperty) {
        PRMGenericProperty genericPropertyDefinition = (PRMGenericProperty)pRMProperty;
        PRMGenericType attributeTypeDefinition = genericPropertyDefinition.getTypeDef();
        if(attributeTypeDefinition != null) {
            if(!schema.hasClassOrPrimitiveDefinition(attributeTypeDefinition.getRootType())) {
                addValidityError(schema, pRMClass.getSourceSchemaId(), MessageIds.EC_GENERIC_PROPERTY_ROOT_TYPE_NOT_FOUND, pRMClass.getSourceSchemaId(),
                        pRMClass.getName(),
                        pRMProperty.getName(),
                        attributeTypeDefinition.getRootType());
            }

            for(PRMType genericParameter:attributeTypeDefinition.getGenericParameterDefs().values()) {
                validateGenericTypeDefParameter(pRMClass, pRMProperty, attributeTypeDefinition, genericParameter);
            }
        } else {
            addValidityError(schema, pRMClass.getSourceSchemaId(), MessageIds.EC_GENERIC_PROPERTY_TYPE_DEF_UNDEFINED,
                    pRMClass.getSourceSchemaId(),
                    pRMClass.getName(),
                    pRMProperty.getName());
        }
    }

    private void validateGenericTypeDefParameter(PRMClass pRMClass, PRMProperty pRMProperty, PRMGenericType attributeTypeDefinition, PRMType genericParameter) {
        List<String> typeReferences = genericParameter.flattenedTypeList();
        for(String typeReference:typeReferences) {
            if(!schema.hasClassOrPrimitiveDefinition(typeReference)) {
                if (pRMClass.isGeneric()) {  //it might be a formal parameter, to be matched against those of enclosing class
                    Map<String, PRMGenericParameter> genericParameters = pRMClass.getGenericParameterDefs();
                    if (!genericParameters.containsKey(typeReference)) {
                        addValidityError(schema, pRMClass.getSourceSchemaId(), MessageIds.EC_GENERIC_PROPERTY_TYPE_PARAMETER_NOT_FOUND,
                                pRMClass.getSourceSchemaId(),
                                pRMClass.getName(),
                                pRMProperty.getName(),
                                attributeTypeDefinition.getRootType());
                    } else {
                        //Should this be logged?
                    }
                } else {
                    //cannot have a generic type declaration for a non-generic class
                    addValidityError(schema, pRMClass.getSourceSchemaId(), MessageIds.EC_GENERIC_PARAMETER_NOT_FOUND,
                            pRMClass.getSourceSchemaId(),
                            pRMClass.getName(),
                            pRMProperty.getName(),
                            typeReference);
                }
            }
        }
    }

    private void validateContainerProperty(PRMClass pRMClass, PRMProperty pRMProperty) {
        PRMContainerProperty containerPropertyDefinition = (PRMContainerProperty) pRMProperty;
        PRMContainerType attributeTypeDefinition = containerPropertyDefinition.getTypeRef();
        PRMType attributeTypeReference = attributeTypeDefinition.getTypeRef();
        if(!schema.hasClassOrPrimitiveDefinition(attributeTypeDefinition.getContainerType())) {
            addValidityError(schema, pRMClass.getSourceSchemaId(), MessageIds.EC_CONTAINER_TYPE_NOT_FOUND,
                    pRMClass.getSourceSchemaId(),
                    pRMClass.getName(),
                    pRMProperty.getName(),
                    attributeTypeDefinition.getType());
        } else if(attributeTypeReference != null){
            //Loop through types inside container type
            List<String> typeReferences = attributeTypeReference.flattenedTypeList();
            if(typeReferences != null) {
                for(String typeReference:typeReferences) {
                    validateContainerTypeReference(pRMClass, pRMProperty, attributeTypeDefinition, typeReference);
                }
            } else {
                //Should this be logged?
            }
        } else {
            addValidityError(schema, pRMClass.getSourceSchemaId(), MessageIds.EC_CONTAINER_PROPERTY_TARGET_TYPE_NOT_DEFINED,
                    pRMClass.getSourceSchemaId(),
                    pRMClass.getName(),
                    pRMProperty.getName());
        }
        if(containerPropertyDefinition.getCardinality() == null) {
//                    addValidityInfo(pRMClass.getSourceSchemaId(), RMMessageIds.EC_CONTAINER_PROPERTY_CARDINALITY_NOT_DEFINED,
//                            pRMClass.getSourceSchemaId(),
//                            pRMClass.getName(),
//                            pRMProperty.getName());
        }
    }

    private void validateContainerTypeReference(PRMClass pRMClass, PRMProperty pRMProperty, PRMContainerType attributeTypeDefinition, String typeReference) {
        if (!schema.hasClassOrPrimitiveDefinition(typeReference)) {
            if (pRMClass.isGeneric()) {  //it might be a formal parameter, to be matched against those of enclosing class
                Map<String, PRMGenericParameter> genericParameters = pRMClass.getGenericParameterDefs();
                if (!genericParameters.containsKey(typeReference)) {
                    addValidityError(schema, pRMClass.getSourceSchemaId(), MessageIds.EC_GENERIC_PROPERTY_TYPE_PARAMETER_NOT_FOUND,
                            pRMClass.getSourceSchemaId(),
                            pRMClass.getName(),
                            pRMProperty.getName(),
                            attributeTypeDefinition.getType());
                }
            } else {
                addValidityError(schema, pRMClass.getSourceSchemaId(), MessageIds.EC_CONTAINER_PROPERTY_TARGET_TYPE_NOT_FOUND,
                        pRMClass.getSourceSchemaId(),
                        pRMClass.getName(),
                        pRMProperty.getName(),
                        attributeTypeDefinition.getType());
            }
        }
    }

    private void validateSimpleOpenProperty(PRMClass pRMClass, PRMProperty pRMProperty) {
        //For open properties, check if the containing class is a generic class and has a parameter of that type
        PRMSinglePropertyOpen singlePropertyOpenDefinition = (PRMSinglePropertyOpen) pRMProperty;
        PRMOpenType attributeTypeDefinition = singlePropertyOpenDefinition.getTypeRef();
        if(!pRMClass.isGeneric() || !pRMClass.getGenericParameterDefs().containsKey(attributeTypeDefinition.getType())) {
            addValidityError(schema, pRMClass.getSourceSchemaId(), MessageIds.EC_SINGLE_OPEN_PARAMETER_NOT_FOUND, pRMClass.getSourceSchemaId(), pRMClass.getName(), pRMProperty.getName(), attributeTypeDefinition.getType());
        }
    }

    private void validateSingleProperty(PRMClass pRMClass, PRMProperty pRMProperty) {
        PRMSingleProperty singlePropertyDefinition = (PRMSingleProperty)pRMProperty;
        PRMSimpleType attributeTypeDefinition = singlePropertyDefinition.getTypeRef();
        if(StringUtils.isEmpty(attributeTypeDefinition.getType()) || !schema.hasClassOrPrimitiveDefinition(attributeTypeDefinition.getType())) {
            addValidityError(schema, pRMClass.getSourceSchemaId(), MessageIds.EC_SINGLE_PROPERTY_TYPE_NOT_FOUND,
                    pRMClass.getSourceSchemaId(),
                    pRMClass.getName(),
                    pRMProperty.getName(),
                    attributeTypeDefinition.getType());
        }
    }

    private void validateOverriddenPropertyType(PRMClass pRMClass, PRMProperty pRMProperty) {
        for(String ancestorName:pRMClass.getAncestorTypeNames()) {
            PRMClass ancestor = schema.findClassOrPrimitiveDefinition(RMDefinitions.typeNameToClassKey(ancestorName));
            if(ancestor != null) {
                PRMProperty ancestorProperty = ancestor.getProperties().get(pRMProperty.getName());
                if (ancestor != null && ancestorProperty != null && !conformanceChecker.propertyConformsTo(schema, pRMProperty, ancestorProperty)) {
                    addValidityError(schema, pRMClass.getSourceSchemaId(), MessageIds.EC_OVERRIDDEN_PROPERTY_DOES_NOT_CONFORM, pRMClass.getSourceSchemaId(), pRMClass.getName(), pRMProperty.getName(), ancestorName);
                }
            }
        }
    }


}
