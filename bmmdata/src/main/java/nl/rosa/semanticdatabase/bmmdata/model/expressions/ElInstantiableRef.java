package nl.rosa.semanticdatabase.bmmdata.model.expressions;

import lombok.Data;
import nl.rosa.semanticdatabase.bmmdata.model.BmmBaseEntity;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmType;

import javax.validation.constraints.NotNull;


/**
 * Class ElInstantiableRef
 * Terminal item corresponding to a reference to a directly instantiable entity,
 * i.e. a variable, constant, or property.
 */
@Data
public class ElInstantiableRef<T> extends BmmBaseEntity implements ElScopedRef {
/**
 *  ElScopedRef
 *    ElInstanceRef
 *      ElTerminal
 *        ElExpression
 */
  /**
   * ElInstanceRef
   */
  /**
   * ElExpression
   */
  @NotNull
  public BmmType evalType(){
    return null;
  }
  @NotNull
  public Boolean isBoolean(){
    return null;
  }
  /**
   * ElScopedRef
   */
  private ElInstanceRef scope;
  /**
   * ElTerminal
   */
  /**
   * ElExpression
   */
  @NotNull
  public BmmType evalType(){
    return null;
  }
  @NotNull
  public Boolean isBoolean(){
    return null;
  }
//======================================================================================
  // BmmElScopedRef
  /**
   * Reference to an owning object for this terminal element, if it is not the current scope.
   */
  private ElInstanceRef scope;


  /**
   * Definition of the constant, property or variable, inferred by inspection of the current scoping instance.
   */
  private T definition;
  
  //
  // Constructors
  //
  public ElInstantiableRef () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of definition
   * Definition of the constant, property or variable, inferred by inspection of the
   * current scoping instance.
   * @param newVar the new value of definition
   */
  public void setDefinition (T newVar) {
    definition = newVar;
  }

  /**
   * Get the value of definition
   * Definition of the constant, property or variable, inferred by inspection of the
   * current scoping instance.
   * @return the value of definition
   */
  public T getDefinition () {
    return definition;
  }

  //
  // Other methods
  //

  /**
   * Type definition (i.e. BMM meta-type definition object) of the constant, property
   * or variable, inferred by inspection of the current scoping instance. Return
   * definition.type.
   * @return       nl.rosa.semanticdatabase.bmm.model.types.BmmType
   */
  public BmmType evalType()
  {
    //TODO
    return null;
  }

  @Override
  public Boolean isBoolean() {
    //TODO
    return false;
  }


}
