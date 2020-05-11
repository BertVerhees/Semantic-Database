package nl.rosa.semanticdatabase.referencemodel.bmm.class_features;


import lombok.Data;
import nl.rosa.semanticdatabase.referencemodel.bmm.classes.BmmClass;
import nl.rosa.semanticdatabase.referencemodel.bmm.expressions.ElAssertion;
import nl.rosa.semanticdatabase.referencemodel.bmm.functional_elements.BmmStatementItem;
import nl.rosa.semanticdatabase.referencemodel.bmm.model_structure.BmmDeclaration;
import nl.rosa.semanticdatabase.referencemodel.bmm.types.BmmSignature;

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
  /**
   * True if this declaration entity is the root of the declaration hierarchy.
   * @return
   */
  @Override
  public boolean isRootScope() {
    return false;
  }


}
