package nl.rosa.semanticdatabase.bmmdata.services.model_access.data;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import nl.rosa.semanticdatabase.bmmdata.domain.classes.BmmClass;
import nl.rosa.semanticdatabase.bmmdata.domain.model_structure.BmmModel;

import java.util.*;

/**
 * Default created on 5-6-2020
 */

/**
 * Descriptor for a BMM schema. Contains a meta-data table of attributes.
 */
@Builder
@Getter
@Setter
public class BmmSchemaDescriptor {
    //=============== bmmSchema =========================================================================
    /**
     * 0..1
     * bmm_schema: BMM_SCHEMA
     * Persistent form of model.
     */
    private BmmSchema bmmSchema;
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
    private String schemaId;
    /**
     * 1..1
     * meta_data: Hash<String, String>
     * Table of {key, value} of schema meta-data, keys are string values defined by 
     * {BMM_DEFINITIONS}.Metadata_* constants.
     */
    @NonNull
    private Map<String, String> metaData = new HashMap<>();
    public BmmSchemaDescriptor addMetaData(String key, String value) {
        this.metaData.put(key, value);
        return this;
    }


    public BmmSchemaDescriptor removeMetaData(String key) {
        if (metaData != null) {
            this.metaData.remove(key);
        }
        return this;
    }

    public Optional<Map<String, String>> getMetaData() {
        if(metaData!=null){
            return Optional.of(Collections.unmodifiableMap(metaData));
        }else{
            return Optional.empty();
        }
    }

    public BmmSchemaDescriptor setMetaData(Map<String, String> metaData){
        this.metaData = metaData;
        return this;
    }
    /**
     * 0..1
     * includes: List<String>
     * Identifiers of schemas included by this schema.
     */
    private Set<String> includes;
    public Optional<Set<String>> getIncludes() {
        if(includes!=null){
            return Optional.of(Collections.unmodifiableSet(includes));
        }else{
            return Optional.empty();
        }
    }

    public BmmSchemaDescriptor setIncludes(Set<String> includes) {
        this.includes = includes;
        return this;
    }

    public BmmSchemaDescriptor addInclude(String include) {
        if(this.includes==null){
            this.includes = new HashSet<>();
        }
        this.includes.add(include);
        return this;
    }

    public BmmSchemaDescriptor addIncludes(Set<String> includes) {
        if(this.includes==null){
            includes = new HashSet<>();
        }
        this.includes.addAll(includes);
        return this;
    }

    public BmmSchemaDescriptor removeInclude(String include) {
        if(this.includes!=null) {
            this.includes.remove(include);
        }
        return this;
    }

    public BmmSchemaDescriptor removeIncludes(Set<String> includes) {
        if(this.includes!=null) {
            this.includes.removeAll(includes);
        }
        return this;
    }
}
