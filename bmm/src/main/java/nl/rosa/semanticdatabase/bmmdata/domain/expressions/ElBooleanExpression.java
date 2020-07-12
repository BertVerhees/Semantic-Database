package nl.rosa.semanticdatabase.bmmdata.domain.expressions;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import nl.rosa.semanticdatabase.bmmdata.domain.Bmm;

/**
 * Optionally tagged Boolean-returning expression.
 * Default created on 12-7-2020
 *
 * Invariants
 * Inv_boolean_expression: expression.is_boolean()
 */

public class ElBooleanExpression extends Bmm {
    /**
     * 1..1
     * expression: EL_EXPRESSION
     * The expression of this assertion.
     */
    @NonNull
    @Getter
    @Setter
    private ElExpression expression;

}
