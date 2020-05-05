package nl.rosa.semanticdatabase.referencemodel.model_access;

import lombok.Getter;
import lombok.Setter;
import nl.rosa.semanticdatabase.referencemodel.base.BmmDefinitions;
import nl.rosa.semanticdatabase.referencemodel.model.BmmModel;

import java.util.List;
import java.util.Map;

/**
 * Default created on 5-5-2020
 *
 * Descriptor for a BMM schema. Contains a meta-data table of attributes obtained from a mini parse of the schema file.
 */
@Getter
@Setter
public abstract class BmmSchemaDescriptor extends BmmDefinitions {
    /**
     * Persistent form of model.
     */
    private BmmSchema bmmSchema;
    /**
     * Computable form of model.
     */
    private BmmModel bmmModel;
    /**
     * Schema id, formed from:
     * meta_data.item(Metadata_model_publisher) '-' meta_data.item(metadata_schema_name) '-' meta_data.item(Metadata_model_release)
     * e.g. openehr_rm_1.0.3, openehr_test_1.0.1, iso_13606_1_2008_2.1.2.
     */
    private String schemaId;
    /**
     * Table of {key, value} pairs of schema meta-data, keys are string values corresponding to values in P_BMM_SCHEMA_METADATA_KEY.
     */
    private Map<String, String> metaData;
    /**
     * Identifiers of schemas included by this schema.
     */
    private List<String> includes;

    /**
     * True if this is a top-level schema, i.e. not included by some other schema.
     * @return
     */
    public boolean isTopLevel(){
        return false;
    }

    /**
     * True if the BMM version found in the schema (or assumed, if none) is compatible with that in this software.
     * @return
     */
    public boolean isBmmCompatible() {
        return false;
    }

    /**
     * Load schema into in-memory form, i.e. a P_BMM_SCHEMA instance, if structurally valid. If successful, p_schema will be set.
     */
    public void load(){

    }

    /**
     * Validate loaded schema and report errors.
     */
    public void validateMerged(){

    }

    /**
     * Validate includes list for this schema, to see if each mentioned schema exists in all_schemas list.
     * @param allSchemaList
     */
    public void validateIncludes(List<String> allSchemaList){

    }

    /**
     * Create schema, i.e. the BMM_MODEL from one P_BMM_SCHEMA schema.
     */
    public void createModel(){

    }
    //TODO
}
