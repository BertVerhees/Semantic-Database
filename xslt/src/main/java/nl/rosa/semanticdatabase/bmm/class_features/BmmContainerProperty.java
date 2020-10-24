package nl.rosa.semanticdatabase.bmm.class_features;

/**
 * 
 * Meta-type of for properties of linear container type, such as List<T> etc.
 * 
*/
public interface BmmContainerProperty extends BmmProperty {

/**
 * 
 * Cardinality of this container.
 * 
*/
MultiplicityInterval getCardinality()
setCardinality(var MultiplicityInterval)

/**
 * 
 * Declared or inferred static type of the entity.
 * 
*/
BmmContainerType getType()
setType(var BmmContainerType)

}
