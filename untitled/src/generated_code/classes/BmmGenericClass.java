package classes;
import nl.rosa.semanticdatabase.bmm.types.BmmGenericType;
import nl.rosa.semanticdatabase.bmm.types.BmmParameterType;


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

  private nl.rosa.semanticdatabase.bmm.types.BmmParameterType genericParameters;
  
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
  public void setGenericParameters (nl.rosa.semanticdatabase.bmm.types.BmmParameterType newVar) {
    genericParameters = newVar;
  }

  /**
   * Get the value of genericParameters
   * @return the value of genericParameters
   */
  public nl.rosa.semanticdatabase.bmm.types.BmmParameterType getGenericParameters () {
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
   * @return       nl.rosa.semanticdatabase.bmm.types.BmmGenericType
   */
  public nl.rosa.semanticdatabase.bmm.types.BmmGenericType type()
  {
  }


}
