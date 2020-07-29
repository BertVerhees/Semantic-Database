package nl.rosa.semanticdatabase.bmmdata.domain.statements;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Default created on 14-7-2020
 *
 * Structural representation of a condition chain, i.e. an if/elseif/else statement.
 */

public class BmmConditionChain extends BmmDecisionGroup<BmmConditionBranch>{
    /**
     * 1..1
     * branches: List<BMM_DECISION_BRANCH>
     * Decision branches.
     */
}
