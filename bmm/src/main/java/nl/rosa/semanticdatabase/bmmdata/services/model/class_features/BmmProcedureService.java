package nl.rosa.semanticdatabase.bmmdata.services.model.class_features;

import nl.rosa.semanticdatabase.bmmdata.model.class_features.BmmProcedure;
import nl.rosa.semanticdatabase.bmmdata.services.CrudService;
import nl.rosa.semanticdatabase.bmmdata.services.model_base_services.class_features.BmmRoutineService;

/**
 * Default created on 26-5-2020
 */

public interface BmmProcedureService extends
        CrudService<BmmProcedure, Long>, BmmRoutineService {
}
