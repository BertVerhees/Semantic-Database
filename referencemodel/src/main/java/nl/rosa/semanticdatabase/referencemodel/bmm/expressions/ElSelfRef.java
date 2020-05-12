package nl.rosa.semanticdatabase.referencemodel.bmm.expressions;

import lombok.Data;
import nl.rosa.semanticdatabase.referencemodel.bmm.types.BmmType;


/**
 * Class ElSelfRef
 * Special meta-type used to represent a reference that may appear in any routine,
 * pre- or post-condition, or invariant, and resolves to the current object within
 * which feature references are scoped; corresponds to 'self', 'this' or 'Current'
 * in various programming languages.
 */
@Data
public class ElSelfRef implements ElInstanceRef {

  /**
   * Type of the current scoping instance, inferred from expression context.
   */
  private BmmType type;
  
  //
  // Constructors
  //
  public ElSelfRef () { };
  //
  // Other methods
  //

  /**
   * Return type.
   * @return       types.BmmType
   */
  public BmmType evalType()
  {
    //TODO
    return null;
  }

  @Override
  public boolean isBoolean() {
    //TODO
    return false;
  }


}
