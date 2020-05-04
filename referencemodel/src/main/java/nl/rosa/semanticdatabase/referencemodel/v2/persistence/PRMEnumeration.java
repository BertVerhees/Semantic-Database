package nl.rosa.semanticdatabase.referencemodel.v2.persistence;

import java.util.List;

public class PRMEnumeration<ItemType> extends PRMClass {
    private List<String> itemNames;
    private List<ItemType> itemValues;

    public List<String> getItemNames() {
        return itemNames;
    }

    public void setItemNames(List<String> itemNames) {
        this.itemNames = itemNames;
    }

    public List<ItemType> getItemValues() {
        return itemValues;
    }

    public void setItemValues(List<ItemType> itemValues) {
        this.itemValues = itemValues;
    }
}
