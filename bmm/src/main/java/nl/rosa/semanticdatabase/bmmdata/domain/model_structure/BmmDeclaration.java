package nl.rosa.semanticdatabase.bmmdata.domain.model_structure;


import lombok.*;
import nl.rosa.semanticdatabase.bmmdata.domain.BmmBaseEntity;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Class BmmDeclaration
 */
@DiscriminatorValue("2")
public abstract class BmmDeclaration extends BmmBaseEntity {
  /**
   * 1..1
   * name: String
   * Name of this model element.
   */
  @Getter
  @NonNull
  private String name;

  public BmmDeclaration setName(String name) {
    this.name = name;
    return this;
  }

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
  @Getter
  @Setter
  @ElementCollection
  @CollectionTable(name = "bmm_declaration_documentation_mapping",
          joinColumns = {@JoinColumn(name = "documentation_id", referencedColumnName = "id")})
  @MapKeyColumn(name = "documentation_name")
  @Column(name = "documentation")
  private Map<String, Object> documentation = new HashMap<>();
  public BmmDeclaration addDocumentationItem(String key, Object value){
    documentation.put(key, value);
    return this;
  }
  public Object getDocumentationItem(String key){
    return documentation.get(key);
  }
  public Object removeDocumentationItem(String key){
    return documentation.remove(key);
  }

  public BmmDeclaration setDocumentation(Map<String, Object> documentation) {
    this.documentation = documentation;
    return this;
  }

  /**
   * 1..1
   * scope: BMM_DECLARATION
   * Model element within which an element is declared.
   */
  @NonNull
  @Getter
  @Setter
  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "scope_id")
  private BmmDeclaration scope;

  public BmmDeclaration setScope(BmmDeclaration scope) {
    this.scope = scope;
    return this;
  }

  /**
   * 0..1
   * extensions: Hash<String, Any>
   * Optional meta-data of this element, as a keyed list. May be used to extend the meta-model.
   */
  @Getter
  @Setter
  @ElementCollection
  @CollectionTable(name = "bmm_declaration_extensions_mapping",
          joinColumns = {@JoinColumn(name = "extension_id", referencedColumnName = "id")})
  @MapKeyColumn(name = "extension_name")
  @Column(name = "extensions")
  private Map<String, Object> extensions = new HashMap<>();
  public BmmDeclaration addExtensionsItem(String key, Object value){
    extensions.put(key, value);
    return this;
  }
  public Object getExtensionsItem(String key){
    return extensions.get(key);
  }
  public Object deleteExtensionsItem(String key){
    return extensions.remove(key);
  }

  public BmmDeclaration setExtensions(Map<String, Object> extensions) {
    this.extensions = extensions;
    return this;
  }
  // Functions

  /**
   * 1..1
   * is_root_scope (): Boolean
   * Post_result: Result = (scope = self)
   * True if this declaration entity is the root of the declaration hierarchy.
   * @return
   */
  @NonNull
  public Boolean isRootScope(){
    return null;
  }
}
