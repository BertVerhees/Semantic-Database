package nl.rosa.semanticdatabase.bmmdata.model.types;

import lombok.Data;
import nl.rosa.semanticdatabase.bmmdata.model.BmmBaseEntity;
import nl.rosa.semanticdatabase.bmmdata.model.classes.BmmGenericClass;

import javax.validation.constraints.NotNull;
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
public class BmmContainerType extends BmmBaseEntity implements BmmType {
/**
 * BmmType
 *  BmmEntity
 */
  /**
   * BmmType
   */
  // Functions
  @NotNull
  public String typeName(){
    return null;
  }
  @NotNull
  public List<String> flattenedTypeList(){
    return null;
  }
  @NotNull
  public String typeSignature(){
    return null;
  }
  @NotNull
  public BmmUnitaryType unitaryType(){
    return null;
  }
  @NotNull
  public BmmEffectiveType effectiveType(){
    return null;
  }
  /**
   * BmmEntity
   */
  // Functions
  @NotNull
  public Boolean isAbstract(){
    return null;
  }
  @NotNull
  public Boolean isPrimitive(){
    return null;
  }
  //==================================================================================
  /**
   * 1..1
   * container_class: BMM_GENERIC_CLASS
   * The type of the container. This converts to the root_type in BMM_GENERIC_TYPE.
   */
  @NotNull
  private BmmGenericClass containerClass;
  /**
   * 1..1
   * item_type: BMM_UNITARY_TYPE
   * The container item type.
   */
  @NotNull
  private BmmUnitaryType itemType;
  /**
   * 0..1
   * is_ordered: Boolean
   * {default = true}
   * True indicates that order of the items in the container attribute is considered significant and must be preserved,
   * e.g. across sessions, serialisation, deserialisation etc. Otherwise known as 'list' semantics.
   * True indicates that order of the items in the container attribute is considered significant
   * and must be preserved, e.g. across sessions, serialisation, deserialisation etc. Otherwise known
   * as 'list' semantics.
   */
  private Boolean isOrdered = true;
  /**
   * 0..1
   * is_unique: Boolean
   * {default = false}
   * True indicates that only unique instances of items in the container are allowed.
   * Otherwise known as 'set' semantics.
   */
  private Boolean isUnique = false;
  
  //
  // Constructors
  //
  public BmmContainerType () { }

  /**
   * True if this declaration entity is the root of the declaration hierarchy.
   * @return
   */
  public Boolean isRootScope() {
    return false;
  }


}
