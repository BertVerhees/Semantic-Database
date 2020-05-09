package nl.rosa.semanticdatabase.referencemodel.bmm.class_features;


/**
 * Class BmmOperator
 * Definition of a symbolic operator associated with a function
 */
public class BmmOperator {

  //
  // Fields
  //

  /**
   * Position of operator in syntactic representation.
   */
  private class_features.BmmOperatorPosition position;
  /**
   * Set of String symbols that may be used to represent this operator in a textual representation of a BMM model.
   */
  private String symbols;
  /**
   * Formal name of the operator, e.g. 'minus' etc.
   */
  private String name;
  
  //
  // Constructors
  //
  public BmmOperator () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of position
   * Position of operator in syntactic representation.
   * @param newVar the new value of position
   */
  public void setPosition (class_features.BmmOperatorPosition newVar) {
    position = newVar;
  }

  /**
   * Get the value of position
   * Position of operator in syntactic representation.
   * @return the value of position
   */
  public class_features.BmmOperatorPosition getPosition () {
    return position;
  }

  /**
   * Set the value of symbols
   * Set of String symbols that may be used to represent this operator in a textual
   * representation of a BMM model.
   * @param newVar the new value of symbols
   */
  public void setSymbols (String newVar) {
    symbols = newVar;
  }

  /**
   * Get the value of symbols
   * Set of String symbols that may be used to represent this operator in a textual
   * representation of a BMM model.
   * @return the value of symbols
   */
  public String getSymbols () {
    return symbols;
  }

  /**
   * Set the value of name
   * Formal name of the operator, e.g. 'minus' etc.
   * @param newVar the new value of name
   */
  public void setName (String newVar) {
    name = newVar;
  }

  /**
   * Get the value of name
   * Formal name of the operator, e.g. 'minus' etc.
   * @return the value of name
   */
  public String getName () {
    return name;
  }

  //
  // Other methods
  //

}
