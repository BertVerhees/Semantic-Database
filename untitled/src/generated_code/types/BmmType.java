package types;
import entities.BmmEntity;


/**
 * Class BmmType
 * Abstract idea of specifying a type in some context. This is not the same as
 * 'defining' a class. A type specification is essentially a reference of some
 * kind, that defines the type of an attribute, or function result or argument. It
 * may include generic parameters that might or might not be bound. See subtypes.
 */
abstract public class BmmType extends BmmEntity {

  //
  // Fields
  //

  
  //
  // Constructors
  //
  public BmmType () { };
  
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
   * True if type is based only on a primitive class, or a collection thereof.
   * Effected in descendants.
   * @return       String
   */
  public String typeName()
  {
  }


  /**
   * Completely flattened list of type names, flattening out all generic parameters.
   * @return       List<String>
   */
  public List<String> flattenedTypeList()
  {
  }


  /**
   * Signature form of the type name, which for generics includes generic parameter
   * constrainer types E.g. Interval<T:Ordered>.
   * Defaults to the value of type_name().
   * @return       String
   */
  public String typeSignature()
  {
  }


  /**
   * Type with any container abstracted away.
   * When UnitaryType: Result = self.
   */
  public void unitaryType()
  {
  }


  /**
   * Type with any container abstracted away, and any formal parameter replaced by
   * its effective constraint type. When BmmEffectiveType Result=self
   */
  public void effectiveType()
  {
  }


}
