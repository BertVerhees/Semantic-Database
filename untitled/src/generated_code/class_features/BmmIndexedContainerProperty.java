package class_features;
import nl.rosa.semanticdatabase.bmm.model.types.BmmIndexedContainerType;


/**
 * Class BmmIndexedContainerProperty
 * Meta-type of for properties of linear container type, such as Hash<Index_type,
 * T> etc.
 */
public class BmmIndexedContainerProperty extends BmmContainerProperty {

  //
  // Fields
  //

  /**
   * Declared or inferred static type of the entity.
   */
  private nl.rosa.semanticdatabase.bmm.model.types.BmmIndexedContainerType type;
  
  //
  // Constructors
  //
  public BmmIndexedContainerProperty () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of type
   * Declared or inferred static type of the entity.
   * @param newVar the new value of type
   */
  public void setType (nl.rosa.semanticdatabase.bmm.model.types.BmmIndexedContainerType newVar) {
    type = newVar;
  }

  /**
   * Get the value of type
   * Declared or inferred static type of the entity.
   * @return the value of type
   */
  public nl.rosa.semanticdatabase.bmm.model.types.BmmIndexedContainerType getType () {
    return type;
  }

  //
  // Other methods
  //

  /**
   * Name of this property in form name: ContainerTypeName<IndexTypeName, �?>.
   * @return       String
   */
  public String displayName()
  {
  }


}
