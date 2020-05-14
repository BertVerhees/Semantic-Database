package nl.rosa.semanticdatabase.bmm.types;


/**
 * Class BmmEffectiveType
 * Meta-type for a A concrete, unitary type that can be used as an actual parameter
 * type in a generic type declaration.
 */
abstract public class BmmEffectiveType extends BmmUnitaryType {

  //
  // Fields
  //

  
  //
  // Constructors
  //
  public BmmEffectiveType () { };
  
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
   * Name of base generator type, i.e. excluding any generic parts if present.
   * 
   * @return       String
   */
  public String typeBaseName()
  {
  }


}
