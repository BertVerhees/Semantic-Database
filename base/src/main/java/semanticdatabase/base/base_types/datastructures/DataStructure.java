package semanticdatabase.base.base_types.datastructures;

import semanticdatabase.base.archetyped.*;
import semanticdatabase.base.foundation_types.identification_package.UidBasedId;
import semanticdatabase.base.foundation_types.text_types.DvText;

import javax.annotation.Nullable;
import java.util.List;

/**
 * Created by pieter.bos on 04/11/15.
 */
public abstract class DataStructure extends Locatable {

    public DataStructure(String archetypeNodeId, DvText name) {
        super(archetypeNodeId, name);
    }

    public DataStructure(@Nullable UidBasedId uid, String archetypeNodeId, DvText name, @Nullable Archetyped archetypeDetails, @Nullable FeederAudit feederAudit, @Nullable List<Link> links, @Nullable Pathable parent, @Nullable String parentAttributeName) {
        super(uid, archetypeNodeId, name, archetypeDetails, feederAudit, links, parent, parentAttributeName);
    }
}
