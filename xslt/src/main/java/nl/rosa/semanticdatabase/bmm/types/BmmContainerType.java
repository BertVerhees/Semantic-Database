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
    void setContainerClass(value BmmGenericClass);

/**
 * 
 * The container item type.
 * 
*/
    BmmUnitaryType getItemType();
    void setItemType(value BmmUnitaryType);

/**
 * 
 * True indicates that order of the items in the container attribute is considered significant and must be preserved, e.g.
 * across sessions, serialisation, deserialisation etc.
 * Otherwise known as 'list' semantics.
 * 
*/
    Boolean {default = true} getIsOrdered();
    void setIsOrdered(value Boolean {default = true});

/**
 * 
 * True indicates that only unique instances of items in the container are allowed.
 * Otherwise known as 'set' semantics.
 * 
*/
    Boolean {default = false} getIsUnique();
    void setIsUnique(value Boolean {default = false});

/* * FUNCTION * */

/**
 * 
 * Return full type name, e.g.
 * List<ELEMENT>.
 * type_name (): String
 * 
*/
    String typeName ();

/**
 * 
 * True if the container class is abstract.
 * is_abstract (): Boolean Post_is_abstract: Result = container_type.is_abstract
 * 
*/
    Boolean postIsAbstract: result = containerType.isAbstract isAbstract ();

/**
 * 
 * Flattened list of type names of item_type, i.e.
 * item_type.flattened_type_list().
 * flattened_type_list (): List<String> Post_result: Result = item_type.flattened_type_list
 * 
*/
    List<string> postResult: result = itemType.flattenedTypeList flattenedTypeList ();

/**
 * 
 * Return item_type.
 * unitary_type (): BMM_UNITARY_TYPE
 * 
*/
    BmmUnitaryType unitaryType ();

/**
 * 
 * True if item_type is primitive.
 * is_primitive (): Boolean Post_result: Result = item_type.is_primitive
 * 
*/
    Boolean postResult: result = itemType.isPrimitive isPrimitive ();

/**
 * 
 * Return item_type.effective_type().
 * effective_type (): BMM_EFFECTIVE_TYPE
 * 
*/
    BmmEffectiveType effectiveType ();

}
