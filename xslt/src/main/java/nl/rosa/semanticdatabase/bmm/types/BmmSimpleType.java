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
    BmmSimpleClass getBaseClass();
    void setBaseClass(BmmSimpleClass value);

/* * FUNCTION * */

/**
 * 
 * Result is base_class.name.
 * 
*/
    String  type_name();

/**
 * 
 * Result is base_class.is_abstract.
 * 
*/
    Boolean  is_abstract();

/**
 * 
 * Result is base_class.name .
 * 
*/
    List<String>  flattened_type_list();

/**
 * 
 * Main design class for this type, from which properties etc can be extracted.
 * 
*/
    BmmSimpleClass  effective_base_class();

}
