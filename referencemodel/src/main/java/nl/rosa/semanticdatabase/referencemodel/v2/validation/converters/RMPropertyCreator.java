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

    private RMGenericProperty createGenericProperty(RMModel schema, PRMGenericProperty property, RMGenericType typeDefinition, RMClass bmmClass) {
        RMGenericProperty bmmProperty = new RMGenericProperty(property.getName(), typeDefinition);
        setBasics(property, bmmProperty);
        PRMGenericType pbmmType = property.getTypeRef();
        RMGenericType genericTypeDef = new RMGenericType();
        genericTypeDef.setBaseClass(schema.getClassDefinition(pbmmType.getRootType()));
        List<RMType> genericParams = new ArrayList<>();
        TypeCreator typeCreator = new TypeCreator();
        for(PRMType genericParamType: pbmmType.getGenericParamaterRefs()) {
            genericParams.add(typeCreator.createRMType(genericParamType, schema, bmmClass));
        }
        genericTypeDef.setGenericParameters(genericParams);
        bmmProperty.setGenericTypeDef(genericTypeDef);
        //bmmProperty.setGenericTypeDef();
        return bmmProperty;
    }

    private void setBasics(PRMProperty property, RMProperty bmmProperty) {
        bmmProperty.setDocumentation(property.getDocumentation());
        bmmProperty.setMandatory(property.isMandatory());
        bmmProperty.setComputed(property.isComputed());
        bmmProperty.setImInfrastructure(property.isImInfrastructure());
        bmmProperty.setImRuntime(property.isImRuntime());

        if(bmmProperty.getMandatory() == null) {
            bmmProperty.setMandatory(false);
        }
        if(bmmProperty.getComputed() == null) {
            bmmProperty.setComputed(false);
        }
        if(bmmProperty.getImInfrastructure() == null) {
            bmmProperty.setImInfrastructure(false);
        }

        if(bmmProperty.getImRuntime() == null) {
            bmmProperty.setImRuntime(false);
        }
    }


}
