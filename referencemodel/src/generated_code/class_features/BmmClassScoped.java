package class_features;
import classes.BmmClass;


/**
 * Class BmmClassScoped
 * A class entity having a signature and a class as its scope.
 */
abstract public class BmmClassScoped extends BmmClassEntity {

  //
  // Fields
  //
  /**

   * Visibility of this item to client entities.
   * TODO: define scheme; probably need to support C++/Java scheme as well as better type-based schemes.   */

  private Object visibility;
  private classes.BmmClass scope;
  
  //
  // Constructors
  //
  public BmmClassScoped () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of visibility
   * Visibility of this item to client entities.
   * TODO: define scheme; probably need to support C++/Java scheme as well as better
   * type-based schemes.
   * @param newVar the new value of visibility
   */
  public void setVisibility (Object newVar) {
    visibility = newVar;
  }

  /**
   * Get the value of visibility
   * Visibility of this item to client entities.
   * TODO: define scheme; probably need to support C++/Java scheme as well as better
   * type-based schemes.
   * @return the value of visibility
   */
  public Object getVisibility () {
    return visibility;
  }

  /**
   * Set the value of scope
   * @param newVar the new value of scope
   */
  public void setScope (classes.BmmClass newVar) {
    scope = newVar;
  }

  /**
   * Get the value of scope
   * @return the value of scope
   */
  public classes.BmmClass getScope () {
    return scope;
  }

  //
  // Other methods
  //

}
