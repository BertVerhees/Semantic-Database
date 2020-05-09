package nl.rosa.semanticdatabase.referencemodel.bmm.expressions;

import nl.rosa.semanticdatabase.referencemodel.bmm.types.BmmType;


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
  private BmmType type;
  
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
  public void setType (BmmType newVar) {
    type = newVar;
  }

  /**
   * Get the value of type
   * Type of the current scoping instance, inferred from expression context.
   * @return the value of type
   */
  public BmmType getType () {
    return type;
  }

  //
  // Other methods
  //

  /**
   * Return type.
   * @return       types.BmmType
   */
  public BmmType evalType()
  {
  }


}
