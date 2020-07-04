package nl.rosa.semanticdatabase.bmmdata.model_access;

import lombok.Getter;
import lombok.Setter;
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
    @Getter
    @Setter
    private List<String> schemaDirectories = null;
    /**
     * 0..1
     * all_schemas: Hash<String,BMM_SCHEMA_DESCRIPTOR>
     * All schemas found and loaded from schema_directory. Keyed by schema_id.
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bmmdeclaration")
    @MapKey(name = "schema_id")
    private Map<String, BmmSchemaDescriptor> allSchemas;

    public void setAllSchemas(Map<String, BmmSchemaDescriptor> allSchemas) {
        this.allSchemas = allSchemas;
    }

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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bmmdeclaration")
    @MapKey(name = "model_id")
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
        allModelsSet.forEach(model -> this.addBmmModel(model));
        return this;
    }

    public BmmModelAccess removeBmmModel(BmmModel model) {
        if (bmmModels != null) {
            bmmModels.remove(model.modelId());
        }
        return this;
    }

    public BmmModelAccess removeModels(Set<BmmModel> allModelsSet) {
        allModelsSet.forEach(model -> this.removeBmmModel(model));
        return this;
    }
    public Map<String, BmmModel> getBmmModels() {
        return Collections.unmodifiableMap(bmmModels);
    }
    /**
     * 0..1
     * matching_bmm_models: Hash<String,BMM_MODEL>
     * BMM_MODELs keyed by model_id() and any shorter form used in calls to
     */

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bmmdeclaration")
    @MapKey(name = "model_id")
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
        allModelsSet.forEach(item -> this.addMatchingBmmModel(item));
        return this;
    }

    public BmmModelAccess removeMatchingBmmModel(BmmModel schema) {
        if (matchingBmmModels != null) {
            matchingBmmModels.remove(schema.modelId());
        }
        return this;
    }

    public BmmModelAccess removeMatchingBmmModels(Set<BmmModel> allModelsSet) {
        allModelsSet.forEach(ancestor -> this.removeMatchingBmmModel(ancestor));
        return this;
    }
    public Map<String, BmmModel> getMatchingBmmModels() {
        return Collections.unmodifiableMap(matchingBmmModels);
    }

    /**
     * 0..1
     * initialise_with_load_list (a_schema_load_list: List<String>[0..1])
     * Initialise with a specific schema load list, usually a sub-set of schemas
     * @param schemas
     */
    public void initializeWithLoadList(Set<String> schemas){

    }

    /**
     * 1..1
     * bmm_model (a_model_key: String[1]): BMM_MODEL
     * Return ref model containing the model key which is a model_id or any shorter form e.g. model id minus the version. If a shorter key is used, the BMM_MODEL with the highest version will be selected.
     * @param aModelKey
     * @return
     */
    public BmmModel bmmModel(String aModelKey){
        return null;
    }

    /**
     * 1..1
     * has_bmm_model (a_model_key: String[1]): Boolean
     * True if a model for a model_key is available. A model key is a model_id or any
     * shorter form e.g. model id minus the version. If a shorter key is used,
     * the Result s True if a BMM_MODEL with any version exists.
     * @param aModelKey
     * @return
     */
    public Boolean hasBmmModel(String aModelKey){
        return null;
    }

    //======== SINGLETON =========================================================
    // static variable single_instance of type Singleton
    private static BmmModelAccess single_instance = null;
    // private constructor restricted to this class itself
    private BmmModelAccess()
    {
    }

    // static method to create instance of Singleton class
    public static BmmModelAccess getInstance()
    {
        if (single_instance == null)
            single_instance = new BmmModelAccess();

        return single_instance;
    }
}
