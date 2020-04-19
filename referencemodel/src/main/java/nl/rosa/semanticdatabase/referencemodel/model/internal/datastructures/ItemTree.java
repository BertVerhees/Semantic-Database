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

public class ItemTree extends ItemStructure<Item> {
    @Nullable
    private List<Item> items = new ArrayList<>();

    public ItemTree() {
    }

    public ItemTree(String archetypeNodeId, DvText name, @Nullable List<Item> items) {
        super(archetypeNodeId, name);
        this.items = items;
        setThisAsParent(items, "items");
    }

    public ItemTree(
            @Nullable UIDBasedId uid,
            String archetypeNodeId,
            DvText name,
            @Nullable Archetyped archetypeDetails,
            @Nullable FeederAudit feederAudit,
            @Nullable List<Link> links,
            @Nullable Pathable parent,
            @Nullable String parentAttributeName,
            @Nullable List<Item> items) {
        super(uid, archetypeNodeId, name, archetypeDetails, feederAudit, links, parent, parentAttributeName);
        this.items = items;
        setThisAsParent(items, "items");
    }

    public void addItem(Item item) {
        this.items.add(item);
        setThisAsParent(item, "items");
    }

}
