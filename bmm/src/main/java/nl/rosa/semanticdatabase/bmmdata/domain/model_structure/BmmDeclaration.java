package nl.rosa.semanticdatabase.bmmdata.domain.model_structure;


import lombok.*;
import nl.rosa.semanticdatabase.bmmdata.domain.BmmBase;
import nl.rosa.semanticdatabase.utils.map.MapUtils;

import java.util.*;

/**
 * Class BmmDeclaration
 */
public abstract class BmmDeclaration extends BmmBase {

  /**
   * 1..1
   * name: String
   * Name of this model element.
   */
  //========= name =======================================================================
  @Getter
  @Setter
  protected @NonNull String name;

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
  private Map<String, Object> documentation;

  public void putDocumentationItem(@NonNull String key, @NonNull Object value){
    MapUtils.addStringObjectItemToMap(documentation, key, value);
  }
  public void putDocumentationItems(Map<String, Object> items){
    items.keySet().forEach(key -> putDocumentationItem(key, items.get(key)));
  }
  public Object getDocumentationItem(String key){
    if(documentation==null){
      return null;
    }
    return documentation.get(key);
  }
  public void removeDocumentationItem(String key){
    if(documentation!=null) {
      documentation.remove(key);
    }
  }
  public void removeDocumentationItems(Collection<String> keys){
    keys.forEach(this::removeDocumentationItem);
  }
  void setDocumentation(Map<String, Object> documentation) {
    this.documentation = documentation;
  }
  Map<String,Object> getDocumentation() {
    return documentation;
  }
  public Map<String,Object> documentation() {
    return Collections.unmodifiableMap(documentation);
  }

  /**
   * 1..1
   * scope: BMM_DECLARATION
   * Model element within which an element is declared.
   */
  //========= scope =======================================================================
  @Getter
  @Setter
  protected @NonNull BmmDeclaration scope;

  /**
   * 0..1
   * extensions: Hash<String, Any>
   * Optional meta-data of this element, as a keyed list. May be used to extend the meta-model.
   */
  //========= extensions =======================================================================
  private Map<String, Object> extensions;

  public void putExtension(@NonNull String key, @NonNull Object value){
    MapUtils.addStringObjectItemToMap(extensions, key, value);

  }
  public void putExtensions(@NonNull Map<String, Object> items){
    items.keySet().forEach(key -> putExtension(key, items.get(key)));
  }
  public Object getExtension(String key){
    if(extensions==null){
      return null;
    }
    return extensions.get(key);
  }
  public void removeExtension(String key){
    if(extensions!=null) {
      extensions.remove(key);
    }
  }
  public void removeExtensions(Collection<String> keys){
    keys.forEach(this::removeExtension);
  }
  void setExtensions(Map<String, Object> extensions) {
    this.extensions = extensions;
  }
  Map<String,Object> getExtensions() {
    return extensions;
  }
  public Map<String,Object> extensions() {
    return Collections.unmodifiableMap(extensions);
  }



  // Functions

  /**
   * 1..1
   * is_root_scope (): Boolean
   * Post_result: Result = (scope = self)
   * True if this declaration entity is the root of the declaration hierarchy.
   * @return
   */

  public @NonNull Boolean isRootScope(){
    return scope.getId() == this.getId();
  }
}
