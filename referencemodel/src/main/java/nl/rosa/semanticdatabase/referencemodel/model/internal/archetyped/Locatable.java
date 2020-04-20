package nl.rosa.semanticdatabase.referencemodel.model.internal.archetyped;

import lombok.Getter;
import lombok.Setter;
import nl.rosa.semanticdatabase.referencemodel.model.internal.datavalues.DvText;
import nl.rosa.semanticdatabase.referencemodel.model.internal.support.identification.UIDBasedId;
import org.springframework.lang.Nullable;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
public class Locatable extends Pathable{
    public Locatable() {
    }

    public Locatable(String archetypeNodeId, DvText name) {
        this.name = name;
        this.archetypeNodeId = archetypeNodeId;
    }

    public Locatable(
            @Nullable UIDBasedId uid,
            String archetypeNodeId,
            DvText name,
            @Nullable Archetyped archetypeDetails,
            @Nullable FeederAudit feederAudit,
            @Nullable Set<Link> links,
            @Nullable Pathable parent,
            @Nullable String parentAttributeName) {
        super(parent, parentAttributeName);
        this.name = name;
        this.archetypeNodeId = archetypeNodeId;
        this.uid = uid;
        this.archetypeDetails = archetypeDetails;
        this.feederAudit = feederAudit;
        this.links = links;
    }

    /** Runtime name of this fragment, used to build runtime paths. This is the term provided via an application or batch
     * process to name this construct:
     its retention in the application faithfully preserves the original label by which this entry was known to end users.
     */
    private DvText name;
    /** Design-time archetype identifier of this node taken from its generating archetype; used to build archetype paths.
     Always in the form of an at-code, e.g. at0005. This value enables a 'standardised' name for this node to be generated,
     by referring to the generating archetype local terminology.
     At an archetype root point, the value of this attribute is always the stringified form of the archetype_id found in the archetype_details object.
     */
    private DvText archetypeNodeId;
    /** Optional globally unique object identifier for root points of archetyped structures
     */
    private UIDBasedId uid;
    /**
     * Links to other archetyped structures (data whose root object inherits from ARCHETYPED, such as ENTRY, SECTION and so on).
     * Links may be to structures in other compositions.
     */
    private Set<Link> links;
    /**
     * Details of archetyping used on this node.
     */
    private Archetyped archetypeDetails;
    /**
     * Audit trail from non-openEHR system of original commit of information forming the content of this node,
     * or from a conversion gateway which has synthesised this node.
     */
    private FeederAudit feederAudit;

    /**
     * Clinical concept of the archetype as a whole (= derived from the archetype_node_id' of the root node)
     * @return DvText
     */
    public DvText concept(){
        if(isArchetypeRoot()){
            return archetypeNodeId;
        }
        return null;
    }

    /**
     * True if this node is the root of an archetyped structure.
     * @return boolean
     */
    //TODO

    public boolean isArchetypeRoot(){
        return false;
    }
}
