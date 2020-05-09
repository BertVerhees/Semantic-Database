package nl.rosa.semanticdatabase.referencemodel.bmm.class_features;
import nl.rosa.semanticdatabase.referencemodel.bmm.types.BmmSimpleType;
import nl.rosa.semanticdatabase.referencemodel.bmm.types.BmmType;


/**
 * Class BmmTyped
 * Any entity that has a declared or inferred static type, and that can therefore
 * be generate a value.
 */
abstract public class BmmTyped extends BmmType {

  //
  // Fields
  //

  /**
   * Declared or inferred static type of the entity.
   */
  private BmmType type;
  
  //
  // Constructors
  //
  public BmmTyped () { };
  
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
  public void setType (BmmType newVar) {
    type = newVar;
  }

  /**
   * Get the value of type
   * Declared or inferred static type of the entity.
   * @return the value of type
   */
  public BmmType getType () {
    return type;
  }

  //
  // Other methods
  //

  /**
   * True if type is notionally Boolean (i.e. a BMM_SIMPLE_TYPE with type_name() = 'Boolean').
   * @return
   */
  public boolean isBoolean(){
    return type instanceof BmmSimpleType && type.typeName()=="Boolean";
  }



}
