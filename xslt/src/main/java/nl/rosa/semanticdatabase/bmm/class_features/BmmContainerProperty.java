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
    BmmContainerProperty getCardinality();
    void setCardinality(BmmContainerProperty value);

/**
 * 
 * Declared or inferred static type of the entity.
 * 
*/
    BmmContainerProperty getType();
    void setType(BmmContainerProperty value);

/* * FUNCTION * */

/**
 * 
 * Name of this property in form name: ContainerTypeName<>.
 * 
*/
    BmmContainerProperty  display_name();

}
