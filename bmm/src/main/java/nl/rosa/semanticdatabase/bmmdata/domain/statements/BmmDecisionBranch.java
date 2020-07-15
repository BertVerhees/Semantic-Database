package nl.rosa.semanticdatabase.bmmdata.domain.statements;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * Default created on 14-7-2020
 * Abstract parent of branch in a multi-branch decision structure.
 */

public abstract class BmmDecisionBranch {
    /**
     * 1..1
     * item: BMM_STATEMENT_ITEM
     * Statement(s) to execute within this branch.
     */
    @NonNull
    @Getter
    @Setter
    private BmmStatementItem item;
}
