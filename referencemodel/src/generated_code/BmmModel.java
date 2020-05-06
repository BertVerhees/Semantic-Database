

/**
 * Class BmmModel
 */
public class BmmModel extends BmmPackageContainer, BmmModelMetadata {

  //
  // Fields
  //

  private BmmClass classDefinitions;
  private BmmModel usedModels;
  
  //
  // Constructors
  //
  public BmmModel () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

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
   * Set the value of usedModels
   * @param newVar the new value of usedModels
   */
  public void setUsedModels (BmmModel newVar) {
    usedModels = newVar;
  }

  /**
   * Get the value of usedModels
   * @return the value of usedModels
   */
  public BmmModel getUsedModels () {
    return usedModels;
  }

  //
  // Other methods
  //

  /**
   * @return       String
   */
  public String modelId()
  {
  }


  /**
   * @return       BmmClass
   * @param        name
   */
  public BmmClass classDefinition(String name)
  {
  }


  /**
   * @return       BmmClass
   */
  public BmmClass typeDefinition()
  {
  }


  /**
   * @return       boolean
   * @param        className
   */
  public boolean hasClassDefinition(String className)
  {
  }


  /**
   * @return       boolean
   * @param        typeName
   */
  public boolean hasTypeDefinition(String typeName)
  {
  }


  /**
   * @return       BmmEnumeration
   * @param        name
   */
  public BmmEnumeration enumerationDefinition(String name)
  {
  }


  /**
   * @return       List<String>
   */
  public List<String> primitiveTypes()
  {
  }


  /**
   * @return       List<String>
   */
  public List<String> enumerationTypes()
  {
  }


  /**
   * @return       BmmProperty
   */
  public BmmProperty propertyDefinition()
  {
  }


  /**
   * @return       boolean
   * @param        bmmTypeName
   * @param        bmmPropertyName
   * @param        modelSemanticPropertyName
   */
  public boolean modelSemanticConformantType(String bmmTypeName, String bmmPropertyName, String modelSemanticPropertyName)
  {
  }


  /**
   * @return       BmmProperty
   */
  public BmmProperty propertyDefintionAtPath()
  {
  }


  /**
   * @return       BmmClass
   * @param        typeName
   * @param        propertyPath
   */
  public BmmClass classDefintionAtPath(String typeName, String propertyPath)
  {
  }


  /**
   * @return       List<String>
   * @param        aClass
   */
  public List<String> allAncestorClasses(String aClass)
  {
  }


  /**
   * @return       boolean
   * @param        className
   * @param        parentCLassName
   */
  public boolean isDescendantOf(String className, String parentCLassName)
  {
  }


  /**
   * @return       boolean
   * @param        descType
   * @param        ancestorType
   */
  public boolean typeConformsTo(String descType, String ancestorType)
  {
  }


  /**
   * @return       List<String>
   * @param        aType
   */
  public List<String> subtypes(String aType)
  {
  }


  /**
   * @return       BmmSimpleClass
   */
  public BmmSimpleClass anyClassDefinition()
  {
  }


  /**
   * @return       BmmSimpleType
   */
  public BmmSimpleType anyTypeDefinition()
  {
  }


  /**
   * @return       BmmSimpleClass
   */
  public BmmSimpleClass booleanTypeDefinition()
  {
  }


}
