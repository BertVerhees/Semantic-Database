package nl.rosa.semanticdatabase.bmmdata.domain.class_features;

import lombok.Data;
import lombok.EqualsAndHashCode;
import nl.rosa.semanticdatabase.bmmdata.domain.expressions.ElAssertion;
import nl.rosa.semanticdatabase.bmmdata.domain.routine_implementation.BmmStatementItem;
import nl.rosa.semanticdatabase.bmmdata.domain.types.BmmSignature;

import javax.persistence.Entity;
import java.util.List;


/**
 * Class BmmRoutine
 * A feature defining a routine, scoped to a class.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public abstract class BmmRoutine extends BmmClassScoped {

  /**
   * 0..1
   * parameters: List<BMM_PARAMETER>
   * Formal parameters of the routine.
   */
  private List<BmmParameter> parameters;

  /**
   * 0..1
   * locals: List<BMM_LOCAL>
   * Local variables of the routine.
   */
  private List<BmmLocal> locals;

  /**
   * 0..1
   * pre_conditions: List<EL_ASSERTION>
   */
  private List<ElAssertion> preConditions;

  /**
   * 0..1
   * post_conditions: List<EL_ASSERTION>
   */
  private List<ElAssertion> postConditions;

  /**
   * 0..1
   * body: BMM_STATEMENT_ITEM
   * Body of a routine, i.e. executable program.
   */
  private BmmStatementItem body;
  // Functions

  /**
   * 1..1
   * arity (): Integer
   * Return number of arguments of this routine.
   * @return
   */
  public Integer arity() {
    return null;
  }

  /**
   * 1..1
   * (effected)
   * signature ()
   * Formal signature of this element, in the form
   * '[arg1_name: T_arg1, …​]:T_value'.
   * @return
   */
  public BmmSignature signature(){
    return null;
  }
}
