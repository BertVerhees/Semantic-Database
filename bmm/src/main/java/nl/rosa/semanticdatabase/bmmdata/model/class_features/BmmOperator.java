package nl.rosa.semanticdatabase.bmmdata.model.class_features;


/**
 * Class BmmOperator
 * Definition of a symbolic operator associated with a function
 */

import lombok.Data;
import lombok.EqualsAndHashCode;
import nl.rosa.semanticdatabase.bmmdata.model.BmmBaseEntity;

@Data
@EqualsAndHashCode(callSuper = true)
public class BmmOperator extends BmmBaseEntity {

  /**
   * Position of operator in syntactic representation.
   */
  private BmmOperatorPosition position;
  /**
   * Set of String symbols that may be used to represent this operator in a textual representation of a BMM model.
   */
  private String symbols;
  /**
   * Formal name of the operator, e.g. 'minus' etc.
   */
  private String name;
}
