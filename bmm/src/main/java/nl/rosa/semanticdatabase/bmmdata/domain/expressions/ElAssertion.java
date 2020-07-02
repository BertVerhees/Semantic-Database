package nl.rosa.semanticdatabase.bmmdata.domain.expressions;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import nl.rosa.semanticdatabase.bmmdata.domain.BmmBaseEntity;
import nl.rosa.semanticdatabase.bmmdata.domain.classes.BmmClass;

import javax.persistence.*;

/**
 * Class ElAssertion
 * Optionally tagged Boolean-returning expression.
 */
@EqualsAndHashCode(callSuper = true)
@Entity
public class ElAssertion extends BmmBaseEntity {

  /**
   * Optional tag, typically used to designate design intention of the assertion, e.g. "Inv_all_members_valid".
   */
  @Getter
  @Column(name = "tag")
  private String tag;

  public ElAssertion setTag(String tag) {
    this.tag = tag;
    return this;
  }

  /**
   * The expression of this assertion.
   */
  @Getter
  @Column(name = "expression")
  private ElExpression expression;

  public ElAssertion setExpression(ElExpression expression) {
    this.expression = expression;
    return this;
  }

  //=============  counterparts =========================================================
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "fk_bmm_class_id")
  @Getter
  private BmmClass bmmClass;

  public ElAssertion setBmmClass(BmmClass bmmClass) {
    this.bmmClass = bmmClass;
    return this;
  }

}
