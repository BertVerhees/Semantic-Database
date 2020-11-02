package nl.rosa.semanticdatabase.;

/**
 * 
 * Enumeration of processing states of a BMM_SCHEMA used by creation and validation routines in BMM_SCHEMA.
 * 
*/
public enum BmmSchemaState {

/**
 * 
 * Initial state directly after instantiation of schema.
 * 
*/
    State_created,

/**
 * 
 * Initial validation pass after instantiation.
 * 
*/
    State_validated_created,

/**
 * 
 * State of schema processing if there are still included schemas to process.
 * 
*/
    State_includes_pending,

/**
 * 
 * State when all included schemas have been processed.
 * 
*/
    State_includes_processed

}
