package nl.rosa.semanticdatabase.bmmdata.domain.class_features;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import nl.rosa.semanticdatabase.bmmdata.domain.types.BmmSignature;

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
