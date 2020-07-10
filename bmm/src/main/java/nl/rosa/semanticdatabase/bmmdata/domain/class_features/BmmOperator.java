package nl.rosa.semanticdatabase.bmmdata.domain.class_features;


import lombok.*;
import nl.rosa.semanticdatabase.bmmdata.domain.Bmm;

import javax.persistence.Entity;
import java.util.Collection;
import java.util.Set;

/**
 * Class BmmOperator
 * Definition of a symbolic operator associated with a function
 */
@EqualsAndHashCode(callSuper = true)
@Builder
public class BmmOperator extends Bmm {

  /**
   * 1..1
   * position: BMM_OPERATOR_POSITION
   * Position of operator in syntactic representation.
   */
  @NonNull
  @Getter
  @Setter
  private BmmOperatorPosition position;
  /**
   * 1..1
   * symbols: List<String>
   * Set of String symbols that may be used to represent this operator in a textual representation of a BMM model.
   */
  @NonNull
  @Setter
  @Getter
  private Set<String> symbols;
  /**
   * 1..1
   * name: String
   * Formal name of the operator, e.g. 'minus' etc.
   */
  @NonNull
  @Getter
  @Setter
  private String name;

}
