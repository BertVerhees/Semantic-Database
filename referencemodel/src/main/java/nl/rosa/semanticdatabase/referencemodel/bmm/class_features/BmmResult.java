package nl.rosa.semanticdatabase.referencemodel.bmm.class_features;


import lombok.Data;
import nl.rosa.semanticdatabase.referencemodel.bmm.model_structure.BmmDeclaration;
import nl.rosa.semanticdatabase.referencemodel.bmm.types.BmmType;

import java.util.Map;

/**
 * Class BmmResult
 * Automatically declared variable representing result instance of a Function call.
 */
@Data
public class BmmResult implements BmmVariable {

  //
  // Fields
  //

  // BmmDeclaration
  private String name;
  private Map<String,Object> documentation;
  private BmmDeclaration scope;
  private Map<String,Object> extensions;

  // BmmClassEntity
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


  private boolean isSynthesisedGeneric;
  /**
   * Name of this model element.
   * {default = "Result"}   */

  private String name;
  
  //
  // Constructors
  //
  public BmmResult () { };
  
}
