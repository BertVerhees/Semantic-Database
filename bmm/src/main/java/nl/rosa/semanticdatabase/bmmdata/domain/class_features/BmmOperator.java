package nl.rosa.semanticdatabase.bmmdata.domain.class_features;


/**
 * Class BmmOperator
 * Definition of a symbolic operator associated with a function
 */

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import nl.rosa.semanticdatabase.bmmdata.domain.BmmBaseEntity;

import javax.persistence.Entity;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
public class BmmOperator extends BmmBaseEntity {

  /**
   * 1..1
   * position: BMM_OPERATOR_POSITION
   * Position of operator in syntactic representation.
   */
  @NonNull
  private BmmOperatorPosition position;
  /**
   * 1..1
   * symbols: List<String>
   * Set of String symbols that may be used to represent this operator in a textual representation of a BMM model.
   */
  @NonNull
  private String symbols;
  /**
   * 1..1
   * name: String
   * Formal name of the operator, e.g. 'minus' etc.
   */
  @NonNull
  private String name;
}
