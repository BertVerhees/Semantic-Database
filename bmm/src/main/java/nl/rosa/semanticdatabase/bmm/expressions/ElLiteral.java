package nl.rosa.semanticdatabase.bmm.expressions;

import lombok.Data;
import nl.rosa.semanticdatabase.bmm.types.BmmType;
import nl.rosa.semanticdatabase.bmm.literal_values.BmmLiteralValue;


/**
 * Class ElLiteral
 * Literal value of any type known in the model, including primitive nl.rosa.semanticdatabase.bmm.types. Defined
 * via a BMM_LITERAL_VALUE.
 */
@Data
public class ElLiteral implements ElInstanceRef {

  //
  // Fields
  //

  /**
   * The reference item from which the value of this node can be computed.
   */
  private BmmLiteralValue value;
  
  //
  // Constructors
  //
  public ElLiteral () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of value
   * The reference item from which the value of this node can be computed.
   * @param newVar the new value of value
   */
  public void setValue (BmmLiteralValue newVar) {
    value = newVar;
  }

  /**
   * Get the value of value
   * The reference item from which the value of this node can be computed.
   * @return the value of value
   */
  public BmmLiteralValue getValue () {
    return value;
  }

  //
  // Other methods
  //

  /**
   * Return value.type.
   * @return       nl.rosa.semanticdatabase.bmm.types.BmmType
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
