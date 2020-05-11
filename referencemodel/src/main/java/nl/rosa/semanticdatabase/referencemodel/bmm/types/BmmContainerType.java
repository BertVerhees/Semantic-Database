package nl.rosa.semanticdatabase.referencemodel.bmm.types;

import lombok.Data;
import nl.rosa.semanticdatabase.referencemodel.bmm.classes.BmmGenericClass;

import java.util.List;


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
@Data
public class BmmContainerType implements BmmType {
  /**
   * The type of the container. This converts to the root_type in BMM_GENERIC_TYPE.
   */
  private BmmGenericClass containerClass;
  /**
   * The container item type.
   */
  private BmmUnitaryType itemType;
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
  public BmmContainerType () { }

  /**
   * Return full type name, e.g. List<ELEMENT>.
   * @return
   */
  @Override
  public String typeName() {
    //TODO
    return null;
  }

  /**
   * Flattened list of type names with container type name abstracted away.
   * Post_result: Result = item_type.flattened_type_list
   * @return
   */
  @Override
  public List<String> flattenedTypeList() {
    //TODO
    return null;
  }

  @Override
  public String typeSignature() {
    //TODO
    return null;
  }

  /**
   * Return item_type.
   */
  @Override
  public BmmUnitaryType unitaryType() {
    //TODO
    return null;
  }

  @Override
  public BmmEffectiveType effectiveType() {
    //TODO
    return null;
  }

  /**
   * True if the container class is abstract.
   * @return
   */
  @Override
  public boolean isAbstract() {
    //TODO
    return false;
  }

  /**
   * True if item_type is primitive.
   * Post_result: Result = item_type.is_primitive
   * @return
   */
  @Override
  public boolean isPrimitive() {
    //TODO
    return false;
  }
  /**
   * True if this declaration entity is the root of the declaration hierarchy.
   * @return
   */
  @Override
  public boolean isRootScope() {
    return false;
  }

  /**
   * Formal string form of the type as per UML.
   * @return
   */
  @Override
  public String typeName() {
    //TODO
    return null;
  }

  /**
   * Completely flattened list of type names, flattening out all generic parameters.
   * @return
   */
  @Override
  public List<String> flattenedTypeList() {
    //TODO
    return null;
  }

  /**
   * Signature form of the type name, which for generics includes generic parameter constrainer types E.g. Interval<T:Ordered>.
   *
   * Defaults to the value of type_name().
   * @return
   */
  @Override
  public String typeSignature() {
    //TODO
    return null;
  }

  /**
   * Type with any container abstracted away.
   * @return
   */
  @Override
  public BmmUnitaryType unitaryType() {
    //TODO
    return null;
  }

  /**
   * Type with any container abstracted away, and any formal parameter replaced by its effective constraint type.
   * @return
   */
  @Override
  public BmmEffectiveType effectiveType() {
    //TODO
    return null;
  }

}
