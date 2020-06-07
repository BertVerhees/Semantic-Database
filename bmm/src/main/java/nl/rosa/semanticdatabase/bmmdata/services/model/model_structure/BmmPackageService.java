package nl.rosa.semanticdatabase.bmmdata.services.model.model_structure;

import nl.rosa.semanticdatabase.bmmdata.model.model_structure.BmmPackage;
import nl.rosa.semanticdatabase.bmmdata.services.CrudService;
import nl.rosa.semanticdatabase.bmmdata.services.model_base_services.model_structure.BmmPackageContainerService;

/**
 * Default created on 17-5-2020
 */

public interface BmmPackageService extends
        CrudService<BmmPackage, Long>, BmmPackageContainerService {
}
