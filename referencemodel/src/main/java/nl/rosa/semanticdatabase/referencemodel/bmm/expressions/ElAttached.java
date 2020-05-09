package nl.rosa.semanticdatabase.referencemodel.bmm.expressions;


import lombok.Data;
import nl.rosa.semanticdatabase.referencemodel.bmm.types.BmmSimpleType;

/**
 * Class ElAttached
 * A predicate on any object reference (including function call) that returns True
 * if the reference is attached, i.e. non-Void.
 */
@Data
public class ElAttached implements ElPredicate {

  //
  // Fields
  //

  // ElPredicate
  /**
   * The target instance of this predicate.
   */
  private ElInstanceRef operand;



  //
  // Constructors
  //
  public ElAttached () { };

  @Override
  public BmmSimpleType evalType() {
    return null;
  }

  @Override
  public boolean isBoolean() {
    return false;
  }
}
