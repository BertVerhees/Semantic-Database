package nl.rosa.semanticdatabase.bmmdata.domain.expressions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import nl.rosa.semanticdatabase.bmmdata.domain.types.BmmType;

import javax.persistence.Entity;


/**
 * Class ElTypeRef
 * Meta-type for reference to a non-abstract type as an object. Assumed to be
 * accessible at run-time. Typically represented syntactically as TypeName or
 * {TypeName}.
 * May be used as a value, or as the qualifier for a function or constant access.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class ElTypeRef extends ElInstanceRef  {
  /**
   * 1..1
   * type: BMM_TYPE
   */
  private BmmType type;

  @Override
  public BmmType evalType() {
    return null;
  }
}
