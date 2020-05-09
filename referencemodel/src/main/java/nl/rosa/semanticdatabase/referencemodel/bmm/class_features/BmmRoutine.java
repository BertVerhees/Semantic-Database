package nl.rosa.semanticdatabase.referencemodel.bmm.class_features;
import expressions.ElAssertion;
import functional_elements.BmmStatementItem;


/**
 * Class BmmRoutine
 * A feature defining a routine, scoped to a class.
 */
abstract public class BmmRoutine extends BmmClassScoped {

  //
  // Fields
  //

  /**
   * Formal parameters of the routine.
   */
  private class_features.BmmParameter parameters;
  /**
   * Local variables of the routine.
   */
  private class_features.BmmLocal locals;
  private expressions.ElAssertion preConditions;
  private expressions.ElAssertion postCondtions;
  /**
   * Body of a routine, i.e. executable program.
   */
  private functional_elements.BmmStatementItem body;
  
  //
  // Constructors
  //
  public BmmRoutine () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of parameters
   * Formal parameters of the routine.
   * @param newVar the new value of parameters
   */
  public void setParameters (class_features.BmmParameter newVar) {
    parameters = newVar;
  }

  /**
   * Get the value of parameters
   * Formal parameters of the routine.
   * @return the value of parameters
   */
  public class_features.BmmParameter getParameters () {
    return parameters;
  }

  /**
   * Set the value of locals
   * Local variables of the routine.
   * @param newVar the new value of locals
   */
  public void setLocals (class_features.BmmLocal newVar) {
    locals = newVar;
  }

  /**
   * Get the value of locals
   * Local variables of the routine.
   * @return the value of locals
   */
  public class_features.BmmLocal getLocals () {
    return locals;
  }

  /**
   * Set the value of preConditions
   * @param newVar the new value of preConditions
   */
  public void setPreConditions (expressions.ElAssertion newVar) {
    preConditions = newVar;
  }

  /**
   * Get the value of preConditions
   * @return the value of preConditions
   */
  public expressions.ElAssertion getPreConditions () {
    return preConditions;
  }

  /**
   * Set the value of postCondtions
   * @param newVar the new value of postCondtions
   */
  public void setPostCondtions (expressions.ElAssertion newVar) {
    postCondtions = newVar;
  }

  /**
   * Get the value of postCondtions
   * @return the value of postCondtions
   */
  public expressions.ElAssertion getPostCondtions () {
    return postCondtions;
  }

  /**
   * Set the value of body
   * Body of a routine, i.e. executable program.
   * @param newVar the new value of body
   */
  public void setBody (functional_elements.BmmStatementItem newVar) {
    body = newVar;
  }

  /**
   * Get the value of body
   * Body of a routine, i.e. executable program.
   * @return the value of body
   */
  public functional_elements.BmmStatementItem getBody () {
    return body;
  }

  //
  // Other methods
  //

  /**
   * Return number of arguments of this routine.
   * @return       Integer
   */
  public Integer arity()
  {
  }


  /**
   * Formal signature of this element, in the form
   * '[arg1_name: T_arg1, �?]:T_value'.
   */
  public void signature()
  {
  }


}
