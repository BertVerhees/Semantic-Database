package nl.rosa.semanticdatabase.bmmdata.domain.expressions;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import nl.rosa.semanticdatabase.bmmdata.domain.Bmm;
import nl.rosa.semanticdatabase.bmmdata.domain.classes.BmmClass;
import org.springframework.data.annotation.Transient;

import javax.persistence.*;

/**
 * Class ElAssertion
 * Optionally tagged Boolean-returning expression.
 */
public class ElAssertion extends ElBooleanExpression {

  /**
   * 0..1
   * tag: String
   * Optional tag, typically used to designate design intention of the assertion, e.g. "Inv_all_members_valid".
   */
  @Getter
  @Setter
  private String tag;
}
