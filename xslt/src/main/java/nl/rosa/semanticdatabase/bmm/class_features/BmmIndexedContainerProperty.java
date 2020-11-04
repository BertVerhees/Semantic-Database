package nl.rosa.semanticdatabase.bmm.class_features;

/**
 * 
 * Meta-type of for properties of linear container type, such as Hash<Index_type, T> etc.
 * 
*/
public interface BmmIndexedContainerProperty extends BmmContainerProperty {

/* * ATTRIBUTE * */

/**
 * 
 * Declared or inferred static type of the entity.
 * 
*/
    BmmIndexedContainerType getType();
    void setType(BmmIndexedContainerType value);

/* * FUNCTION * */

/**
 * 
 * Name of this property in form name: ContainerTypeName<IndexTypeName, …​>.
 * 
*/
    String  display_name();

/* * CONSTANTS * */

}
