package class_features;
import nl.rosa.semanticdatabase.bmm.model.types.BmmType;


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
  private nl.rosa.semanticdatabase.bmm.model.types.BmmType type;
  
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
  public void setType (nl.rosa.semanticdatabase.bmm.model.types.BmmType newVar) {
    type = newVar;
  }

  /**
   * Get the value of type
   * Declared or inferred static type of the entity.
   * @return the value of type
   */
  public nl.rosa.semanticdatabase.bmm.model.types.BmmType getType () {
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
