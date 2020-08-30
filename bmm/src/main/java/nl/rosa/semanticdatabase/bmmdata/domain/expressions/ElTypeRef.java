package nl.rosa.semanticdatabase.bmmdata.domain.expressions;

import lombok.*;
import nl.rosa.semanticdatabase.bmmdata.domain.types.BmmType;

import javax.persistence.Entity;


/**
 * Class ElTypeRef
 * Meta-type for reference to a non-abstract type as an object. Assumed to be
 * accessible at run-time. Typically represented syntactically as TypeName or
 * {TypeName}.
 * May be used as a value, or as the qualifier for a function or constant access.
 */
public class ElTypeRef extends ElInstanceRef  {
  /**
   * 1..1
   * Type, directly from the name of the reference, e.g. {SOME_TYPE}.
   * type: BMM_TYPE
   */
  @NonNull
  @Getter
  @Setter
  private BmmType type;

  /**
   * 1..1
   * (effected)
   * eval_type (): BMM_TYPE
   * Return type.
   * @return
   */
  @Override
  public BmmType evalType() {
    return null;
  }
}
