package nl.rosa.semanticdatabase.referencemodel.bmm.expressions;
import types.BmmSimpleType;


/**
 * Class ElPredicate
 * Parent type of predicate of any object reference.
 */
public class ElPredicate extends ElTerminal {

  //
  // Fields
  //

  /**
   * The target instance of this predicate.
   */
  private expressions.ElInstanceRef operand;
  
  //
  // Constructors
  //
  public ElPredicate () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of operand
   * The target instance of this predicate.
   * @param newVar the new value of operand
   */
  public void setOperand (expressions.ElInstanceRef newVar) {
    operand = newVar;
  }

  /**
   * Get the value of operand
   * The target instance of this predicate.
   * @return the value of operand
   */
  public expressions.ElInstanceRef getOperand () {
    return operand;
  }

  //
  // Other methods
  //

  /**
   * Return {BMM_MODEL}.boolean_type_definition().
   * @return       types.BmmSimpleType
   */
  public types.BmmSimpleType evalType()
  {
  }


}
