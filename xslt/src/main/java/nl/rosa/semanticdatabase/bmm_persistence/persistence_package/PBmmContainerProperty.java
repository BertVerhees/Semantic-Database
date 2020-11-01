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
     getCardinality();
    void setCardinality( value);

/**
 * 
 * Type definition of this property, if not a simple String type reference.
 * Persistent attribute.
 * 
*/
    PBmmContainerType getTypeDef();
    void setTypeDef(PBmmContainerType value);

/**
 * 
 * BMM_PROPERTY created by create_bmm_property.
 * 
*/
    BmmContainerProperty getBmmProperty();
    void setBmmProperty(BmmContainerProperty value);

/* * FUNCTION * */

/**
 * 
 * Create bmm_property_definition.
 * 
*/
      create_bmm_property();

}
