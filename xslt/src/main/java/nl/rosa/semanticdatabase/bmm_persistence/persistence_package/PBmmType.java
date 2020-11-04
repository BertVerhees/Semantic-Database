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
    BmmType getBmmType();
    void setBmmType(BmmType value);

/* * FUNCTION * */

/**
 * 
 * Create appropriate BMM_XXX object; effected in descendants.
 * 
*/
    void  create_bmm_type();

/**
 * 
 * Formal name of the type for display.
 * 
*/
    String  as_type_string();

/* * CONSTANTS * */

}
