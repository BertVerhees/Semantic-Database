package expressions;
import types.BmmType;


/**
 * Class ElExpression
 * Abstract parent of all typed expression tree items.
 */
abstract public class ElExpression {

  //
  // Fields
  //

  
  //
  // Constructors
  //
  public ElExpression () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  //
  // Other methods
  //

  /**
   * Meta-type of expression entity used in type-checking and evaluation.
   * Effected in descendants.
   * @return       types.BmmType
   */
  abstract public types.BmmType evalType();


  /**
   * True if eval_type is notionally Boolean (i.e. a BMM_SIMPLE_TYPE with type_name()
   * = Boolean)
   * @return       boolean
   */
  public boolean isBoolean()
  {
  }


}
