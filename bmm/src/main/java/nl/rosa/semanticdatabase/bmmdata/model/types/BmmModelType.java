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
   * 0..1
   * value_constraint: BMM_VALUE_SET_SPEC
   */
  void setValueConstraint (BmmValueSpec newVar);
  BmmValueSpec getValueConstraint ();
  /**
   * 1..1
   * base_class: BMM_CLASS
   * Defining class of this type.
   */
  void setBaseClass (BmmClass newVar);
  BmmClass getBaseClass ();
}
