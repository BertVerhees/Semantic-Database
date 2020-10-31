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
    PBmmSimpleType getType();
    void setType(PBmmSimpleType value);

/**
 * 
 * Result of create_bmm_type() call.
 * 
*/
    PBmmSimpleType getBmmType();
    void setBmmType(PBmmSimpleType value);

/* * FUNCTION * */

}
