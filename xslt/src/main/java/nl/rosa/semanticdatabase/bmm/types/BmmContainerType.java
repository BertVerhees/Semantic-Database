package nl.rosa.semanticdatabase.bmm.types;

/**
 * 
 * Meta-type that specifies linear containers with a generic parameter corresponding to the type of contained item, and whose container type is a generic type such as List<T>, Set<T> etc.
 * 
*/
public interface BmmContainerType extends BmmType {

/* * ATTRIBUTE * */

/**
 * 
 * The type of the container.
 * This converts to the root_type in BMM_GENERIC_TYPE.
 * 
*/
    BmmContainerType getContainerClass();
    void setContainerClass(BmmContainerType value);

/**
 * 
 * The container item type.
 * 
*/
    BmmContainerType getItemType();
    void setItemType(BmmContainerType value);

/* * FUNCTION * */

/**
 * 
 * Return full type name, e.g.
 * List<ELEMENT>.
 * 
*/
    BmmContainerType  type_name();

/**
 * 
 * True if the container class is abstract.
 * 
*/
    BmmContainerType  is_abstract();

/**
 * 
 * Flattened list of type names of item_type, i.e.
 * item_type.flattened_type_list().
 * 
*/
    BmmContainerType  flattened_type_list();

/**
 * 
 * Return item_type.
 * 
*/
    BmmContainerType  unitary_type();

/**
 * 
 * True if item_type is primitive.
 * 
*/
    BmmContainerType  is_primitive();

/**
 * 
 * Return item_type.effective_type().
 * 
*/
    BmmContainerType  effective_type();

}
