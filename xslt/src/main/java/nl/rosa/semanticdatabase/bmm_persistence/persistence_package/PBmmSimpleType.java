package nl.rosa.semanticdatabase.bmm_persistence.persistence_package;

/**
 * 
 * Persistent form of BMM_SIMPLE_TYPE.
 * 
*/
public interface PBmmSimpleType extends PBmmBaseType {

/* * ATTRIBUTE * */

/**
 * 
 * Name of type - must be a simple class name.
 * 
*/
    String getType();
    void setType(value String);

/**
 * 
 * Result of create_bmm_type() call.
 * 
*/
    BmmSimpleType getBmmType();
    void setBmmType(value BmmSimpleType);

/* * FUNCTION * */

}
