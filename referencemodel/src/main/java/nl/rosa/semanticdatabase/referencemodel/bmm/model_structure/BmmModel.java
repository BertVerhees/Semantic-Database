package nl.rosa.semanticdatabase.referencemodel.bmm.model_structure;
import model_access.BmmModelMetadata;
import classes.BmmClass;
import classes.BmmEnumeration;
import class_features.BmmProperty;
import types.BmmSimpleType;


/**
 * Class BmmModel
 */
public class BmmModel extends BmmPackageContainer, BmmModelMetadata {

  //
  // Fields
  //

  private classes.BmmClass classDefinitions;
  private model_structure.BmmModel usedModels;
  
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
   * Set the value of usedModels
   * @param newVar the new value of usedModels
   */
  public void setUsedModels (model_structure.BmmModel newVar) {
    usedModels = newVar;
  }

  /**
   * Get the value of usedModels
   * @return the value of usedModels
   */
  public model_structure.BmmModel getUsedModels () {
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
   * @return       classes.BmmClass
   * @param        name
   */
  public classes.BmmClass classDefinition(String name)
  {
  }


  /**
   * @return       classes.BmmClass
   */
  public classes.BmmClass typeDefinition()
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
   * @return       classes.BmmEnumeration
   * @param        name
   */
  public classes.BmmEnumeration enumerationDefinition(String name)
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
   * @return       class_features.BmmProperty
   */
  public class_features.BmmProperty propertyDefinition()
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
   * @return       class_features.BmmProperty
   */
  public class_features.BmmProperty propertyDefintionAtPath()
  {
  }


  /**
   * @return       classes.BmmClass
   * @param        typeName
   * @param        propertyPath
   */
  public classes.BmmClass classDefintionAtPath(String typeName, String propertyPath)
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
   */
  public void anyClassDefinition()
  {
  }


  /**
   * @return       types.BmmSimpleType
   */
  public types.BmmSimpleType anyTypeDefinition()
  {
  }


  /**
   * @return       undef
   */
  public undef booleanTypeDefinition()
  {
  }


}
