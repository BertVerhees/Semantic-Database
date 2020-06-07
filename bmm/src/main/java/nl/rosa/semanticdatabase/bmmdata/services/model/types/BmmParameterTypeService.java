package nl.rosa.semanticdatabase.bmmdata.services.model.types;

import nl.rosa.semanticdatabase.bmmdata.model.types.BmmParameterType;
import nl.rosa.semanticdatabase.bmmdata.services.CrudService;
import nl.rosa.semanticdatabase.bmmdata.services.model_base_services.types.BmmUnitaryTypeService;

/**
 * Default created on 19-5-2020
 */

public interface BmmParameterTypeService extends
        CrudService<BmmParameterType, Long>, BmmUnitaryTypeService {
}
