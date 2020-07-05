package nl.rosa.semanticdatabase.bmmdata.services.model_access.data;

import nl.rosa.semanticdatabase.bmmdata.domain.model_structure.BmmModel;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Default created on 5-7-2020
 */
@Component
public class BmmModelAccess {
    //========== matchingBmmModels ===================================================================
    /**
     * 0..1
     * matching_bmm_models: Hash<String,BMM_MODEL>
     * BMM_MODELs keyed by model_id() and any shorter form used in calls to
     */
    private Map<String, BmmModel> matchingBmmModels;

    public void setMatchingBmmModels(Map<String, BmmModel> bmmModels) {
        this.matchingBmmModels = bmmModels;
    }

    public BmmModelAccess addMatchingBmmModel(BmmModel model) {
        if (matchingBmmModels == null) {
            matchingBmmModels = new HashMap<>();
        }
        this.matchingBmmModels.put(model.modelId(), model);
        return this;
    }

    public BmmModelAccess addMatchingMatchingBmmModels(Set<BmmModel> allModelsSet) {
        allModelsSet.forEach(this::addMatchingBmmModel);
        return this;
    }

    public BmmModelAccess removeMatchingBmmModel(BmmModel schema) {
        if (matchingBmmModels != null) {
            matchingBmmModels.remove(schema.modelId());
        }
        return this;
    }

    public BmmModelAccess removeMatchingBmmModels(Set<BmmModel> allModelsSet) {
        allModelsSet.forEach(this::removeMatchingBmmModel);
        return this;
    }
    public Map<String, BmmModel> getMatchingBmmModels() {
        return Collections.unmodifiableMap(matchingBmmModels);
    }

    //====== bmmModels =========================================================================
    /**
     * 0..1
     * bmm_models: Hash<String,BMM_MODEL>
     * Top-level (root) schemas in use. Table is keyed by model_id.
     */
    private Map<String, BmmModel> bmmModels;

    public void setBmmModels(Map<String, BmmModel> bmmModels) {
        this.bmmModels = bmmModels;
    }

    public BmmModelAccess addBmmModel(BmmModel model) {
        if (bmmModels == null) {
            bmmModels = new HashMap<>();
        }
        this.bmmModels.put(model.modelId(), model);
        return this;
    }

    public BmmModelAccess addModels(Set<BmmModel> allModelsSet) {
        allModelsSet.forEach(this::addBmmModel);
        return this;
    }

    public BmmModelAccess removeBmmModel(BmmModel model) {
        if (bmmModels != null) {
            bmmModels.remove(model.modelId());
        }
        return this;
    }

    public BmmModelAccess removeModels(Set<BmmModel> allModelsSet) {
        allModelsSet.forEach(this::removeBmmModel);
        return this;
    }
    public Map<String, BmmModel> getBmmModels() {
        return Collections.unmodifiableMap(bmmModels);
    }
    //=======  AllSchemas =================================================================================
    /**
     * 0..1
     * all_schemas: Hash<String,BMM_SCHEMA_DESCRIPTOR>
     * All schemas found and loaded from schema_directory. Keyed by schema_id.
     */
    private Map<String, BmmSchemaDescriptor> allSchemas;

    public void setAllSchemas(Map<String, BmmSchemaDescriptor> allSchemas) {
        this.allSchemas = allSchemas;
    }
    public Map<String, BmmSchemaDescriptor> getAllSchemas() {
        return Collections.unmodifiableMap(allSchemas);
    }

    public BmmModelAccess addSchema(BmmSchemaDescriptor schema) {
        if (allSchemas == null) {
            allSchemas = new HashMap<>();
        }
        this.allSchemas.put(schema.getSchemaId(), schema);
        return this;
    }

    public BmmModelAccess addSchemas(Set<BmmSchemaDescriptor> allSchemasSet) {
        allSchemasSet.forEach(this::addSchema);
        return this;
    }

    public BmmModelAccess removeSchema(BmmSchemaDescriptor schema) {
        if (allSchemas != null) {
            allSchemas.remove(schema.getSchemaId());
        }
        return this;
    }

    public BmmModelAccess removeSchemas(Set<BmmSchemaDescriptor> allSchemasSet) {
        allSchemasSet.forEach(this::removeSchema);
        return this;
    }


}
