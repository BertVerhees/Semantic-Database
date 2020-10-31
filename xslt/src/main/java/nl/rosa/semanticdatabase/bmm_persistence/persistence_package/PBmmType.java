package nl.rosa.semanticdatabase.bmm_persistence.persistence_package;

/**
 * 
 * Persistent form of BMM_TYPE.
 * 
*/
public interface PBmmType {

/* * ATTRIBUTE * */

/**
 * 
 * Result of create_bmm_type() call.
 * 
*/
    PBmmType getBmmType();
    void setBmmType(PBmmType value);

/* * FUNCTION * */

/**
 * 
 * Create appropriate BMM_XXX object; effected in descendants.
 * 
*/
    PBmmType  create_bmm_type();

/**
 * 
 * Formal name of the type for display.
 * 
*/
    PBmmType  as_type_string();

}
