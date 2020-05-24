package nl.rosa.semanticdatabase.bmm.class_features;


import lombok.Data;
import nl.rosa.semanticdatabase.bmm.classes.BmmClass;
import nl.rosa.semanticdatabase.bmm.expressions.ElAssertion;
import nl.rosa.semanticdatabase.bmm.routine_implementation.BmmStatementItem;
import nl.rosa.semanticdatabase.bmm.model_structure.BmmDeclaration;
import nl.rosa.semanticdatabase.bmm.types.BmmSignature;

import java.util.List;
import java.util.Map;

/**
 * Class BmmProcedure
 * A formal element with signature of the form: name ({arg:TArg}*). A procedure is
 * a computed (rather than data) element, generally assumed to be state-changing.
 */
@Data
public class BmmProcedure implements BmmRoutine {

  //
  // Fields
  //

  // BmmDeclaration
  private String name;
  private Map<String,Object> documentation;
  private Map<String,Object> extensions;

  // BmmClassEntity
  private boolean isSynthesisedGeneric;

  /**
   * Formal parameters of the routine.
   */
  private List<BmmParameter> parameters;
  /**
   * Local variables of the routine.
   */
  private List<BmmLocal> locals;
  private List<ElAssertion> preConditions;
  private List<ElAssertion> postCondtions;
  /**
   * Body of a routine, i.e. executable program.
   */
  private BmmStatementItem body;


  //BmmClassScoped
  /**
   * Visibility of this item to client entities.
   * TODO: define scheme; probably need to support C++/Java scheme as well as better type-based schemes.   */

  private Object visibility;
  private BmmClass scope;



  //
  // Constructors
  //
  public BmmProcedure () { };

  /**
   * Return number of arguments of this routine.
   * @return
   */
  @Override
  public Integer arity() {
    //TODO
    return null;
  }

  /**
   * Formal signature of this element, in the form
   *
   * '[arg1_name: T_arg1, …​]:T_value'.
   * @return
   */
  @Override
  public BmmSignature signature() {
    //TODO
    return null;
  }

  @Override
  @Deprecated
  public void setScope(BmmDeclaration newVar) {
    this.scope = (BmmClass) newVar;
  }

  @Override
  public void setScope(BmmClass newVar) {
    this.scope = newVar;
  }

  /**
   * True if this declaration entity is the root of the declaration hierarchy.
   * @return
   */
  @Override
  public boolean isRootScope() {
    return false;
  }


}
