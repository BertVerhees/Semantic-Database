package nl.rosa.semanticdatabase.bmmdata.model.model_structure;


import java.util.Map;

/**
 * Class BmmDeclaration
 */
public interface BmmDeclaration {

  void setName (String newVar);
  String getName ();
  void setDocumentation (Map<String,Object> newVar);
  Map<String,Object> getDocumentation ();

  /**
   * Model element within which an element is declared.
   */
  void setScope (BmmDeclaration newVar);
  /**
   * Model element within which an element is declared.
   */
  BmmDeclaration getScope ();
  /**
   * Optional meta-data of this element, as a keyed list. May be used to extend the meta-model.
   */
  void setExtensions (Map<String,Object> newVar);
  /**
   * Optional meta-data of this element, as a keyed list. May be used to extend the meta-model.
   */
  Map<String,Object> getExtensions ();
  /**
   * @return       boolean
   */
  boolean isRootScope();
}
