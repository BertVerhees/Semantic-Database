package nl.rosa.semanticdatabase.referencemodel.v2.validation.converters;

import nl.rosa.semanticdatabase.referencemodel.core.*;
import nl.rosa.semanticdatabase.referencemodel.v2.persistence.*;

public class TypeCreator {

    public RMType createRMType(PRMType typeDef, RMModel schema, RMClass bmmClass) {
        if(typeDef == null) {
            return null;
        }
        if(typeDef instanceof PRMSimpleType) {
            return createSimpleType((PRMSimpleType) typeDef, schema);
        } else if (typeDef instanceof PRMGenericType) {
            return createGenericType((PRMGenericType) typeDef, schema);
        } else if (typeDef instanceof PRMContainerType) {
            return createContainerType((PRMContainerType) typeDef, schema, bmmClass);
        } else if (typeDef instanceof PRMOpenType) {
            return createOpenType((PRMOpenType) typeDef, schema, bmmClass);
        } else {
            throw new RuntimeException("unknown type found: " + typeDef.getClass().getName());
        }
    }

    private RMType createOpenType(PRMOpenType typeDef, RMModel schema, RMClass bmmClass) {
        RMGenericParameter genericParameter = ((RMGenericClass) bmmClass).getGenericParameter(typeDef.getType());
        if(bmmClass instanceof RMGenericClass && genericParameter != null) {
            RMOpenType openType = new RMOpenType();
            openType.setGenericConstraint(genericParameter);
            return openType;
        } else {
            throw new RuntimeException("Unable to initialize RMOpenType of type " + typeDef.getType() + ". Have you defined generic parameters in the class definition " + bmmClass.getName() + " for type " + typeDef.getType() + "?");
        }
    }

    private RMType createContainerType(PRMContainerType typeDef, RMModel schema, RMClass bmmClass) {
        PRMContainerType containerType = typeDef;
        RMContainerType rmContainerType = new RMContainerType();
        RMType containedType = createRMType(containerType.getTypeRef(), schema, bmmClass);

        RMClass containerClass = schema.getClassDefinition(containerType.getContainerType());
        if(containerClass == null) {
            throw new RuntimeException("Container type is null for " + containerType.getContainerType());
        } else {
            rmContainerType.setContainerType(containerClass);
        }
        rmContainerType.setBaseType(containedType);
        return rmContainerType;

    }

    private RMType createSimpleType(PRMSimpleType typeDef, RMModel schema) {
        RMClass baseClass = schema.getClassDefinition(typeDef.getType());
        if(baseClass == null) {
            //Shouldn't happen: validation already tests this, so runtime exception is fine!
            throw new RuntimeException("RMClass " + typeDef.getType() + " is not defined in this model");
        } else {
            RMSimpleType simpleType = new RMSimpleType();
            simpleType.setBaseClass(baseClass);
            return simpleType;
        }
    }

    private RMType createGenericType(PRMGenericType typeDef, RMModel schema) {
        PRMGenericType pGenericType = typeDef;
        RMGenericType genericType = new RMGenericType();
        RMClass classDefinition = schema.getClassDefinition(pGenericType.getRootType());
        if(classDefinition != null && classDefinition instanceof RMGenericClass) {
            RMGenericClass baseClass = (RMGenericClass)schema.getClassDefinition(pGenericType.getRootType());
            genericType.setBaseClass(baseClass);
            for(PRMType param: pGenericType.getGenericParameterDefs().values()) {

                RMType paramRMType = createRMType(param, schema, classDefinition);
                genericType.addGenericParameter(paramRMType);
            }
        } else {
            throw new RuntimeException("RMClass " + pGenericType.getRootType() + " is not defined in this model or not a generic type");
        }
        return genericType;
    }
}
