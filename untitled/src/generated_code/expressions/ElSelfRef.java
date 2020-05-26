package expressions;
import nl.rosa.semanticdatabase.bmm.model.types.BmmType;


/**
 * Class ElSelfRef
 * Special meta-type used to represent a reference that may appear in any routine,
 * pre- or post-condition, or invariant, and resolves to the current object within
 * which feature references are scoped; corresponds to 'self', 'this' or 'Current'
 * in various programming languages.
 */
public class ElSelfRef extends ElInstanceRef {

  //
  // Fields
  //

  /**
   * Type of the current scoping instance, inferred from expression context.
   */
  private nl.rosa.semanticdatabase.bmm.model.types.BmmType type;
  
  //
  // Constructors
  //
  public ElSelfRef () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of type
   * Type of the current scoping instance, inferred from expression context.
   * @param newVar the new value of type
   */
  public void setType (nl.rosa.semanticdatabase.bmm.model.types.BmmType newVar) {
    type = newVar;
  }

  /**
   * Get the value of type
   * Type of the current scoping instance, inferred from expression context.
   * @return the value of type
   */
  public nl.rosa.semanticdatabase.bmm.model.types.BmmType getType () {
    return type;
  }

  //
  // Other methods
  //

  /**
   * Return type.
   * @return       nl.rosa.semanticdatabase.bmm.model.types.BmmType
   */
  public nl.rosa.semanticdatabase.bmm.model.types.BmmType evalType()
  {
  }


}
