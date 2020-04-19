package nl.rosa.semanticdatabase.referencemodel.model.internal.datastructures;

import nl.rosa.semanticdatabase.referencemodel.model.internal.archetyped.Archetyped;
import nl.rosa.semanticdatabase.referencemodel.model.internal.archetyped.FeederAudit;
import nl.rosa.semanticdatabase.referencemodel.model.internal.archetyped.Link;
import nl.rosa.semanticdatabase.referencemodel.model.internal.archetyped.Pathable;
import nl.rosa.semanticdatabase.referencemodel.model.internal.datavalues.DataValue;
import nl.rosa.semanticdatabase.referencemodel.model.internal.datavalues.DvCodedText;
import nl.rosa.semanticdatabase.referencemodel.model.internal.datavalues.DvText;
import nl.rosa.semanticdatabase.referencemodel.model.internal.datavalues.SingleValuedDataValue;
import nl.rosa.semanticdatabase.referencemodel.model.internal.support.identification.UIDBasedId;
import org.springframework.lang.Nullable;

import java.util.List;

public class Element extends Item implements SingleValuedDataValue<DataValue> {

    @Nullable
    private DataValue value;

    @Nullable
    private DvCodedText nullFlavour;

    public Element() {
    }

    public Element(String archetypeNodeId, DvText name, @Nullable DataValue value) {
        super(archetypeNodeId, name);
        this.value = value;
    }

    public Element(
            @Nullable UIDBasedId uid,
            String archetypeNodeId,
            DvText name,
            @Nullable Archetyped archetypeDetails,
            @Nullable FeederAudit feederAudit,
            @Nullable List<Link> links,
            @Nullable Pathable parent,
            @Nullable String parentAttributeName,
            @Nullable DataValue value,
            @Nullable DvCodedText nullFlavour) {
        super(uid, archetypeNodeId, name, archetypeDetails, feederAudit, links, parent, parentAttributeName);
        this.value = value;
        this.nullFlavour = nullFlavour;
    }
}
