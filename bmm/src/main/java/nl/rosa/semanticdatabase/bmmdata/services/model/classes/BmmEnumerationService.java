package nl.rosa.semanticdatabase.bmmdata.services.model.classes;

import nl.rosa.semanticdatabase.bmmdata.domain.classes.BmmEnumeration;
import org.springframework.data.repository.CrudRepository;

/**
 * Default created on 25-5-2020
 */

public interface BmmEnumerationService  extends
        CrudRepository<BmmEnumeration, Long> {
}
