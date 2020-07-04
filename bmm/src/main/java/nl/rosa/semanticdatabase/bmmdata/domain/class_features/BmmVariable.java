package nl.rosa.semanticdatabase.bmmdata.domain.class_features;


import lombok.*;
import nl.rosa.semanticdatabase.bmmdata.domain.types.BmmSignature;
import nl.rosa.semanticdatabase.bmmdata.domain.types.BmmType;

/**
 * Class BmmVariable
 * A mutable entity whose scope is a routine.
 *
 * Invariants
 * Inv_signature_no_args: signature.arguments = Void
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
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
  protected Boolean isNullable;

  public BmmVariable setIsNullable(Boolean nullable) {
    isNullable = nullable;
    return this;
  }
  /**
   * 1..1
   * type: BMM_TYPE
   * Declared or inferred static type of the entity.
   *
   * Implemented because of implemented derived interface from BmmTyped
   */
  @NonNull
  @Getter
  private BmmType type;

  public BmmVariable setType(BmmType type) {
    this.type = type;
    return this;
  }

  /**
   * 1..1
   * (redefined)
   * scope: BMM_ROUTINE
   * Routine within which variable is defined.
   */
  @NonNull
  private BmmRoutine scope;

  /**
   * 1..1
   * (effected)
   * signature ()
   * Formal signature of this element, in the form 'name [arg1_name: T_arg1, …​][:T_value]'.
   * @return
   */
  public BmmSignature signature(){
    return null;
  }
}
