package nl.rosa.semanticdatabase.bmmdata.services.model_access;

import nl.rosa.semanticdatabase.bmmdata.domain.model_structure.BmmModel;

import java.util.Optional;
import java.util.Set;

/**
 * Default created on 5-6-2020
 */

public interface BmmModelAccessService {
    /**
     * Loads data from Source and creates all Objects
     * @param schemas
     */
    void initializeWithLoadList(Set<String> schemas);

    /**
     * 1..1
     * bmm_model ( a_model_key: String[1] ): BMM_MODEL
     *
     * Return ref model containing the model key which is a model_id or any shorter form
     * e.g. model id minus the version.
     * If a shorter key is used, the BMM_MODEL with the highest version will be selected.
     * @param aModelKey
     * @return
     */
    Optional<BmmModel> bmmModel(String aModelKey);

}
