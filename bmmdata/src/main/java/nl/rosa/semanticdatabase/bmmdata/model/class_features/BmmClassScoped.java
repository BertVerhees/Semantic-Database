package nl.rosa.semanticdatabase.bmmdata.model.class_features;

import nl.rosa.semanticdatabase.bmmdata.model.classes.BmmClass;


/**
 * Class BmmClassScoped
 * A class entity having a signature and a class as its scope.
 */
public interface BmmClassScoped extends BmmClassEntity {

  //
  // Accessor methods
  //

  /**
   * 0..1
   * visibility: Any
   * Visibility of this item to client entities.
   */
  void setVisibility (Object newVar);
  Object getVisibility ();

  /**
   * 1..1
   * (redefined)
   * scope: BMM_CLASS
   * Class within which a referenceable element is known.
   */
  void setScope (BmmClass newVar);
  BmmClass getScope ();

}
