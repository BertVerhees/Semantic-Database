package nl.rosa.semanticdatabase.bmm_persistence.persistence_package;

/**
 * 
 * Persistent form of BMM_PARAMETER_TYPE.
 * 
*/
public interface PBmmOpenType extends PBmmBaseType {

/* * ATTRIBUTE * */

/**
 * 
 * Simple type parameter as a single letter like 'T', 'G' etc.
 * 
*/
    PBmmOpenType getType();
    void setType(PBmmOpenType value);

/**
 * 
 * Result of create_bmm_type() call.
 * 
*/
    PBmmOpenType getBmmType();
    void setBmmType(PBmmOpenType value);

/* * FUNCTION * */

}
