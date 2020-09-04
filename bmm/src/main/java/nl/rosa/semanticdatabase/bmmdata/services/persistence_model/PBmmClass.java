package nl.rosa.semanticdatabase.bmmdata.services.persistence_model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import nl.rosa.semanticdatabase.bmmdata.domain.class_features.BmmProperty;
import nl.rosa.semanticdatabase.bmmdata.domain.classes.BmmClass;

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

    private Map<String, PBmmGenericParameter> genericParameterdefs;

    public void putGenericParameterdef(@NonNull String key, @NonNull PBmmGenericParameter value){
        if(genericParameterdefs==null){
            genericParameterdefs = new HashMap<>();
        }
        genericParameterdefs.put(key,  value);

    }
    public void putGenericParameterdefs(Map<String, PBmmGenericParameter> items){
        items.keySet().forEach(key -> putGenericParameterdef(key, items.get(key)));

    }
    public PBmmGenericParameter getGenericParameterdef(String key){
        if(genericParameterdefs==null){
            return null;
        }
        return genericParameterdefs.get(key);
    }
    public void removeGenericParameterdef(String key){
        if(properties!=null) {
            properties.remove(key);
        }
    }
    public void removeGenericParameterdefs(Collection<String> keys){
        keys.forEach(this::removeGenericParameterdef);
    }
    void setGenericParameterdefs(Map<String, PBmmGenericParameter> properties) {
        this.genericParameterdefs = properties;
    }
    Map<String,PBmmGenericParameter> getGenericParameterdefs() {
        return genericParameterdefs;
    }
    public Map<String,PBmmGenericParameter> genericParameterdefs() {
        return Collections.unmodifiableMap(genericParameterdefs);
    }

    /**
     * 1..1
     * source_schema_id: String
     * Reference to original source schema defining this class. Set during BMM_SCHEMA materialise.
     * Useful for GUI tools to enable user to edit the schema file containing a given class
     * (i.e. taking into account that a class may be in any of the schemas in a schema inclusion hierarchy).
     */
    @Getter
    @Setter
    @NonNull
    private String sourceSchemaId;

    /**
     * 0..1
     * bmm_class: BMM_CLASS
     * BMM_CLASS object built by create_bmm_class_definition and populate_bmm_class_definition.
     */
    @Getter
    @Setter
    private BmmClass bmmClass;

    /**
     * 1..1
     * uid: Integer
     * Unique id generated for later comparison during merging, in order to detect if two classes are the same.
     * Assigned in post-load processing.
     */
    @Getter
    @Setter
    @NonNull
    private Integer uid;

    private Set<PBmmGenericType> ancestorDefs;
    public void addAncestorDef(@NonNull PBmmGenericType value){
        if(ancestorDefs==null){
            ancestorDefs = new HashSet<>();
        }
        ancestorDefs.add(value);
    }
    public void addAncestorDefs(Set<PBmmGenericType> openArgs){
        openArgs.forEach(openArg -> addAncestorDef(openArg));

    }
    public void removeAncestorDef(PBmmGenericType openArg){
        if(ancestorDefs!=null) {
            ancestorDefs.remove(openArg);
        }
    }
    public void removeAncestorDefs(Collection<PBmmGenericType> openArgs){
        openArgs.forEach(this::removeAncestorDef);
    }
    public void removeAncestorDefs(Set<PBmmGenericType> openArgs) {
        this.ancestorDefs.removeAll(openArgs);
    }
    void setAncestorDefs(Set<PBmmGenericType> openArgs) {
        this.ancestorDefs = openArgs;
    }
    Set<PBmmGenericType> getAncestorDefs() {
        return ancestorDefs;
    }
    public Set<PBmmGenericType> ancestorDefs() {
        return Collections.unmodifiableSet(ancestorDefs);
    }
}
