package nl.rosa.semanticdatabase.bmmcontroller.model_access;

import nl.rosa.semanticdatabase.bmm.model_structure.BmmModel;

import java.util.List;
import java.util.Map;


/**
 * Class BmmSchemaDescriptor
 */
abstract public class BmmSchemaDescriptor {

  private BmmSchema bmmSchema;
  private BmmModel bmmModel;
  private String schemaId;
  private Map<String,String> metaData;
  private List<String> includes;
  //
  // Accessor methods
  //

  /**
   * Set the value of bmmSchema
   * @param newVar the new value of bmmSchema
   */
  abstract void setBmmSchema(BmmSchema newVar);
  /**
   * Get the value of bmmSchema
   * @return the value of bmmSchema
   */
  abstract BmmSchema getBmmSchema();
  /**
   * Set the value of bmmModel
   * @param newVar the new value of bmmModel
   */
  abstract void setBmmModel(BmmModel newVar);
  /**
   * Get the value of bmmModel
   * @return the value of bmmModel
   */
  abstract BmmModel getBmmModel();
  /**
   * Set the value of schemaId
   * @param newVar the new value of schemaId
   */
  abstract void setSchemaId(String newVar);
  /**
   * Get the value of schemaId
   * @return the value of schemaId
   */
  abstract String getSchemaId();
  /**
   * Set the value of metaData
   * @param newVar the new value of metaData
   */
  abstract void setMetaData(Map<String, String> newVar);
  /**
   * Get the value of metaData
   * @return the value of metaData
   */
  abstract Map<String,String> getMetaData();
  /**
   * Set the value of includes
   * @param newVar the new value of includes
   */
  abstract void setIncludes(List<String> newVar);
  /**
   * Get the value of includes
   * @return the value of includes
   */
  abstract List<String> getIncludes();
  //
  // Other methods
  //

  /**
   * @return       boolean
   */
  abstract boolean isTopLevel();


  /**
   * @return       boolean
   */
  abstract boolean isBmmCompatible();

  /**
   */
  abstract void load();


  /**
   */
  abstract void validateMerged();
  /**
   * @param        allSchemaList
   */
  abstract void validateIncludes(List<String> allSchemaList);

  /**
   */
  abstract void createModel();
}
