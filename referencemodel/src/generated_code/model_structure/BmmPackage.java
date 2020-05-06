package model_structure;


/**
 * Class BmmPackage
 */
public class BmmPackage {

  //
  // Fields
  //

  private BmmClass classes;
  
  //
  // Constructors
  //
  public BmmPackage () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of classes
   * @param newVar the new value of classes
   */
  public void setClasses (BmmClass newVar) {
    classes = newVar;
  }

  /**
   * Get the value of classes
   * @return the value of classes
   */
  public BmmClass getClasses () {
    return classes;
  }

  //
  // Other methods
  //

  /**
   * @return       BmmClass
   */
  public BmmClass rootClasses()
  {
  }


  /**
   * @return       String
   */
  public String path()
  {
  }


}
