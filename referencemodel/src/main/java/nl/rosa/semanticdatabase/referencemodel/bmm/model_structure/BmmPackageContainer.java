package nl.rosa.semanticdatabase.referencemodel.bmm.model_structure;


/**
 * Class BmmPackageContainer
 */
public class BmmPackageContainer extends BmmDeclaration {

  //
  // Fields
  //

  private model_structure.BmmPackage packages;
  private model_structure.BmmPackageContainer scope;
  
  //
  // Constructors
  //
  public BmmPackageContainer () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of packages
   * @param newVar the new value of packages
   */
  public void setPackages (model_structure.BmmPackage newVar) {
    packages = newVar;
  }

  /**
   * Get the value of packages
   * @return the value of packages
   */
  public model_structure.BmmPackage getPackages () {
    return packages;
  }

  /**
   * Set the value of scope
   * @param newVar the new value of scope
   */
  public void setScope (model_structure.BmmPackageContainer newVar) {
    scope = newVar;
  }

  /**
   * Get the value of scope
   * @return the value of scope
   */
  public model_structure.BmmPackageContainer getScope () {
    return scope;
  }

  //
  // Other methods
  //

}
