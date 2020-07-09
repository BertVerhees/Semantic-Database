package nl.rosa.semanticdatabase.bmmdata.domain.model_structure;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import nl.rosa.semanticdatabase.bmmdata.domain.Bmm;
import nl.rosa.semanticdatabase.utils.json.JSONUtils;
import nl.rosa.semanticdatabase.utils.map.MapUtils;

import javax.persistence.*;
import java.util.*;

/**
 * Class BmmDeclaration
 */
@EqualsAndHashCode(callSuper = true)
public abstract class BmmDeclaration extends Bmm {
  /**
   * 1..1
   * name: String
   * Name of this model element.
   */
  @Getter
  @NonNull
  //========= name =======================================================================
  protected String name;

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
  private Map<String, String> documentation;

  public BmmDeclaration putDocumentationItem(@NonNull String key, @NonNull Object value){
    MapUtils.addStringObjectItemToMap(documentation, key, value);
    return this;
  }
  public BmmDeclaration putDocumentationItems(Map<String, Object> items){
    items.keySet().forEach(key -> putDocumentationItem(key, items.get(key)));
    return this;
  }
  public Object getDocumentationItem(String key){
    if(documentation==null){
      return null;
    }
    String value = documentation.get(key);
    if(JSONUtils.isJSONValid(value)){
      return JSONUtils.toJSON(value);
    }else{
      return value;
    }
  }
  public void removeDocumentationItem(String key){
    if(documentation!=null) {
      documentation.remove(key);
    }
  }
  public void removeDocumentationItems(Collection<String> keys){
    keys.forEach(this::removeDocumentationItem);
  }
  private void setDocumentation(Map<String, String> documentation) {
    this.documentation = documentation;
  }
  private Map<String,String> getDocumentation() {
    return documentation;
  }
  public Map<String,Object> documentation() {
    return Collections.unmodifiableMap(documentation);
  }
  /**
   * 0..1
   * extensions: Hash<String, Any>
   * Optional meta-data of this element, as a keyed list. May be used to extend the meta-model.
   */
  //========= extensions =======================================================================
  private Map<String, String> extensions;

  public BmmDeclaration putExtension(@NonNull String key, @NonNull Object value){
    MapUtils.addStringObjectItemToMap(extensions, key, value);
    return this;
  }
  public BmmDeclaration putExtensions(@NonNull Map<String, Object> items){
    items.keySet().forEach(key -> putExtension(key, items.get(key)));
    return this;
  }
  public Object getExtension(String key){
    if(extensions==null){
      return null;
    }
    String value = extensions.get(key);
    if(JSONUtils.isJSONValid(value)){
      return JSONUtils.toJSON(value);
    }else{
      return value;
    }
  }
  public Object removeExtension(String key){
    if(extensions!=null) {
      extensions.remove(key);
    }
  }
  public void removeExtensions(Collection<String> keys){
    keys.forEach(this::removeExtension);
  }
  private void setExtensions(Map<String, String> extensions) {
    this.extensions = extensions;
  }
  private Map<String,String> getExtensions() {
    return extensions;
  }
  public Map<String,Object> extensions() {
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
