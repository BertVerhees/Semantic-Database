package nl.rosa.semanticdatabase.archetypeobjectmodel.aom;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import nl.rosa.semanticdatabase.base.paths.PathSegment;
import nl.rosa.semanticdatabase.base.paths.PathUtil;

import java.util.List;

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
    public abstract List<PathSegment> getPathSegments();

    @JsonIgnore
    public abstract boolean isLeaf();

    public final String getPath() {
        return PathUtil.getPath(getPathSegments());
    }


    @JsonIgnore
    public Archetype getArchetype() {
        ArchetypeConstraint constraint = getParent();
        return constraint == null ? null : constraint.getArchetype();
    }

}
