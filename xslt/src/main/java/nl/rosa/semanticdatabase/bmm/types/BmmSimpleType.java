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
void setBaseClass(var BmmSimpleClass);

/* * FUNCTION * */

/**
 * 
 * Result is base_class.name.
 * type_name (): String
 * 
*/

/**
 * 
 * Result is base_class.is_abstract.
 * is_abstract (): Boolean
 * 
*/

/**
 * 
 * Result is base_class.name .
 * flattened_type_list (): List<String>
 * 
*/

/**
 * 
 * Main design class for this type, from which properties etc can be extracted.
 * effective_base_class (): BMM_SIMPLE_CLASS
 * 
*/

}
