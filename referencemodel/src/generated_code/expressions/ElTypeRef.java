package expressions;
import types.BmmType;


/**
 * Class ElTypeRef
 * Meta-type for reference to a non-abstract type as an object. Assumed to be
 * accessible at run-time. Typically represented syntactically as TypeName or
 * {TypeName}.
 * May be used as a value, or as the qualifier for a function or constant access.
 */
public class ElTypeRef extends ElInstanceRef {

  //
  // Fields
  //

  private types.BmmType type;
  
  //
  // Constructors
  //
  public ElTypeRef () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of type
   * @param newVar the new value of type
   */
  public void setType (types.BmmType newVar) {
    type = newVar;
  }

  /**
   * Get the value of type
   * @return the value of type
   */
  public types.BmmType getType () {
    return type;
  }

  //
  // Other methods
  //

}
