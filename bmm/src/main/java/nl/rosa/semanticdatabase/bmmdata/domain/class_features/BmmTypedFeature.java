package nl.rosa.semanticdatabase.bmmdata.domain.class_features;


/**
 * Class BmmTypedFeature
 * A typed entity that is a feature within a context, and which may therefore be
 * Void, i.e. 'nullable'.
 */
public interface BmmTypedFeature extends BmmTyped {


  /**
   * 0..1
   * is_nullable: Boolean
   * {default = false}
   * True if this element can be null (Void) at execution time. May be interpreted as optionality in subtypes..
   */
  void setIsNullable(Boolean isNullable);
  Boolean getIsNullable();
}
