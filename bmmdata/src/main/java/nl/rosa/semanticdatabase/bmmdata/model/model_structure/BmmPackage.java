package nl.rosa.semanticdatabase.bmmdata.model.model_structure;

import lombok.Data;
import nl.rosa.semanticdatabase.bmmdata.model.classes.BmmClass;

import java.util.List;


/**
 * Class BmmPackage
 */
@Data
public class BmmPackage extends BmmPackageContainer{

  //
  // Fields
  //

  private List<BmmClass> classes;
  
  //
  // Constructors
  //
  public BmmPackage () { };
  
  //
  // Methods
  //
  /**
   * @return       classes.BmmClass
   */
  public List<BmmClass> rootClasses()
  {
    //TODO
    return null;
  }


  /**
   * @return       String
   */
  public String path()
  {
    //TODO
    return null;
  }


}
