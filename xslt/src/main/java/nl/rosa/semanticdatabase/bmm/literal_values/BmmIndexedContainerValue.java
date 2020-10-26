package nl.rosa.semanticdatabase.bmm.literal_values;

/**
 * 
 * Meta-type for literals whose concrete type is an indexed container, i.e.
 * Hash table, Map etc.
 * 
*/
public interface BmmIndexedContainerValue extends BmmContainerValue {

/* * ATTRIBUTE * */

/**
 * 
 * Declared or inferred static type of the entity.
 * 
*/
BmmIndexedContainerType getType();
void setType(value BmmIndexedContainerType);

/* * FUNCTION * */

}
