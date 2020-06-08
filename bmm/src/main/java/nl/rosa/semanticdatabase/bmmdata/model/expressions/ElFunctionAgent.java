package nl.rosa.semanticdatabase.bmmdata.model.expressions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import nl.rosa.semanticdatabase.bmmdata.model.class_features.BmmFunction;


/**
 * Class ElFunctionAgent
 * An agent whose signature is of a function, i.e. has a result type.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ElFunctionAgent extends ElAgent {
  private BmmFunction definition;
}


