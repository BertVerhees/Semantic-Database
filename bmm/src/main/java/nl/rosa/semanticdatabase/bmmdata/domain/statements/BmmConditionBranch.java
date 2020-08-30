package nl.rosa.semanticdatabase.bmmdata.domain.statements;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import nl.rosa.semanticdatabase.bmmdata.domain.expressions.ElExpression;
import nl.rosa.semanticdatabase.bmmdata.domain.types.BmmType;

/**
 * Default created on 14-7-2020
 * Representation of one conditional branch of an if/then statement.
 */

public class BmmConditionBranch extends BmmDecisionBranch{
    /**
     * 1..1
     * test: EL_EXPRESSION
     * The test expression to evaluate for this branch
     */
    @NonNull
    @Getter
    @Setter
    private ElExpression<BmmType> test;
}
