package nl.rosa.semanticdatabase.bmmdata.model_access;

import nl.rosa.semanticdatabase.bmmdata.domain.model_structure.BmmModel;

import javax.persistence.CascadeType;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import java.util.*;

/**
 * Default created on 5-6-2020
 * Access to BMM models that have been loaded and validated from one or more schema sets.
 */

public class BmmModelAccess {
    /**
     * 0..1
     * schema_directories: List<String>
     * List of directories where all the schemas loaded here are found.
     * NOT USED
     */
    private List<String> schemaDirectories = null;
    /**
     * 0..1
     * all_schemas: Hash<String,BMM_SCHEMA_DESCRIPTOR>
     * All schemas found and loaded from schema_directory. Keyed by schema_id.
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bmmdeclaration")
    @MapKey(name = "schema_id")
    private Map<String, BmmSchemaDescriptor> allSchemas;

    public BmmModelAccess addSchema(BmmSchemaDescriptor schema) {
        if (allSchemas == null) {
            allSchemas = new HashMap<>();
        }
        this.allSchemas.put(schema.getSchemaId(), schema);
        return this;
    }

    public BmmModelAccess addSchemas(Set<BmmSchemaDescriptor> allSchemasSet) {
        allSchemasSet.forEach(item -> this.addSchema(item));
        return this;
    }

    public BmmModelAccess removeSchema(BmmSchemaDescriptor schema) {
        if (allSchemas != null) {
            allSchemas.remove(schema.getSchemaId());
        }
        return this;
    }

    public BmmModelAccess removeSchemas(Set<BmmSchemaDescriptor> allSchemasSet) {
        allSchemasSet.forEach(ancestor -> this.removeSchema(ancestor));
        return this;
    }
    public Map<String, BmmSchemaDescriptor> getAllSchemas() {
        return Collections.unmodifiableMap(allSchemas);
    }
    /**
     * 0..1
     * bmm_models: Hash<String,BMM_MODEL>
     * Top-level (root) schemas in use. Table is keyed by model_id.
     */
    private Map<String, BmmModel> bmmModels;
    /**
     * 0..1
     * matching_bmm_models: Hash<String,BMM_MODEL>
     * BMM_MODELs keyed by model_id() and any shorter form used in calls to
     */
    private Map<String, BmmModel> matchingBmmModels;
}
