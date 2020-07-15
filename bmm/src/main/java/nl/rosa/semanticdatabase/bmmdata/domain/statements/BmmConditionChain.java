package nl.rosa.semanticdatabase.bmmdata.domain.statements;

import java.util.HashSet;
import java.util.Set;

/**
 * Default created on 14-7-2020
 *
 * Structural representation of a condition chain, i.e. an if/elseif/else statement.
 */

public class BmmConditionChain extends BmmDecisionGroup{
    /**
     * 1..1
     * branches: List<BMM_DECISION_BRANCH>
     * Decision branches.
     */
//    private Set<BmmConditionBranch> branches;
//    Set<BmmConditionBranch> getBranches() {
//        return this.branches;
//    }
//
//    void setBranches(@NotNull Set<BmmConditionBranch> branches) {
//        this.branches = branches;
//    }

    public void addBranch(BmmConditionBranch branch) {
        this.branches.add(branch);
    }

//    public void addBranches(Set<? extends BmmDecisionBranch> branches) {
//        if(this.branches==null){
//            this.branches = new HashSet<>();
//        }
//        this.branches.addAll(branches);
//    }

    public void removeBranch(BmmConditionBranch branch) {
        this.branches.remove(branch);
    }

//    public void removeBranches(Set<BmmConditionBranch> branches) {
//        if(this.branches!=null) {
//            this.branches.removeAll(branches);
//        }
//    }

//    public Set<BmmConditionBranch> branches(){
//        return Optional.of(Collections.unmodifiableSet(this.branches));
//    }
}
