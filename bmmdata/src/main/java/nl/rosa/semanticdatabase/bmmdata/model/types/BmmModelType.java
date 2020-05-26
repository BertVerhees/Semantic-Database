package nl.rosa.semanticdatabase.bmmdata.model.types;

import nl.rosa.semanticdatabase.bmmdata.model.classes.BmmValueSpec;
import nl.rosa.semanticdatabase.bmmdata.model.classes.BmmClass;


/**
 * Class BmmModelType
 * A type that is defined by a class (or classes) in the model.
 * 
 * (effected) type_base_name (): String
 * Result = defining_class.name.
 * (effected) is_primitive (): Boolean
 * Result = defining_class.is_primitive.
 * 
 */
public interface BmmModelType extends BmmEffectiveType {
  /**
   * Set the value of valueConstraint
   * @param newVar the new value of valueConstraint
   */
  void setValueConstraint (BmmValueSpec newVar);
  /**
   * Get the value of valueConstraint
   * @return the value of valueConstraint
   */
  BmmValueSpec getValueConstraint ();
  /**
   * Set the value of baseClass
   * Defining class of this type.
   * @param newVar the new value of baseClass
   */
  void setBaseClass (BmmClass newVar);
  /**
   * Get the value of baseClass
   * Defining class of this type.
   * @return the value of baseClass
   */
  BmmClass getBaseClass ();

  //
  // Other methods
  //

}
