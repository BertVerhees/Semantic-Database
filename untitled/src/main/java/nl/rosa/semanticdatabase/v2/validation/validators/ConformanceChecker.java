package nl.rosa.semanticdatabase.referencemodel.v2.validation.validators;

import nl.rosa.semanticdatabase.referencemodel.persistence.validation.RMDefinitions;
import nl.rosa.semanticdatabase.referencemodel.v2.persistence.*;

import java.util.List;

public class ConformanceChecker {

    /**
     * True if `a_child_prop' conforms to `a_parent_prop' such that it could be used to override it; same nl.rosa.semanticdatabase.bmm.model.types are not considered conforming
     *
     * @param aChildProperty
     * @param aParentProperty
     * @return
     */
    public boolean propertyConformsTo(PRMSchema schema, PRMProperty aChildProperty, PRMProperty aParentProperty) {
        if(aParentProperty instanceof PRMSingleProperty && ((PRMSingleProperty) aParentProperty).getTypeRef().getType().equalsIgnoreCase(RMDefinitions.ANY_TYPE)) {
            return true;
        } else if(aChildProperty.getName().equalsIgnoreCase(aParentProperty.getName())) {
            //Properties names are the same
            if(aChildProperty instanceof PRMSingleProperty && aParentProperty instanceof PRMSingleProperty) {
                PRMSingleProperty aChildSingleProperty = (PRMSingleProperty)aChildProperty;
                PRMSingleProperty aParentSingleProperty = (PRMSingleProperty)aParentProperty;
                return typeStrictlyConformsTo(schema, aChildSingleProperty.getTypeRef().getType(), aParentSingleProperty.getTypeRef().getType());
            } else if(aParentProperty instanceof PRMSingleProperty) {
                if(aChildProperty instanceof PRMSinglePropertyOpen) {
                    //If both properties have the same name and are both open properties, then they do not conform.
                    return false;
                } else if(aChildProperty instanceof PRMSingleProperty) {
                    return true;
                    //TODO FIXME: proper type conformance to constraining generic type needs to be checked here
                }
            } else if(aChildProperty instanceof PRMContainerProperty && aParentProperty instanceof PRMContainerProperty) {
                PRMContainerProperty aChildContainerProperty = (PRMContainerProperty)aChildProperty;
                PRMContainerProperty aParentContainerProperty = (PRMContainerProperty)aParentProperty;
                return typeStrictlyConformsTo(schema, aChildContainerProperty.getTypeRef().asTypeString(), aParentContainerProperty.getTypeRef().asTypeString());
            } else if(aChildProperty instanceof PRMGenericProperty && aParentProperty instanceof PRMGenericProperty) {
                PRMGenericProperty aChildGenericProperty = (PRMGenericProperty)aChildProperty;
                PRMGenericProperty aParentGenericProperty = (PRMGenericProperty)aParentProperty;
                return typeStrictlyConformsTo(schema, aChildGenericProperty.getTypeRef().asTypeString(), aParentGenericProperty.getTypeRef().asTypeString());
            }
        }
        return false;
    }

    /**
     * check if type 1 and type 2 are identical; each type may be generic
     *
     * @param type1
     * @param type2
     * @return
     */
    public boolean typeSameAs(String type1, String type2) {
        return RMDefinitions.typeNameAsFlatList(type1).toString().equalsIgnoreCase(RMDefinitions.typeNameAsFlatList(type2).toString());
    }

    /**
     * check conformance of type 1 to type 2 for substitutability; each type may be generic
     *
     * @param type1
     * @param type2
     * @return
     */
    public boolean typeConformsTo(PRMSchema schema, String type1, String type2) {
        List<String> typeList1 = null, typeList2 = null;
        typeList1 = RMDefinitions.typeNameAsFlatList(type1);
        typeList2 = RMDefinitions.typeNameAsFlatList(type2);
        int index = 0;

        while(index < typeList1.size() && index < typeList2.size() &&
                schema.hasClassOrPrimitiveDefinition(typeList1.get(index)) &&
                schema.hasClassOrPrimitiveDefinition(typeList2.get(index))) {
            String typePart1 = typeList1.get(index);
            String typePart2 = typeList2.get(index);
            if(!(type1.equalsIgnoreCase(typePart2)
                    || isAncestor(schema, typePart1, typePart2))) {
                return false;
            }
            index++;

        }
        return true;
    }

    /**
     * Return true if typePart2 is an ancestor of typePart1 in the given schema
     * @param schema
     * @param typePart1
     * @param typePart2
     * @return
     */
    public boolean isAncestor(PRMSchema schema, String typePart1, String typePart2) {
        PRMClass classOrPrimitiveDefinition = schema.findClassOrPrimitiveDefinition(typePart1);
        List<String> ancestors = classOrPrimitiveDefinition.getAncestorTypeNames();
        if(ancestors.contains(typePart2)) { //direct ancestor
            return true;
        }
        for(String ancestor:ancestors) {
            if(isAncestor(schema, typePart1, ancestor)) { //recursive check
                return true;
            }
        }
        return false;
    }

    /**
     * check conformance of type 1 to type 2 for redefinition; each type may be generic
     *
     * @param type1
     * @param type2
     * @return
     */
    public boolean typeStrictlyConformsTo(PRMSchema schema, String type1, String type2) {
        return typeSameAs(type1,type2) || typeConformsTo(schema, type1, type2);
    }
}
