package nl.rosa.semanticdatabase.referencemodel.bmm.class_features;

import nl.rosa.semanticdatabase.referencemodel.bmm.types.BmmType;


/**
 * Class BmmTyped
 * Any entity that has a declared or inferred static type, and that can therefore
 * be generate a value.
 */
public interface BmmTyped extends BmmType {

  /**
   * Set the value of type
   * Declared or inferred static type of the entity.
   * @param newVar the new value of type
   */
  public void setType (BmmType newVar);

  /**
   * Get the value of type
   * Declared or inferred static type of the entity.
   * @return the value of type
   */
  public BmmType getType ();

  //
  // Other methods
  //

  /**
   * True if type is notionally Boolean (i.e. a BMM_SIMPLE_TYPE with type_name() =
   * 'Boolean').
   * @return       boolean
   */
  public boolean isBoolean();


}
