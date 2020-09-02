package nl.rosa.semanticdatabase.bmmdata.services.persistence_model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import nl.rosa.semanticdatabase.bmmdata.domain.class_features.BmmProperty;

import java.util.*;

/**
 * Default created on 31-7-2020
 */

public class PBmmClass implements PBmmModelElement{
    /**
     * 0..1
     * documentation: String
     * Optional documentation of this element.
     * (********  inherits from PBmmModelElement)
     */
    @Getter
    @Setter
    private String documentation;

    /**
     * 1..1
     * name: String
     * Name of the class. Persisted attribute.
     */
    @Getter
    @Setter
    @NonNull
    private String name;

    /**
     * 0..1
     * ancestors: List<String>
     * List of immediate inheritance parents. If there are generic ancestors, use ancestor_defs instead.
     * Persisted attribute.
     */
    private Set<String> ancestors;
    public void addAncestor(@NonNull String value){
        if(ancestors==null){
            ancestors = new HashSet<>();
        }
        ancestors.add(value);
    }
    public void addAncestors(Set<String> ancestors){
        ancestors.forEach(ancestor -> addAncestor(ancestor));

    }
    public void removeAncestor(String ancestor){
        if(ancestors!=null) {
            ancestors.remove(ancestor);
        }
    }
    public void removeAncestors(Collection<String> ancestors){
        ancestors.forEach(this::removeAncestor);
    }
    public void removeAncestors(Set<String> ancestors) {
        this.ancestors.removeAll(ancestors);
    }
    void setAncestors(Set<String> ancestors) {
        this.ancestors = ancestors;
    }
    Set<String> getAncestors() {
        return ancestors;
    }
    public Set<String> ancestors() {
        return Collections.unmodifiableSet(ancestors);
    }

    /**
     * 0..1
     * properties: Hash<String,P_BMM_PROPERTY>
     * List of attributes defined in this class. Persistent attribute.
     */
    private Map<String, PBmmProperty> properties;

    public void putProperty(@NonNull String key, @NonNull PBmmProperty value){
        if(properties==null){
            properties = new HashMap<>();
        }
        properties.put(key,  value);

    }
    public void putProperties(Map<String, PBmmProperty> items){
        items.keySet().forEach(key -> putProperty(key, items.get(key)));

    }
    public PBmmProperty getProperty(String key){
        if(properties==null){
            return null;
        }
        return properties.get(key);
    }
    public void removeProperty(String key){
        if(properties!=null) {
            properties.remove(key);
        }
    }
    public void removeProperties(Collection<String> keys){
        keys.forEach(this::removeProperty);
    }
    void setProperties(Map<String, PBmmProperty> properties) {
        this.properties = properties;
    }
    Map<String,PBmmProperty> getProperties() {
        return properties;
    }
    public Map<String,PBmmProperty> properties() {
        return Collections.unmodifiableMap(properties);
    }

    /**
     * 0..1
     * is_abstract: Boolean
     * True if this is an abstract type. Persisted attribute.
     */
    @Getter
    @Setter
    private Boolean isAbstract;

    /**
     * 0..1
     * is_override: Boolean
     * True if this class definition overrides one found in an included schema.
     */
    @Getter
    @Setter
    private Boolean isOverride;
}
