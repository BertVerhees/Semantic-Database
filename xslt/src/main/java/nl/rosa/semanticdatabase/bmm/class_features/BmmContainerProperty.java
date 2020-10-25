package nl.rosa.semanticdatabase.bmm.class_features;

/**
 * 
 * Meta-type of for properties of linear container type, such as List<T> etc.
 * 
*/
public interface BmmContainerProperty extends BmmProperty {

/* * ATTRIBUTE * */

/**
 * 
 * Cardinality of this container.
 * 
*/
MultiplicityInterval getCardinality();
void setCardinality(var MultiplicityInterval);

/**
 * 
 * Declared or inferred static type of the entity.
 * 
*/
BmmContainerType getType();
void setType(var BmmContainerType);

/* * FUNCTION * */

/**
 * 
 * Name of this property in form name: ContainerTypeName<>.
 * display_name (): String
 * 
*/

}
