package nl.rosa.semanticdatabase.bmmdata.services.model_access.data;

import nl.rosa.semanticdatabase.bmmdata.domain.model_structure.BmmModel;
import org.springframework.stereotype.Component;

import java.util.*;

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

    public BmmModelAccess setMatchingBmmModels(Map<String, BmmModel> bmmModels) {
        this.matchingBmmModels = bmmModels;
        return this;
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
    public Optional<Map<String, BmmModel>> getMatchingBmmModels() {
        if(matchingBmmModels!=null){
            return Optional.of(Collections.unmodifiableMap(matchingBmmModels));
        }else{
            return Optional.empty();
        }
    }

    //====== bmmModels =========================================================================
    /**
     * 0..1
     * bmm_models: Hash<String,BMM_MODEL>
     * Top-level (root) schemas in use. Table is keyed by model_id.
     */
    private Map<String, BmmModel> bmmModels;

    public BmmModelAccess setBmmModels(Map<String, BmmModel> bmmModels) {
        this.bmmModels = bmmModels;
        return this;
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
    public Optional<Map<String, BmmModel>> getBmmModels() {
        if(bmmModels!=null){
            return Optional.of(Collections.unmodifiableMap(bmmModels));
        }else{
            return Optional.empty();
        }
    }
    //=======  AllSchemas =================================================================================
    /**
     * 0..1
     * all_schemas: Hash<String,BMM_SCHEMA_DESCRIPTOR>
     * All schemas found and loaded from schema_directory. Keyed by schema_id.
     */
    private Map<String, BmmSchemaDescriptor> allSchemas;

    public BmmModelAccess setAllSchemas(Map<String, BmmSchemaDescriptor> allSchemas) {
        this.allSchemas = allSchemas;
        return this;
    }
    public Optional<Map<String, BmmSchemaDescriptor>> getAllSchemas() {
        if(bmmModels!=null){
            return Optional.of(Collections.unmodifiableMap(allSchemas));
        }else{
            return Optional.empty();
        }
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
