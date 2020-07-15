package nl.rosa.semanticdatabase.bmmdata.domain.statements;

import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Default created on 14-7-2020
 *
 * Abstract parent of multi-branch decision structures.
 */

public abstract class BmmDecisionGroup implements BmmStatement{
    /**
     * 1..1
     * branches: List<BMM_DECISION_BRANCH>
     * Decision branches.
     */
    protected Set<BmmDecisionBranch> branches = new HashSet<>();
    Set<? extends BmmDecisionBranch> getBranches() {
        return this.branches;
    }

    void setBranches(@NotNull Set<BmmDecisionBranch> branches) {
        this.branches = branches;
    }

    public void addBranch(BmmDecisionBranch branch) {
        if(this.branches==null){
            this.branches = new HashSet<>();
        }
        this.branches.add(branch);
    }

    public void addBranches(Set<? extends BmmDecisionBranch> branches) {
        if(this.branches==null){
            this.branches = new HashSet<>();
        }
        this.branches.addAll(branches);
    }

    public void removeBranch(BmmDecisionBranch branch) {
        if(this.branches!=null){
            this.branches.remove(branch);
        }
    }

    public void removeBranches(Set<? extends BmmDecisionBranch> branches) {
        if(this.branches!=null) {
            this.branches.removeAll(branches);
        }
    }

    public Set<BmmDecisionBranch> branches(){
        return Collections.unmodifiableSet(this.branches);
    }
}
