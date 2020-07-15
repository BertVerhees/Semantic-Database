package nl.rosa.semanticdatabase.bmmdata.domain.statements;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import nl.rosa.semanticdatabase.bmmdata.domain.expressions.ElBooleanExpression;

/**
 * Default created on 14-7-2020
 */

public class BmmAssertion implements BmmStatement{
    /**
     * 1..1
     * expression: EL_BOOLEAN_EXPRESSION
     */
    @NonNull
    @Getter
    @Setter
    private ElBooleanExpression expression;
}
