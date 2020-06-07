package nl.rosa.semanticdatabase.bmmdata.services.model.class_features;

import nl.rosa.semanticdatabase.bmmdata.model.class_features.BmmParameter;
import nl.rosa.semanticdatabase.bmmdata.services.CrudService;
import nl.rosa.semanticdatabase.bmmdata.services.model_base_services.class_features.BmmVariableService;

/**
 * Default created on 26-5-2020
 */

public interface BmmParameterService extends
        CrudService<BmmParameter, Long>, BmmVariableService {

}
