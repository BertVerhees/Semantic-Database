package nl.rosa.semanticdatabase.bmmdata.domain.statements;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import nl.rosa.semanticdatabase.bmmdata.domain.expressions.ElConstraintExpression;

import java.util.ArrayList;

/**
 * Default created on 15-7-2020
 */

public class BmmCaseBranch extends BmmDecisionBranch{
    /**
     * 1..1
     * range: EL_CONSTRAINT_EXPRESSION
     * Value range of this case branch.
     */
    @Getter
    @Setter
    @NonNull
    private ElConstraintExpression range;

}
