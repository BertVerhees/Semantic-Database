package nl.rosa.semanticdatabase.referencemodel.model.internal.datastructures;

import nl.rosa.semanticdatabase.referencemodel.model.internal.archetyped.Archetyped;
import nl.rosa.semanticdatabase.referencemodel.model.internal.archetyped.FeederAudit;
import nl.rosa.semanticdatabase.referencemodel.model.internal.archetyped.Link;
import nl.rosa.semanticdatabase.referencemodel.model.internal.archetyped.Pathable;
import nl.rosa.semanticdatabase.referencemodel.model.internal.datavalues.DvText;
import nl.rosa.semanticdatabase.referencemodel.model.internal.support.identification.UIDBasedId;
import org.springframework.lang.Nullable;

import java.util.List;

public abstract class ItemStructure<Type extends Item> extends DataStructure {

    public ItemStructure() {
    }

    public ItemStructure(String archetypeNodeId, DvText name) {
        super(archetypeNodeId, name);
    }

    public ItemStructure(
            @Nullable UIDBasedId uid,
            String archetypeNodeId,
            DvText name,
            @Nullable Archetyped archetypeDetails,
            @Nullable FeederAudit feederAudit,
            @Nullable List<Link> links,
            @Nullable Pathable parent,
            @Nullable String parentAttributeName) {
        super(uid, archetypeNodeId, name, archetypeDetails, feederAudit, links, parent, parentAttributeName);
    }
}
