package nl.rosa.semanticdatabase.bmmdata.model_access;

import lombok.Getter;
import lombok.NonNull;
import nl.rosa.semanticdatabase.bmmdata.domain.model_structure.BmmModel;

import javax.persistence.*;
import java.util.*;

/**
 * Default created on 5-6-2020
 */

/**
 * Descriptor for a BMM schema. Contains a meta-data table of attributes.
 */

public class BmmSchemaDescriptor {
    /**
     * 0..1
     * bmm_schema: BMM_SCHEMA
     * Persistent form of model.
     */
    @Getter
    private BmmSchema bmmSchema;

    public BmmSchemaDescriptor setBmmSchema(BmmSchema bmmSchema) {
        this.bmmSchema = bmmSchema;
        return this;
    }

    /**
     * 0..1
     * bmm_model: BMM_MODEL
     * Computable form of model.
     */
    private BmmModel bmmModel;
    /**
     * schema_id: String
     * Schema id, formed by
     * {BMM_DEFINITIONS}.create_schema_id( meta_data.item({BMM_DEFINITIONS}.Metadata_model_publisher),
     * meta_data.item({BMM_DEFINITIONS}.Metadata_schema_name), meta_data.item({BMM_DEFINITIONS}.Metadata_model_release)
     * e.g. openehr_rm_1.0.3, openehr_test_1.0.1, iso_13606_1_2008_2.1.2.
     */
    @NonNull
    @Getter
    private String schemaId;

    public BmmSchemaDescriptor setSchemaId(String schemaId) {
        this.schemaId = schemaId;
        return this;
    }

    /**
     * 1..1
     * meta_data: Hash<String, String>
     * Table of {key, value} of schema meta-data, keys are string values defined by 
     * {BMM_DEFINITIONS}.Metadata_* constants.
     */
    @NonNull
    @ElementCollection
    @MapKeyColumn(name="key")
    @Column(name="value")
    @CollectionTable(name="example_attributes", joinColumns=@JoinColumn(name="example_id"))
    private Map<String, String> metaData;

    public String addMetaDataItem(String key, String value) {
        if (metaData == null) {
            metaData = new HashMap<>();
        }
        return this.metaData.put(key, value);
    }

    public void addMetaDataItems(HashMap<String, String> metaDataItems) {
        metaDataItems.keySet().forEach(key -> this.addMetaDataItem(key, metaDataItems.get(key)));
    }

    public String removeMetaDataItem(String key) {
        if (metaData != null) {
            metaData.remove(key);
        }
        return null;
    }

    public void removeMetaDataItems(HashMap<String, String> metaDataItems) {
        metaDataItems.keySet().forEach(key -> this.removeMetaDataItem(key));
    }

    public Map<String, String> getMetaDataItems() {
        return Collections.unmodifiableMap(metaData);
    }

    /**
     * 0..1
     * includes: List<String>
     * Identifiers of schemas included by this schema.
     */
    @ElementCollection
    private Set<String> includes;

    public BmmSchemaDescriptor setIncludes(Set<String> includes) {
        this.includes = includes;
        return this;
    }

    public Set<String> getIncludes() {
        return Collections.unmodifiableSet(this.includes);
    }

    public Boolean addInclude(String include){
        if(includes == null){
             includes = new HashSet<>();
        }
        return includes.add(include);
    }

    public void addIncludes(List<String> includes){
        if(this.includes == null){
            this.includes = new HashSet<>();
        }
        includes.forEach(include -> addInclude(include));
    }

    public Boolean removeInclude(String include){
        if(includes!=null){
            return includes.remove(include);
        }
        return false;
    }

    public void removeIncludes(List<String> includes){
        if(this.includes!=null){
            includes.forEach(include -> removeInclude(include));
        }
    }
}
