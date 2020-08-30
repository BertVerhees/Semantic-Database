package nl.rosa.semanticdatabase.bmmdata.domain.class_features;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import nl.rosa.semanticdatabase.bmmdata.domain.BmmBase;

import java.util.*;

/**
 * Default created on 18-8-2020
 * A logical group of features, with a name and set of properties that applies to the group.
 */

public class BmmFeatureGroup extends BmmBase {

    /**
     * 1..1
     * name: String
     * {default = "feature"}
     * Name of this feature group; defaults to 'feature'.
     */
    @NonNull
    @Getter
    @Setter
    private String name = "feature";

    /**
     * 1..1
     * properties: Hash<String, String>
     * Set of properties of this group, represented as name/value pairs. These are understood to apply logically
     * to all of the features contained within the group.
     */
    private Map<String, String> properties = new HashMap<>();

    public void putProperty(@NonNull String key, @NonNull String value){
        properties.put(key,  value);
    }
    public void putProperties(Map<String, String> items){
        items.keySet().forEach(key -> putProperty(key, items.get(key)));

    }
    public String getProperty(String key){
        return properties.get(key);
    }
    public void removeProperty(String key){
        properties.remove(key);
    }
    public void removeProperties(Collection<String> keys){
        keys.forEach(this::removeProperty);
    }
    void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }
    Map<String,String> getProperties() {
        return properties;
    }
    public Map<String,String> properties() {
        return Collections.unmodifiableMap(properties);
    }

    /**
     * 0..1
     * features: List<BMM_CLASS_FEATURE>
     * Set of features in this group.
     */
    private Set<BmmClassFeature> features;
    public void addFeature(@NonNull BmmClassFeature value){
        if(features==null){
            features = new HashSet<>();
        }
        features.add(value);

    }
    public void addFeatures(Set<BmmClassFeature> items){
        items.forEach(item -> addFeature(item));

    }
    public void removeFeature(BmmClassFeature item){
        if(features!=null) {
            features.remove(item);
        }
    }
    public void removeFeatures(Collection<BmmClassFeature> items){
        items.forEach(this::removeFeature);
    }
    void setFeatures(Set<BmmClassFeature> items) {
        this.features = items;
    }
    private Set<BmmClassFeature> getFeatures() {
        return features;
    }
    public Set<BmmClassFeature> features() {
        return Collections.unmodifiableSet(features);
    }

    /**
     * 0..1
     * visibility: BMM_VISIBILITY
     * Optional visibility to apply to all features in this group.
     */
    @Getter
    @Setter
    private BmmVisibility visibility;
}
