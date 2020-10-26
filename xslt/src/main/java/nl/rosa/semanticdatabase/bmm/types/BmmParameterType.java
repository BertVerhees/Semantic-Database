package nl.rosa.semanticdatabase.bmm.types;

/**
 * 
 * Definition of a generic parameter in a class definition of a generic type.
 * 
*/
public interface BmmParameterType extends BmmUnitaryType {

/* * ATTRIBUTE * */

/**
 * 
 * Name of the parameter, e.g.
 * 'T' etc.
 * The name is limited to 1 character and upper-case.
 * 
*/
String getName();
void setName(value String);

/**
 * 
 * Optional conformance constraint that must be the name of a defined type.
 * 
*/
BmmEffectiveType getTypeConstraint();
void setTypeConstraint(value BmmEffectiveType);

/**
 * 
 * If set, is the corresponding generic parameter definition in an ancestor class.
 * 
*/
BmmParameterType getInheritancePrecursor();
void setInheritancePrecursor(value BmmParameterType);

/* * FUNCTION * */

/**
 * 
 * Result is either conforms_to_type or inheritance_precursor.flattened_conforms_to_type.
 * flattened_conforms_to_type (): BMM_EFFECTIVE_TYPE
 * 
*/
BmmEffectiveType flattenedConformsToType ();

/**
 * 
 * Signature form of the open type, including constrainer type if there is one, e.g.
 * T:Ordered.
 * type_signature (): String
 * 
*/
String typeSignature ();

/**
 * 
 * Result = False - generic parameters are understood by definition to be non-primitive.
 * is_primitive (): Boolean
 * 
*/
Boolean isPrimitive ();

/**
 * 
 * Result = False - generic parameters are understood by definition to be non-abstract.
 * is_abstract (): Boolean
 * 
*/
Boolean isAbstract ();

/**
 * 
 * Return name.
 * type_name (): String
 * 
*/
String typeName ();

/**
 * 
 * Result is either flattened_conforms_to_type.flattened_type_list or the Any type.
 * flattened_type_list (): List<String>
 * 
*/
List<string> flattenedTypeList ();

/**
 * 
 * Generate ultimate conformance type, which is either flattened_conforms_to_type or if not set, 'Any'.
 * effective_type (): BMM_EFFECTIVE_TYPE
 * 
*/
BmmEffectiveType effectiveType ();

}
