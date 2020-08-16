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
     * Validated models, keyed by model_id() and any shorter forms of id, with some or no versioning information.
     * For example, the keys "openEHR_EHR_1.0.4", "openEHR_EHR_1.0", "openEHR_EHR_1", and "openEHR_EHR" will all
     * match the "openEHR_EHR_1.0.4" model, assuming it is the most recent version available.
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
     * All schemas loaded. Keyed by schema_id.
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
    //============== Functions ==================================================================================================
    /**
     * 0..1
     * initialise_with_load_list ( * a_schema_dirs: List<String>[1], * a_schema_load_list: List<String>[0..1] * )
     * Initialise with a specific schema load list, usually a sub-set of schemas that will be found in a specified directories a_schema_dirs.
     */
    public void initializeWithLoadList(Set<String> aLoadList){

    }

    /**
     * 0..1
     * reload_schemas
     * Reload BMM schemas.
     */
    public void reloadSchemas(){

    }

    /**
     * 1..1
     * bmm_model ( * a_model_key: String[1] * ): BMM_MODEL
     *
     * Return model containing the model key which is a model_id or any shorter form e.g. model id minus the version.
     * If a shorter key is used, the BMM_MODEL with the most recent version will be selected.
     * Uses matching_bmm_models table to find matches if partial version information is supplied in key.
     * @param key
     * @return
     */
    public BmmModel bmmModel(String key){
        return null;
    }

    /**
     * 1..1
     * has_bmm_model ( * a_model_key: String[1] * ): Boolean
     *
     * True if a model for a model_key is available. A model key is a model_id or any shorter form e.g. model id
     * minus the version. If a shorter key is used, the Result s True if a BMM_MODEL with any version exists.
     * @param key
     * @return
     */
    public Boolean hasBmmModel(String key){
        return null;
    }
}
