package types;
import classes.BmmSimpleClass;


/**
 * Class BmmSimpleType
 * Type reference to a single type i.e. not generic or container type.
 * 
 * (effected) type_name (): String
 * Result is base_class.name.
 * (effected) is_abstract (): Boolean
 * Result is base_class.is_abstract.
 * (effected) flattened_type_list (): List<String>
 * Result is base_class.name .
 * 
 */
public class BmmSimpleType extends BmmModelType {

  //
  // Fields
  //

  private classes.BmmSimpleClass baseClass;
  
  //
  // Constructors
  //
  public BmmSimpleType () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of baseClass
   * @param newVar the new value of baseClass
   */
  public void setBaseClass (classes.BmmSimpleClass newVar) {
    baseClass = newVar;
  }

  /**
   * Get the value of baseClass
   * @return the value of baseClass
   */
  public classes.BmmSimpleClass getBaseClass () {
    return baseClass;
  }

  //
  // Other methods
  //

  /**
   * Main design class for this type, from which properties etc can be extracted.
   * @return       classes.BmmSimpleClass
   */
  public classes.BmmSimpleClass effectiveBaseClass()
  {
  }


}
