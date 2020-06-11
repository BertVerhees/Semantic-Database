package nl.rosa.semanticdatabase.bmmdata.model.model_structure;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import nl.rosa.semanticdatabase.bmmdata.model.expressions.ElProcedureAgent;

import java.util.Map;

/**
 * Class BmmPackageContainer
 */
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class BmmPackageContainer extends BmmDeclaration {

  /**
   * Child packages; keys all in upper case for guaranteed matching.
   */
  private Map<String, BmmPackage> packages;
  /**
   * 1..1
   * (redefined)
   * scope: BMM_PACKAGE_CONTAINER
   * Model element within which a referenceable element is known.
   */
  private BmmPackageContainer scope;
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
