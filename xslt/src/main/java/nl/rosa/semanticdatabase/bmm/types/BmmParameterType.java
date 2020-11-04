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
    void setName(String value);

/**
 * 
 * Optional conformance constraint that must be the name of a defined type.
 * 
*/
    BmmEffectiveType getTypeConstraint();
    void setTypeConstraint(BmmEffectiveType value);

/**
 * 
 * If set, is the corresponding generic parameter definition in an ancestor class.
 * 
*/
    BmmParameterType getInheritancePrecursor();
    void setInheritancePrecursor(BmmParameterType value);

/* * FUNCTION * */

/**
 * 
 * Result is either conforms_to_type or inheritance_precursor.flattened_conforms_to_type.
 * 
*/
    BmmEffectiveType  flattened_conforms_to_type();

/**
 * 
 * Signature form of the open type, including constrainer type if there is one, e.g.
 * T:Ordered.
 * 
*/
    String  type_signature();

/**
 * 
 * Result = False - generic parameters are understood by definition to be non-primitive.
 * 
*/
    Boolean  is_primitive();

/**
 * 
 * Result = False - generic parameters are understood by definition to be non-abstract.
 * 
*/
    Boolean  is_abstract();

/**
 * 
 * Return name.
 * 
*/
    String  type_name();

/**
 * 
 * Result is either flattened_conforms_to_type.flattened_type_list or the Any type.
 * 
*/
    List<String>  flattened_type_list();

/**
 * 
 * Generate ultimate conformance type, which is either flattened_conforms_to_type or if not set, 'Any'.
 * 
*/
    BmmEffectiveType  effective_type();

/* * CONSTANTS * */

}
