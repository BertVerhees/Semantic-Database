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
    PBmmSingleProperty getType();
    void setType(PBmmSingleProperty value);

/**
 * 
 * Type definition of this property computed from type for later use in bmm_property.
 * 
*/
    PBmmSingleProperty getTypeRef();
    void setTypeRef(PBmmSingleProperty value);

/**
 * 
 * BMM_PROPERTY created by create_bmm_property_definition.
 * 
*/
    PBmmSingleProperty getBmmProperty();
    void setBmmProperty(PBmmSingleProperty value);

/* * FUNCTION * */

/**
 * 
 * Generate type_ref from type and save.
 * 
*/
    PBmmSingleProperty  type_def();

}
