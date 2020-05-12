package nl.rosa.semanticdatabase.referencemodel.bmm.expressions;

import lombok.Data;
import nl.rosa.semanticdatabase.referencemodel.bmm.class_features.BmmProcedure;
import nl.rosa.semanticdatabase.referencemodel.bmm.class_features.BmmRoutine;
import nl.rosa.semanticdatabase.referencemodel.bmm.types.BmmSignature;

import java.util.List;


/**
 * Class ElProcedureAgent
 * An agent whose signature is of a procedure, i.e. has no result type.
 */
@Data
public class ElProcedureAgent implements ElAgent {

  //
  // Fields
  //

  // ElScopedRef
  /**
   * Reference to an owning object for this terminal element, if it is not the current scope.
   */
  private ElInstanceRef scope;


  // ElAgent
  /**
   * Name of the routine being called.
   */
  private String name;
  /**
   * Closed arguments of a routine call as a tuple of objects.
   */
  private ElTuple closedArgs;
  /**
   * Optional list of names of open arguments of the call. If not provided, and the name refers to a routine with more arguments than supplied in closed_args, the missing arguments are inferred from the definition.
   */
  private List<String> openArgs;
  /**
   * Reference to definition of routine for which this is a call instance.
   */
  private BmmProcedure definition;
  
  //
  // Constructors
  //
  public ElProcedureAgent () { };

  @Override
  @Deprecated
  public void setDefinition(BmmRoutine newVar) {
    this.definition = (BmmProcedure) newVar;
  }

  @Override
  public BmmSignature evalType() {
    //TODO
    return null;
  }

  @Override
  public boolean isBoolean() {
    //TODO
    return false;
  }

  @Override
  public boolean isCallable() {
    //TODO
    return false;
  }
}
