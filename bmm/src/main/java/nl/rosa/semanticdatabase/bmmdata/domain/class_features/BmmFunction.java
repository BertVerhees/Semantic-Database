package nl.rosa.semanticdatabase.bmmdata.domain.class_features;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
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
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class BmmFunction extends BmmRoutine implements BmmTypedFeature{


  /**
   * Optional details enabling a function to be represented as an operator in a syntactic representation.
   */
  private BmmOperator operatorDefinition;
  /**
   * Automatically created Result variable, usable in body and post-condition.
   */
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
  private Boolean isNullable;

  public BmmFunction setIsNullable(Boolean nullable) {
    isNullable = nullable;
    return this;
  }


  /**
   * 1..1
   * type: BMM_TYPE
   * Declared or inferred static type of the entity.
   *
   * Implemented because of implemented derived interface from BmmTyped
   */
  @NonNull
  @Getter
  private BmmType type;

  public BmmFunction setType(BmmType type) {
    this.type = type;
    return this;
  }
  /**
   * 1..1
   * is_boolean (): Boolean
   * Post_result: Result = type().equal( {BMM_MODEL}.boolean_type_definition())
   * True if type is notionally Boolean (i.e. a BMM_SIMPLE_TYPE with type_name() = 'Boolean').
   * @return
   */
  public Boolean isBoolean() {
    return null;
  }
  //========== counterparts =====================================================
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "fk_bmm_class_id")
  private BmmClass bmmClass;
}
