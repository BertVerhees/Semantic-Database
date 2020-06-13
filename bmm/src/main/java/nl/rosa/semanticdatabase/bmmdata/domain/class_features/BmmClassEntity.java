package nl.rosa.semanticdatabase.bmmdata.domain.class_features;

import lombok.Data;
import lombok.EqualsAndHashCode;
import nl.rosa.semanticdatabase.bmmdata.domain.model_structure.BmmDeclaration;
import nl.rosa.semanticdatabase.bmmdata.domain.types.BmmSignature;


/**
 * Class BmmClassEntity
 * Any entity declared within a class.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class BmmClassEntity extends BmmDeclaration {

  /**
   * 0..1
   * is_synthesised_generic: Boolean
   * {default = false}
   * True if this feature was synthesised due to generic substitution in an inherited type, or further
   * constraining of a formal generic parameter.
   */
  private Boolean isSynthesisedGeneric;

  /**
   * 1..1
   * (abstract)
   * signature (): BMM_SIGNATURE
   * Formal signature of this element, in the form:
   * name [arg1_name: T_arg1, …​][:T_value]
   * Specific implementations in descendants.
   * @return
   */
  public abstract BmmSignature signature();
}
