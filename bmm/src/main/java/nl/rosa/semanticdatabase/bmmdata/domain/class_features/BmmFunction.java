package nl.rosa.semanticdatabase.bmmdata.domain.class_features;


import lombok.*;
import nl.rosa.semanticdatabase.bmmdata.domain.classes.BmmClass;
import nl.rosa.semanticdatabase.bmmdata.domain.types.BmmType;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Class BmmFunction
 * A formal element with signature of the form: name ({arg:TArg}*):TResult. A
 * function is a computed (rather than data) element, generally assumed to be
 * non-state-changing.
 *
 * Invariants
 * Operator_validity: operator_def /= Void implies arity in |1..2|
 * Inv_signature_has_result: signature.result /= Void
 * Inv_result_type: type = Result.type
 */
public class BmmFunction extends BmmRoutine implements BmmTypedFeature{


  /**
   * 0..1
   * BMM_OPERATOR
   * Optional details enabling a function to be represented as an operator in a syntactic representation.
   */
  @Getter
  @Setter
  private BmmOperator operatorDefinition;
  /**
   * Automatically created Result variable, usable in body and post-condition.
   */
  @NonNull
  @Getter
  @Setter
  private BmmResult result;
  /**
   * 0..1
   * is_nullable: Boolean
   * {default = false}
   * True if this element can be null (Void) at execution time. May be interpreted as optionality in subtypes..
   * Implemented by interface BmmTypedFeature
   */
  @NonNull
  @Getter
  @Setter
  private Boolean isNullable;

  /**
   * 1..1
   * type: BMM_TYPE
   * Declared or inferred static type of the entity.
   *
   * Implemented because of implemented derived interface from BmmTyped
   */
  @NonNull
  @Getter
  @Setter
  private BmmType type;

  /**
   * 1..1
   * is_boolean (): Boolean
   * Post_result: Result = type().equal( {BMM_MODEL}.boolean_type_definition())
   * True if type is notionally Boolean (i.e. a BMM_SIMPLE_TYPE with type_name() = 'Boolean').
   * @return
   */
  @NonNull
  public Boolean isBoolean() {
    return null;
  }
}
