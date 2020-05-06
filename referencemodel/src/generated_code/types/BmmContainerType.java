package types;


/**
 * Class BmmContainerType
 * Meta-type that specifies linear containers with a generic parameter
 * corresponding to the type of contained item, and whose container type is a
 * generic type such as List<T>, Set<T> etc.
 * 
 * (effected) type_name (): String
 * Return full type name, e.g. List<ELEMENT>.
 * (effected) is_abstract (): Boolean
 * Post_is_abstract: Result = container_type.is_abstract
 * True if the container class is abstract.
 * (effected) flattened_type_list (): List<String>
 * Post_result: Result = item_type.flattened_type_list
 * Flattened list of type names with container type name abstracted away.
 * (effected) unitary_type (): BMM_UNITARY_TYPE
 * Return item_type.
 * (effected) is_primitive (): Boolean
 * Post_result: Result = item_type.is_primitive
 * True if item_type is primitive.
 * 
 */
public class BmmContainerType extends BmmType {

  //
  // Fields
  //

  /**
   * The type of the container. This converts to the root_type in BMM_GENERIC_TYPE.
   */
  private BmmGenericClass containerClass;
  /**
   * The container item type.
   */
  private types.BmmUnitaryType itemType;
  /**
   * True indicates that order of the items in the container attribute is considered significant and must be preserved, e.g. across sessions, serialisation, deserialisation etc. Otherwise known as 'list' semantics.
   */
  private boolean isOrdered = true;
  /**
   * True indicates that only unique instances of items in the container are allowed. Otherwise known as 'set' semantics.
   */
  private boolean isUnique = false;
  
  //
  // Constructors
  //
  public BmmContainerType () { };
  
  //
  // Methods
  //


}
