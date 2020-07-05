package nl.rosa.semanticdatabase.bmmdata.services.springdatajpa.model_access;

import nl.rosa.semanticdatabase.bmmdata.domain.model_structure.BmmModel;
import nl.rosa.semanticdatabase.bmmdata.services.model_access.BmmModelAccessService;

import java.util.Optional;
import java.util.Set;

/**
 * Default created on 5-7-2020
 */

public class BmmModelAccessSDJpaService implements BmmModelAccessService {
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
    public Optional<BmmModel> bmmModel(String aModelKey){
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

}
