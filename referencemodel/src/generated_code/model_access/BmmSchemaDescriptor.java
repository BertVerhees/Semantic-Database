package model_access;
import model_structure.BmmModel;


/**
 * Class BmmSchemaDescriptor
 */
abstract public class BmmSchemaDescriptor extends BmmDefintions {

  //
  // Fields
  //

  private model_access.BmmSchema bmmSchema;
  private model_structure.BmmModel bmmModel;
  private String schemaId;
  private Hash<String,String> metaData;
  private List<String> includes;
  
  //
  // Constructors
  //
  public BmmSchemaDescriptor () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of bmmSchema
   * @param newVar the new value of bmmSchema
   */
  public void setBmmSchema (model_access.BmmSchema newVar) {
    bmmSchema = newVar;
  }

  /**
   * Get the value of bmmSchema
   * @return the value of bmmSchema
   */
  public model_access.BmmSchema getBmmSchema () {
    return bmmSchema;
  }

  /**
   * Set the value of bmmModel
   * @param newVar the new value of bmmModel
   */
  public void setBmmModel (model_structure.BmmModel newVar) {
    bmmModel = newVar;
  }

  /**
   * Get the value of bmmModel
   * @return the value of bmmModel
   */
  public model_structure.BmmModel getBmmModel () {
    return bmmModel;
  }

  /**
   * Set the value of schemaId
   * @param newVar the new value of schemaId
   */
  public void setSchemaId (String newVar) {
    schemaId = newVar;
  }

  /**
   * Get the value of schemaId
   * @return the value of schemaId
   */
  public String getSchemaId () {
    return schemaId;
  }

  /**
   * Set the value of metaData
   * @param newVar the new value of metaData
   */
  public void setMetaData (Hash<String,String> newVar) {
    metaData = newVar;
  }

  /**
   * Get the value of metaData
   * @return the value of metaData
   */
  public Hash<String,String> getMetaData () {
    return metaData;
  }

  /**
   * Set the value of includes
   * @param newVar the new value of includes
   */
  public void setIncludes (List<String> newVar) {
    includes = newVar;
  }

  /**
   * Get the value of includes
   * @return the value of includes
   */
  public List<String> getIncludes () {
    return includes;
  }

  //
  // Other methods
  //

  /**
   * @return       boolean
   */
  public boolean isTopLevel()
  {
  }


  /**
   * @return       boolean
   */
  public boolean isBmmCompatible()
  {
  }


  /**
   */
  public void load()
  {
  }


  /**
   */
  public void validateMerged()
  {
  }


  /**
   * @param        allSchemaList
   */
  public void validateIncludes(List<String> allSchemaList)
  {
  }


  /**
   */
  public void createModel()
  {
  }


}
