package nl.rosa.semanticdatabase.bmmdata.domain.expressions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import nl.rosa.semanticdatabase.bmmdata.domain.types.BmmType;

import javax.persistence.Entity;


/**
 * Class ElSelfRef
 * Special meta-type used to represent a reference that may appear in any routine,
 * pre- or post-condition, or invariant, and resolves to the current object within
 * which feature references are scoped; corresponds to 'self', 'this' or 'Current'
 * in various programming languages.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class ElSelfRef extends ElInstanceRef {
  /**
   * Type of the current scoping instance, inferred from expression context.
   */
  private BmmType type;
  
  /**
   * Return type.
   * @return       nl.rosa.semanticdatabase.bmm.model.types.BmmType
   */
  public BmmType evalType()
  {
    //TODO
    return null;
  }
}
