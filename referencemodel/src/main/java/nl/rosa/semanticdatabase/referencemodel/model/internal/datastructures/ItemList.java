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

public class ItemList extends ItemStructure<Element> {


    @Nullable
    private List<Element> items = new ArrayList<>();

    public ItemList() {
    }

    public ItemList(String archetypeNodeId, DvText name, @Nullable List<Element> items) {
        super(archetypeNodeId, name);
        setItems(items);
    }

    public ItemList(
            @Nullable UIDBasedId uid,
            String archetypeNodeId,
            DvText name,
            @Nullable Archetyped archetypeDetails,
            @Nullable FeederAudit feederAudit,
            @Nullable List<Link> links,
            @Nullable Pathable parent,
            @Nullable String parentAttributeName,
            @Nullable List<Element> items) {
        super(uid, archetypeNodeId, name, archetypeDetails, feederAudit, links, parent, parentAttributeName);
        setItems(items);
    }

    public List<Element> getItems() {
        return items;
    }

    public void setItems(List<Element> items) {
        this.items = items;
        setThisAsParent(items, "items");
    }

    public void addItem(Element item) {
        this.items.add(item);
        setThisAsParent(item, "items");
    }
}
