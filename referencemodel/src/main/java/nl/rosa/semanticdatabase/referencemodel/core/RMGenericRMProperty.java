package nl.rosa.semanticdatabase.referencemodel.core;

import java.io.Serializable;

/**
 * Default created on 2-5-2020
 */

public class RMGenericRMProperty extends RMProperty<RMGenericRMTypeTypeElement> implements Serializable {

    private RMGenericRMTypeTypeElement RMGenericTypeDef;//fix to call it typeDef once fix has been made to this attribute in parent class;

    public RMGenericRMProperty(String name, RMGenericRMTypeTypeElement type) {
        super(name, type);
    }

    public RMGenericRMTypeTypeElement getRMGenericTypeDef() {
        return RMGenericTypeDef;
    }

    public void setRMGenericTypeDef(RMGenericRMTypeTypeElement RMGenericTypeDef) {
        this.RMGenericTypeDef = RMGenericTypeDef;
    }

//    public String toString() {
//        return serialize();
//    }
//
//    public String serialize() {
//        return serialize(0);
//    }

//    public String serialize(int indentation) {
//        StringBuilder builder = new StringBuilder();
//        int indentCount = indentation;
//        indentBy(builder, indentCount);
//        builder.append("[\"").append(getName()).append("\"] = (").append(BmmProperty.P_BMM_GENERIC_PROPERTY).append(") <").append("\n");
//        indentCount++;
//        indentBy(builder, indentCount);
//        builder.append(OdinSerializationUtils.buildOdinStringObjectPropertyInitialization(BmmConstants.BMM_PROPERTY_NAME, getName()));
//        indentBy(builder, indentCount);
//        builder.append(BmmConstants.BMM_PROPERTY_TYPE_DEF).append(" = <").append("\n");
//        indentCount++;
//        indentBy(builder, indentCount);
////        builder.append(OdinSerializationUtils.buildOdinStringObjectPropertyInitialization(BmmConstants.BMM_PROPERTY_ROOT_TYPE, getGenericTypeDef().getRootType()));
//        indentBy(builder, indentCount);
////        builder.append(OdinSerializationUtils.buildOdinListPropertyInitialization(BmmConstants.BMM_PROPERTY_GENERIC_PARAMETERS, getGenericTypeDef().getGenericParameters()));
//        indentCount--;
//        indentBy(builder, indentCount);
//        builder.append(">").append("\n");
//        if(getMandatory() != null && getMandatory()) {
//            indentBy(builder, indentCount);
//            builder.append(OdinSerializationUtils.buildOdinBooleanObjectPropertyInitialization(BmmConstants.BMM_PROPERTY_IS_MANDATORY, true));
//        }
//        indentCount--;
//        indentBy(builder, indentCount);
//        builder.append(">").append("\n");
//        return builder.toString();
//    }
}
