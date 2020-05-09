package nl.rosa.semanticdatabase.referencemodel.bmm.class_features;

import lombok.*;
import nl.rosa.semanticdatabase.referencemodel.bmm.model_structure.BmmDeclaration;


/**
 * Class BmmClassEntity
 * Any entity declared within a class.
 */
@Data
abstract public class BmmClassEntity extends BmmDeclaration {

  /**
   * True if this feature was synthesised due to generic substitution in an inherited type, or further constraining of a formal generic parameter.
   * {default = false}   */

  private boolean isSynthesisedGeneric;

  @Builder
  public BmmClassEntity(boolean isSynthesisedGeneric) {
    this.isSynthesisedGeneric = isSynthesisedGeneric;
  }

  public BmmClassEntity () { };
  
  /**
   * Formal signature of this element, in the form:
   * name [arg1_name: T_arg1, �?][:T_value]
   * Specific implementations in descendants.
   */
  public void signature()
  {
  }


}
