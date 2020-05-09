package entities;
import model_structure.BmmDefintions;


/**
 * Class BmmEntity
 */
abstract public class BmmEntity extends BmmDefintions {

  //
  // Fields
  //

  
  //
  // Constructors
  //
  public BmmEntity () { };
  
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
   * If true, indicates an abstract class in a BMM model, or a type based on an
   * abstract class, i.e. a type that cannot be directly instantiated.
   * @return       boolean
   */
  public boolean isAbstract()
  {
  }


  /**
   * If True, indicates that the entity in a BMM model is considered to relate to a
   * primitive type set, i.e. be a primitive type, or be a definer of one.
   * @return       boolean
   */
  public boolean isPrimitive()
  {
  }


}
