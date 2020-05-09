package nl.rosa.semanticdatabase.referencemodel.bmm.model_structure;
import classes.BmmClass;


/**
 * Class BmmPackage
 */
public class BmmPackage {

  //
  // Fields
  //

  private classes.BmmClass classes;
  
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
  public void setClasses (classes.BmmClass newVar) {
    classes = newVar;
  }

  /**
   * Get the value of classes
   * @return the value of classes
   */
  public classes.BmmClass getClasses () {
    return classes;
  }

  //
  // Other methods
  //

  /**
   * @return       classes.BmmClass
   */
  public classes.BmmClass rootClasses()
  {
  }


  /**
   * @return       String
   */
  public String path()
  {
  }


}
