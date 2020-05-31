package nl.rosa.semanticdatabase.bmmdata.model.model_structure;


import java.util.Map;

/**
 * Class BmmDeclaration
 */
public interface BmmDeclaration {

  /**
   * 1..1
   * name: String
   * Name of this model element.
   */
  void setName (String newVar);
  String getName ();

  /**
   * 0..1
   * documentation: Hash<String, Any>
   * Optional documentation of this element, as a keyed list.
   * It is strongly recommended to use the following key /type combinations for the relevant purposes:
   * "purpose": String
   * "keywords": List<String>
   * "use": String
   * "misuse": String
   * "references": String
   * Other keys and value types may be freely added.
   */
  void setDocumentation (Map<String,Object> newVar);
  Map<String,Object> getDocumentation ();

  /**
   * Model element within which an element is declared.
   */
  void setScope (BmmDeclaration newVar);
  BmmDeclaration getScope ();
  /**
   * 0..1
   * extensions: Hash<String, Any>
   * Optional meta-data of this element, as a keyed list. May be used to extend the meta-model.
   */
  void setExtensions (Map<String,Object> newVar);
  Map<String,Object> getExtensions ();
  /**
   * 1..1
   * is_root_scope (): Boolean
   * Post_result: Result = (scope = self)
   * True if this declaration entity is the root of the declaration hierarchy.
   */
  boolean isRootScope();
}
