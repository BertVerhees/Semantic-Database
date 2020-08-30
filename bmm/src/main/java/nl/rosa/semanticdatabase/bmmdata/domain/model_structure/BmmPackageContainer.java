package nl.rosa.semanticdatabase.bmmdata.domain.model_structure;


import lombok.*;
import nl.rosa.semanticdatabase.bmmdata.domain.expressions.ElProcedureAgent;
import nl.rosa.semanticdatabase.utils.json.JSONUtils;
import nl.rosa.semanticdatabase.utils.map.MapUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Class BmmPackageContainer
 */
public abstract class BmmPackageContainer extends BmmDeclaration {

  /**
   * Child packages; keys all in upper case for guaranteed matching.
   */
  //========= documentation =======================================================================
  private Map<String, BmmPackage> packages;

  public void putPackage(@NonNull String key, @NonNull BmmPackage value){
    if(packages==null){
      packages = new HashMap<>();
    }
    packages.put(key,  value);
  }
  public void putPackages(Map<String, BmmPackage> items){
    items.keySet().forEach(key -> putPackage(key, items.get(key)));
  }
  public BmmPackage getPackage(String key){
    if(packages==null){
      return null;
    }
    return packages.get(key);
  }
  public void removePackage(String key){
    if(packages!=null) {
      packages.remove(key);
    }
  }
  public void removePackages(Collection<String> keys){
    keys.forEach(this::removePackage);
  }
  void setPackages(Map<String, BmmPackage> packages) {
    this.packages = packages;
  }
  Map<String,BmmPackage> getPackages() {
    return packages;
  }
  public Map<String,BmmPackage> packages() {
    return Collections.unmodifiableMap(packages);
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
  public void setScope(@NonNull BmmPackageContainer scope){
    super.setScope(scope);
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
