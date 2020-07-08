package nl.rosa.semanticdatabase.bmmdata.domain.classes;


import lombok.NonNull;
import nl.rosa.semanticdatabase.bmmdata.domain.Bmm;

import javax.persistence.Entity;

/**
 * Class BmmValueSpec
 * Definition of a range-constrained class whose value range is defined by
 * reference to a 'value set' within an external resource, e.g. a reference data
 * service.
 */
@Entity
public class BmmValueSetSpec extends Bmm {
  /**
   * 1..1
   * resource_id: String
   * Identifier of a resource (typically available as a service) that contains legal values of a specific type.
   * This is typically a URI but need not be.
   */
  @NonNull
  private String resourceId;
  /**
   * 1..1
   * value_set_id: String
   * Identifier of a value set within the resource identified by resource_id, which specifies the set of legal
   * values of a type. This might be a URI, but need not be.
   */
  @NonNull
  private String valueSetId;
}
