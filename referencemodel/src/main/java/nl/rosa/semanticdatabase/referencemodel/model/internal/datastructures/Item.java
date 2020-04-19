package nl.rosa.semanticdatabase.referencemodel.model.internal.datastructures;


import nl.rosa.semanticdatabase.referencemodel.model.internal.archetyped.*;
import nl.rosa.semanticdatabase.referencemodel.model.internal.datavalues.DvText;
import nl.rosa.semanticdatabase.referencemodel.model.internal.support.identification.UIDBasedId;
import org.springframework.lang.Nullable;

import java.util.List;

public abstract class Item extends Locatable {

    public Item() {
    }

    public Item(String archetypeNodeId, DvText name) {
        super(archetypeNodeId, name);
    }

    public Item(
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
