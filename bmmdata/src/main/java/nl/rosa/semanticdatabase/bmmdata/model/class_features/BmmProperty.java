package nl.rosa.semanticdatabase.bmmdata.model.class_features;


import nl.rosa.semanticdatabase.base.MultiplicityInterval;

/**
 * Class BmmProperty
 * Meta-type of a property definition within a class definition of an object model.
 * The is_composition attribute indicates whether the property has sub-part or an
 * association semantics with respect to the owning class.
 */
public interface BmmProperty extends BmmInstantiable, BmmClassScoped {


  //
  // Accessor methods
  //

  /**
   * Set the value of isImRuntime
   * True if this property is marked with info model im_runtime property.
   * {default = false}
   * @param newVar the new value of isImRuntime
   */
  void setImRuntime (boolean newVar);

  /**
   * Get the value of isImRuntime
   * True if this property is marked with info model im_runtime property.
   * {default = false}
   * @return the value of isImRuntime
   */
  boolean isImRuntime ();

  /**
   * Set the value of isImInfrastructure
   * True if this property was marked with info model im_infrastructure flag.{default
   * = false}
   * @param newVar the new value of isImInfrastructure
   */
  void setImInfrastructure (boolean newVar);

  /**
   * Get the value of isImInfrastructure
   * True if this property was marked with info model im_infrastructure flag.{default
   * = false}
   * @return the value of isImInfrastructure
   */
  boolean isImInfrastructure ();

  /**
   * Set the value of isComposition
   * True if this property instance is a compositional sub-part of the owning class
   * instance. Equivalent to 'composition' in UML associations (but missing from UML
   * properties without associations) and also 'cascade-delete' semantics in ER
   * schemas.
   * {default = false}
   * @param newVar the new value of isComposition
   */
  void setComposition (boolean newVar);

  /**
   * Get the value of isComposition
   * True if this property instance is a compositional sub-part of the owning class
   * instance. Equivalent to 'composition' in UML associations (but missing from UML
   * properties without associations) and also 'cascade-delete' semantics in ER
   * schemas.
   * {default = false}
   * @return the value of isComposition
   */
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
