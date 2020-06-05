package nl.rosa.semanticdatabase.bmmdata.model.model_structure;


import lombok.Data;
import lombok.EqualsAndHashCode;
import nl.rosa.semanticdatabase.bmmdata.model.BmmBaseEntity;

import javax.validation.constraints.NotNull;
import java.util.Map;

/**
 * Class BmmPackageContainer
 */
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class BmmPackageContainer extends BmmBaseEntity implements BmmDeclaration {

  /**
   * BmmDeclaration
   */
  @NotNull
  private String name;
  private Map<String, Object> documentation;
  @NotNull
  private BmmDeclaration scope;
  private Map<String, Object> extensions;
  // Functions;
  @Override
  public Boolean isRootScope(){
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

}
