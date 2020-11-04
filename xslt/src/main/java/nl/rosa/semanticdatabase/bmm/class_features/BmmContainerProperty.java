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
    Multiplicity_interval getCardinality();
    void setCardinality(Multiplicity_interval value);

/**
 * 
 * Declared or inferred static type of the entity.
 * 
*/
    BmmContainerType getType();
    void setType(BmmContainerType value);

/* * FUNCTION * */

/**
 * 
 * Name of this property in form name: ContainerTypeName<>.
 * 
*/
    String  display_name();

/* * CONSTANTS * */

}
