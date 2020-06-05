package nl.rosa.semanticdatabase.bmmdata.model_access;

import lombok.Data;
import nl.rosa.semanticdatabase.bmmdata.model.BmmBaseEntity;
import nl.rosa.semanticdatabase.bmmdata.model.model_structure.BmmModel;

import java.util.Map;
import java.util.Optional;

/**
 * Default created on 5-6-2020
 * Access to BMM models that have been loaded and validated from one or more schema sets.
 */

@Data
public class BmmModelAccess extends BmmBaseEntity {
    /**
     * 0..1
     * all_schemas: Hash<String,BMM_SCHEMA_DESCRIPTOR>
     * All schemas found and loaded from schema_directory. Keyed by schema_id.
     */
    private Optional<Map<String, BmmSchemaDescriptor>> allSchemas;
    /**
     * 0..1
     * bmm_models: Hash<String,BMM_MODEL>
     * Top-level (root) schemas in use. Table is keyed by model_id.
     */
    private Optional<Map<String, BmmModel>> bmmModels;
    /**
     * 0..1
     * matching_bmm_models: Hash<String,BMM_MODEL>
     * BMM_MODELs keyed by model_id() and any shorter form used in calls to
     */
    private Optional<Map<String, BmmModel>> matchingBmmModels;
}
