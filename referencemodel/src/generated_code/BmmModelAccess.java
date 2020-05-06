

/**
 * Class BmmModelAccess
 */
public class BmmModelAccess extends BmmDefintions {

  //
  // Fields
  //

  private List<String> schemaDirectories;
  /**
   * Hash<String,BMM_SCHEMA_DESCRIPTOR>
   */
  private BmmSchemaDescriptor allSchemas;
  private BmmModel bmmModels;
  private BmmModel matchingBmmModels;
  
  //
  // Constructors
  //
  public BmmModelAccess () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of schemaDirectories
   * @param newVar the new value of schemaDirectories
   */
  public void setSchemaDirectories (List<String> newVar) {
    schemaDirectories = newVar;
  }

  /**
   * Get the value of schemaDirectories
   * @return the value of schemaDirectories
   */
  public List<String> getSchemaDirectories () {
    return schemaDirectories;
  }

  /**
   * Set the value of allSchemas
   * Hash<String,BMM_SCHEMA_DESCRIPTOR>
   * @param newVar the new value of allSchemas
   */
  public void setAllSchemas (BmmSchemaDescriptor newVar) {
    allSchemas = newVar;
  }

  /**
   * Get the value of allSchemas
   * Hash<String,BMM_SCHEMA_DESCRIPTOR>
   * @return the value of allSchemas
   */
  public BmmSchemaDescriptor getAllSchemas () {
    return allSchemas;
  }

  /**
   * Set the value of bmmModels
   * @param newVar the new value of bmmModels
   */
  public void setBmmModels (BmmModel newVar) {
    bmmModels = newVar;
  }

  /**
   * Get the value of bmmModels
   * @return the value of bmmModels
   */
  public BmmModel getBmmModels () {
    return bmmModels;
  }

  /**
   * Set the value of matchingBmmModels
   * @param newVar the new value of matchingBmmModels
   */
  public void setMatchingBmmModels (BmmModel newVar) {
    matchingBmmModels = newVar;
  }

  /**
   * Get the value of matchingBmmModels
   * @return the value of matchingBmmModels
   */
  public BmmModel getMatchingBmmModels () {
    return matchingBmmModels;
  }

  //
  // Other methods
  //

  /**
   * @param        aSchemaDirs
   * @param        aSchemaLoadList
   */
  public void initializeWithLoadList(List<String> aSchemaDirs, List<String> aSchemaLoadList)
  {
  }


  /**
   * @param        aSchemaDirs
   */
  public void initializeAll(List<String> aSchemaDirs)
  {
  }


  /**
   */
  public void reloadSchemas()
  {
  }


  /**
   * @return       BmmModel
   * @param        aModelKey
   */
  public BmmModel bmmModel(String aModelKey)
  {
  }


  /**
   * @return       boolean
   * @param        aModelKey
   */
  public boolean hasBmmModel(String aModelKey)
  {
  }


}
