package nl.rosa.semanticdatabase.archetypeobjectmodel.aom.terminology;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import nl.rosa.semanticdatabase.archetypeobjectmodel.aom.ArchetypeModelObject;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Getter
@Setter
public class ArchetypeTerm extends ArchetypeModelObject implements Map<String, String> {

    private String code;
    private Map<String,String> items = new ConcurrentHashMap<>();

    public void setText(String text) {
        items.put("text", text);
    }
    @JsonProperty
    public String getText() {
        return items.get("text");
    }

    public void setDescription(String description) {
        items.put("description", description);
    }

    @JsonProperty
    public String getDescription() {
        return items.get("description");
    }

    public ArchetypeTerm() {
        super();
    }

    public ArchetypeTerm(String code, String text, String description) {
        this.code = code;
        this.setText(text);
        this.setDescription(description);
    }

    /**
     * For compatibility with the AOM, the other items is explicitly modelled here. You could just use the map interface
     * implemented here - it is faster and easier (and required for odin-parsing with jackson).
     * @return
     */
    public Map<String, String> getOtherItems() {
        Map<String, String> otherItems = new HashMap<>();
        for(Entry<String, String> entry:items.entrySet()) {
            if(!(entry.getKey().equals("text") || entry.getKey().equals("description"))) {
                otherItems.put(entry.getKey(), entry.getValue());
            }
        }
        return otherItems;
    }

    @Override
    public int size() {
        return items.size();
    }

    @Override
    public boolean isEmpty() {
        return items.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return items.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return items.containsValue(value);
    }

    @Override
    public String get(Object key) {
        return items.get(key);
    }

    @Override
    public String put(String key, String value) {
        return items.put(key, value);
    }

    @Override
    public String remove(Object key) {
        return items.remove(key);
    }

    @Override
    public void putAll(Map<? extends String, ? extends String> m) {
        items.putAll(m);
    }

    @Override
    public void clear() {
        items.clear();
    }

    @Override
    public Set<String> keySet() {
        return items.keySet();
    }

    @Override
    public Collection<String> values() {
        return items.values();
    }

    @Override
    public Set<Entry<String, String>> entrySet() {
        return items.entrySet();
    }

}
