package nl.rosa.semanticdatabase.bmmdata.domain.class_features;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import nl.rosa.semanticdatabase.bmmdata.domain.model_structure.BmmDeclaration;
import nl.rosa.semanticdatabase.bmmdata.domain.types.BmmSignature;

import javax.persistence.DiscriminatorValue;


/**
 * Class BmmClassEntity
 * Any entity declared within a class.
 */
public abstract class BmmClassEntity extends BmmDeclaration {

  /**
   * 0..1
   * is_synthesised_generic: Boolean
   * {default = false}
   * True if this feature was synthesised due to generic substitution in an inherited type, or further
   * constraining of a formal generic parameter.
   */
  @Getter
  @Setter
  private Boolean isSynthesisedGeneric;

//===================== functions ============================================
  /**
   * 1..1
   * (abstract)
   * signature (): BMM_SIGNATURE
   * Formal signature of this element, in the form:
   * name [arg1_name: T_arg1, …​][:T_value]
   * Specific implementations in descendants.
   * @return
   */
  @NonNull
  public abstract BmmSignature signature();
}
