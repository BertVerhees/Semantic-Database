package nl.rosa.semanticdatabase.bmmdata.services.model.classes;

import nl.rosa.semanticdatabase.bmmdata.model.classes.BmmEnumerationString;
import org.springframework.data.repository.CrudRepository;

/**
 * Default created on 25-5-2020
 */

public interface BmmEnumerationStringService  extends
        CrudRepository<BmmEnumerationString, Long> {
}
