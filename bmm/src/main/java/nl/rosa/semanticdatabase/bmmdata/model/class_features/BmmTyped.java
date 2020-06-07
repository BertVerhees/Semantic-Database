package nl.rosa.semanticdatabase.bmmdata.model.class_features;

import nl.rosa.semanticdatabase.bmmdata.model.types.BmmType;


/**
 * Class BmmTyped
 * Any entity that has a declared or inferred static type, and that can therefore
 * be generate a value.
 */
public interface BmmTyped extends BmmType {

  /**
   * 1..1
   * type: BMM_TYPE
   * Declared or inferred static type of the entity.
   */
  public void setType (BmmType newVar);
  public BmmType getType ();
}
