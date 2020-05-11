package nl.rosa.semanticdatabase.referencemodel.model_structure;

import lombok.Getter;
import lombok.Setter;
import nl.rosa.semanticdatabase.referencemodel.classes.BmmClass;

/**
 * Class BmmPackage
 */
@Getter
@Setter
public class BmmPackage {

  //
  // Fields
  //

  private BmmClass classes;
  

  //
  // Methods
  //


  /**
   * @return       BmmClass
   */
  public BmmClass rootClasses()
  {
    return null;
    //TODO
  }


  /**
   * @return       String
   */
  public String path()
  {
    return null;
    //TODO
  }


}
