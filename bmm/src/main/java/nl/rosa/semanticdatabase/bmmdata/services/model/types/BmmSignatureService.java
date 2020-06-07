package nl.rosa.semanticdatabase.bmmdata.services.model.types;

import nl.rosa.semanticdatabase.bmmdata.model.types.BmmSignature;
import nl.rosa.semanticdatabase.bmmdata.services.CrudService;
import nl.rosa.semanticdatabase.bmmdata.services.model_base_services.types.BmmEffectiveTypeService;

/**
 * Default created on 19-5-2020
 */

public interface BmmSignatureService extends
        CrudService<BmmSignature, Long>, BmmEffectiveTypeService {
}
