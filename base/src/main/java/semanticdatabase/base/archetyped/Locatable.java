package semanticdatabase.base.archetyped;

import semanticdatabase.base.paths.PathSegment;
import semanticdatabase.base.support.identification.UIDBasedId;
import semanticdatabase.base_types.datavalues.DvText;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Locatable extends Pathable {

    private DvText name;
    private String archetypeNodeId;
    @Nullable
    private UIDBasedId uid;
    @Nullable
    private Archetyped archetypeDetails;
    @Nullable
    private FeederAudit feederAudit;
    @Nullable
    private List<Link> links = new ArrayList<>();


    public Locatable() {
    }

    public Locatable(String archetypeNodeId, DvText name) {
        if (name == null) {
            throw new NullPointerException("Property:name has cardinality NonNull, but is null");
        }
        if (archetypeNodeId == null) {
            throw new NullPointerException("Property:archetypeNodeId has cardinality NonNull, but is null");
        }
        this.name = name;
        this.archetypeNodeId = archetypeNodeId;
    }

    public Locatable(
            UIDBasedId uid,
            String archetypeNodeId,
            DvText name,
            Archetyped archetypeDetails,
            FeederAudit feederAudit,
            List<Link> links,
            Pathable parent,
            String parentAttributeName) {
        super(parent, parentAttributeName);
        if (name == null) {
            throw new NullPointerException("Property:name has cardinality NonNull, but is null");
        }
        if (archetypeNodeId == null) {
            throw new NullPointerException("Property:archetypeNodeId has cardinality NonNull, but is null");
        }
        this.name = name;
        this.archetypeNodeId = archetypeNodeId;
        this.uid = uid;
        this.archetypeDetails = archetypeDetails;
        this.feederAudit = feederAudit;
        this.links = links;
    }

    public DvText getName() {
        return name;
    }

    public void setName(DvText name) {
        if (name == null) {
            throw new NullPointerException("Property:name has cardinality NonNull, but is null");
        }
        this.name = name;
    }

    /**
     * convenience method
     */
    public void setNameAsString(String name) {
        this.name = new DvText(name);
    }


    public String getArchetypeNodeId() {
        return archetypeNodeId;
    }

    public void setArchetypeNodeId(String archetypeNodeId) {
        if (archetypeNodeId == null) {
            throw new NullPointerException("Property:archetypeNodeId has cardinality NonNull, but is null");
        }
        this.archetypeNodeId = archetypeNodeId;
    }

    public UIDBasedId getUid() {
        return uid;
    }

    public void setUid(UIDBasedId uid) {
        this.uid = uid;
    }

    public Archetyped getArchetypeDetails() {
        return archetypeDetails;
    }

    public void setArchetypeDetails(Archetyped archetypeDetails) {
        this.archetypeDetails = archetypeDetails;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> linked) {
        this.links = linked;
    }

    public void addLink(Link link) {
        this.links.add(link);
    }

    @Override
    public List<PathSegment> getPathSegments() {
        Pathable parent = getParent();
        if (parent == null) {
            return new ArrayList<>();
        }

        List<PathSegment> segments = parent.getPathSegments();
        segments.add(new PathSegment(getParentAttributeName(), archetypeNodeId));
        return segments;
    }

    public String getNameAsString() {
        return name == null ? null : name.getValue();
    }

    @Nullable
    public FeederAudit getFeederAudit() {
        return feederAudit;
    }

    public void setFeederAudit(@Nullable FeederAudit feederAudit) {
        this.feederAudit = feederAudit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Locatable locatable = (Locatable) o;
        return Objects.equals(name, locatable.name) &&
                Objects.equals(archetypeNodeId, locatable.archetypeNodeId) &&
                Objects.equals(uid, locatable.uid) &&
                Objects.equals(archetypeDetails, locatable.archetypeDetails) &&
                Objects.equals(feederAudit, locatable.feederAudit) &&
                Objects.equals(links, locatable.links);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, archetypeNodeId, uid, archetypeDetails, feederAudit, links);
    }
}
