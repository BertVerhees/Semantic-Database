package nl.rosa.semanticdatabase.bmmdata.domain.model_structure;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import nl.rosa.semanticdatabase.bmmdata.domain.BmmBaseEntity;

import java.util.Map;

/**
 * Class BmmDeclaration
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public abstract class BmmDeclaration extends BmmBaseEntity {
  /**
   * 1..1
   * name: String
   * Name of this model element.
   */
  @NonNull
  private String name;

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
  private Map<String, Object> documentation;

  /**
   * 1..1
   * scope: BMM_DECLARATION
   * Model element within which an element is declared.
   */
  @NonNull
  private BmmDeclaration scope;
  /**
   * 0..1
   * extensions: Hash<String, Any>
   * Optional meta-data of this element, as a keyed list. May be used to extend the meta-model.
   */
  private Map<String, Object> extensions;
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
