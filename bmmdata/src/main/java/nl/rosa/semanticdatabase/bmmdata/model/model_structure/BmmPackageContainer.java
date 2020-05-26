package nl.rosa.semanticdatabase.bmmdata.model.model_structure;


import lombok.Data;
import lombok.NonNull;

import java.util.Map;

/**
 * Class BmmPackageContainer
 */
@Data
public abstract class BmmPackageContainer implements BmmDeclaration {

  private Long id;

  /**
   * Child packages; keys all in upper case for guaranteed matching.
   */
  private BmmPackage packages;
  /**
   * Model element within which a referenceable element is known.
   */
  @NonNull private BmmPackageContainer scope;

  /**
   * Name of this model element.
   */
  @NonNull private String name;
  /**
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
  private Map<String, Object> extensions;

  @Override
  public boolean isRootScope() {
    return scope.equals(this);
  }

  public BmmPackageContainer() {
  }

  public BmmPackageContainer(
          BmmPackage packages,
          BmmPackageContainer scope,
          String name,
          Map<String, Object> documentation,
          Map<String, Object> extensions) {
    this.packages = packages;
    this.scope = scope;
    this.name = name;
    this.documentation = documentation;
    this.extensions = extensions;
  }

  @Override
  @Deprecated
  public void setScope(BmmDeclaration newVar){
    this.scope = (BmmPackageContainer) newVar;
  }
}
