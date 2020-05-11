package nl.rosa.semanticdatabase.referencemodel.bmm.model_structure;

import lombok.Data;
import nl.rosa.semanticdatabase.referencemodel.bmm.class_features.BmmProperty;
import nl.rosa.semanticdatabase.referencemodel.bmm.classes.BmmClass;
import nl.rosa.semanticdatabase.referencemodel.bmm.classes.BmmEnumeration;
import nl.rosa.semanticdatabase.referencemodel.bmm.classes.BmmSimpleClass;
import nl.rosa.semanticdatabase.referencemodel.bmm.model_access.BmmModelMetadata;
import nl.rosa.semanticdatabase.referencemodel.bmm.types.BmmSimpleType;

import java.util.List;


/**
 * Class BmmModel
 */
@Data
public class BmmModel implements BmmPackageContainer, BmmModelMetadata {

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
   * @return       boolean
   * @param        className
   */
  public boolean hasClassDefinition(String className)
  {
    //TODO
    return false;
  }

  /**
   * True if a_type_name is already concretely known in the system, including if it is generic,
   * which may be open, partially open or closed.
   * @return       boolean
   * @param        typeName
   */
  public boolean hasTypeDefinition(String typeName)
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
   * List of keys in class_definitions of items marked as primitive types.
   * @return       List<String>
   */
  public List<String> primitiveTypes()
  {
    //TODO
    return null;
  }

  /**
   * List of keys in class_definitions of items that are enumeration types.
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
   * which abstracts away container types like List<>, Set<> etc
   * and compares the dynamic type with the relation target type in the UML sense,
   * i.e. regardless of whether there is single or multiple containment.
   * @return       boolean
   * @param        bmmTypeName
   * @param        bmmPropertyName
   * @param        modelSemanticPropertyName
   */
  public boolean modelSemanticConformantType(
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
   * Return all ancestor types of a_class_name up to root class (usually Any, Object or something similar).
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
   * @return       boolean
   * @param        className
   * @param        parentCLassName
   */
  public boolean isDescendantOf(String className, String parentCLassName)
  {
    //TODO
    return false;
  }

  /**
   * Check conformance of a_desc_type to an_anc_type; the types may be generic,
   * and may contain open generic parameters like 'T' etc.
   * These are replaced with their appropriate constrainer types,
   * or Any during the conformance testing process.
   *
   * Conformance is found if:
   * * [base class test] types are non-generic, and either type names are identical,
   *   or else a_desc_type has an_anc_type in its ancestors;
   * * both types are generic and pass base class test; number of generic params matches,
   *   and each generic parameter type, after 'open parameter' substitution, recursively passes; type_name_conforms_to test
   * * descendant type is generic and ancestor type is not, and they pass base classes test.
   * @return       boolean
   * @param        descType
   * @param        ancestorType
   */
  public boolean typeConformsTo(String descType, String ancestorType)
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
   * @return       types.BmmSimpleType
   */
  public BmmSimpleType anyTypeDefinition()
  {
    //TODO
    return null;
  }


  /**
   * @return       undef
   */
  public BmmSimpleType booleanTypeDefinition()
  {
    //TODO
    return null;
  }


}
