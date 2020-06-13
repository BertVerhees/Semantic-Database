package nl.rosa.semanticdatabase.bmmdata.domain.expressions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import nl.rosa.semanticdatabase.bmmdata.domain.class_features.BmmFunction;

import javax.persistence.Entity;


/**
 * Class ElFunctionAgent
 * An agent whose signature is of a function, i.e. has a result type.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class ElFunctionAgent extends ElAgent {
  private BmmFunction definition;
}


