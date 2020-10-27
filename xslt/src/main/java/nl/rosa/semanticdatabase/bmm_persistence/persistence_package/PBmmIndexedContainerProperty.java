package nl.rosa.semanticdatabase.bmm_persistence.persistence_package;

/**
 * 
 * 
 * 
*/
public interface PBmmIndexedContainerProperty extends PBmmContainerProperty {

/* * ATTRIBUTE * */

/**
 * 
 * Type definition of this property, if not a simple String type reference.
 * Persistent attribute.
 * 
*/
    PBmmIndexedContainerProperty getTypeDef();
    void setTypeDef(value PBmmIndexedContainerProperty);

/**
 * 
 * BMM_PROPERTY created by create_bmm_property.
 * 
*/
    PBmmIndexedContainerProperty getBmmProperty();
    void setBmmProperty(value PBmmIndexedContainerProperty);

/* * FUNCTION * */

}
