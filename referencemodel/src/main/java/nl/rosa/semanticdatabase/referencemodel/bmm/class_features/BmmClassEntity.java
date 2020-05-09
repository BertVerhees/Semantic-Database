package nl.rosa.semanticdatabase.referencemodel.bmm.class_features;

import nl.rosa.semanticdatabase.referencemodel.bmm.model_structure.BmmDeclaration;


/**
 * Class BmmClassEntity
 * Any entity declared within a class.
 */
public interface BmmClassEntity extends BmmDeclaration {

  /**
   * Set the value of isSynthesisedGeneric
   * True if this feature was synthesised due to generic substitution in an inherited
   * type, or further constraining of a formal generic parameter.
   * {default = false}
   * @param newVar the new value of isSynthesisedGeneric
   */
  void setIsSynthesisedGeneric (boolean newVar);

  /**
   * Get the value of isSynthesisedGeneric
   * True if this feature was synthesised due to generic substitution in an inherited
   * type, or further constraining of a formal generic parameter.
   * {default = false}
   * @return the value of isSynthesisedGeneric
   */
  boolean getIsSynthesisedGeneric ();

  /**
   * Formal signature of this element, in the form:
   * name [arg1_name: T_arg1, �?][:T_value]
   * Specific implementations in descendants.
   */
  public void signature();


}
