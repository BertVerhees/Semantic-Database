package nl.rosa.semanticdatabase.bmmdata.domain.class_features;


/**
 * Class BmmOperator
 * Definition of a symbolic operator associated with a function
 */

import lombok.*;
import nl.rosa.semanticdatabase.bmmdata.domain.Bmm;

import javax.persistence.Entity;

@Getter
@EqualsAndHashCode(callSuper = true)
public class BmmOperator extends Bmm {

  /**
   * 1..1
   * position: BMM_OPERATOR_POSITION
   * Position of operator in syntactic representation.
   */
  @NonNull
  private BmmOperatorPosition position;

  public BmmOperator setPosition(BmmOperatorPosition position) {
    this.position = position;
    return this;
  }
  /**
   * 1..1
   * symbols: List<String>
   * Set of String symbols that may be used to represent this operator in a textual representation of a BMM model.
   */
  @NonNull
  private String symbols;
  public BmmOperator setSymbols(String symbols) {
    this.symbols = symbols;
    return this;
  }

  /**
   * 1..1
   * name: String
   * Formal name of the operator, e.g. 'minus' etc.
   */
  @NonNull
  private String name;

  public BmmOperator setName(String name) {
    this.name = name;
    return this;
  }
}
