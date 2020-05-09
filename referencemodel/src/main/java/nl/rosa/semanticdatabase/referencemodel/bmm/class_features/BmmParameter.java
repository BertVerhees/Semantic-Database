package nl.rosa.semanticdatabase.referencemodel.bmm.class_features;


import lombok.Data;
import nl.rosa.semanticdatabase.referencemodel.bmm.types.BmmType;

/**
 * Class BmmParameter
 * A routine parameter variable.
 */
@Data
public class BmmParameter implements BmmVariable {

  //
  // Fields
  //

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


  private boolean isSynthesisedGeneric;

  /**
   * Optional read/write direction of the parameter. If none-supplied, the parameter is treated as in, i.e. readable.
   */
  private BmmParameterDirection direction;
  
  //
  // Constructors
  //
  public BmmParameter () { };
  
}
