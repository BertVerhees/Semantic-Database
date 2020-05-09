package nl.rosa.semanticdatabase.referencemodel.bmm.types;


/**
 * Class BmmIndexedContainerType
 * Meta-type of linear container type that indexes the contained items in the
 * manner of a standard Hash table, map or dictionary.
 * 
 * (effected) type_name (): String
 * Return full type name, e.g. HashMap<String, ELEMENT>.
 * 
 */
public class BmmIndexedContainerType extends BmmContainerType {

  //
  // Fields
  //

  /**
   * Type of the element index, typically String or Integer, but may be a numeric type or indeed any type from which a hash value can be derived.
   */
  private types.BmmSimpleType indexType;
  
  //
  // Constructors
  //
  public BmmIndexedContainerType () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of indexType
   * Type of the element index, typically String or Integer, but may be a numeric
   * type or indeed any type from which a hash value can be derived.
   * @param newVar the new value of indexType
   */
  public void setIndexType (types.BmmSimpleType newVar) {
    indexType = newVar;
  }

  /**
   * Get the value of indexType
   * Type of the element index, typically String or Integer, but may be a numeric
   * type or indeed any type from which a hash value can be derived.
   * @return the value of indexType
   */
  public types.BmmSimpleType getIndexType () {
    return indexType;
  }

  //
  // Other methods
  //

}
