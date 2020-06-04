package nl.rosa.semanticdatabase.bmmdata.model.model_structure;

import lombok.Data;
import lombok.EqualsAndHashCode;
import nl.rosa.semanticdatabase.bmmdata.model.classes.BmmClass;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;


/**
 * Class BmmPackage
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BmmPackage extends BmmPackageContainer{
  /**
   * BmmDeclaration
   */
  @NotNull
  private String name;
  private Map<String, Object> documentation;
  @NotNull
  private BmmDeclaration scope;
  private Map<String, Object> extensions;
  // Functions;
  @Override
  public Boolean isRootScope(){
    return scope.equals(this);
  }

  /**
   * 0..1
   * classes: List<BMM_CLASS>
   * Classes listed as being in this package.
   */
  private List<BmmClass> classes;
  
  //
  // Constructors
  //
  public BmmPackage () { };
  /**
   * 0..1
   * root_classes (): List<BMM_CLASS>
   * Obtain the set of top-level classes in this package, either from this package itself or by recursing into the
   * structure until classes are obtained from child packages.
   * Recurse into each child only far enough to find the first level of classes.
   * @return
   */
  public List<BmmClass> rootClasses()
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
