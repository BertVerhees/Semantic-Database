package nl.rosa.semanticdatabase.bmm_persistence.persistence_package;

/**
 * 
 * Persistent form of BMM_PROPERTY.
 * 
*/
public interface PBmmProperty extends PBmmModelElement {

/* * ATTRIBUTE * */

/**
 * 
 * Name of this property within its class.
 * Persisted attribute.
 * 
*/
     getName();
    void setName( value);

/**
 * 
 * True if this property is mandatory in its class.
 * Persisted attribute.
 * 
*/
     getIsMandatory();
    void setIsMandatory( value);

/**
 * 
 * True if this property is computed rather than stored in objects of this class.
 * Persisted Attribute.
 * 
*/
     getIsComputed();
    void setIsComputed( value);

/**
 * 
 * True if this property is info model 'infrastructure' rather than 'data'.
 * Persisted attribute.
 * 
*/
     getIsImInfrastructure();
    void setIsImInfrastructure( value);

/**
 * 
 * True if this property is info model 'runtime' settable property.
 * Persisted attribute.
 * 
*/
     getIsImRuntime();
    void setIsImRuntime( value);

/**
 * 
 * Type definition of this property, if not a simple String type reference.
 * Persisted attribute.
 * 
*/
     getTypeDef();
    void setTypeDef( value);

/**
 * 
 * BMM_PROPERTY created by create_bmm_property_definition.
 * 
*/
     getBmmProperty();
    void setBmmProperty( value);

/* * FUNCTION * */

/**
 * 
 * Create bmm_property_definition from P_BMM_XX parts.
 * 
*/
      create_bmm_property();

}
