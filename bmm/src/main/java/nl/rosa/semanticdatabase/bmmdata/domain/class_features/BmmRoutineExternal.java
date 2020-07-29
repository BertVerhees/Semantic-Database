package nl.rosa.semanticdatabase.bmmdata.domain.class_features;

import lombok.NonNull;
import nl.rosa.semanticdatabase.bmmdata.domain.classes.BmmClass;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Default created on 29-7-2020
 */

public class BmmRoutineExternal implements BmmRoutineBody{
    /**
     * 1..1
     * meta_data: Hash<String, String>
     * External call general meta-data, including target routine name, type mapping etc.
     */
    private Map<String, String> metaData = new HashMap<>();
    public void putMetaData(@NonNull String key, @NonNull String value){
        metaData.put(key,  value);
    }
    public void putMetaDataItem(Map<String, String> items){
        items.keySet().forEach(key -> putMetaData(key, items.get(key)));
    }
    public String getMetaDataItem(String key){
        return metaData.get(key);
    }
    public void removeMetaDataItem(String key){
        metaData.remove(key);
    }
    public void removeMetaData(Collection<String> keys){
        keys.forEach(this::removeMetaDataItem);
    }
    void setMetaData(Map<String, String> constants) {
        this.metaData = constants;
    }
    Map<String,String> getMetaData() {
        return metaData;
    }
    public Map<String,String> metaData() {
        return Collections.unmodifiableMap(metaData);
    }
    /**
     * 0..1
     * argument_mapping: Hash<String, String>
     * Optional argument-mapping meta-data.
     */
    private Map<String, String> argumentMapping;
    public void putArgumentMapping(@NonNull String key, @NonNull String value){
        argumentMapping.put(key,  value);
    }
    public void putArgumentMappingItem(Map<String, String> items){
        items.keySet().forEach(key -> putArgumentMapping(key, items.get(key)));
    }
    public String getArgumentMappingItem(String key){
        return argumentMapping.get(key);
    }
    public void removeArgumentMappingItem(String key){
        argumentMapping.remove(key);
    }
    public void removeArgumentMappings(Collection<String> keys){
        keys.forEach(this::removeArgumentMappingItem);
    }
    void setArgumentMapping(Map<String, String> constants) {
        this.argumentMapping = constants;
    }
    Map<String,String> getArgumentMapping() {
        return argumentMapping;
    }
    public Map<String,String> argumentMapping() {
        return Collections.unmodifiableMap(argumentMapping);
    }
}