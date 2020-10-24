package nl.rosa.semanticdatabase.bmm.literal_values;

/**
 * 
 * Meta-type for literals whose concrete type is a linear container type, i.e.
 * array, list or set.
 * 
*/
public interface BmmContainerValue extends BmmLiteralValue {

/**
 * 
 * Declared or inferred static type of the entity.
 * 
*/
BmmContainerType getType()
setType(var BmmContainerType)

}
