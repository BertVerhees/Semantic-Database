package nl.rosa.semanticdatabase.referencemodel.bmm.types;


import lombok.Data;

/**
 * Class BmmIndexedContainerType
 * Meta-type of linear container type that indexes the contained items in the
 * manner of a standard Hash table, map or dictionary.
 * 
 * (effected) type_name (): String
 * Return full type name, e.g. HashMap<String, ELEMENT>.
 * 
 */
@Data
public class BmmIndexedContainerType extends BmmContainerType {

  /**
   * Type of the element index, typically String or Integer, but may be a numeric type or indeed any type from which a hash value can be derived.
   */
  private BmmSimpleType indexType;
  
  //
  // Constructors
  //
  public BmmIndexedContainerType () { };
  

  // BmmEntity
  @Override
  public boolean isAbstract() {
    //TODO
    return false;
  }

  @Override
  public boolean isPrimitive() {
    //TODO
    return false;
  }
}
