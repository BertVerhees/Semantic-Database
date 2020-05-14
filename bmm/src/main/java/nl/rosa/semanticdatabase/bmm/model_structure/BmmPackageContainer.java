package nl.rosa.semanticdatabase.bmm.model_structure;


import java.util.Map;

/**
 * Class BmmPackageContainer
 */
public class BmmPackageContainer implements BmmDeclaration {

  private BmmPackage packages;
  private BmmPackageContainer scope;

  @Override
  public void setScope(BmmDeclaration newVar){
    this.scope = (BmmPackageContainer) newVar;
  }

  private String name;
  private Map<String, Object> documentation;
  private Map<String, Object> extensions;
  
  //
  // Constructors
  //
  public BmmPackageContainer () { };

  @Override
  public boolean isRootScope() {
    return false;
  }

  public BmmPackage getPackages() {
    return this.packages;
  }

  public BmmPackageContainer getScope() {
    return this.scope;
  }

  public String getName() {
    return this.name;
  }

  public Map<String, Object> getDocumentation() {
    return this.documentation;
  }

  public Map<String, Object> getExtensions() {
    return this.extensions;
  }

  public void setPackages(BmmPackage packages) {
    this.packages = packages;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setDocumentation(Map<String, Object> documentation) {
    this.documentation = documentation;
  }

  public void setExtensions(Map<String, Object> extensions) {
    this.extensions = extensions;
  }

  public boolean equals(final Object o) {
    if (o == this) return true;
    if (!(o instanceof BmmPackageContainer))
      return false;
    final BmmPackageContainer other = (BmmPackageContainer) o;
    if (!other.canEqual((Object) this)) return false;
    final Object this$packages = this.getPackages();
    final Object other$packages = other.getPackages();
    if (this$packages == null ? other$packages != null : !this$packages.equals(other$packages)) return false;
    final Object this$scope = this.getScope();
    final Object other$scope = other.getScope();
    if (this$scope == null ? other$scope != null : !this$scope.equals(other$scope)) return false;
    final Object this$name = this.getName();
    final Object other$name = other.getName();
    if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
    final Object this$documentation = this.getDocumentation();
    final Object other$documentation = other.getDocumentation();
    if (this$documentation == null ? other$documentation != null : !this$documentation.equals(other$documentation))
      return false;
    final Object this$extensions = this.getExtensions();
    final Object other$extensions = other.getExtensions();
    if (this$extensions == null ? other$extensions != null : !this$extensions.equals(other$extensions))
      return false;
    return true;
  }

  protected boolean canEqual(final Object other) {
    return other instanceof BmmPackageContainer;
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final Object $packages = this.getPackages();
    result = result * PRIME + ($packages == null ? 43 : $packages.hashCode());
    final Object $scope = this.getScope();
    result = result * PRIME + ($scope == null ? 43 : $scope.hashCode());
    final Object $name = this.getName();
    result = result * PRIME + ($name == null ? 43 : $name.hashCode());
    final Object $documentation = this.getDocumentation();
    result = result * PRIME + ($documentation == null ? 43 : $documentation.hashCode());
    final Object $extensions = this.getExtensions();
    result = result * PRIME + ($extensions == null ? 43 : $extensions.hashCode());
    return result;
  }

  public String toString() {
    return "BmmPackageContainer(packages=" + this.getPackages() + ", scope=" + this.getScope() + ", name=" + this.getName() + ", documentation=" + this.getDocumentation() + ", extensions=" + this.getExtensions() + ")";
  }
}
