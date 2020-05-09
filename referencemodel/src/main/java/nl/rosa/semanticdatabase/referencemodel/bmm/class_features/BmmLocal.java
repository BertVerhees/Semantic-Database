package nl.rosa.semanticdatabase.referencemodel.bmm.class_features;


import lombok.Data;
import nl.rosa.semanticdatabase.referencemodel.bmm.types.BmmType;

/**
 * Class BmmLocal
 */
@Data
public class BmmLocal extends BmmVariable {

  //
  // Fields
  //
  private boolean isSynthesisedGeneric;

  // BmmVariable
  /**
   * Routine within which variable is defined.
   */
  private BmmRoutine scope;

  // BmmTypedFeature
  /**
   * True if this element can be null (Void) at execution time. May be interpreted as optionality in subtypes..
   * {default = false}   */

  private boolean isNullable;


  // BmmTyped
  /**
   * Declared or inferred static type of the entity.
   */
  private BmmType type;


  //
  // Constructors
  //
  public BmmLocal () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  //
  // Other methods
  //

}
