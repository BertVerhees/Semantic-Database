package nl.rosa.semanticdatabase.bmmdata.domain.model_structure;


import lombok.Getter;
import lombok.NonNull;
import nl.rosa.semanticdatabase.bmmdata.domain.BmmBaseEntity;
import nl.rosa.semanticdatabase.utils.json.JSONUtils;

import javax.persistence.*;
import java.util.*;

/**
 * Class BmmDeclaration
 */
@DiscriminatorValue("2")
@Entity
public abstract class BmmDeclaration extends BmmBaseEntity {
  /**
   * 1..1
   * name: String
   * Name of this model element.
   */
  @Getter
  @NonNull
  @MapKey
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
  //========= documentation =======================================================================
  @ElementCollection
  @CollectionTable(name = "bmm_declaration_documentation_mapping",
          joinColumns = {@JoinColumn(name = "documentation_id", referencedColumnName = "id")})
  @MapKeyColumn(name = "documentation_name")
  @Column(name = "documentation")
  private Map<String, String> documentation = new HashMap<>();

  public BmmDeclaration putDocumentationItem(String key, Object value){
    if(value instanceof String){
      documentation.put(key, (String) value);
    }else{
      documentation.put(key, JSONUtils.toJSON(value));
    }
    return this;
  }
  public Object getDocumentationItem(String key){
    String value = documentation.get(key);
    if(JSONUtils.isJSONValid(value)){
      return JSONUtils.toJSON(value);
    }else{
      return value;
    }
  }
  public Object removeDocumentationItem(String key){
    return documentation.remove(key);
  }

  public BmmDeclaration setDocumentation(Map<String, String> documentation) {
    this.documentation = documentation;
    return this;
  }
  public Map<String,String> getDocumentation() {
    return Collections.unmodifiableMap(documentation);
  }

  /**
   * 0..1
   * extensions: Hash<String, Any>
   * Optional meta-data of this element, as a keyed list. May be used to extend the meta-model.
   */
  //========= extensions =======================================================================
  @ElementCollection
  @CollectionTable(name = "bmm_declaration_extensions_mapping",
          joinColumns = {@JoinColumn(name = "extension_id", referencedColumnName = "id")})
  @MapKeyColumn(name = "extension_name")
  @Column(name = "extensions")
  private Map<String, String>  extensions = new HashMap<>();

  public BmmDeclaration putExtensionsItem(String key, Object value){
    if(value instanceof String){
      extensions.put(key, (String) value);
    }else{
      extensions.put(key, JSONUtils.toJSON(value));
    }
    return this;
  }
  public Object getExtensionsItem(String key){
    String value = extensions.get(key);
    if(JSONUtils.isJSONValid(value)){
      return JSONUtils.toJSON(value);
    }else{
      return value;
    }
  }
  public Object removeExtensionsItem(String key){
    return extensions.remove(key);
  }

  public BmmDeclaration setExtensions(Map<String, String> extensions) {
    this.extensions = extensions;
    return this;
  }
  public Map<String,String> getExtensions() {
    return Collections.unmodifiableMap(extensions);
  }


  /**
   * 1..1
   * scope: BMM_DECLARATION
   * Model element within which an element is declared.
   */
  //========= scope =======================================================================
  @NonNull
  @Getter
  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "scope_id")
  protected BmmDeclaration scope;

  public BmmDeclaration setScope(BmmDeclaration scope) {
    this.scope = scope;
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
    return scope.getId() == this.getId();
  }
}
