package nl.rosa.semanticdatabase.bmmdata.model.class_features;

import nl.rosa.semanticdatabase.bmmdata.model.model_structure.BmmDeclaration;


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

}
