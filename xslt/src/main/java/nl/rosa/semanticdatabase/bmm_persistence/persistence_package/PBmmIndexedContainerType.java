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
    String getIndexType();
    void setIndexType(value String);

/**
 * 
 * Result of create_bmm_type() call.
 * 
*/
    PBmmIndexedContainerType getBmmType();
    void setBmmType(value PBmmIndexedContainerType);

/* * FUNCTION * */

}
