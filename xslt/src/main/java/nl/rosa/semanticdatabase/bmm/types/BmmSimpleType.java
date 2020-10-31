package nl.rosa.semanticdatabase.bmm.types;

/**
 * 
 * Type reference to a single type i.e.
 * not generic or container type.
 * 
*/
public interface BmmSimpleType extends BmmModelType {

/* * ATTRIBUTE * */

/**
 * 
 * Defining class of this type.
 * 
*/
    BmmSimpleType getBaseClass();
    void setBaseClass(BmmSimpleType value);

/* * FUNCTION * */

/**
 * 
 * Result is base_class.name.
 * 
*/
    BmmSimpleType  type_name();

/**
 * 
 * Result is base_class.is_abstract.
 * 
*/
    BmmSimpleType  is_abstract();

/**
 * 
 * Result is base_class.name .
 * 
*/
    BmmSimpleType  flattened_type_list();

/**
 * 
 * Main design class for this type, from which properties etc can be extracted.
 * 
*/
    BmmSimpleType  effective_base_class();

}
