package nl.rosa.semanticdatabase.bmm.types;

/**
 * 
 * Definition of a generic parameter in a class definition of a generic type.
 * 
*/
public interface BmmParameterType extends BmmUnitaryType {

/**
 * 
 * Name of the parameter, e.g.
 * 'T' etc.
 * The name is limited to 1 character and upper-case.
 * 
*/
String getName()
setName(var String)

/**
 * 
 * Optional conformance constraint that must be the name of a defined type.
 * 
*/
BmmEffectiveType getTypeConstraint()
setTypeConstraint(var BmmEffectiveType)

/**
 * 
 * If set, is the corresponding generic parameter definition in an ancestor class.
 * 
*/
BmmParameterType getInheritancePrecursor()
setInheritancePrecursor(var BmmParameterType)

}
