package nl.rosa.semanticdatabase.bmmdata.services.persistence_model;


import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * Class BmmPackageContainer
 * Persisted form of a model component that contains packages.
 */
public class BmmPackageContainer {
  /**
   * 1..1
   * packages: Hash<String, P_BMM_PACKAGE>
   * Package structure as a hierarchy of packages each potentially containing names of classes in that package in the original model.
   */
  @Getter
  @Setter
  @NonNull
  private Map<String, BmmPackage> packages = new HashMap<>();
}
