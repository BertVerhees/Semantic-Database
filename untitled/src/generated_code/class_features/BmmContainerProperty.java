package class_features;
import nl.rosa.semanticdatabase.bmm.types.BmmContainerType;


/**
 * Class BmmContainerProperty
 * Meta-type of for properties of linear container type, such as List<T> etc.
 */
public class BmmContainerProperty extends BmmProperty {

  //
  // Fields
  //

  /**
   * Declared or inferred static type of the entity.
   */
  private nl.rosa.semanticdatabase.bmm.types.BmmContainerType type;
  /**
   * Cardinality of this container.
   */
  private MultiplicityInterval cardinality;
  
  //
  // Constructors
  //
  public BmmContainerProperty () { };
  
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
  public void setType (nl.rosa.semanticdatabase.bmm.types.BmmContainerType newVar) {
    type = newVar;
  }

  /**
   * Get the value of type
   * Declared or inferred static type of the entity.
   * @return the value of type
   */
  public nl.rosa.semanticdatabase.bmm.types.BmmContainerType getType () {
    return type;
  }

  /**
   * Set the value of cardinality
   * Cardinality of this container.
   * @param newVar the new value of cardinality
   */
  public void setCardinality (MultiplicityInterval newVar) {
    cardinality = newVar;
  }

  /**
   * Get the value of cardinality
   * Cardinality of this container.
   * @return the value of cardinality
   */
  public MultiplicityInterval getCardinality () {
    return cardinality;
  }

  //
  // Other methods
  //

  /**
   * Name of this property in form name: ContainerTypeName<>.
   * 
   * @return       String
   */
  public String displayName()
  {
  }


}
