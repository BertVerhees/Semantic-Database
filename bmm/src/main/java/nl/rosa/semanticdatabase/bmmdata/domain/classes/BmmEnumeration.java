package nl.rosa.semanticdatabase.bmmdata.domain.classes;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import nl.rosa.semanticdatabase.bmmdata.domain.expressions.ElAssertion;
import nl.rosa.semanticdatabase.bmmdata.domain.literal_values.BmmLiteralValue;

import javax.persistence.*;
import java.util.*;


/**
 * Class BmmEnumeration
 */
@EqualsAndHashCode(callSuper = true)
public class BmmEnumeration extends BmmSimpleClass {
    /**
     * 0..1
     * item_names: List<String>
     * The list of names of the enumeration. If no values are supplied, the integer values 0, 1, 2, …​ are assumed.
     */
    protected Set<String> itemNames;

    public BmmEnumeration addItemName(@NonNull String value) {
        if (itemNames == null) {
            itemNames = new HashSet<>();
        }
        itemNames.add(value);
        return this;
    }

    public BmmEnumeration addtemNames(Set<String> items) {
        items.forEach(item -> addItemName(item));
        return this;
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
    private Set<BmmLiteralValue> itemValues;

    public BmmEnumeration addItemValue(@NonNull BmmLiteralValue value) {
        if (itemValues == null) {
            itemValues = new HashSet<>();
        }
        itemValues.add(value);
        return this;
    }

    public BmmEnumeration addtemValues(Set<BmmLiteralValue> items) {
        items.forEach(item -> addItemValue(item));
        return this;
    }

    public void removeItemValue(BmmLiteralValue item) {
        if (itemValues != null) {
            itemValues.remove(item);
        }
    }

    public void removeItemValues(Collection<BmmLiteralValue> items) {
        items.forEach(this::removeItemValue);
    }

    private void setItemValues(Set<BmmLiteralValue> items) {
        this.itemValues = items;
    }

    private Set<BmmLiteralValue> getItemValues() {
        return itemValues;
    }

    public Set<BmmLiteralValue> itemValues() {
        return Collections.unmodifiableSet(itemValues);
    }

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
