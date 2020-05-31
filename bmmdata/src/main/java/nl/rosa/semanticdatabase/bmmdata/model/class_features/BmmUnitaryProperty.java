package nl.rosa.semanticdatabase.bmmdata.model.class_features;

import lombok.Data;
import nl.rosa.semanticdatabase.base.MultiplicityInterval;
import nl.rosa.semanticdatabase.bmmdata.model.BmmBaseEntity;
import nl.rosa.semanticdatabase.bmmdata.model.classes.BmmClass;
import nl.rosa.semanticdatabase.bmmdata.model.model_structure.BmmDeclaration;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmEffectiveType;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmSignature;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmType;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmUnitaryType;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;


/**
 * Class BmmUnitaryProperty
 * Meta-type of for properties of unitary type.
 */
@Data
public class BmmUnitaryProperty extends BmmBaseEntity implements BmmProperty {

  /**
   * BmmDeclaration
   */
  @NotNull
  private String name;
  private Map<String, Object> documentation;
  private Map<String, Object> extensions;

  @Override
  public boolean isRootScope(){
    return scope.equals(this);
  }
  /**
   * BmmClassEntity
   */
  private boolean isSynthesisedGeneric;
  /**
   * BmmClassScoped
   */
  private Object visibility;
  @NotNull private BmmClass scope;
  /**
   * BmmProperty
   */
  private boolean isImRuntime;
  private boolean isImInfrastructure;
  private boolean isComposition;


  // BmmTypedFeature
  /**
   * True if this element can be null (Void) at execution time. May be interpreted as optionality in subtypes..
   * {default = false}   */

  private boolean isNullable;





  /**
   * Declared or inferred static type of the entity.
   */
  private BmmUnitaryType type;
  
  //
  // Constructors
  //
  public BmmUnitaryProperty () { };
  
  @Override
  public void setType(BmmType newVar) {
    this.type = (BmmUnitaryType) newVar;
  }

  //
  // Other methods
  //
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
   * Signature form of the type name, which for generics includes generic parameter constrainer nl.rosa.semanticdatabase.bmm.model.types E.g. Interval<T:Ordered>.
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

  /**
   * Formal signature of this element, in the form:
   *
   * name [arg1_name: T_arg1, …​][:T_value]
   *
   * Specific implementations in descendants.
   * @return
   */
  @Override
  public BmmSignature signature() {
    //TODO
    return null;
  }


  @Override
  public MultiplicityInterval existence() {
    //TODO
    return null;
  }

  @Override
  public String displayName() {
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

  @Override
  public void setScope(BmmClass newVar) {
    this.scope = newVar;
  }
}
