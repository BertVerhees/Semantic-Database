package nl.rosa.semanticdatabase.bmm.model_access;

import lombok.Data;
import nl.rosa.semanticdatabase.bmm.model_structure.BmmModel;

import java.util.List;
import java.util.Map;


/**
 * Class BmmModelAccess
 */
@Data
public class BmmModelAccess {

  //
  // Fields
  //

  private List<String> schemaDirectories;
  /**
   * Hash<String,BMM_SCHEMA_DESCRIPTOR>
   */
  private Map<String, BmmSchemaDescriptor> allSchemas;
  private Map<String, BmmModel> bmmModels;
  private Map<String, BmmModel> matchingBmmModels;
  
  //
  // Constructors
  //
  public BmmModelAccess () { };
  
  //
  // Methods
  //

  /**
   * @param        aSchemaDirs
   * @param        aSchemaLoadList
   */
  public void initializeWithLoadList(List<String> aSchemaDirs, List<String> aSchemaLoadList)
  {
    //TODO
  }


  /**
   * @param        aSchemaDirs
   */
  public void initializeAll(List<String> aSchemaDirs)
  {
    //TODO
  }


  /**
   */
  public void reloadSchemas()
  {
    //TODO
  }


  /**
   * @return       model_structure.BmmModel
   * @param        aModelKey
   */
  public BmmModel bmmModel(String aModelKey)
  {
    //TODO
    return null;
  }


  /**
   * @return       boolean
   * @param        aModelKey
   */
  public boolean hasBmmModel(String aModelKey)
  {
    //TODO
    return false;
  }


}
