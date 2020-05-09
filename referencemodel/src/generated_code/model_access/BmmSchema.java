package model_access;
import persistence.PBmmPackageContainer;
import model_structure.BmmPackageContainer;
import classes.BmmClass;
import model_structure.BmmModel;


/**
 * Class BmmSchema
 */
abstract public class BmmSchema extends PBmmPackageContainer, BmmModelMetadata, BmmPackageContainer {

  //
  // Fields
  //

  private String bmmVersion;
  private classes.BmmClass primitiveTypes;
  private classes.BmmClass classDefinitions;
  private model_access.BmmIncludeSpec includes;
  private model_structure.BmmModel bmmSchema;
  private model_access.BmmSchemaState state;
  private String modelName;
  private String schemaName;
  private String schemaRevision;
  private String schemaLifecycleState;
  private String schemaAuthor;
  private String schemaDescription;
  private List<String> schemaContributors;
  
  //
  // Constructors
  //
  public BmmSchema () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of bmmVersion
   * @param newVar the new value of bmmVersion
   */
  public void setBmmVersion (String newVar) {
    bmmVersion = newVar;
  }

  /**
   * Get the value of bmmVersion
   * @return the value of bmmVersion
   */
  public String getBmmVersion () {
    return bmmVersion;
  }

  /**
   * Set the value of primitiveTypes
   * @param newVar the new value of primitiveTypes
   */
  public void setPrimitiveTypes (classes.BmmClass newVar) {
    primitiveTypes = newVar;
  }

  /**
   * Get the value of primitiveTypes
   * @return the value of primitiveTypes
   */
  public classes.BmmClass getPrimitiveTypes () {
    return primitiveTypes;
  }

  /**
   * Set the value of classDefinitions
   * @param newVar the new value of classDefinitions
   */
  public void setClassDefinitions (classes.BmmClass newVar) {
    classDefinitions = newVar;
  }

  /**
   * Get the value of classDefinitions
   * @return the value of classDefinitions
   */
  public classes.BmmClass getClassDefinitions () {
    return classDefinitions;
  }

  /**
   * Set the value of includes
   * @param newVar the new value of includes
   */
  public void setIncludes (model_access.BmmIncludeSpec newVar) {
    includes = newVar;
  }

  /**
   * Get the value of includes
   * @return the value of includes
   */
  public model_access.BmmIncludeSpec getIncludes () {
    return includes;
  }

  /**
   * Set the value of bmmSchema
   * @param newVar the new value of bmmSchema
   */
  public void setBmmSchema (model_structure.BmmModel newVar) {
    bmmSchema = newVar;
  }

  /**
   * Get the value of bmmSchema
   * @return the value of bmmSchema
   */
  public model_structure.BmmModel getBmmSchema () {
    return bmmSchema;
  }

  /**
   * Set the value of state
   * @param newVar the new value of state
   */
  public void setState (model_access.BmmSchemaState newVar) {
    state = newVar;
  }

  /**
   * Get the value of state
   * @return the value of state
   */
  public model_access.BmmSchemaState getState () {
    return state;
  }

  /**
   * Set the value of modelName
   * @param newVar the new value of modelName
   */
  public void setModelName (String newVar) {
    modelName = newVar;
  }

  /**
   * Get the value of modelName
   * @return the value of modelName
   */
  public String getModelName () {
    return modelName;
  }

  /**
   * Set the value of schemaName
   * @param newVar the new value of schemaName
   */
  public void setSchemaName (String newVar) {
    schemaName = newVar;
  }

  /**
   * Get the value of schemaName
   * @return the value of schemaName
   */
  public String getSchemaName () {
    return schemaName;
  }

  /**
   * Set the value of schemaRevision
   * @param newVar the new value of schemaRevision
   */
  public void setSchemaRevision (String newVar) {
    schemaRevision = newVar;
  }

  /**
   * Get the value of schemaRevision
   * @return the value of schemaRevision
   */
  public String getSchemaRevision () {
    return schemaRevision;
  }

  /**
   * Set the value of schemaLifecycleState
   * @param newVar the new value of schemaLifecycleState
   */
  public void setSchemaLifecycleState (String newVar) {
    schemaLifecycleState = newVar;
  }

  /**
   * Get the value of schemaLifecycleState
   * @return the value of schemaLifecycleState
   */
  public String getSchemaLifecycleState () {
    return schemaLifecycleState;
  }

  /**
   * Set the value of schemaAuthor
   * @param newVar the new value of schemaAuthor
   */
  public void setSchemaAuthor (String newVar) {
    schemaAuthor = newVar;
  }

  /**
   * Get the value of schemaAuthor
   * @return the value of schemaAuthor
   */
  public String getSchemaAuthor () {
    return schemaAuthor;
  }

  /**
   * Set the value of schemaDescription
   * @param newVar the new value of schemaDescription
   */
  public void setSchemaDescription (String newVar) {
    schemaDescription = newVar;
  }

  /**
   * Get the value of schemaDescription
   * @return the value of schemaDescription
   */
  public String getSchemaDescription () {
    return schemaDescription;
  }

  /**
   * Set the value of schemaContributors
   * @param newVar the new value of schemaContributors
   */
  public void setSchemaContributors (List<String> newVar) {
    schemaContributors = newVar;
  }

  /**
   * Get the value of schemaContributors
   * @return the value of schemaContributors
   */
  public List<String> getSchemaContributors () {
    return schemaContributors;
  }

  //
  // Other methods
  //

  /**
   */
  abstract public void validateCreated();


  /**
   */
  abstract public void loadFinalise();


  /**
   * @param        other
   */
  abstract public void merge(model_access.BmmSchema other);


  /**
   */
  public void validate()
  {
  }


  /**
   */
  abstract public void createBmmModel();


  /**
   * @return       boolean
   */
  public boolean readToValidate()
  {
  }


  /**
   * @return       String
   */
  public String schemaId()
  {
  }


}
