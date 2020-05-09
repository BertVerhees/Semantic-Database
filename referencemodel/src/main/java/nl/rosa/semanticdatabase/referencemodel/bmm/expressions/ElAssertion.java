package nl.rosa.semanticdatabase.referencemodel.bmm.expressions;


import lombok.Data;

/**
 * Class ElAssertion
 * Optionally tagged Boolean-returning expression.
 */
@Data
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
  private ElExpression expression;
  
  //
  // Constructors
  //
  public ElAssertion () { };
  
}
