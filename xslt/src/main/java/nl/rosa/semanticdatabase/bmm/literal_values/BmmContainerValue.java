package nl.rosa.semanticdatabase.bmm.literal_values;

/**
 * 
 * Meta-type for literals whose concrete type is a linear container type, i.e.
 * array, list or set.
 * 
*/
public interface BmmContainerValue extends BmmLiteralValue {

/* * ATTRIBUTE * */

/**
 * 
 * Declared or inferred static type of the entity.
 * 
*/
    BmmContainerValue getType();
    void setType(value BmmContainerValue);

/* * FUNCTION * */

}
