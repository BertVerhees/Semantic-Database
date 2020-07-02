package nl.rosa.semanticdatabase.bmmdata.domain.class_features;


import lombok.Data;
import lombok.EqualsAndHashCode;
import nl.rosa.semanticdatabase.bmmdata.domain.classes.BmmClass;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
@Entity
public class BmmProcedure extends BmmRoutine {

    //========== counterparts =====================================================
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_bmm_class_id")
    private BmmClass bmmClass;
}
