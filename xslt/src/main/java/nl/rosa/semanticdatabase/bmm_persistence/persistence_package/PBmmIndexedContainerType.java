package nl.rosa.semanticdatabase.bmm_persistence.persistence_package;

/**
 * 
 * 
 * 
*/
public interface PBmmIndexedContainerType extends PBmmContainerType {

/* * ATTRIBUTE * */

/**
 * 
 * 
 * 
*/
    PBmmIndexedContainerType getIndexType();
    void setIndexType(value PBmmIndexedContainerType);

/**
 * 
 * Result of create_bmm_type() call.
 * 
*/
    PBmmIndexedContainerType getBmmType();
    void setBmmType(value PBmmIndexedContainerType);

/* * FUNCTION * */

}
