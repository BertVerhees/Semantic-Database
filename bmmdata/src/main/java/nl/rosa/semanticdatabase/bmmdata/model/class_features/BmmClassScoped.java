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
   * Set the value of visibility
   * Visibility of this item to client entities.
   * TODO: define scheme; probably need to support C++/Java scheme as well as better
   * type-based schemes.
   * @param newVar the new value of visibility
   */
  void setVisibility (Object newVar);

  /**
   * Get the value of visibility
   * Visibility of this item to client entities.
   * TODO: define scheme; probably need to support C++/Java scheme as well as better
   * type-based schemes.
   * @return the value of visibility
   */
  Object getVisibility ();

  /**
   * Set the value of scope
   * @param newVar the new value of scope
   */
  void setScope (BmmClass newVar);

  /**
   * Get the value of scope
   * @return the value of scope
   */
  BmmClass getScope ();

}
