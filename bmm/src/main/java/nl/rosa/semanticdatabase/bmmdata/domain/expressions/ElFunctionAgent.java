package nl.rosa.semanticdatabase.bmmdata.domain.expressions;

import lombok.Getter;
import lombok.Setter;
import nl.rosa.semanticdatabase.bmmdata.domain.class_features.BmmFunction;

/**
 * Class ElFunctionAgent
 * An agent whose signature is of a function, i.e. has a result type.
 */
public class ElFunctionAgent extends ElAgent {
  /**
   * 0..1
   * (redefined)
   * definition: BMM_FUNCTION
   * Reference to definition of a routine for which this is a direct call instance, if one exists.
   */
  @Getter
  @Setter
  private BmmFunction definition;
}


