package nl.rosa.semanticdatabase.bmmdata.services.persistence_model;


import java.util.Map;

/**
 * Class BmmPackageContainer
 * Persisted form of a model component that contains packages.
 */
public interface BmmPackageContainer {

  void setPackages(Map<String, nl.rosa.semanticdatabase.bmmdata.domain.model_structure.BmmPackage> packages);
  Map<String, nl.rosa.semanticdatabase.bmmdata.domain.model_structure.BmmPackage> getPackages();

}
