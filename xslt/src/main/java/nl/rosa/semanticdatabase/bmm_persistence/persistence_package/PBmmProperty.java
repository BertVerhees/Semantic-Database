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
    PBmmProperty getName();
    void setName(PBmmProperty value);

/**
 * 
 * True if this property is mandatory in its class.
 * Persisted attribute.
 * 
*/
    PBmmProperty getIsMandatory();
    void setIsMandatory(PBmmProperty value);

/**
 * 
 * True if this property is computed rather than stored in objects of this class.
 * Persisted Attribute.
 * 
*/
    PBmmProperty getIsComputed();
    void setIsComputed(PBmmProperty value);

/**
 * 
 * True if this property is info model 'infrastructure' rather than 'data'.
 * Persisted attribute.
 * 
*/
    PBmmProperty getIsImInfrastructure();
    void setIsImInfrastructure(PBmmProperty value);

/**
 * 
 * True if this property is info model 'runtime' settable property.
 * Persisted attribute.
 * 
*/
    PBmmProperty getIsImRuntime();
    void setIsImRuntime(PBmmProperty value);

/**
 * 
 * Type definition of this property, if not a simple String type reference.
 * Persisted attribute.
 * 
*/
    PBmmProperty getTypeDef();
    void setTypeDef(PBmmProperty value);

/**
 * 
 * BMM_PROPERTY created by create_bmm_property_definition.
 * 
*/
    PBmmProperty getBmmProperty();
    void setBmmProperty(PBmmProperty value);

/* * FUNCTION * */

/**
 * 
 * Create bmm_property_definition from P_BMM_XX parts.
 * 
*/
    PBmmProperty  create_bmm_property();

}
