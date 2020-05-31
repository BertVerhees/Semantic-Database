package nl.rosa.semanticdatabase.bmmdata.model.model_structure;


import lombok.Data;
import lombok.NonNull;
import nl.rosa.semanticdatabase.bmmdata.model.BmmBaseEntity;

import java.util.Map;

/**
 * Class BmmPackageContainer
 */
@Data
public abstract class BmmPackageContainer extends BmmBaseEntity implements BmmDeclaration {

  /**
   * BmmDeclaration
   */
  @NonNull
  private String name;
  private Map<String, Object> documentation;
  @NonNull //redefined
  private BmmPackageContainer scope;
  private Map<String, Object> extensions;

  @Override
  public boolean isRootScope(){
    return scope.equals(this);
  }

  /**
   * Child packages; keys all in upper case for guaranteed matching.
   */
  private BmmPackage packages;
  /**
   * Model element within which a referenceable element is known.
   */



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
