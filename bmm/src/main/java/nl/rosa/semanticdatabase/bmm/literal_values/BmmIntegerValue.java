package nl.rosa.semanticdatabase.bmm.literal_values;


import lombok.Data;

/**
 * Class BmmIntegerValue
 * Meta-type for a literal Integer value, for which type is fixed to the BMM_TYPE
 * representing Integer and value is of type Integer.
 */
@Data
public class BmmIntegerValue extends BmmLiteralValue {

  // BmmLiteralValue
  /**
   * A serial representation of the value.
   */
  private String valueLiteral;
  /**
   * Optional specification of formalism of the value_literal attribute for complex values. Value may be any of json | yawl | xml | odin | rdf or another value agreed by the user community. If not set, json is assumed.
   */
  private String syntax;/**
   * Native Integer value.
   */
  private Integer value;
  
  //
  // Constructors
  //
  public BmmIntegerValue () { };

  @Override
  @Deprecated
  void setValue(Object newVar) {
    this.value = (Integer) newVar;
  }

}
