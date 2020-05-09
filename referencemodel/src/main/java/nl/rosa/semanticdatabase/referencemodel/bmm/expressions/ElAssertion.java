package nl.rosa.semanticdatabase.referencemodel.bmm.expressions;


/**
 * Class ElAssertion
 * Optionally tagged Boolean-returning expression.
 */
public class ElAssertion {

  //
  // Fields
  //

  /**
   * Optional tag, typically used to designate design intention of the assertion, e.g. "Inv_all_members_valid".
   */
  private String tag;
  /**
   * The expression of this assertion.
   */
  private expressions.ElExpression expression;
  
  //
  // Constructors
  //
  public ElAssertion () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of tag
   * Optional tag, typically used to designate design intention of the assertion,
   * e.g. "Inv_all_members_valid".
   * @param newVar the new value of tag
   */
  public void setTag (String newVar) {
    tag = newVar;
  }

  /**
   * Get the value of tag
   * Optional tag, typically used to designate design intention of the assertion,
   * e.g. "Inv_all_members_valid".
   * @return the value of tag
   */
  public String getTag () {
    return tag;
  }

  /**
   * Set the value of expression
   * The expression of this assertion.
   * @param newVar the new value of expression
   */
  public void setExpression (expressions.ElExpression newVar) {
    expression = newVar;
  }

  /**
   * Get the value of expression
   * The expression of this assertion.
   * @return the value of expression
   */
  public expressions.ElExpression getExpression () {
    return expression;
  }

  //
  // Other methods
  //

}
