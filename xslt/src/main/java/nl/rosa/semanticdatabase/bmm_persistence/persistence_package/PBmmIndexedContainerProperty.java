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
    PBmmIndexedContainerType getTypeDef();
    void setTypeDef(PBmmIndexedContainerType value);

/**
 * 
 * BMM_PROPERTY created by create_bmm_property.
 * 
*/
    BmmIndexedContainerProperty getBmmProperty();
    void setBmmProperty(BmmIndexedContainerProperty value);

/* * FUNCTION * */

/* * CONSTANTS * */

}
