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
    BmmGenericClass getContainerClass();
    void setContainerClass(BmmGenericClass value);

/**
 * 
 * The container item type.
 * 
*/
     getItemType();
    void setItemType( value);

/* * FUNCTION * */

/**
 * 
 * Return full type name, e.g.
 * List<ELEMENT>.
 * 
*/
      type_name();

/**
 * 
 * True if the container class is abstract.
 * 
*/
      is_abstract();

/**
 * 
 * Flattened list of type names of item_type, i.e.
 * item_type.flattened_type_list().
 * 
*/
      flattened_type_list();

/**
 * 
 * Return item_type.
 * 
*/
      unitary_type();

/**
 * 
 * True if item_type is primitive.
 * 
*/
      is_primitive();

/**
 * 
 * Return item_type.effective_type().
 * 
*/
      effective_type();

}
