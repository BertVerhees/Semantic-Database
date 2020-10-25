package nl.rosa.semanticdatabase.bmm_persistence.persistence_package;

/**
 * 
 * Persistent form of BMM_SINGLE_PROPERTY.
 * 
*/
public interface PBmmSingleProperty extends PBmmProperty {

/* * ATTRIBUTE * */

/**
 * 
 * If the type is a simple type, then this attribute will hold the type name.
 * If the type is a container or generic, then type_ref will hold the type definition.
 * The resulting type is generated in type_def.
 * 
*/
String getType();
void setType(var String);

/**
 * 
 * Type definition of this property computed from type for later use in bmm_property.
 * 
*/
PBmmSimpleType getTypeRef();
void setTypeRef(var PBmmSimpleType);

/**
 * 
 * BMM_PROPERTY created by create_bmm_property_definition.
 * 
*/
BmmUnitaryProperty getBmmProperty();
void setBmmProperty(var BmmUnitaryProperty);

/* * FUNCTION * */

/**
 * 
 * Generate type_ref from type and save.
 * type_def (): P_BMM_SIMPLE_TYPE
 * 
*/

}
