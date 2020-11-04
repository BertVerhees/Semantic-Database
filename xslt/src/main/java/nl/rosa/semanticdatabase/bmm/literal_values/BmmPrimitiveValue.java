package nl.rosa.semanticdatabase.bmm.literal_values;

/**
 * 
 * Meta-type for literals whose concrete type is a primitive type.
 * 
*/
public interface BmmPrimitiveValue extends BmmUnitaryValue {

/* * ATTRIBUTE * */

/**
 * 
 * Declared or inferred static type of the entity.
 * 
*/
    BmmSimpleType getType();
    void setType(BmmSimpleType value);

/* * FUNCTION * */

/* * CONSTANTS * */

}
