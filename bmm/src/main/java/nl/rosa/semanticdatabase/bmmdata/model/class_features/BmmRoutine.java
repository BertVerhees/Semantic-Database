package nl.rosa.semanticdatabase.bmmdata.model.class_features;

import nl.rosa.semanticdatabase.bmmdata.model.expressions.ElAssertion;
import nl.rosa.semanticdatabase.bmmdata.model.routine_implementation.BmmStatementItem;

import java.util.List;


/**
 * Class BmmRoutine
 * A feature defining a routine, scoped to a class.
 */
public interface BmmRoutine extends BmmClassScoped {

  /**
   * 0..1
   * parameters: List<BMM_PARAMETER>
   * Formal parameters of the routine.
   */
  void setParameters (List<BmmParameter> newVar);
  List<BmmParameter> getParameters ();

  /**
   * 0..1
   * locals: List<BMM_LOCAL>
   * Local variables of the routine.
   */
  void setLocals (List<BmmLocal> newVar);
  List<BmmLocal> getLocals ();

  /**
   * 0..1
   * pre_conditions: List<EL_ASSERTION>
   */
  void setPreConditions (List<ElAssertion> newVar);
  List<ElAssertion> getPreConditions ();

  /**
   * 0..1
   * post_conditions: List<EL_ASSERTION>
   */
  void setPostConditions (List<ElAssertion> newVar);
  List<ElAssertion> getPostConditions ();

  /**
   * 0..1
   * body: BMM_STATEMENT_ITEM
   * Body of a routine, i.e. executable program.
   */
  void setBody (BmmStatementItem newVar);
  BmmStatementItem getBody ();

  //
  // Other methods
  //

  /**
   * Return number of arguments of this routine.
   * @return       Integer
   */
  Integer arity();


}
