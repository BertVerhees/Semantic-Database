package nl.rosa.semanticdatabase.bmmdata.services.springdatajpa.model_access;

import lombok.NonNull;
import nl.rosa.semanticdatabase.bmmdata.domain.model_structure.BmmModel;
import nl.rosa.semanticdatabase.bmmdata.services.model_access.BmmModelAccessService;
import nl.rosa.semanticdatabase.utils.json.JSONUtils;

import javax.validation.constraints.NotEmpty;
import java.util.Optional;


/**
 * Default created on 5-7-2020
 */

public class BmmModelAccessSDJpaService implements BmmModelAccessService {
    Optional<BmmModel> model = Optional.empty();
    /**
     * 0..1
     * {"classDefinitions":{},"usedModels":[],"packages":{},"documentation":{},"extensions":{}}
     * {"classDefinitions":{},"usedModels":[],"rmPublisher":"publisher","rmRelease":"1.2.3","packages":{},"name":"test","documentation":{},"extensions":{}}
     * {"classDefinitions":{},"usedModels":[{"classDefinitions":{},"rmPublisher":"publisher2","rmRelease":"1.2.32","packages":{},"name":"test2","documentation":{},"extensions":{}}],
     * "rmPublisher":"publisher","rmRelease":"1.2.3","packages":{},"name":"test","documentation":{},"extensions":{}}
     * @param schema
     */
    public void initialize(@NonNull String schema){
        if ( JSONUtils.isJSONValid(schema, BmmModel.class)){
            model = Optional.of((BmmModel) JSONUtils.fromJSON(schema, BmmModel.class));
        }else{
            throw new RuntimeException("Invalid BmmModel in schema.");
        }
    }

    /**
     * 1..1
     * bmm_model (a_model_key: String[1]): BMM_MODEL
     * Return ref model containing the model key which is a model_id or any shorter form e.g. model id minus the version. If a shorter key is used, the BMM_MODEL with the highest version will be selected.
     * @param aModelKey
     * @return
     */
    public Optional<BmmModel> bmmModel(@NotEmpty String aModelKey){
        BmmModel bmmModel = model.orElseThrow(() -> new RuntimeException("BmmModelAccessService is not initialized"));
        if(bmmModel.modelId().equals(aModelKey)){
            return Optional.of(bmmModel);
        }else{
            if(bmmModel.usedModels().isPresent()){
                return bmmModel.usedModels().get().stream().filter(model -> model.modelId().equals(aModelKey)).findFirst();
            }
        }
        return Optional.empty();
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
        BmmModel bmmModel = model.orElseThrow(() -> new RuntimeException("BmmModelAccessService is not initialized"));
        if(bmmModel.modelId().equals(aModelKey)){
            return true;
        }else{
            if(bmmModel.usedModels().isPresent()){
                return bmmModel.usedModels().get().stream().filter(model -> model.modelId().equals(aModelKey)).findFirst().isPresent();
            }
        }
        return false;
    }

}
