package nl.rosa.semanticdatabase.referencemodel.bmm.class_features;


import lombok.Data;
import nl.rosa.semanticdatabase.referencemodel.bmm.classes.BmmClass;
import nl.rosa.semanticdatabase.referencemodel.bmm.expressions.ElAssertion;
import nl.rosa.semanticdatabase.referencemodel.bmm.functional_elements.BmmStatementItem;
import nl.rosa.semanticdatabase.referencemodel.bmm.types.BmmType;

import java.util.List;

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
  // BmmRoutine
  private boolean isSynthesisedGeneric;

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
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of operatorDefinition
   * Optional details enabling a function to be represented as an operator in a
   * syntactic representation.
   * @param newVar the new value of operatorDefinition
   */
  public void setOperatorDefinition (class_features.BmmOperator newVar) {
    operatorDefinition = newVar;
  }

  /**
   * Get the value of operatorDefinition
   * Optional details enabling a function to be represented as an operator in a
   * syntactic representation.
   * @return the value of operatorDefinition
   */
  public class_features.BmmOperator getOperatorDefinition () {
    return operatorDefinition;
  }

  /**
   * Set the value of result
   * Automatically created Result variable, usable in body and post-condition.
   * @param newVar the new value of result
   */
  public void setResult (class_features.BmmResult newVar) {
    result = newVar;
  }

  /**
   * Get the value of result
   * Automatically created Result variable, usable in body and post-condition.
   * @return the value of result
   */
  public class_features.BmmResult getResult () {
    return result;
  }

  //
  // Other methods
  //

}
