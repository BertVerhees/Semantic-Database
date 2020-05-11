package class_features;
import types.BmmType;


/**
 * Class BmmTyped
 * Any entity that has a declared or inferred static type, and that can therefore
 * be generate a value.
 */
abstract public class BmmTyped extends BmmType {

  //
  // Fields
  //

  /**
   * Declared or inferred static type of the entity.
   */
  private types.BmmType type;
  
  //
  // Constructors
  //
  public BmmTyped () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of type
   * Declared or inferred static type of the entity.
   * @param newVar the new value of type
   */
  public void setType (types.BmmType newVar) {
    type = newVar;
  }

  /**
   * Get the value of type
   * Declared or inferred static type of the entity.
   * @return the value of type
   */
  public types.BmmType getType () {
    return type;
  }

  //
  // Other methods
  //

  /**
   * True if type is notionally Boolean (i.e. a BMM_SIMPLE_TYPE with type_name() =
   * 'Boolean').
   * @return       boolean
   */
  public boolean isBoolean()
  {
  }


}
