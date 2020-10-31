package nl.rosa.semanticdatabase.bmm_persistence.persistence_package;

/**
 * 
 * Persistent form of BMM_CONTAINER_PROPERTY.
 * 
*/
public interface PBmmContainerProperty extends PBmmProperty {

/* * ATTRIBUTE * */

/**
 * 
 * Cardinality of this property in its class.
 * Persistent attribute.
 * 
*/
    PBmmContainerProperty getCardinality();
    void setCardinality(PBmmContainerProperty value);

/**
 * 
 * Type definition of this property, if not a simple String type reference.
 * Persistent attribute.
 * 
*/
    PBmmContainerProperty getTypeDef();
    void setTypeDef(PBmmContainerProperty value);

/**
 * 
 * BMM_PROPERTY created by create_bmm_property.
 * 
*/
    PBmmContainerProperty getBmmProperty();
    void setBmmProperty(PBmmContainerProperty value);

/* * FUNCTION * */

/**
 * 
 * Create bmm_property_definition.
 * 
*/
    PBmmContainerProperty  create_bmm_property();

}
