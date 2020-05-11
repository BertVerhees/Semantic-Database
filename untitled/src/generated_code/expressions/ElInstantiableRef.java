package expressions;
import types.BmmType;


/**
 * Class ElInstantiableRef
 * Terminal item corresponding to a reference to a directly instantiable entity,
 * i.e. a variable, constant, or property.
 */
public class ElInstantiableRef extends ElScopedRef {

  //
  // Fields
  //

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
   * @return       types.BmmType
   */
  public types.BmmType evalType()
  {
  }


}
