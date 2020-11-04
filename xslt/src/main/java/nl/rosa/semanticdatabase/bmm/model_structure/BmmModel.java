package nl.rosa.semanticdatabase.bmm.model_structure;

/**
 * 
 * Definition of the root of a BMM model (along with what is inherited from BMM_SCHEMA_CORE).
 * 
*/
public interface BmmModel extends BmmPackageContainer,BmmModelMetadata {

/* * ATTRIBUTE * */

/**
 * 
 * All classes in this model, keyed by type name.
 * 
*/
    Map<String,BmmClass> getClassDefinitions();
    void setClassDefinitions(Map<String,BmmClass> value);

/**
 * 
 * List of other models 'used' (i.e.
 * 'imported' by this model).
 * Classes in the current model may refer to classes in a used model by specifying the other class’s scope meta-attribute.
 * 
*/
    List<BmmModel> getUsedModels();
    void setUsedModels(List<BmmModel> value);

/* * FUNCTION * */

/**
 * 
 * Identifier of this model, lower-case, formed from: <rm_publisher>_<model_name>_<rm_release> E.g.
 * "openehr_ehr_1.0.4".
 * 
*/
    String  model_id();

/**
 * 
 * Retrieve the class definition corresponding to a_type_name (which may contain a generic part).
 * 
*/
    BmmClass  class_definition();

/**
 * 
 * Retrieve the class definition corresponding to a_type_name.
 * If it contains a generic part, this will be removed if it is a fully open generic name, otherwise it will remain intact, i.e.
 * if it is an effective generic name that identifies a BMM_GENERIC_CLASS_EFFECTIVE.
 * 
*/
    BmmClass  type_definition();

/**
 * 
 * True if a_class_name has a class definition in the model.
 * 
*/
    Boolean  has_class_definition();

/**
 * 
 * True if a_type_name is already concretely known in the system, including if it is generic, which may be open, partially open or closed.
 * 
*/
    Boolean  has_type_definition();

/**
 * 
 * Retrieve the enumeration definition corresponding to a_type_name.
 * 
*/
    BmmEnumeration  enumeration_definition();

/**
 * 
 * List of keys in class_definitions of items marked as primitive types.
 * 
*/
    List<String>  primitive_types();

/**
 * 
 * List of keys in class_definitions of items that are enumeration types.
 * 
*/
    List<String>  enumeration_types();

/**
 * 
 * Retrieve the property definition for a_prop_name in flattened class corresponding to a_type_name.
 * 
*/
    BmmProperty  property_definition();

/**
 * 
 * True if a_ms_property_type is a valid 'MS' dynamic type for a_property in BMM type a_bmm_type_name.
 * 'MS' conformance means 'model-semantic' conformance, which abstracts away container types like List<>, Set<> etc and compares the dynamic type with the relation target type in the UML sense, i.e.
 * regardless of whether there is single or multiple containment.
 * 
*/
    Boolean  ms_conformant_property_type();

/**
 * 
 * Retrieve the property definition for a_property_path in flattened class corresponding to a_type_name.
 * 
*/
    BmmProperty  property_definition_at_path();

/**
 * 
 * Retrieve the class definition for the class that owns the terminal attribute in a_prop_path in flattened class corresponding to a_type_name.
 * 
*/
    BmmClass  class_definition_at_path();

/**
 * 
 * Return all ancestor types of a_class_name up to root class (usually Any, Object or something similar).
 * Does not include current class.
 * Returns empty list if none.
 * 
*/
    List<String>  all_ancestor_classes();

/**
 * 
 * True if a_class_name is a descendant in the model of a_parent_class_name.
 * 
*/
    Boolean  is_descendant_of();

/**
 * 
 * Check conformance of a_desc_type to an_anc_type; the types may be generic, and may contain open generic parameters like 'T' etc.
 * These are replaced with their appropriate constrainer types, or Any during the conformance testing process.
 * Conformance is found if: [base class test] types are non-generic, and either type names are identical, or else a_desc_type has an_anc_type in its ancestors; both types are generic and pass base class test; number of generic params matches, and each generic parameter type, after 'open parameter' substitution, recursively passes; type_name_conforms_to test descendant type is generic and ancestor type is not, and they pass base classes test.
 * 
*/
    Boolean  type_conforms_to();

/**
 * 
 * Generate type substitutions for the supplied type, which may be simple, generic (closed, open or partially open), or a container type.
 * In the generic and container cases, the result is the permutation of the base class type and type substitutions of all generic parameters.
 * Parameters a_type Name of a type.
 * 
*/
    List<String>  subtypes();

/**
 * 
 * BMM_SIMPLE_CLASS instance for the Any class.
 * This may be defined in the BMM schema, but if not, use BMM_DEFINITIONS.any_class.
 * 
*/
    BmmSimpleClass  any_class_definition();

/**
 * 
 * BMM_SIMPLE_TYPE instance for the Any type.
 * 
*/
    BmmSimpleType  any_type_definition();

/**
 * 
 * BMM_SIMPLE_TYPE instance for the Boolean type.
 * 
*/
    BmmSimpleType  boolean_type_definition();

/* * CONSTANTS * */

}
