package nl.rosa.semanticdatabase.base_types.datastructures;

import nl.rosa.semanticdatabase.base.archetyped.Archetyped;
import nl.rosa.semanticdatabase.base.archetyped.FeederAudit;
import nl.rosa.semanticdatabase.base.archetyped.Link;
import nl.rosa.semanticdatabase.base.archetyped.Locatable;
import nl.rosa.semanticdatabase.base.support.identification.UIDBasedId;
import nl.rosa.semanticdatabase.base_types.datavalues.DvText;

import javax.annotation.Nullable;

public abstract class Item extends Locatable {

    public Item() {
    }

    public Item(String archetypeNodeId, DvText name) {
        super(archetypeNodeId, name);
    }

    public Item(@Nullable UIDBasedId uid, String archetypeNodeId, DvText name, @Nullable Archetyped archetypeDetails, @Nullable FeederAudit feederAudit, @Nullable List<Link> links, @Nullable Pathable parent, @Nullable String parentAttributeName) {
        super(uid, archetypeNodeId, name, archetypeDetails, feederAudit, links, parent, parentAttributeName);
    }
}
