package nl.rosa.semanticdatabase.bmmdata.services.model_access.data;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
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
    private Map<String, String> metaData;
    /**
     * 0..1
     * includes: List<String>
     * Identifiers of schemas included by this schema.
     */
    private Set<String> includes;
}
