package nl.rosa.semanticdatabase.bmmdata.domain.expressions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import nl.rosa.semanticdatabase.bmmdata.domain.class_features.BmmProcedure;

import javax.persistence.Entity;


/**
 * Class ElProcedureAgent
 * An agent whose signature is of a procedure, i.e. has no result type.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class ElProcedureAgent extends ElAgent {
  private BmmProcedure definition;
}
