package nl.rosa.semanticdatabase.bmmdata.model.model_structure;


import java.util.Map;

/**
 * Class BmmPackageContainer
 */
public interface BmmPackageContainer extends BmmDeclaration {

  /**
   * Child packages; keys all in upper case for guaranteed matching.
   */
  Map<String, BmmPackage> getPackages();
  void setPackages(Map<String, BmmPackage> newVar);
}
