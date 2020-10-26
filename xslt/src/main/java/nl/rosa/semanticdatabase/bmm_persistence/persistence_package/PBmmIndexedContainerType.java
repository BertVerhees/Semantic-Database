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
BmmIndexedContainerType getBmmType();
void setBmmType(value BmmIndexedContainerType);

/* * FUNCTION * */

}
