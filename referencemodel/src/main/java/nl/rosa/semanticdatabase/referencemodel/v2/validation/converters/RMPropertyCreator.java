package nl.rosa.semanticdatabase.referencemodel.v2.validation.converters;

import nl.rosa.semanticdatabase.base.Interval;
import nl.rosa.semanticdatabase.base.MultiplicityInterval;
import nl.rosa.semanticdatabase.referencemodel.core.*;
import nl.rosa.semanticdatabase.referencemodel.v2.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class RMPropertyCreator {

    public RMProperty createRMProperty(PRMProperty property, RMModel schema, RMClass bmmClass) {
        //getTypeDefinition().createRMType(bmmSchema, classDefinition);
        RMType type = new TypeCreator().createRMType(property.getTypeRef(), schema, bmmClass);

        if(property instanceof PRMSinglePropertyOpen) {
            return createSimpleProperty(property, type);
        } else if (property instanceof PRMSingleProperty) {
            return createSimpleProperty(property, type);
        } else if (property instanceof PRMGenericProperty) {
            return createGenericProperty(schema, (PRMGenericProperty) property, (RMGenericType) type, bmmClass);
        } else if (property instanceof PRMContainerProperty) {
            return createContainerProperty((PRMContainerProperty) property, (RMContainerType) type);
        } else {
            throw new RuntimeException("unknown property class: " + property.getClass().getName());
        }

    }

    private RMContainerProperty createContainerProperty(PRMContainerProperty property, RMContainerType type) {
        RMContainerProperty bmmContainerProperty = new RMContainerProperty(property.getName(), type);
        setBasics(property, bmmContainerProperty);
        if(property.getCardinality() != null) {
            Interval<Integer> cardinality = property.getCardinality();
            bmmContainerProperty.setCardinality(new MultiplicityInterval(cardinality.getLower(), cardinality.isLowerIncluded(),
                    cardinality.isLowerUnbounded(),
                    cardinality.getUpper(), cardinality.isUpperIncluded(),
                    cardinality.isUpperUnbounded()));
        }
        return bmmContainerProperty;
    }

    private RMProperty createSimpleProperty(PRMProperty property, RMType typeDefinition) {
        RMProperty bmmProperty = new RMProperty(property.getName(), typeDefinition);
        setBasics(property, bmmProperty);
        return bmmProperty;
    }

    private RMGenericProperty createGenericProperty(RMModel schema, PRMGenericProperty property, RMGenericType typeDefinition, RMClass rmClass) {
        RMGenericProperty rmProperty = new RMGenericProperty(property.getName(), typeDefinition);
        setBasics(property, rmProperty);
        PRMGenericType pRMType = property.getTypeRef();
        RMGenericType genericTypeDef = new RMGenericType();
        genericTypeDef.setBaseClass(schema.getClassDefinition(pRMType.getRootType()));
        List<RMType> genericParams = new ArrayList<>();
        TypeCreator typeCreator = new TypeCreator();
        for(PRMType genericParamType: pRMType.getGenericParamaterRefs()) {
            genericParams.add(typeCreator.createRMType(genericParamType, schema, rmClass));
        }
        genericTypeDef.setGenericParameters(genericParams);
        rmProperty.setRmGenericTypeDef(genericTypeDef);
        //bmmProperty.setGenericTypeDef();
        return rmProperty;
    }

    private void setBasics(PRMProperty property, RMProperty rmProperty) {
        rmProperty.setDocumentation(property.getDocumentation());
        rmProperty.setIsMandatory(property.isMandatory());
        rmProperty.setIsComputed(property.isComputed());
        rmProperty.setIsImInfrastructure(property.isImInfrastructure());
        rmProperty.setIsImRuntime(property.isImRuntime());

        if(rmProperty.getIsMandatory() == null) {
            rmProperty.setIsMandatory(false);
        }
        if(rmProperty.getIsComputed() == null) {
            rmProperty.setIsComputed(false);
        }
        if(rmProperty.getIsImInfrastructure() == null) {
            rmProperty.setIsImInfrastructure(false);
        }

        if(rmProperty.getIsImRuntime() == null) {
            rmProperty.setIsImRuntime(false);
        }
    }


}
