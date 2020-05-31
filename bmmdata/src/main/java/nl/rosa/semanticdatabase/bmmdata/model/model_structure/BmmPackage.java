package nl.rosa.semanticdatabase.bmmdata.model.model_structure;

import lombok.Data;
import nl.rosa.semanticdatabase.bmmdata.model.classes.BmmClass;

import java.util.List;


/**
 * Class BmmPackage
 */
@Data
public class BmmPackage extends BmmPackageContainer{


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
