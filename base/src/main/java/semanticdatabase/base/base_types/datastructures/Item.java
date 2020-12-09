package semanticdatabase.base.base_types.datastructures;

import semanticdatabase.base.archetyped.*;
import semanticdatabase.base.base_types.datavalues.DvText;
import semanticdatabase.base.foundation_types.identification_package.UidBasedId;

import javax.annotation.Nullable;
import java.util.List;

public abstract class Item extends Locatable {

    public Item() {
    }

    public Item(String archetypeNodeId, DvText name) {
        super(archetypeNodeId, name);
    }

    public Item(@Nullable UidBasedId uid, String archetypeNodeId, DvText name, @Nullable Archetyped archetypeDetails, @Nullable FeederAudit feederAudit, @Nullable List<Link> links, @Nullable Pathable parent, @Nullable String parentAttributeName) {
        super(uid, archetypeNodeId, name, archetypeDetails, feederAudit, links, parent, parentAttributeName);
    }
}
