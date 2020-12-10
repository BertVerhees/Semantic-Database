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
public class ItemTable extends ItemStructure {

    private List<Cluster> rows = new ArrayList<>();


    public ItemTable(String archetypeNodeId, DvText name, List<Cluster> rows) {
        super(archetypeNodeId, name);
        setRows(rows);
    }

    public ItemTable(UidBasedId uid, String archetypeNodeId, DvText name, Archetyped archetypeDetails, FeederAudit feederAudit, List<Link> links, Pathable parent, String parentAttributeName, List<Cluster> rows) {
        super(uid, archetypeNodeId, name, archetypeDetails, feederAudit, links, parent, parentAttributeName);
        setRows(rows);
    }

    public List<Cluster> getRows() {
        return rows;
    }

    public void setRows(List<Cluster> rows) {
        this.rows = rows;
        setThisAsParent(rows, "rows");
    }

    public void addItem(Cluster row) {
        this.rows.add(row);
        setThisAsParent(row, "rows");
    }

    /**
     * This is a bit of a strange one - returns all elements present in the table. Use getRows instead
     */
    @Override
    public List<Element> getItems() {
        if (rows == null) {
            return null;
        }
        List<Element> result = new ArrayList<>();
        for (Cluster row : rows) {
            for (Item element : row.getItems()) {
                result.add((Element) element);
            }
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ItemTable itemTable = (ItemTable) o;
        return Objects.equals(rows, itemTable.rows);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), rows);
    }
}
