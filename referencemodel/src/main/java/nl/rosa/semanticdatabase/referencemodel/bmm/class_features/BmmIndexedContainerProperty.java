package nl.rosa.semanticdatabase.referencemodel.bmm.class_features;

import lombok.Data;
import nl.rosa.semanticdatabase.referencemodel.bmm.types.BmmIndexedContainerType;


/**
 * Class BmmIndexedContainerProperty
 * Meta-type of for properties of linear container type, such as Hash<Index_type,
 * T> etc.
 */
@Data
public class BmmIndexedContainerProperty extends BmmContainerProperty {

  //
  // Fields
  //

  /**
   * Declared or inferred static type of the entity.
   */
  private BmmIndexedContainerType type;
  
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
  public void setType (BmmIndexedContainerType newVar) {
    type = newVar;
  }

  /**
   * Get the value of type
   * Declared or inferred static type of the entity.
   * @return the value of type
   */
  public BmmIndexedContainerType getType () {
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
