package nl.rosa.semanticdatabase.referencemodel.bmm.model_structure;


import java.util.Map;

/**
 * Class BmmDeclaration
 */
public interface BmmDeclaration extends BmmDefinitions {

  /**
   * Set the value of name
   * @param newVar the new value of name
   */
  void setName (String newVar);
  /**
   * Get the value of name
   * @return the value of name
   */
  String getName ();

  /**
   * Set the value of documentation
   * @param newVar the new value of documentation
   */
  void setDocumentation (Map<String,Object> newVar);
  /**
   * Get the value of documentation
   * @return the value of documentation
   */
  Map<String,Object> getDocumentation ();

  /**
   * Set the value of scope
   * @param newVar the new value of scope
   */
  void setScope (BmmDeclaration newVar);
  /**
   * Get the value of scope
   * @return the value of scope
   */
  BmmDeclaration getScope ();
  /**
   * Set the value of extensions
   * @param newVar the new value of extensions
   */
  void setExtensions (Map<String,Object> newVar);
  /**
   * Get the value of extensions
   * @return the value of extensions
   */
  Map<String,Object> getExtensions ();
  //
  // Other methods
  //

  /**
   * @return       boolean
   */
  boolean isRootScope();
}
