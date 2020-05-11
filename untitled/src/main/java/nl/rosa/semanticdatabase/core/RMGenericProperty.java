package nl.rosa.semanticdatabase.referencemodel.core;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Default created on 2-5-2020
 */

@Getter
@Setter
public class RMGenericProperty extends RMProperty<RMGenericType> implements Serializable {

    private RMGenericType rmGenericTypeDef;//fix to call it typeDef once fix has been made to this attribute in parent class;

    public RMGenericProperty(String name, RMGenericType type) {
        super(name, type);
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
