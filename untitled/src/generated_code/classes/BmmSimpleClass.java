package classes;
import nl.rosa.semanticdatabase.bmm.model.types.BmmSimpleType;


/**
 * Class BmmSimpleClass
 * Definition of a simple class, i.e. a class that has no generic parameters and is
 * 1:1 with the type it generates.
 * 
 * (effected) type (): BMM_SIMPLE_TYPE
 * Generate a type object that represents the type of this class. Can only be an
 * instance of BMM_SIMPLE_TYPE or a descendant.
 * 
 */
public class BmmSimpleClass extends BmmClass {

  //
  // Fields
  //

  
  //
  // Constructors
  //
  public BmmSimpleClass () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  //
  // Other methods
  //

  /**
   * Generate a type object that represents the type of this class. Can only be an
   * instance of BMM_SIMPLE_TYPE or a descendant.
   * @return       nl.rosa.semanticdatabase.bmm.model.types.BmmSimpleType
   */
  public nl.rosa.semanticdatabase.bmm.model.types.BmmSimpleType type()
  {
  }


}
