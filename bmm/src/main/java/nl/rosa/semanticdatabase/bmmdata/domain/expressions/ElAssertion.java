package nl.rosa.semanticdatabase.bmmdata.domain.expressions;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import nl.rosa.semanticdatabase.bmmdata.domain.Bmm;
import nl.rosa.semanticdatabase.bmmdata.domain.classes.BmmClass;
import org.springframework.data.annotation.Transient;

import javax.persistence.*;

/**
 * Class ElAssertion
 * Optionally tagged Boolean-returning expression.
 */
@EqualsAndHashCode(callSuper = true)
@Getter
public class ElAssertion extends Bmm {

  /**
   * Optional tag, typically used to designate design intention of the assertion, e.g. "Inv_all_members_valid".
   */
  private String tag;

  public ElAssertion setTag(String tag) {
    this.tag = tag;
    return this;
  }

  /**
   * The expression of this assertion.
   */
  private ElExpression expression;

  public ElAssertion setExpression(ElExpression expression) {
    this.expression = expression;
    return this;
  }
  //=============  counterparts =========================================================
  //TODO
  @Transient
  private String bmmClassName;

  public ElAssertion setBmmClass(String bmmClassName) {
    this.bmmClassName = bmmClassName;
    return this;
  }

}
