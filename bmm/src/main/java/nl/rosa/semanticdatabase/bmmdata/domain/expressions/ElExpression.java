package nl.rosa.semanticdatabase.bmmdata.domain.expressions;

import nl.rosa.semanticdatabase.bmmdata.domain.BmmBase;
import nl.rosa.semanticdatabase.bmmdata.domain.types.BmmType;

/**
 * Class ElExpression
 * Abstract parent of all typed expression tree items.
 */
public abstract class ElExpression<T extends BmmType> extends BmmBase {
    /**
     * 1..1
     * (abstract)
     * eval_type (): BMM_TYPE
     * Meta-type of expression entity used in type-checking and evaluation.
     * Effected in descendants.
     * @return
     */
    public abstract T evalType();
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
