package nl.rosa.semanticdatabase.bmm.model_structure;


import lombok.Builder;
import lombok.Data;

import java.util.Map;

/**
 * Class BmmPackageContainer
 */
@Data
@Builder
public class BmmPackageContainer implements BmmDeclaration {

  private BmmPackage packages;
  private BmmPackageContainer scope;

  @Override
  @Deprecated
  public void setScope(BmmDeclaration newVar){
    this.scope = (BmmPackageContainer) newVar;
  }

  private String name;
  private Map<String, Object> documentation;
  private Map<String, Object> extensions;

  @Override
  public boolean isRootScope() {
    return false;
  }

  public BmmPackageContainer() {
  }
}
