package nl.rosa.semanticdatabase.referencemodel.v2.validation.converters;

import nl.rosa.semanticdatabase.referencemodel.core.*;
import nl.rosa.semanticdatabase.referencemodel.persistence.validation.RMDefinitions;
import nl.rosa.semanticdatabase.referencemodel.v2.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class RMClassCreator {

    public RMClass createRMClass(PRMClass pRMClass) {
        RMClass rmClass;
        if(pRMClass instanceof PRMEnumerationString) {
            rmClass = new RMEnumerationString(pRMClass.getName());
        } else if (pRMClass instanceof PRMEnumerationInteger) {
            rmClass = new RMEnumerationInteger(pRMClass.getName());
        } else if (pRMClass.getGenericParameterDefs() != null && pRMClass.getGenericParameterDefs().size() > 0) {
            rmClass = new RMGenericClass(pRMClass.getName());
        } else {
            rmClass = new RMClass(pRMClass.getName());
        }

        rmClass.setDocumentation(pRMClass.getDocumentation());
        rmClass.setAbstract(pRMClass.isAbstract() == null ? false : pRMClass.isAbstract());
        rmClass.setOverride(pRMClass.isOverride() == null ? false : pRMClass.isOverride());
        rmClass.setSourceSchemaId(pRMClass.getSourceSchemaId());
        return rmClass;
    }

    public void populateRMClass(PRMClass pRMClass, RMModel schema) {

        RMClass rmClass = schema.getClassDefinition(pRMClass.getName());
        if (rmClass != null) {

            for (String ancestorTypeName : pRMClass.getAncestorTypeNames()) {
                //typeName will have generics included. BMM 2 does not support generics as ancestors, so just throw away this information
                //until migration to BMM 3
                RMClass classDefinition = schema.getClassDefinition(RMDefinitions.typeNameToClassKey(ancestorTypeName));
                if (classDefinition != null) {
                    rmClass.addAncestor(classDefinition);
                } else {
                    throw new RuntimeException("Error retrieving class definition for " + ancestorTypeName);
                }
            }

            if (rmClass instanceof RMGenericClass && pRMClass.getGenericParameterDefs() != null) {
                for (PRMGenericParameter param : pRMClass.getGenericParameterDefs().values()) {
                    RMGenericParameter rmGenericParameter = createRMGenericParameter(param, schema);
                    ((RMGenericClass) rmClass).addGenericParameter(rmGenericParameter);
                }
            }
            if (pRMClass.getProperties() != null) {
                for (PRMProperty property : pRMClass.getProperties().values()) {
                    RMProperty propertyDef = new RMPropertyCreator().createRMProperty(property, schema, rmClass);
                    rmClass.addProperty(propertyDef);
                }
            }
        } else {
            throw new RuntimeException("The class " + pRMClass.getName() + " is null. It may have been defined as a class or a primitive but not included in a package");
        }

        if(pRMClass instanceof PRMEnumerationString) {

            populateStringEnumeration((PRMEnumerationString) pRMClass, (RMEnumerationString) rmClass);
        } else if (pRMClass instanceof PRMEnumerationInteger) {

            populateIntegerEnumeration((PRMEnumerationInteger) pRMClass, (RMEnumerationInteger) rmClass);
        }
    }

    private void populateIntegerEnumeration(PRMEnumerationInteger pRMClass, RMEnumerationInteger rmClass) {
        PRMEnumerationInteger pEnumerationInteger = pRMClass;
        RMEnumerationInteger enumeration = rmClass;
        enumeration.setItemNames(pEnumerationInteger.getItemNames());
        enumeration.setItemValues(pEnumerationInteger.getItemValues());
        if(enumeration.getItemValues() == null || enumeration.getItemValues().isEmpty()) {
            //documentation says: for integers, the values 0, 1, 2, etc are assumed. I'm adding 'unless otherwise specified' here
            List<Integer> itemValues = new ArrayList<>();
            for(int i = 0; i < enumeration.getItemNames().size(); i++) {
                itemValues.add(i);
            }
            enumeration.setItemValues(itemValues);
        }
    }

    private void populateStringEnumeration(PRMEnumerationString pRMClass, RMEnumerationString rmClass) {
        PRMEnumerationString pEnumerationString = pRMClass;
        RMEnumerationString enumeration = rmClass;
        enumeration.setItemNames(pEnumerationString.getItemNames());
        enumeration.setItemValues(pEnumerationString.getItemValues());
    }


    private RMGenericParameter createRMGenericParameter(PRMGenericParameter param, RMModel rmSchema) {
        RMGenericParameter rmGenericParameter = new RMGenericParameter();
        rmGenericParameter.setName(param.getName());
        rmGenericParameter.setDocumentation(param.getDocumentation());

        if(param.getConformsToType() != null) {
            RMClass conformsToTypeClass = rmSchema.getClassDefinition(param.getConformsToType());
            if(conformsToTypeClass != null) {
                rmGenericParameter.setConformsToType(conformsToTypeClass);
            }
        } else {
            rmGenericParameter.setBaseClass(rmSchema.getAnyClassDefinition());
            rmGenericParameter.setConformsToType(null);
        }

        return rmGenericParameter;
    }


}
