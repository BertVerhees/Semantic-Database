package nl.rosa.semanticdatabase.referencemodel.bmm.literal_values;


import lombok.Data;

/**
 * Class BmmStringValue
 * Meta-type for a literal String value, for which type is fixed to the BMM_TYPE
 * representing String and value is of type String.
 */
@Data
public class BmmStringValue extends BmmLiteralValue {

  //
  // Fields
  //

  // BmmLiteralValue
  /**
   * A serial representation of the value.
   */
  private String valueLiteral;
  /**
   * Optional specification of formalism of the value_literal attribute for complex values. Value may be any of json | yawl | xml | odin | rdf or another value agreed by the user community. If not set, json is assumed.
   */
  private String syntax;/**
   * Native String value.
   */
  private String value;
  
  //
  // Constructors
  //
  public BmmStringValue () { };
  
}
