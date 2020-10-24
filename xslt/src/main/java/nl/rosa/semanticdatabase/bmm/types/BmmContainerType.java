package nl.rosa.semanticdatabase.bmm.types;

/**
 * 
 * Meta-type that specifies linear containers with a generic parameter corresponding to the type of contained item, and whose container type is a generic type such as List<T>, Set<T> etc.
 * 
*/
public interface BmmContainerType extends BmmType {

/**
 * 
 * The type of the container.
 * This converts to the root_type in BMM_GENERIC_TYPE.
 * 
*/
BmmGenericClass getContainerClass()
setContainerClass(var BmmGenericClass)

/**
 * 
 * The container item type.
 * 
*/
BmmUnitaryType getItemType()
setItemType(var BmmUnitaryType)

/**
 * 
 * True indicates that order of the items in the container attribute is considered significant and must be preserved, e.g.
 * across sessions, serialisation, deserialisation etc.
 * Otherwise known as 'list' semantics.
 * 
*/
Boolean {default = true} getIsOrdered()
setIsOrdered(var Boolean {default = true})

/**
 * 
 * True indicates that only unique instances of items in the container are allowed.
 * Otherwise known as 'set' semantics.
 * 
*/
Boolean {default = false} getIsUnique()
setIsUnique(var Boolean {default = false})

}
