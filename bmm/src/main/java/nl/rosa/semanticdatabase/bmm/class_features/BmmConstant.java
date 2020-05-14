package nl.rosa.semanticdatabase.bmm.class_features;

import lombok.*;
import nl.rosa.semanticdatabase.bmm.classes.BmmClass;
import nl.rosa.semanticdatabase.bmm.literal_values.BmmLiteralValue;
import nl.rosa.semanticdatabase.bmm.model_structure.BmmDeclaration;
import nl.rosa.semanticdatabase.bmm.types.BmmEffectiveType;
import nl.rosa.semanticdatabase.bmm.types.BmmSignature;
import nl.rosa.semanticdatabase.bmm.types.BmmType;
import nl.rosa.semanticdatabase.bmm.types.BmmUnitaryType;

import java.util.List;
import java.util.Map;


/**
 * Class BmmConstant
 * An immutable, static value-returning element scoped to a class.
 */
@Data
public class BmmConstant implements BmmClassScoped, BmmInstantiable {

  //
  // Fields
  //
  //BmmEntity
  private boolean isAbstract;
  private boolean isPrimitive;

  // BmmClassEntity
  private boolean isSynthesisedGeneric;

  // BmmDeclaration
  private String name;
  private Map<String,Object> documentation;
  private Map<String,Object> extensions;


  // BmmTypedFeature
  /**
   * True if this element can be null (Void) at execution time. May be interpreted as optionality in subtypes..
   * {default = false}   */

  private boolean isNullable;


  // BmmTyped
  /**
   * Declared or inferred static type of the entity.
   */
  private BmmType type;


  // BmmClassScoped
  /**
   * Visibility of this item to client entities.
   * TODO: define scheme; probably need to support C++/Java scheme as well as better type-based schemes.   */

  private Object visibility;
  private BmmClass scope;

  /**
   * The value of the constant.
   */
  private BmmLiteralValue value;
  
  //
  // Constructors
  //
  public BmmConstant () { };

  /**
   * Formal signature of this element, in the form:
   * name [arg1_name: T_arg1, �?][:T_value]
   * Specific implementations in descendants.
   */
  public BmmSignature signature(){
    //TODO
    return null;
  }

  /**
   * True if type is notionally Boolean (i.e. a BMM_SIMPLE_TYPE with type_name() =
   * 'Boolean').
   * @return       boolean
   */
  public boolean isBoolean(){
    //TODO
    return false;
  }


  @Override
  @Deprecated
  public void setScope(BmmDeclaration newVar) {
    this.scope = (BmmClass) newVar;
  }

  @Override
  public void setScope(BmmClass newVar) {
    this.scope = newVar;
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
   * Signature form of the type name, which for generics includes generic parameter constrainer nl.rosa.semanticdatabase.bmm.types E.g. Interval<T:Ordered>.
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

  // BmmEntity
  @Override
  public boolean isAbstract() {
    //TODO
    return false;
  }

  @Override
  public boolean isPrimitive() {
    //TODO
    return false;
  }

}
