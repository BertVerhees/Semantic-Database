package class_features;


/**
 * Class BmmProperty
 * Meta-type of a property definition within a class definition of an object model.
 * The is_composition attribute indicates whether the property has sub-part or an
 * association semantics with respect to the owning class.
 */
abstract public class BmmProperty extends BmmInstantiableClass, BmmClassScoped {

  //
  // Fields
  //
  /**

   * True if this property is marked with info model im_runtime property.
   * {default = false}   */

  private boolean isImRuntime;
  /**
   * True if this property was marked with info model im_infrastructure flag.{default = false}
   */
  private boolean isImInfrastructure;  /**

   * True if this property instance is a compositional sub-part of the owning class instance. Equivalent to 'composition' in UML associations (but missing from UML properties without associations) and also 'cascade-delete' semantics in ER schemas.
   * {default = false}   */

  private boolean isComposition;
  
  //
  // Constructors
  //
  public BmmProperty () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of isImRuntime
   * True if this property is marked with info model im_runtime property.
   * {default = false}
   * @param newVar the new value of isImRuntime
   */
  public void setIsImRuntime (boolean newVar) {
    isImRuntime = newVar;
  }

  /**
   * Get the value of isImRuntime
   * True if this property is marked with info model im_runtime property.
   * {default = false}
   * @return the value of isImRuntime
   */
  public boolean getIsImRuntime () {
    return isImRuntime;
  }

  /**
   * Set the value of isImInfrastructure
   * True if this property was marked with info model im_infrastructure flag.{default
   * = false}
   * @param newVar the new value of isImInfrastructure
   */
  public void setIsImInfrastructure (boolean newVar) {
    isImInfrastructure = newVar;
  }

  /**
   * Get the value of isImInfrastructure
   * True if this property was marked with info model im_infrastructure flag.{default
   * = false}
   * @return the value of isImInfrastructure
   */
  public boolean getIsImInfrastructure () {
    return isImInfrastructure;
  }

  /**
   * Set the value of isComposition
   * True if this property instance is a compositional sub-part of the owning class
   * instance. Equivalent to 'composition' in UML associations (but missing from UML
   * properties without associations) and also 'cascade-delete' semantics in ER
   * schemas.
   * {default = false}
   * @param newVar the new value of isComposition
   */
  public void setIsComposition (boolean newVar) {
    isComposition = newVar;
  }

  /**
   * Get the value of isComposition
   * True if this property instance is a compositional sub-part of the owning class
   * instance. Equivalent to 'composition' in UML associations (but missing from UML
   * properties without associations) and also 'cascade-delete' semantics in ER
   * schemas.
   * {default = false}
   * @return the value of isComposition
   */
  public boolean getIsComposition () {
    return isComposition;
  }

  //
  // Other methods
  //

  /**
   * Interval form of 0..1, 1..1 etc, derived from is_nullable.
   */
  public void existence()
  {
  }


  /**
   * Name of this property to display in UI.
   * @return       String
   */
  public String displayName()
  {
  }


}
