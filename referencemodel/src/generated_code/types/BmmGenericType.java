package types;
import classes.BmmGenericClass;


/**
 * Class BmmGenericType
 * Meta-type based on a non-container generic class, e.g. Packet<Header>.
 * 
 * (effected) type_name (): String
 * Return the full name of the type including generic parameters, e.g.
 * DV_INTERVAL<T>, TABLE<List<THING>,String>.
 * (effected) is_abstract (): Boolean
 * True if base_class.is_abstract or if any (non-open) parameter type is abstract.
 * (effected) flattened_type_list (): List<String>
 * Result is base_class.name followed by names of all generic parameter type names,
 * which may be open or closed.
 * 
 */
public class BmmGenericType extends BmmModelType {

  //
  // Fields
  //

  /**
   * Generic parameters of the root_type in this type specifier. The order must match the order of the owning class’s formal generic parameter declarations, and the types may be defined types or formal parameter types.
   */
  private List<BmmUnitaryType> genericParameters;
  /**
   * The target type; this converts to the first parameter in generic_parameters in BMM_GENERIC_TYPE.
   */
  private classes.BmmGenericClass baseClass;
  private types.BmmUnitaryType new_attribute;
  
  //
  // Constructors
  //
  public BmmGenericType () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of genericParameters
   * Generic parameters of the root_type in this type specifier. The order must match
   * the order of the owning class’s formal generic parameter declarations, and the
   * types may be defined types or formal parameter types.
   * @param newVar the new value of genericParameters
   */
  public void setGenericParameters (List<BmmUnitaryType> newVar) {
    genericParameters = newVar;
  }

  /**
   * Get the value of genericParameters
   * Generic parameters of the root_type in this type specifier. The order must match
   * the order of the owning class’s formal generic parameter declarations, and the
   * types may be defined types or formal parameter types.
   * @return the value of genericParameters
   */
  public List<BmmUnitaryType> getGenericParameters () {
    return genericParameters;
  }

  /**
   * Set the value of baseClass
   * The target type; this converts to the first parameter in generic_parameters in
   * BMM_GENERIC_TYPE.
   * @param newVar the new value of baseClass
   */
  public void setBaseClass (classes.BmmGenericClass newVar) {
    baseClass = newVar;
  }

  /**
   * Get the value of baseClass
   * The target type; this converts to the first parameter in generic_parameters in
   * BMM_GENERIC_TYPE.
   * @return the value of baseClass
   */
  public classes.BmmGenericClass getBaseClass () {
    return baseClass;
  }

  /**
   * Set the value of new_attribute
   * @param newVar the new value of new_attribute
   */
  public void setNew_attribute (types.BmmUnitaryType newVar) {
    new_attribute = newVar;
  }

  /**
   * Get the value of new_attribute
   * @return the value of new_attribute
   */
  public types.BmmUnitaryType getNew_attribute () {
    return new_attribute;
  }

  //
  // Other methods
  //

  /**
   * Signature form of the type, which for generics includes generic parameter
   * constrainer types E.g. Interval<T:Ordered>.
   * @return       String
   */
  public String typeSignature()
  {
  }


  /**
   * Returns True if there is any substituted generic parameter.
   * @return       boolean
   */
  public boolean isPartiallyClosed()
  {
  }


  /**
   * Effective underlying class for this type, abstracting away any container type.
   * @return       classes.BmmGenericClass
   */
  public classes.BmmGenericClass effectiveBaseClass()
  {
  }


  /**
   * True if all generic parameters from ancestor generic types have been substituted
   * in this type.
   * @return       boolean
   */
  public boolean isOpen()
  {
  }


}
