package nl.rosa.semanticdatabase.bmmdata.services.persistence_model.classes;

import nl.rosa.semanticdatabase.bmmdata.domain.classes.BmmEnumerationInteger;
import org.springframework.data.repository.CrudRepository;

/**
 * Default created on 25-5-2020
 */

public interface BmmEnumerationIntegerService extends
        CrudRepository<BmmEnumerationInteger, Long> {

}
