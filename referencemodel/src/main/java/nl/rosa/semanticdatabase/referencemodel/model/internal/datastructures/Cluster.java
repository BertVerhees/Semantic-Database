package nl.rosa.semanticdatabase.referencemodel.model.internal.datastructures;

import nl.rosa.semanticdatabase.referencemodel.model.internal.archetyped.Archetyped;
import nl.rosa.semanticdatabase.referencemodel.model.internal.archetyped.FeederAudit;
import nl.rosa.semanticdatabase.referencemodel.model.internal.archetyped.Link;
import nl.rosa.semanticdatabase.referencemodel.model.internal.archetyped.Pathable;
import nl.rosa.semanticdatabase.referencemodel.model.internal.datavalues.DvText;
import nl.rosa.semanticdatabase.referencemodel.model.internal.support.identification.UIDBasedId;
import org.springframework.lang.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Cluster<Type extends Item> extends Item {

    private List<Type> items = new ArrayList<>();

    public Cluster() {
    }

    public Cluster(String archetypeNodeId, DvText name, List<Type> items) {
        super(archetypeNodeId, name);
        this.items = items;
        setThisAsParent(items, "items");
    }

    public Cluster(
            @Nullable UIDBasedId uid,
            String archetypeNodeId,
            DvText name,
            @Nullable Archetyped archetypeDetails,
            @Nullable FeederAudit feederAudit,
            @Nullable List<Link> links,
            @Nullable Pathable parent,
            @Nullable String parentAttributeName,
            List<Type> items) {
        super(uid, archetypeNodeId, name, archetypeDetails, feederAudit, links, parent, parentAttributeName);
        this.items = items;
        setThisAsParent(items, "items");
    }

    public void addItem(Type item) {
        items.add(item);
        setThisAsParent(item, "items");
    }
}
