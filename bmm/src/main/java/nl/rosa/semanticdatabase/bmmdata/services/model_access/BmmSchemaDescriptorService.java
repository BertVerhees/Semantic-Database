package nl.rosa.semanticdatabase.bmmdata.services.model_access;

import nl.rosa.semanticdatabase.bmmdata.services.CrudService;

import java.util.List;

/**
 * Default created on 6-6-2020
 */

public interface BmmSchemaDescriptorService extends CrudService<BmmSchemaDescriptorService, Long> {
    /**
     * 1..1
     * is_top_level (): Boolean
     * True if this is a top-level schema, i.e. not included by some other schema.
     * @return
     */
    Boolean isTopLevel();

    /**
     * 1..1
     * is_bmm_compatible (): Boolean
     * True if the BMM version found in the schema (or assumed, if none) is compatible with that in this software.
     * @return
     */
    Boolean isBmmCompatible();

    /**
     * 0..1
     * load
     * Load schema into in-memory form, i.e. a P_BMM_SCHEMA instance, if structurally valid.
     * If successful, p_schema will be set.
     */
    void load();

    /**
     * 0..1
     * validate_merged
     * Validate loaded schema and report errors.
     */
    void validateMerged();

    /**
     * 0..1
     * validate_includes ( * all_schemas_list: List<String>[0..1] * )
     * Validate includes list for this schema, to see if each mentioned schema exists in all_schemas list.
     * @param allSchemasList
     */
    void validateIncludes(List<String> allSchemasList);

    /**
     * 0..1
     * create_model
     * Create schema, i.e. the BMM_MODEL from one P_BMM_SCHEMA schema.
     */
    void createModel();
}
