package nl.rosa.semanticdatabase.bmmdata.model.class_features;


import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Class BmmProcedure
 * A formal element with signature of the form: name ({arg:TArg}*). A procedure is
 * a computed (rather than data) element, generally assumed to be state-changing.
 *
 * Invariants
 * Inv_signature_no_result: signature.result = Void
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BmmProcedure extends BmmRoutine {
}
