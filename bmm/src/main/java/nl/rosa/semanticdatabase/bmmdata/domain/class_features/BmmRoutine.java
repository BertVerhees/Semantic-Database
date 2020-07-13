package nl.rosa.semanticdatabase.bmmdata.domain.class_features;

import lombok.*;
import nl.rosa.semanticdatabase.bmmdata.domain.expressions.ElAssertion;
import nl.rosa.semanticdatabase.bmmdata.domain.statements.BmmStatementItem;
import nl.rosa.semanticdatabase.bmmdata.domain.types.BmmSignature;

import java.util.*;


/**
 * Class BmmRoutine
 * A feature defining a routine, scoped to a class.
 */
public abstract class BmmRoutine extends BmmClassScoped {

  /**
   * 0..1
   * parameters: List<BMM_PARAMETER>
   * Formal parameters of the routine.
   */
  private Set<BmmParameter> parameters;
  public void addParameter(@NonNull BmmParameter value){
    if(parameters==null){
      parameters = new HashSet<>();
    }
    parameters.add(value);
  }
  public void addParameters(Set<BmmParameter> items){
    items.forEach(item -> addParameter(item));

  }
  public void removeParameter(BmmParameter item){
    if(parameters!=null) {
      parameters.remove(item);
    }
  }
  public void removeParameters(Collection<BmmParameter> items){
    items.forEach(this::removeParameter);
  }
  void setParameters(Set<BmmParameter> items) {
    this.parameters = items;
  }
  Set<BmmParameter> getParameters() {
    return parameters;
  }
  public Set<BmmParameter> parameters() {
    return Collections.unmodifiableSet(parameters);
  }

  public void removeParameters(Set<BmmParameter> items) {
    this.parameters.removeAll(items);
  }

  /**
   * 0..1
   * locals: List<BMM_LOCAL>
   * Local variables of the routine.
   */
  private Set<BmmLocal> locals;
  public void addLocal(@NonNull BmmLocal value){
    if(locals==null){
      locals = new HashSet<>();
    }
    locals.add(value);
  }
  public void addLocals(Set<BmmLocal> items){
    items.forEach(item -> addLocal(item));

  }
  public void removeLocal(BmmLocal item){
    if(locals!=null) {
      locals.remove(item);
    }
  }
  public void removeLocals(Collection<BmmLocal> items){
    items.forEach(this::removeLocal);
  }
  void setLocals(Set<BmmLocal> items) {
    this.locals = items;
  }
  Set<BmmLocal> getLocals() {
    return locals;
  }
  public Set<BmmLocal> locals() {
    return Collections.unmodifiableSet(locals);
  }

  public void removeLocals(Set<BmmLocal> items) {
    this.locals.removeAll(items);
  }

  /**
   * 0..1
   * pre_conditions: List<EL_ASSERTION>
   */
  private Set<ElAssertion> preConditions;
  public void addPreCondition(@NonNull ElAssertion value){
    if(preConditions==null){
      preConditions = new HashSet<>();
    }
    preConditions.add(value);
  }
  public void addPreConditions(Set<ElAssertion> items){
    items.forEach(item -> addPreCondition(item));

  }
  public void removePreCondition(ElAssertion item){
    if(preConditions!=null) {
      preConditions.remove(item);
    }
  }
  public void removePreConditions(Collection<ElAssertion> items){
    items.forEach(this::removePreCondition);
  }
  void setPreConditions(Set<ElAssertion> items) {
    this.preConditions = items;
  }
  Set<ElAssertion> getPreConditions() {
    return preConditions;
  }
  public Set<ElAssertion> preConditions() {
    return Collections.unmodifiableSet(preConditions);
  }

  public void removePreConditions(Set<ElAssertion> items) {
    this.preConditions.removeAll(items);
  }

  /**
   * 0..1
   * post_conditions: List<EL_ASSERTION>
   */
  private Set<ElAssertion> postConditions;
  public void addPostCondition(@NonNull ElAssertion value){
    if(postConditions==null){
      postConditions = new HashSet<>();
    }
    postConditions.add(value);
  }
  public void addPostConditions(Set<ElAssertion> items){
    items.forEach(item -> addPostCondition(item));

  }
  public void removePostCondition(ElAssertion item){
    if(postConditions!=null) {
      postConditions.remove(item);
    }
  }
  public void removePostConditions(Collection<ElAssertion> items){
    items.forEach(this::removePostCondition);
  }
  void setPostConditions(Set<ElAssertion> items) {
    this.postConditions = items;
  }
  Set<ElAssertion> getPostConditions() {
    return postConditions;
  }
  public Set<ElAssertion> postConditions() {
    return Collections.unmodifiableSet(postConditions);
  }

  public void removePostConditions(Set<ElAssertion> items) {
    this.postConditions.removeAll(items);
  }

  /**
   * 0..1
   * body: BMM_STATEMENT_ITEM
   * Body of a routine, i.e. executable program.
   */
  @Getter
  @Setter
  private BmmStatementItem body;
  // Functions

  /**
   * 1..1
   * arity (): Integer
   * Return number of arguments of this routine.
   * @return
   */
  @NonNull
  public Integer arity() {
    return null;
  }

  /**
   * 1..1
   * (effected)
   * signature ()
   * Formal signature of this element, in the form
   * '[arg1_name: T_arg1, …​]:T_value'.
   * @return
   */
  @NonNull
  public BmmSignature signature(){
    return null;
  }
}
