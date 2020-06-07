package nl.rosa.semanticdatabase.bmmdata.services.model.class_features;

import nl.rosa.semanticdatabase.bmmdata.model.class_features.BmmFunction;
import nl.rosa.semanticdatabase.bmmdata.services.CrudService;
import nl.rosa.semanticdatabase.bmmdata.services.model_base_services.class_features.BmmTypedFeatureService;

/**
 * Default created on 26-5-2020
 */

public interface BmmFunctionService extends
        CrudService<BmmFunction, Long>, BmmTypedFeatureService {
}
