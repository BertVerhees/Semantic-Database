

/**
 * Class BmmSchema
 */
abstract public class BmmSchema extends PBmmPackageContainer, BmmModelMetadata, BmmPackageContainer {

  //
  // Fields
  //

  private String bmmVersion;
  private BmmClass primitiveTypes;
  private BmmClass classDefinitions;
  private BmmIncludeSpec includes;
  private BmmModel bmmSchema;
  private BmmSchemaState state;
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
  public void setPrimitiveTypes (BmmClass newVar) {
    primitiveTypes = newVar;
  }

  /**
   * Get the value of primitiveTypes
   * @return the value of primitiveTypes
   */
  public BmmClass getPrimitiveTypes () {
    return primitiveTypes;
  }

  /**
   * Set the value of classDefinitions
   * @param newVar the new value of classDefinitions
   */
  public void setClassDefinitions (BmmClass newVar) {
    classDefinitions = newVar;
  }

  /**
   * Get the value of classDefinitions
   * @return the value of classDefinitions
   */
  public BmmClass getClassDefinitions () {
    return classDefinitions;
  }

  /**
   * Set the value of includes
   * @param newVar the new value of includes
   */
  public void setIncludes (BmmIncludeSpec newVar) {
    includes = newVar;
  }

  /**
   * Get the value of includes
   * @return the value of includes
   */
  public BmmIncludeSpec getIncludes () {
    return includes;
  }

  /**
   * Set the value of bmmSchema
   * @param newVar the new value of bmmSchema
   */
  public void setBmmSchema (BmmModel newVar) {
    bmmSchema = newVar;
  }

  /**
   * Get the value of bmmSchema
   * @return the value of bmmSchema
   */
  public BmmModel getBmmSchema () {
    return bmmSchema;
  }

  /**
   * Set the value of state
   * @param newVar the new value of state
   */
  public void setState (BmmSchemaState newVar) {
    state = newVar;
  }

  /**
   * Get the value of state
   * @return the value of state
   */
  public BmmSchemaState getState () {
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
  abstract public void merge(BmmSchema other);


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
