package types;


/**
 * Class BmmTupleType
 * Special type representing the type of a tuple, i.e. an array of any number of
 * other types. This includes both container and unitary types, since tuple
 * instances represent concrete objects.
 * Note that both open and closed generic parameters are allowed, as with any
 * generic type, but open generic parameters are only valid within the scope of a
 * generic class.
 * 
 * effected) type_base_name (): String
 * Post_result: Result.is_equal (base_name())
 * Return base_name.
 * (effected) is_primitive (): Boolean
 * Result = True.
 * (effected) is_abstract (): Boolean
 * Result = False.
 * (effected) type_name (): String
 * Post_result: Result.is_equal (base_name())
 * Return base_name.
 * 
 */
public class BmmTupleType extends BmmEffectiveType {

  //
  // Fields
  //

  private String baseName = "Tuple";
  /**
   * List of types of the items of the tuple, keyed by purpose in the tuple.
   */
  private Hash<String,BmmType> itemTypes;
  
  //
  // Constructors
  //
  public BmmTupleType () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of baseName
   * @param newVar the new value of baseName
   */
  public void setBaseName (String newVar) {
    baseName = newVar;
  }

  /**
   * Get the value of baseName
   * @return the value of baseName
   */
  public String getBaseName () {
    return baseName;
  }

  /**
   * Set the value of itemTypes
   * List of types of the items of the tuple, keyed by purpose in the tuple.
   * @param newVar the new value of itemTypes
   */
  public void setItemTypes (Hash<String,BmmType> newVar) {
    itemTypes = newVar;
  }

  /**
   * Get the value of itemTypes
   * List of types of the items of the tuple, keyed by purpose in the tuple.
   * @return the value of itemTypes
   */
  public Hash<String,BmmType> getItemTypes () {
    return itemTypes;
  }

  //
  // Other methods
  //

}
