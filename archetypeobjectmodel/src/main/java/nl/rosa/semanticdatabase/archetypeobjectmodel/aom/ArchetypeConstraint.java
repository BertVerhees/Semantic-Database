package nl.rosa.semanticdatabase.archetypeobjectmodel.aom;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by pieter.bos on 15/10/15.
 */
@Getter
@Setter
public abstract class ArchetypeConstraint extends ArchetypeModelObject {

    @JsonIgnore //ignore these field in popular object mappers
    private transient ArchetypeConstraint parent;
    @JsonIgnore //ignore these field in popular object mappers, otherwise we get infinite loops
    private transient CSecondOrder socParent;

    /**
     * True if this node is the root of the tree.
     */
    @JsonIgnore
    public boolean isRoot() {
        return parent == null;
    }

    @JsonIgnore
    public abstract boolean isLeaf();


    @JsonIgnore
    public Archetype getArchetype() {
        ArchetypeConstraint constraint = getParent();
        return constraint == null ? null : constraint.getArchetype();
    }

}
