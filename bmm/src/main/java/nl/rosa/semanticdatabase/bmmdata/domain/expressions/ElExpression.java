package nl.rosa.semanticdatabase.bmmdata.domain.expressions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import nl.rosa.semanticdatabase.bmmdata.domain.Bmm;
import nl.rosa.semanticdatabase.bmmdata.domain.types.BmmType;

/**
 * Class ElExpression
 * Abstract parent of all typed expression tree items.
 */
@EqualsAndHashCode(callSuper = true)
public abstract class ElExpression extends Bmm {
    /**
     * 1..1
     * (abstract)
     * eval_type (): BMM_TYPE
     * Meta-type of expression entity used in type-checking and evaluation.
     * Effected in descendants.
     * @return
     */
    public abstract BmmType evalType();
    /**
     * 1..1
     * is_boolean (): Boolean
     * Post_result: Result = eval_type().equal( {BMM_MODEL}.boolean_type_definition())
     * True if eval_type is notionally Boolean (i.e. a BMM_SIMPLE_TYPE with type_name() = Boolean).
     */
    public Boolean isBoolean(){
        return null;
    }

}
