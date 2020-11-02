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
    String getName();
    void setName(String value);

/**
 * 
 * True if this property is mandatory in its class.
 * Persisted attribute.
 * 
*/
    Boolean getIsMandatory();
    void setIsMandatory(Boolean value);

/**
 * 
 * True if this property is computed rather than stored in objects of this class.
 * Persisted Attribute.
 * 
*/
    Boolean getIsComputed();
    void setIsComputed(Boolean value);

/**
 * 
 * True if this property is info model 'infrastructure' rather than 'data'.
 * Persisted attribute.
 * 
*/
    Boolean getIsImInfrastructure();
    void setIsImInfrastructure(Boolean value);

/**
 * 
 * True if this property is info model 'runtime' settable property.
 * Persisted attribute.
 * 
*/
    Boolean getIsImRuntime();
    void setIsImRuntime(Boolean value);

/**
 * 
 * Type definition of this property, if not a simple String type reference.
 * Persisted attribute.
 * 
*/
    PBmmType getTypeDef();
    void setTypeDef(PBmmType value);

/**
 * 
 * BMM_PROPERTY created by create_bmm_property_definition.
 * 
*/
    BmmProperty getBmmProperty();
    void setBmmProperty(BmmProperty value);

/* * FUNCTION * */

/**
 * 
 * Create bmm_property_definition from P_BMM_XX parts.
 * 
*/
    void  create_bmm_property();

}
