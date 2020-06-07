package nl.rosa.semanticdatabase.bmmdata.services.model.routine_implementation;

import nl.rosa.semanticdatabase.bmmdata.model.routine_implementation.BmmStatementBlock;
import nl.rosa.semanticdatabase.bmmdata.services.CrudService;
import nl.rosa.semanticdatabase.bmmdata.services.model_base_services.routine_implementation.BmmStatementItemService;

/**
 * Default created on 24-5-2020
 */

public interface BmmStatementBlockService extends
        CrudService<BmmStatementBlock, Long>, BmmStatementItemService {
}
