package nl.rosa.semanticdatabase.bmmdata.services.persistence_model;


import java.util.Map;

/**
 * Class BmmPackageContainer
 * Persisted form of a model component that contains packages.
 */
public interface PBmmPackageContainer {
  /**
   * 1..1
   * packages: Hash<String, P_BMM_PACKAGE>
   * Package structure as a hierarchy of packages each potentially containing names of classes in that package in the original model.
   */
  Map<String, PBmmPackage> getPackages();
  void setPackages(Map<String, PBmmPackage> packages);
}
