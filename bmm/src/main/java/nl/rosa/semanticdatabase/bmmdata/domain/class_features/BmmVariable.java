package nl.rosa.semanticdatabase.bmmdata.domain.class_features;


import lombok.*;
import nl.rosa.semanticdatabase.bmmdata.domain.types.BmmSignature;
import nl.rosa.semanticdatabase.bmmdata.domain.types.BmmType;

import javax.persistence.DiscriminatorValue;

/**
 * Class BmmVariable
 * A mutable entity whose scope is a routine.
 *
 * Invariants
 * Inv_signature_no_args: signature.arguments = Void
 */
@EqualsAndHashCode(callSuper = true)
public abstract class BmmVariable extends BmmClassEntity implements BmmInstantiable {

  /**
   * 0..1
   * is_nullable: Boolean
   * {default = false}
   * True if this element can be null (Void) at execution time. May be interpreted as optionality in subtypes..
   * Implemented by interface BmmTypedFeature
   */
  @NonNull
  @Getter
  @Setter
  protected Boolean isNullable;

  /**
   * 1..1
   * type: BMM_TYPE
   * Declared or inferred static type of the entity.
   *
   * Implemented because of implemented derived interface from BmmTyped
   */
  @NonNull
  @Getter
  @Setter
  private BmmType type;

  /**
   * 1..1
   * (redefined)
   * scope: BMM_ROUTINE
   * Routine within which variable is defined.
   */
  @NonNull
  @Getter
  @Setter
  private BmmRoutine scope;

  /**
   * 1..1
   * (effected)
   * signature ()
   * Formal signature of this element, in the form 'name [arg1_name: T_arg1, …​][:T_value]'.
   * @return
   */
  @NonNull
  public BmmSignature signature(){
    return null;
  }
}
