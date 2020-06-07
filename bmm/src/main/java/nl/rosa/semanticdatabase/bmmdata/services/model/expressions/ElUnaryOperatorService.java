package nl.rosa.semanticdatabase.bmmdata.services.model.expressions;

import nl.rosa.semanticdatabase.bmmdata.model.expressions.ElUnaryOperator;
import nl.rosa.semanticdatabase.bmmdata.services.model_base_services.expressions.ElOperatorService;
import org.springframework.data.repository.CrudRepository;

/**
 * Default created on 24-5-2020
 */

public interface ElUnaryOperatorService extends
        CrudRepository<ElUnaryOperator, Long>, ElOperatorService {
}
