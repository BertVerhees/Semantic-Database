package nl.rosa.semanticdatabase.bmm.types;

/**
 * 
 * Special type representing the type of a tuple, i.e.
 * an array of any number of other types.
 * This includes both container and unitary types, since tuple instances represent concrete objects.
 * Note that both open and closed generic parameters are allowed, as with any generic type, but open generic parameters are only valid within the scope of a generic class.
 * 
*/
public interface BmmTupleType extends BmmEffectiveType {

/* * ATTRIBUTE * */

/**
 * 
 * List of types of the items of the tuple, keyed by purpose in the tuple.
 * 
*/
    Map<String,BmmType> getItemTypes();
    void setItemTypes(Map<String,BmmType> value);

/* * FUNCTION * */

/**
 * 
 * Return base_name.
 * 
*/
    Result.is_equal (base_name())  type_base_name();

/**
 * 
 * Result = True.
 * 
*/
    Boolean  is_primitive();

/**
 * 
 * Result = False.
 * 
*/
    Boolean  is_abstract();

/**
 * 
 * Return base_name.
 * 
*/
    Result.is_equal (base_name())  type_name();

/**
 * 
 * Return the logical set (i.e.
 * unique types) from the merge of flattened_type_list() called on each member of item_types.
 * 
*/
    List<String>  flattened_type_list();

/* * CONSTANTS * */

/**
 * 
 * Base name (built-in).
 * 
*/
    String baseName = "Tuple";

}
