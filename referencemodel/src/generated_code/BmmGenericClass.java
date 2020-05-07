import classes.BmmClass;
import types.BmmGenericType;
import types.BmmParameterType;


/**
 * Class BmmGenericClass
 * Definition of a generic class in an object model.
 * 
 * (effected) type (): BMM_GENERIC_TYPE
 * Generate a fully open BMM_GENERIC_TYPE instance that corresponds to this class
 * definition
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
public class BmmGenericClass extends BmmClass {

  //
  // Fields
  //

  private types.BmmParameterType genericParameters;
  
  //
  // Constructors
  //
  public BmmGenericClass () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of genericParameters
   * @param newVar the new value of genericParameters
   */
  public void setGenericParameters (types.BmmParameterType newVar) {
    genericParameters = newVar;
  }

  /**
   * Get the value of genericParameters
   * @return the value of genericParameters
   */
  public types.BmmParameterType getGenericParameters () {
    return genericParameters;
  }

  //
  // Other methods
  //

  /**
   * Add suppliers from generic parameters.
   * @return       List<String>
   */
  public List<String> suppliers()
  {
  }


  /**
   * For a generic class, type to which generic parameter a_name conforms e.g. if
   * this class is Interval <T:Comparable> then the Result will be the single type
   * Comparable. For an unconstrained type T, the Result will be Any.
   * @return       String
   * @param        name
   */
  public String genericParameterConformanceType(String name)
  {
  }


  /**
   * Generate a fully open BMM_GENERIC_TYPE instance that corresponds to this class
   * definition
   * @return       types.BmmGenericType
   */
  public types.BmmGenericType type()
  {
  }


}
