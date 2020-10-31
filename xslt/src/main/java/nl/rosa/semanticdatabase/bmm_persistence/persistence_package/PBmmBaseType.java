package nl.rosa.semanticdatabase.bmm_persistence.persistence_package;

/**
 * 
 * Persistent form of BMM_PROPER_TYPE.
 * 
*/
public interface PBmmBaseType extends PBmmType {

/* * ATTRIBUTE * */

/**
 * 
 * 
 * 
*/
    PBmmBaseType getValueConstraint();
    void setValueConstraint(PBmmBaseType value);

/* * FUNCTION * */

}
