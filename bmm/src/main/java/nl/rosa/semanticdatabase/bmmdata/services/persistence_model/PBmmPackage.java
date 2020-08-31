package nl.rosa.semanticdatabase.bmmdata.services.persistence_model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import nl.rosa.semanticdatabase.bmmdata.domain.model_structure.BmmPackage;

import javax.persistence.Id;
import java.util.*;


/**
 * Class BmmPackage
 */
public class PBmmPackage implements PBmmModelElement, PBmmPackageContainer {

  @Id
  private Long id;

/**
 * 1..1
 * packages: Hash<String, P_BMM_PACKAGE>
 * Package structure as a hierarchy of packages each potentially containing names of classes in that package in the original model.
 * (********  inherits from PBmmPackageContainer)
 */
  @NonNull
  private Map<String, PBmmPackage> packages = new HashMap<>();
  public void putPackage(@NonNull String key, @NonNull PBmmPackage value){
    packages.put(key,  value);

  }
  public void putPackages(Map<String, PBmmPackage> items){
    items.keySet().forEach(key -> putPackage(key, items.get(key)));

  }
  public PBmmPackage getPackage(String key){
    return packages.get(key);
  }
  public void removePackage(String key){
    packages.remove(key);
  }
  public void removerPackages(Collection<String> keys){
    keys.forEach(this::removePackage);
  }
  void setPackages(Map<String, PBmmPackage> ancestors) {
    this.packages = ancestors;
  }
  public Map<String,PBmmPackage> getPackages() {
    return Collections.unmodifiableMap(packages);
  }
  public Map<String,PBmmPackage> packages() {
    return Collections.unmodifiableMap(packages);
  }


  /**
   * 0..1
   * classes: List<String>
   * Classes listed as being in this package.
   */
  private Set<String> classes;
  public void addClass(@NonNull String value){
    if(classes==null){
      classes = new HashSet<>();
    }
    classes.add(value);
  }
  public void addClasses(Set<String> openArgs){
    openArgs.forEach(openArg -> addClass(openArg));

  }
  public void removeClass(String openArg){
    if(classes!=null) {
      classes.remove(openArg);
    }
  }
  public void removeClasses(Collection<String> classes){
    classes.forEach(this::removeClass);
  }
  public void removeClasses(Set<String> openArgs) {
    this.classes.removeAll(openArgs);
  }
  void setClasses(Set<String> openArgs) {
    this.classes = openArgs;
  }
  Set<String> getClasses() {
    return classes;
  }
  public Set<String> classes() {
    return Collections.unmodifiableSet(classes);
  }
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
  private BmmPackage bmmPackageDefinition;

  /**
   * 0..1
   * documentation: String
   * Optional documentation of this element.
   * (********  inherits from PBmmModelElement)
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
  public void merge(PBmmPackage other){

  }

  /**
   * 0..1
   * create_bmm_package_definition
   * Generate a BMM_PACKAGE_DEFINITION object and write it to bmm_package_definition.
   */
  public void createBmmPackageDefinition(){

  }
  
}
