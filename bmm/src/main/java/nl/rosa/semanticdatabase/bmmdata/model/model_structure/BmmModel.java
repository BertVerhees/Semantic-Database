package nl.rosa.semanticdatabase.bmmdata.model.model_structure;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import nl.rosa.semanticdatabase.bmmdata.model.meta.BmmModelMetadata;
import nl.rosa.semanticdatabase.bmmdata.model.class_features.BmmProperty;
import nl.rosa.semanticdatabase.bmmdata.model.classes.BmmClass;
import nl.rosa.semanticdatabase.bmmdata.model.classes.BmmEnumeration;
import nl.rosa.semanticdatabase.bmmdata.model.classes.BmmSimpleClass;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmSimpleType;

import lombok.NonNull;
import java.util.List;
import java.util.Map;


/**
 * Class BmmModel
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BmmModel extends BmmPackageContainer {
  /**
   * BmmDeclaration
   */
  @NonNull
  private String name;
  private Map<String, Object> documentation;
  @NonNull
  private BmmDeclaration scope;
  private Map<String, Object> extensions;
  // Functions;
  @Override
  public Boolean isRootScope(){
    return scope.equals(this);
  }
  /**
   * All classes in this model, keyed by type name.
   */
  private Map<String,BmmClass> classDefinitions;
  /**
   * List of other models 'used' (i.e. 'imported' by this model). Classes in the current model may refer to classes
   * in a used model by specifying the other class’s scope meta-attribute.
   */
  private BmmModel usedModels;
  private BmmModelMetadata bmmModelMetadata;


  //
  // Constructors
  //
  public BmmModel () {
    super();
  }

  @Builder
  public BmmModel(
          BmmPackage packages,
          BmmPackageContainer scope,
          String name,
          Map<String, Object> documentation,
          Map<String, Object> extensions,
          Map<String,BmmClass> classDefinitions,
          BmmModel usedModels,
          BmmModelMetadata bmmModelMetadata) {
    super(packages, scope, name, documentation, extensions);
    this.classDefinitions = classDefinitions;
    this.usedModels = usedModels;
    this.bmmModelMetadata = bmmModelMetadata;
  }

  //
  // Methods
  //
  /**
   * Identifier of this model, lower-case, formed from:
   * rm_publisher '' model_name '' rm_release
   * E.g. 'openehr_ehr_1.0.4'.
   *
   * @return       String
   */
  public String modelId()
  {
    //TODO
    return null;
  }

  /**
   * Retrieve the class definition corresponding to a_type_name (which may contain a generic part).
   * @return       classes.BmmClass
   * @param        name
   */
  public BmmClass classDefinition(String name)
  {
    //TODO
    return null;
  }

  /**
   * Retrieve the class definition corresponding to a_type_name.
   * If it contains a generic part, this will be removed if it is a fully open generic name,
   * otherwise it will remain intact, i.e. if it is an effective generic name that identifies
   * a BMM_GENERIC_CLASS_EFFECTIVE.
   * @return       classes.BmmClass
   */
  public BmmClass typeDefinition()
  {
    //TODO
    return null;
  }

  /**
   * True if a_class_name has a class definition in the model.
   * @return       Boolean
   * @param        className
   */
  public Boolean hasClassDefinition(String className)
  {
    //TODO
    return false;
  }

  /**
   * True if a_type_name is already concretely known in the system, including if it is generic,
   * which may be open, partially open or closed.
   * @return       Boolean
   * @param        typeName
   */
  public Boolean hasTypeDefinition(String typeName)
  {
    //TODO
    return false;
  }

  /**
   * Retrieve the enumeration definition corresponding to a_type_name.
   * @return       classes.BmmEnumeration
   * @param        name
   */
  public BmmEnumeration enumerationDefinition(String name)
  {
    //TODO
    return null;
  }

  /**
   * List of keys in class_definitions of items marked as primitive nl.rosa.semanticdatabase.bmm.model.types.
   * @return       List<String>
   */
  public List<String> primitiveTypes()
  {
    //TODO
    return null;
  }

  /**
   * List of keys in class_definitions of items that are enumeration nl.rosa.semanticdatabase.bmm.model.types.
   * @return       List<String>
   */
  public List<String> enumerationTypes()
  {
    //TODO
    return null;
  }

  /**
   * Retrieve the property definition for a_prop_name in flattened class
   * corresponding to a_type_name.
   * @return       class_features.BmmProperty
   */
  public BmmProperty propertyDefinition()
  {
    //TODO
    return null;
  }

  /**
   * True if a_ms_property_type is a valid 'MS' dynamic type for a_property in
   * BMM type a_bmm_type_name. 'MS' conformance means 'model-semantic' conformance,
   * which abstracts away container nl.rosa.semanticdatabase.bmm.model.types like List<>, Set<> etc
   * and compares the dynamic type with the relation target type in the UML sense,
   * i.e. regardless of whether there is single or multiple containment.
   * @return       Boolean
   * @param        bmmTypeName
   * @param        bmmPropertyName
   * @param        modelSemanticPropertyName
   */
  public Boolean modelSemanticConformantType(
          String bmmTypeName, String bmmPropertyName, String modelSemanticPropertyName)
  {
    //TODO
    return false;
  }

  /**
   * Retrieve the property definition for a_property_path in flattened class corresponding to a_type_name.
   * @return       class_features.BmmProperty
   */
  public BmmProperty propertyDefintionAtPath()
  {
    //TODO
    return null;
  }

  /**
   * Retrieve the class definition for the class that owns the terminal attribute in a_prop_path
   * in flattened class corresponding to a_type_name.
   * @return       classes.BmmClass
   * @param        typeName
   * @param        propertyPath
   */
  public BmmClass classDefintionAtPath(String typeName, String propertyPath)
  {
    //TODO
    return null;
  }

  /**
   * Return all ancestor nl.rosa.semanticdatabase.bmm.model.types of a_class_name up to root class (usually Any, Object or something similar).
   * Does not include current class. Returns empty list if none.
   * @return       List<String>
   * @param        aClass
   */
  public List<String> allAncestorClasses(String aClass)
  {
    //TODO
    return null;
  }

  /**
   * True if a_class_name is a descendant in the model of a_parent_class_name.
   * @return       Boolean
   * @param        className
   * @param        parentCLassName
   */
  public Boolean isDescendantOf(String className, String parentCLassName)
  {
    //TODO
    return false;
  }

  /**
   * Check conformance of a_desc_type to an_anc_type; the nl.rosa.semanticdatabase.bmm.model.types may be generic,
   * and may contain open generic parameters like 'T' etc.
   * These are replaced with their appropriate constrainer nl.rosa.semanticdatabase.bmm.model.types,
   * or Any during the conformance testing process.
   *
   * Conformance is found if:
   * * [base class test] nl.rosa.semanticdatabase.bmm.model.types are non-generic, and either type names are identical,
   *   or else a_desc_type has an_anc_type in its ancestors;
   * * both nl.rosa.semanticdatabase.bmm.model.types are generic and pass base class test; number of generic params matches,
   *   and each generic parameter type, after 'open parameter' substitution, recursively passes; type_name_conforms_to test
   * * descendant type is generic and ancestor type is not, and they pass base classes test.
   * @return       Boolean
   * @param        descType
   * @param        ancestorType
   */
  public Boolean typeConformsTo(String descType, String ancestorType)
  {
    //TODO
    return false;
  }


  /**
   * Generate type substitutions for the supplied type, which may be simple, generic
   * (closed, open or partially open), or a container type. In the generic and container cases,
   * the result is the permutation of the base class type and type substitutions of all
   * generic parameters.
   *
   * Parameters
   * a_type
   * Name of a type.
   * @return       List<String>
   * @param        aType
   */
  public List<String> subtypes(String aType)
  {
    //TODO
    return null;
  }


  /**
   * BMM_SIMPLE_CLASS instance for the Any class. This may be defined in the BMM schema,
   * but if not, use BMM_DEFINITIONS.any_class.
   */
  public BmmSimpleClass anyClassDefinition()
  {
    //TODO
    return null;
  }


  /**
   * BMM_SIMPLE_TYPE instance for the Any type.
   * @return       nl.rosa.semanticdatabase.bmm.model.types.BmmSimpleType
   */
  public BmmSimpleType anyTypeDefinition()
  {
    //TODO
    return null;
  }


  /**
   * @return       undef
   */
  public BmmSimpleType BooleanTypeDefinition()
  {
    //TODO
    return null;
  }

}
