package semanticdatabase.base.base_types.datastructures;

import semanticdatabase.base.archetyped.Archetyped;
import semanticdatabase.base.archetyped.FeederAudit;
import semanticdatabase.base.archetyped.Link;
import semanticdatabase.base.archetyped.Pathable;
import semanticdatabase.base.foundation_types.identification_package.UidBasedId;
import semanticdatabase.base.foundation_types.text_types.DvText;

import java.util.List;

/**
 * Created by pieter.bos on 04/11/15.
 */
public abstract class ItemStructure extends DataStructure {

    public ItemStructure(String archetypeNodeId, DvText name) {
        super(archetypeNodeId, name);
    }

    public ItemStructure(UidBasedId uid, String archetypeNodeId, DvText name, Archetyped archetypeDetails, FeederAudit feederAudit, List<Link> links, Pathable parent, String parentAttributeName) {
        super(uid, archetypeNodeId, name, archetypeDetails, feederAudit, links, parent, parentAttributeName);
    }

    /**
     * In the default model it's in the subclasses, but defined here as well because it has a lot of uses
     */
    public abstract List<? extends Item> getItems();
}
