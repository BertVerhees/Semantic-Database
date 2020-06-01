package nl.rosa.semanticdatabase.bmmdata.model.class_features;

import nl.rosa.semanticdatabase.bmmdata.model.model_structure.BmmDeclaration;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmSignature;


/**
 * Class BmmClassEntity
 * Any entity declared within a class.
 */
public interface BmmClassEntity extends BmmDeclaration {

  /**
   * 0..1
   * is_synthesised_generic: Boolean
   * {default = false}
   * True if this feature was synthesised due to generic substitution in an inherited type, or further
   * constraining of a formal generic parameter.
   */
  void setIsSynthesisedGeneric (Boolean newVar);
  Boolean getIsSynthesisedGeneric ();

  /**
   * 1..1
   * (abstract)
   * signature (): BMM_SIGNATURE
   * Formal signature of this element, in the form:
   * name [arg1_name: T_arg1, �?][:T_value]
   * Specific implementations in descendants.
   */
  BmmSignature signature();


}
