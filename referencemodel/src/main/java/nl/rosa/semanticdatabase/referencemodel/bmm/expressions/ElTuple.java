package nl.rosa.semanticdatabase.referencemodel.bmm.expressions;

import lombok.Data;
import nl.rosa.semanticdatabase.referencemodel.bmm.types.BmmType;
import nl.rosa.semanticdatabase.referencemodel.bmm.types.BmmTupleType;


/**
 * Class ElTuple
 * Defines an array of optionally named items each of any type.
 */
@Data
public class ElTuple implements ElInstanceRef {

  //
  // Fields
  //

  /**
   * Items in the tuple, potentially with names. Typical use is to represent an argument list to routine call.
   */
  private ElTupleItem items;
  /**
   * Static type inferred from literal value.
   */
  private BmmTupleType type;
  
  //
  // Constructors
  //
  public ElTuple () { };
  
  //
  // Methods
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
