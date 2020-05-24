package nl.rosa.semanticdatabase.bmm.class_features;


import lombok.Data;
import nl.rosa.semanticdatabase.bmm.classes.BmmClass;
import nl.rosa.semanticdatabase.bmm.expressions.ElAssertion;
import nl.rosa.semanticdatabase.bmm.routine_implementation.BmmStatementItem;
import nl.rosa.semanticdatabase.bmm.model_structure.BmmDeclaration;
import nl.rosa.semanticdatabase.bmm.types.BmmEffectiveType;
import nl.rosa.semanticdatabase.bmm.types.BmmSignature;
import nl.rosa.semanticdatabase.bmm.types.BmmType;
import nl.rosa.semanticdatabase.bmm.types.BmmUnitaryType;

import java.util.List;
import java.util.Map;

/**
 * Class BmmFunction
 * A formal element with signature of the form: name ({arg:TArg}*):TResult. A
 * function is a computed (rather than data) element, generally assumed to be
 * non-state-changing.
 */
@Data
public class BmmFunction implements BmmRoutine, BmmTypedFeature {

  //
  // Fields
  //

  // BmmDeclaration
  private String name;
  private Map<String,Object> documentation;
  private Map<String,Object> extensions;

  // BmmClassEntity
  private boolean isSynthesisedGeneric;

  //BmmEntity
  private boolean isAbstract;
  private boolean isPrimitive;


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


  //BmmClassScoped
  /**
   * Visibility of this item to client entities.
   * TODO: define scheme; probably need to support C++/Java scheme as well as better type-based schemes.   */

  private Object visibility;
  private BmmClass scope;

  /**
   * Formal parameters of the routine.
   */
  private List<BmmParameter> parameters;
  /**
   * Local variables of the routine.
   */
  private List<BmmLocal> locals;
  private List<ElAssertion> preConditions;
  private List<ElAssertion> postCondtions;
  /**
   * Body of a routine, i.e. executable program.
   */
  private BmmStatementItem body;



  /**
   * Optional details enabling a function to be represented as an operator in a syntactic representation.
   */
  private BmmOperator operatorDefinition;
  /**
   * Automatically created Result variable, usable in body and post-condition.
   */
  private BmmResult result;
  
  //
  // Constructors
  //
  public BmmFunction () { };

  @Override
  public void setScope(BmmClass newVar) {
    this.scope = newVar;
  }

  /**
   * Return number of arguments of this routine.
   * @return
   */
  @Override
  public Integer arity() {
    //TODO
    return null;
  }
  /**
   * Formal signature of this element, in the form
   *
   * '[arg1_name: T_arg1, …​]:T_value'.
   * @return
   */
  @Override
  public BmmSignature signature() {
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
