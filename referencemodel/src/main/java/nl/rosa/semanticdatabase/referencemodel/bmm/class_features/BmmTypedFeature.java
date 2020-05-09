package nl.rosa.semanticdatabase.referencemodel.bmm.class_features;


/**
 * Class BmmTypedFeature
 * A typed entity that is a feature within a context, and which may therefore be
 * Void, i.e. 'nullable'.
 */
public interface BmmTypedFeature extends BmmTyped {


  /**
   * Set the value of isNullable
   * True if this element can be null (Void) at execution time. May be interpreted as
   * optionality in subtypes..
   * {default = false}
   * @param newVar the new value of isNullable
   */
  public void setIsNullable (boolean newVar);
  /**
   * Get the value of isNullable
   * True if this element can be null (Void) at execution time. May be interpreted as
   * optionality in subtypes..
   * {default = false}
   * @return the value of isNullable
   */
  public boolean getIsNullable ();

}
