package nl.rosa.semanticdatabase.bmmdata.model.expressions;


import lombok.Data;
import nl.rosa.semanticdatabase.bmmdata.model.BmmBaseEntity;

/**
 * Class ElAssertion
 * Optionally tagged Boolean-returning expression.
 */
@Data
public class ElAssertion extends BmmBaseEntity {

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
