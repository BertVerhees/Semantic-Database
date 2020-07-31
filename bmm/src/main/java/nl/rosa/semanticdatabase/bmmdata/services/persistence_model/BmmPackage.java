package nl.rosa.semanticdatabase.bmmdata.services.persistence_model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.HashSet;
import java.util.Set;


/**
 * Class BmmPackage
 */
public class BmmPackage extends BmmPackageContainer implements BmmModelElement {

  @Id
  private Long id;

  /**
   * 0..1
   * classes: List<String>
   * Classes listed as being in this package.
   */
  @Getter
  @Setter
  private Set<String> classes;
  /**
   * 1..1
   * name: String
   * Name of the package from schema; this name may be qualified if it is a top-level package within the schema, or unqualified. Persistent attribute.
   */
  @Getter
  @Setter
  @NonNull
  private String name;
  /**
   * 0..1
   * bmm_package_definition: BMM_PACKAGE
   * BMM_PACKAGE created by create_bmm_package_definition.
   */
  @Getter
  @Setter
  private nl.rosa.semanticdatabase.bmmdata.domain.model_structure.BmmPackage bmmPackageDefinition;

  /**
   * 0..1
   * documentation: String
   * Optional documentation of this element.
   */
  @Getter
  @Setter
  private String documentation;

  /**
   * 0..1
   * merge ( * other: P_BMM_PACKAGE[1] * )
   * Merge packages and classes from other (from an included P_BMM_SCHEMA) into this package.
   * @param other
   */
  public void merge(BmmPackage other){

  }

  /**
   * 0..1
   * create_bmm_package_definition
   * Generate a BMM_PACKAGE_DEFINITION object and write it to bmm_package_definition.
   */
  public void createBmmPackageDefinition(){

  }
  
}
