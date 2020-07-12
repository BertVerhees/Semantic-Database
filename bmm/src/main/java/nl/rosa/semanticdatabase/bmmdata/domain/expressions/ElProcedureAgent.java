package nl.rosa.semanticdatabase.bmmdata.domain.expressions;

import lombok.*;
import nl.rosa.semanticdatabase.bmmdata.domain.class_features.BmmProcedure;

import javax.persistence.Entity;


/**
 * Class ElProcedureAgent
 * An agent whose signature is of a procedure, i.e. has no result type.
 */
public class ElProcedureAgent extends ElAgent {
  /**
   * 0..1
   * (redefined)
   * definition: BMM_PROCEDURE
   * Reference to definition of routine for which this is a call instance.
   */
  @NonNull
  @Getter
  @Setter
  private BmmProcedure definition;
}
