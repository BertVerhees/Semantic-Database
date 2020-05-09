package nl.rosa.semanticdatabase.referencemodel.bmm.model_structure;


import java.util.Map;

/**
 * Class BmmDeclaration
 */
public interface BmmDeclaration extends BmmDefinitions {

  //
  // Fields
  //

  private String name;
  private Map<String,Object> documentation;
  private BmmDeclaration scope;
  private Map<String,Object> extensions;
  
  /**
   * Set the value of name
   * @param newVar the new value of name
   */
  public void setName (String newVar) {
    name = newVar;
  }

  /**
   * Get the value of name
   * @return the value of name
   */
  public String getName () {
    return name;
  }

  /**
   * Set the value of documentation
   * @param newVar the new value of documentation
   */
  public void setDocumentation (Hash<String,ANY> newVar) {
    documentation = newVar;
  }

  /**
   * Get the value of documentation
   * @return the value of documentation
   */
  public Hash<String,ANY> getDocumentation () {
    return documentation;
  }

  /**
   * Set the value of scope
   * @param newVar the new value of scope
   */
  public void setScope (model_structure.BmmDeclaration newVar) {
    scope = newVar;
  }

  /**
   * Get the value of scope
   * @return the value of scope
   */
  public model_structure.BmmDeclaration getScope () {
    return scope;
  }

  /**
   * Set the value of extensions
   * @param newVar the new value of extensions
   */
  public void setExtensions (Hash<String,ANY> newVar) {
    extensions = newVar;
  }

  /**
   * Get the value of extensions
   * @return the value of extensions
   */
  public Hash<String,ANY> getExtensions () {
    return extensions;
  }

  //
  // Other methods
  //

  /**
   * @return       boolean
   */
  public boolean isRootScope()
  {
  }


}
