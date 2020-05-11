package nl.rosa.semanticdatabase.referencemodel.model_access;

import lombok.Getter;
import lombok.Setter;
import nl.rosa.semanticdatabase.referencemodel.bmm.base.BmmDefinitions;
import nl.rosa.semanticdatabase.referencemodel.model_structure.BmmModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Default created on 5-5-2020
 *
 * Access to BMM models that have been loaded and validated from one or more schema sets.
 * Inherit
 * BMM_DEFINITIONS
 */

@Getter
@Setter
public class BmmModelAccess extends BmmDefinitions {
    /**
     * List of directories where all the schemas loaded here are found.
     */
    private List<String> schemaDirectories = new ArrayList<>();
    /**
     * All schemas found and loaded from schema_directory. Keyed by schema_id.
     */
    private Map<String, BmmSchemaDescriptor> allSchemas = new HashMap<>();
    /**
     * Top-level (root) schemas in use. Table is keyed by model_id.
     */
    private Map<String, BmmModel> bmmModels = new HashMap<>();
    /**
     * BMM_MODELs keyed by model_id() and any shorter form used in calls to
     */
    private Map<String, BmmModel> matchingBmmModels = new HashMap<>();

    /**
     * Initialise with a specific schema load list, usually a sub-set of schemas that will be found in a specified directories a_schema_dirs.
     * @param schemaDirs
     * @param schemaLoadList
     */
    public void initialiseWithLoadList(List<String> schemaDirs, List<String> schemaLoadList){
        if(schemaDirs==null || schemaDirs.isEmpty()){
            throw new RuntimeException("Parameter schemadirs should not be null or empty in function: initialiseWithLoadList");
        }

    }

    /**
     * Load all schemas found in a specified directories a_schema_dirs.
     * @param schemaDirs
     */
    public void initialiseAll(List<String> schemaDirs){
        if(schemaDirs==null || schemaDirs.isEmpty()){
            throw new RuntimeException("Parameter schemadirs should not be null or empty in function: initialiseAll");
        }
    }

    /**
     * Reload BMM schemas.
     */
    public void reloadSchemas(){

    }

    /**
     * Return ref model containing the model key which is a model_id or any shorter form e.g. model id minus the version.
     * If a shorter key is used, the BMM_MODEL with the highest version will be selected.
     * @param modelKey
     * @return
     */
    public BmmModel bmmModel(String modelKey){
        if(modelKey==null || modelKey.isEmpty()){
            throw new RuntimeException("Parameter modelKey should not be null or empty in function: bmmModel");
        }
        String mKlc = modelKey.toLowerCase();
        if(bmmModels.containsKey(mKlc)){
            return bmmModels.get(mKlc);
        }
        List<String> sortedKeys = new ArrayList<>();
        sortedKeys.addAll(bmmModels.keySet()
                .stream()
                .sorted()
                .filter(key -> key.startsWith(mKlc.substring(0,mKlc.lastIndexOf('_'))))
                .collect(Collectors.toList()));
        if(sortedKeys.size()>0){
            return bmmModels.get(sortedKeys.get(0));
        }
        return null;
    }

    /**
     * True if a model for a model_key is available. A model key is a model_id or any shorter form e.g. model id minus the version.
     * If a shorter key is used, the Result s True if a BMM_MODEL with any version exists.
     * @param modelKey
     * @return
     */
    public boolean hasBmmModel(String modelKey){
        if(modelKey==null || modelKey.isEmpty()){
            throw new RuntimeException("Parameter modelKey should not be null or empty in function: hasBmmModel");
        }
        return bmmModel(modelKey) != null;
    }
}
