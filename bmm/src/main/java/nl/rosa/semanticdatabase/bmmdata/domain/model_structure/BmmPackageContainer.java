package nl.rosa.semanticdatabase.bmmdata.domain.model_structure;


import lombok.*;
import nl.rosa.semanticdatabase.bmmdata.domain.expressions.ElProcedureAgent;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Class BmmPackageContainer
 */
public abstract class BmmPackageContainer extends BmmDeclaration {

  /**
   * Child packages; keys all in upper case for guaranteed matching.
   */
  @Getter
  @Setter
  @ElementCollection
  @CollectionTable(name = "bmm_package_container_packages_mapping",
          joinColumns = {@JoinColumn(name = "packages_id", referencedColumnName = "id")})
  @MapKeyColumn(name = "packages_name")
  @Column(name = "packages")
  private Map<String, BmmPackage> packages = new HashMap<>();
  public void addPackage(String key, BmmPackage value){
    packages.put(key, value);
  }
  public BmmPackage getPackage(String key){
    return packages.get(key);
  }
  public BmmPackage removePackage(String key){
    return packages.remove(key);
  }
  /**
   * 1..1
   * (redefined)
   * scope: BMM_PACKAGE_CONTAINER
   * Model element within which a referenceable element is known.
   */
  public BmmPackageContainer getScope(){
    if(super.getScope() == null){
      throw new NullPointerException("Scope is null");
    }
    if(super.getScope() instanceof BmmPackageContainer) {
      return (BmmPackageContainer) super.getScope();
    }else{
      throw new RuntimeException("Scope is of the type "+super.getScope().getClass().getCanonicalName()+" but should be of type BmmPackageContainer");
    }
  }
  public BmmPackageContainer setScope(@NonNull BmmPackageContainer scope){
    super.setScope(scope);
    return this;
  }

  // Functions

  /**
   * 0..1
   * package_at_path (
   * a_path: String[1]
   * ): BMM_PACKAGE
   * Package at the path a_path.
   * @param aPath
   * @return
   */
  public BmmPackage packageAtPath(@NonNull String aPath){
    return null;
  }

  /**
   * 0..1
   * do_recursive_packages (
   * action: EL_PROCEDURE_AGENT[1]
   * )
   * Recursively execute action, which is a procedure taking a BMM_PACKAGE argument, on all members of packages.
   * @param action
   */
  public void doRecursivePackages(@NonNull ElProcedureAgent action){

  }

  /**
   * 1..1
   * has_package_path (
   * a_path: String[1]
   * ): Boolean
   * True if there is a package at the path a_path; paths are delimited with delimiter {BMM_DEFINITIONS}_Package_name_delimiter_.
   * @param aPackagePath
   * @return
   */
  public Boolean hasPackagePath(@NonNull String aPackagePath){
    return null;
  }
}
