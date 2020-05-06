

/**
 * Class BmmPackageContainer
 */
public class BmmPackageContainer extends BmmDeclaration {

  //
  // Fields
  //

  private BmmPackage packages;
  private BmmPackageContainer scope;
  
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
  public void setPackages (BmmPackage newVar) {
    packages = newVar;
  }

  /**
   * Get the value of packages
   * @return the value of packages
   */
  public BmmPackage getPackages () {
    return packages;
  }

  /**
   * Set the value of scope
   * @param newVar the new value of scope
   */
  public void setScope (BmmPackageContainer newVar) {
    scope = newVar;
  }

  /**
   * Get the value of scope
   * @return the value of scope
   */
  public BmmPackageContainer getScope () {
    return scope;
  }

  //
  // Other methods
  //

}
