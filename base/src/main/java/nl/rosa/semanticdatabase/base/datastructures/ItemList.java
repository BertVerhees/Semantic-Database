package nl.rosa.semanticdatabase.base.datastructures;

import nl.rosa.semanticdatabase.base.archetyped.Archetyped;
import nl.rosa.semanticdatabase.base.archetyped.FeederAudit;
import nl.rosa.semanticdatabase.base.archetyped.Link;
import nl.rosa.semanticdatabase.base.archetyped.Pathable;
import nl.rosa.semanticdatabase.base.datavalues.text.DvText;
import nl.rosa.semanticdatabase.base.identification.UidBasedId;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Originally: Created by pieter.bos on 04/11/15.
 */
public class ItemList extends ItemStructure {

    private List<Element> items = new ArrayList<>();

    public ItemList(String archetypeNodeId, DvText name, List<Element> items) {
        super(archetypeNodeId, name);
        setItems(items);
    }

    public ItemList(UidBasedId uid, String archetypeNodeId, DvText name, Archetyped archetypeDetails, FeederAudit feederAudit, List<Link> links, Pathable parent, String parentAttributeName, List<Element> items) {
        super(uid, archetypeNodeId, name, archetypeDetails, feederAudit, links, parent, parentAttributeName);
        setItems(items);
    }

    @Override
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ItemList itemList = (ItemList) o;
        return Objects.equals(items, itemList.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), items);
    }
}
