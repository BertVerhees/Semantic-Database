package nl.rosa.semanticdatabase.bmm.expressions;


import lombok.Data;
import nl.rosa.semanticdatabase.bmm.types.BmmSimpleType;

/**
 * Class ElDefined
 * A predicate taking one external variable reference argument, that returns true
 * if the reference is resolvable, i.e. the external value is obtainable.
 * 
 * NOTE
 * probably to be removed.
 * 
 */
@Data
public class ElDefined implements ElPredicate {

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
  public ElDefined () { };

  @Override
  public BmmSimpleType evalType() {
    return null;
  }

  @Override
  public boolean isBoolean() {
    return false;
  }

}
