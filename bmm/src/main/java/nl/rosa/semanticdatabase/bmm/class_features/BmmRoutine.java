package nl.rosa.semanticdatabase.bmm.class_features;

import nl.rosa.semanticdatabase.bmm.classes.BmmClass;
import nl.rosa.semanticdatabase.bmm.expressions.ElAssertion;
import nl.rosa.semanticdatabase.bmm.functional_elements.BmmStatementItem;

import java.util.List;


/**
 * Class BmmRoutine
 * A feature defining a routine, scoped to a class.
 */
public interface BmmRoutine extends BmmClassScoped {


  //
  // Accessor methods
  //

  /**
   * Set the value of scope
   * @param newVar the new value of scope
   */
  void setScope (BmmClass newVar);
  /**
   * Get the value of scope
   * @return the value of scope
   */
  BmmClass getScope ();


  /**
   * Set the value of parameters
   * Formal parameters of the routine.
   * @param newVar the new value of parameters
   */
  void setParameters (List<BmmParameter> newVar);

  /**
   * Get the value of parameters
   * Formal parameters of the routine.
   * @return the value of parameters
   */
  List<BmmParameter> getParameters ();

  /**
   * Set the value of locals
   * Local variables of the routine.
   * @param newVar the new value of locals
   */
  void setLocals (List<BmmLocal> newVar);

  /**
   * Get the value of locals
   * Local variables of the routine.
   * @return the value of locals
   */
  List<BmmLocal> getLocals ();

  /**
   * Set the value of preConditions
   * @param newVar the new value of preConditions
   */
  void setPreConditions (List<ElAssertion> newVar);

  /**
   * Get the value of preConditions
   * @return the value of preConditions
   */
  List<ElAssertion> getPreConditions ();

  /**
   * Set the value of postCondtions
   * @param newVar the new value of postCondtions
   */
  void setPostCondtions (List<ElAssertion> newVar);

  /**
   * Get the value of postCondtions
   * @return the value of postCondtions
   */
  List<ElAssertion> getPostCondtions ();

  /**
   * Set the value of body
   * Body of a routine, i.e. executable program.
   * @param newVar the new value of body
   */
  void setBody (BmmStatementItem newVar);

  /**
   * Get the value of body
   * Body of a routine, i.e. executable program.
   * @return the value of body
   */
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
