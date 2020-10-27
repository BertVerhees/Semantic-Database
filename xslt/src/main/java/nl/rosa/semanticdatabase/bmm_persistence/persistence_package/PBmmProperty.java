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
    void setName(value String);

/**
 * 
 * True if this property is mandatory in its class.
 * Persisted attribute.
 * 
*/
    Boolean getIsMandatory();
    void setIsMandatory(value Boolean);

/**
 * 
 * True if this property is computed rather than stored in objects of this class.
 * Persisted Attribute.
 * 
*/
    Boolean getIsComputed();
    void setIsComputed(value Boolean);

/**
 * 
 * True if this property is info model 'infrastructure' rather than 'data'.
 * Persisted attribute.
 * 
*/
    Boolean getIsImInfrastructure();
    void setIsImInfrastructure(value Boolean);

/**
 * 
 * True if this property is info model 'runtime' settable property.
 * Persisted attribute.
 * 
*/
    Boolean getIsImRuntime();
    void setIsImRuntime(value Boolean);

/**
 * 
 * Type definition of this property, if not a simple String type reference.
 * Persisted attribute.
 * 
*/
    PBmmType getTypeDef();
    void setTypeDef(value PBmmType);

/**
 * 
 * BMM_PROPERTY created by create_bmm_property_definition.
 * 
*/
    BmmProperty getBmmProperty();
    void setBmmProperty(value BmmProperty);

/* * FUNCTION * */

/**
 * 
 * Create bmm_property_definition from P_BMM_XX parts.
 * create_bmm_property ( a_bmm_schema: BMM_MODEL[1], a_class_def: BMM_CLASS[1] )
 * 
*/
    void createBmmProperty ( aBmmSchema: bmmModel[1], aClassDef: bmmClass[1] );

}
