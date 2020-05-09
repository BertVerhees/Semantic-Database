package nl.rosa.semanticdatabase.referencemodel.bmm.types;

import nl.rosa.semanticdatabase.referencemodel.bmm.classes.BmmGenericClass;


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
  private classes.BmmGenericClass containerClass;
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


  //
  // Accessor methods
  //

  /**
   * Set the value of containerClass
   * The type of the container. This converts to the root_type in BMM_GENERIC_TYPE.
   * @param newVar the new value of containerClass
   */
  public void setContainerClass (classes.BmmGenericClass newVar) {
    containerClass = newVar;
  }

  /**
   * Get the value of containerClass
   * The type of the container. This converts to the root_type in BMM_GENERIC_TYPE.
   * @return the value of containerClass
   */
  public classes.BmmGenericClass getContainerClass () {
    return containerClass;
  }

  /**
   * Set the value of itemType
   * The container item type.
   * @param newVar the new value of itemType
   */
  public void setItemType (types.BmmUnitaryType newVar) {
    itemType = newVar;
  }

  /**
   * Get the value of itemType
   * The container item type.
   * @return the value of itemType
   */
  public types.BmmUnitaryType getItemType () {
    return itemType;
  }

  /**
   * Set the value of isOrdered
   * True indicates that order of the items in the container attribute is considered
   * significant and must be preserved, e.g. across sessions, serialisation,
   * deserialisation etc. Otherwise known as 'list' semantics.
   * @param newVar the new value of isOrdered
   */
  public void setIsOrdered (boolean newVar) {
    isOrdered = newVar;
  }

  /**
   * Get the value of isOrdered
   * True indicates that order of the items in the container attribute is considered
   * significant and must be preserved, e.g. across sessions, serialisation,
   * deserialisation etc. Otherwise known as 'list' semantics.
   * @return the value of isOrdered
   */
  public boolean getIsOrdered () {
    return isOrdered;
  }

  /**
   * Set the value of isUnique
   * True indicates that only unique instances of items in the container are allowed.
   * Otherwise known as 'set' semantics.
   * @param newVar the new value of isUnique
   */
  public void setIsUnique (boolean newVar) {
    isUnique = newVar;
  }

  /**
   * Get the value of isUnique
   * True indicates that only unique instances of items in the container are allowed.
   * Otherwise known as 'set' semantics.
   * @return the value of isUnique
   */
  public boolean getIsUnique () {
    return isUnique;
  }

  //
  // Other methods
  //

}
