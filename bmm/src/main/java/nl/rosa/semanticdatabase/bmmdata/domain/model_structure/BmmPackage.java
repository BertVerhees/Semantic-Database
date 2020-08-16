package nl.rosa.semanticdatabase.bmmdata.domain.model_structure;

import lombok.Getter;
import lombok.Setter;
import nl.rosa.semanticdatabase.bmmdata.domain.classes.BmmClass;
import nl.rosa.semanticdatabase.bmmdata.services.model_access.data.BmmSchema;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


/**
 * Class BmmPackage
 */
public class BmmPackage extends BmmPackageContainer {
  /**
   * 0..1
   * classes: List<BMM_CLASS>
   * Classes listed as being in this package.
   */
  @Getter
  @Setter
  private Set<BmmClass> classes = new HashSet<>();
  public Optional<Set<BmmClass>> getClasses() {
    if(classes!=null){
      return Optional.of(Collections.unmodifiableSet(classes));
    }else{
      return Optional.empty();
    }
  }

  public BmmPackage setClasses(Set<BmmClass> classes) {
    this.classes = classes;
    return this;
  }

  public BmmPackage addClassDefinition(BmmClass classes) {
    if(this.classes==null){
      this.classes = new HashSet<>();
    }
    this.classes.add(classes);
    return this;
  }

  public BmmPackage addClasses(Set<BmmClass> classes) {
    if(this.classes==null){
      classes = new HashSet<>();
    }
    this.classes.addAll(classes);
    return this;
  }

  public BmmPackage removeClass(BmmClass classes) {
    if(this.classes!=null) {
      this.classes.remove(classes);
    }
    return this;
  }

  public BmmPackage removeClasses(Set<BmmClass> classes) {
    if(this.classes!=null) {
      this.classes.removeAll(classes);
    }
    return this;
  }


  /**
   * 0..1
   * root_classes (): List<BMM_CLASS>
   * Obtain the set of top-level classes in this package, either from this package itself or by recursing into the
   * structure until classes are obtained from child packages.
   * Recurse into each child only far enough to find the first level of classes.
   * @return
   */
  public Set<BmmClass> rootClasses()
  {
    //TODO
    return null;
  }
  /**
   * 1..1
   * path (): String
   * Full path of this package back to root package.
   * @return
   */
  public String path()
  {
    //TODO
    return null;
  }
}
