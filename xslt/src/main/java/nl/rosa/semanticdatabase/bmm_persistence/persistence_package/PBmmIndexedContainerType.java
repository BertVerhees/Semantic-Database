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
    void setIndexType(String value);

/**
 * 
 * Result of create_bmm_type() call.
 * 
*/
    BmmIndexedContainerType getBmmType();
    void setBmmType(BmmIndexedContainerType value);

/* * FUNCTION * */

/* * CONSTANTS * */

}
