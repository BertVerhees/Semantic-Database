package nl.rosa.semanticdatabase.referencemodel.bmm.literal_values;


/**
 * Class BmmBooleanValue
 * Meta-type for a literal Boolean value, for which type is fixed to the BMM_TYPE
 * representing Boolean and value is of type Boolean.
 */
public class BmmBooleanValue extends BmmLiteralValue {

  // BmmLiteralValue
  /**
   * A serial representation of the value.
   */
  private String valueLiteral;
  private Boolean value;
  /**
   * Optional specification of formalism of the value_literal attribute for complex values. Value may be any of json | yawl | xml | odin | rdf or another value agreed by the user community. If not set, json is assumed.
   */
  private String syntax;

  //
  // Constructors
  //
  public BmmBooleanValue () { };

  void setValue(Object newVar) {
    value = (Boolean) newVar;
  }

  public String getValueLiteral() {
    return this.valueLiteral;
  }

  public Boolean getValue() {
    return this.value;
  }

  public String getSyntax() {
    return this.syntax;
  }

  public void setValueLiteral(String valueLiteral) {
    this.valueLiteral = valueLiteral;
  }

  public void setSyntax(String syntax) {
    this.syntax = syntax;
  }

  public boolean equals(final Object o) {
    if (o == this) return true;
    if (!(o instanceof BmmBooleanValue)) return false;
    final BmmBooleanValue other = (BmmBooleanValue) o;
    if (!other.canEqual((Object) this)) return false;
    final Object this$valueLiteral = this.getValueLiteral();
    final Object other$valueLiteral = other.getValueLiteral();
    if (this$valueLiteral == null ? other$valueLiteral != null : !this$valueLiteral.equals(other$valueLiteral))
      return false;
    final Object this$value = this.getValue();
    final Object other$value = other.getValue();
    if (this$value == null ? other$value != null : !this$value.equals(other$value)) return false;
    final Object this$syntax = this.getSyntax();
    final Object other$syntax = other.getSyntax();
    if (this$syntax == null ? other$syntax != null : !this$syntax.equals(other$syntax)) return false;
    return true;
  }

  protected boolean canEqual(final Object other) {
    return other instanceof BmmBooleanValue;
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final Object $valueLiteral = this.getValueLiteral();
    result = result * PRIME + ($valueLiteral == null ? 43 : $valueLiteral.hashCode());
    final Object $value = this.getValue();
    result = result * PRIME + ($value == null ? 43 : $value.hashCode());
    final Object $syntax = this.getSyntax();
    result = result * PRIME + ($syntax == null ? 43 : $syntax.hashCode());
    return result;
  }

  public String toString() {
    return "BmmBooleanValue(valueLiteral=" + this.getValueLiteral() + ", value=" + this.getValue() + ", syntax=" + this.getSyntax() + ")";
  }
}
