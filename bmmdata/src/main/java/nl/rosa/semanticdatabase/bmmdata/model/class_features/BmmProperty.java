package nl.rosa.semanticdatabase.bmmdata.model.class_features;


import nl.rosa.semanticdatabase.base.MultiplicityInterval;

/**
 * Class BmmProperty
 * Meta-type of a property definition within a class definition of an object model.
 * The is_composition attribute indicates whether the property has sub-part or an
 * association semantics with respect to the owning class.
 */
public interface BmmProperty extends BmmInstantiable, BmmClassScoped {

  /**
   * 0..1
   * is_im_runtime: Boolean
   * {default = false}
   * True if this property is marked with info model im_runtime property.
   */
  void setImRuntime (boolean newVar);
  boolean isImRuntime ();

  /**
   * 0..1
   * is_im_infrastructure: Boolean
   * {default = false}
   * True if this property was marked with info model im_infrastructure flag.
   */
  void setImInfrastructure (boolean newVar);
  boolean isImInfrastructure ();

  /**
   * 0..1
   * is_composition: Boolean
   * {default = false}
   * True if this property instance is a compositional sub-part of the owning class instance.
   * Equivalent to 'composition' in UML associations (but missing from UML properties without associations)
   * and also 'cascade-delete' semantics in ER schemas.
   */
  void setComposition (boolean newVar);
  boolean isComposition ();

  //
  // Other methods
  //

  /**
   * Interval form of 0..1, 1..1 etc, derived from is_nullable.
   */
  MultiplicityInterval existence();


  /**
   * Name of this property to display in UI.
   * @return       String
   */
  String displayName();
}
