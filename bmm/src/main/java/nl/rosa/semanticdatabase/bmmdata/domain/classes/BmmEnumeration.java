package nl.rosa.semanticdatabase.bmmdata.domain.classes;

import lombok.NonNull;
import nl.rosa.semanticdatabase.bmmdata.domain.literal_values.BmmLiteralValue;

import java.util.*;


/**
 * Class BmmEnumeration
 */
public class BmmEnumeration<T extends BmmLiteralValue> extends BmmSimpleClass {

    /**
     * 0..1
     * item_names: List<String>
     * The list of names of the enumeration. If no values are supplied, the integer values 0, 1, 2, …​ are assumed.
     */
    protected Set<String> itemNames;

    public void addItemName(@NonNull String value) {
        if (itemNames == null) {
            itemNames = new HashSet<>();
        }
        itemNames.add(value);

    }

    public void addItemNames(Set<String> items) {
        items.forEach(item -> addItemName(item));

    }

    public void removeItemName(String item) {
        if (itemNames != null) {
            itemNames.remove(item);
        }
    }

    public void removeItemNames(Collection<String> items) {
        items.forEach(this::removeItemName);
    }

    protected void setItemNames(Set<String> items) {
        this.itemNames = items;
    }

    protected Set<String> getItemNames() {
        return itemNames;
    }

    public Set<String> itemNames() {
        return Collections.unmodifiableSet(itemNames);
    }

    /**
     * 0..1
     * item_values: List<BMM_LITERAL_VALUE>
     * Optional list of specific values. Must be 1:1 with item_names list.
     */
    private Set<T> itemValues;

    public void addItemValue(@NonNull T value) {
        if (itemValues == null) {
            itemValues = new HashSet<>();
        }
        itemValues.add(value);

    }

    public void addtemValues(Set<T> items) {
        items.forEach(item -> addItemValue(item));

    }

    public void removeItemValue(T item) {
        if (itemValues != null) {
            itemValues.remove(item);
        }
    }

    public void removeItemValues(Collection<T> items) {
        items.forEach(this::removeItemValue);
    }

    void setItemValues(Set<T> items) {
        this.itemValues = items;
    }

    private Set<T> getItemValues() {
        return itemValues;
    }

    public Set<T> itemValues() {
        return Collections.unmodifiableSet(itemValues);
    }

    //================= Functions =========================================================
    /**
     * 1..1
     * name_map (): Hash<String, String>
     * Map of item_names to item_values (stringified).
     */
    public Map<String, String> nameMap() {
        //TODO
        return null;
    }
}
