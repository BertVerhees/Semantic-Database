package class_features;
import nl.rosa.semanticdatabase.bmm.model.types.BmmUnitaryType;


/**
 * Class BmmUnitaryProperty
 * Meta-type of for properties of unitary type.
 */
public class BmmUnitaryProperty extends BmmProperty {

  //
  // Fields
  //

  /**
   * Declared or inferred static type of the entity.
   */
  private nl.rosa.semanticdatabase.bmm.model.types.BmmUnitaryType type;
  
  //
  // Constructors
  //
  public BmmUnitaryProperty () { };
  
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
  public void setType (nl.rosa.semanticdatabase.bmm.model.types.BmmUnitaryType newVar) {
    type = newVar;
  }

  /**
   * Get the value of type
   * Declared or inferred static type of the entity.
   * @return the value of type
   */
  public nl.rosa.semanticdatabase.bmm.model.types.BmmUnitaryType getType () {
    return type;
  }

  //
  // Other methods
  //

}
