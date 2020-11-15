package nl.rosa.semanticdatabase.;

/**
 * 
 * #Generated: 2020-11-15T18:16:51.043+01:00
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
    stateCreated,

/**
 * 
 * Initial validation pass after instantiation.
 * 
*/
    stateValidatedCreated,

/**
 * 
 * State of schema processing if there are still included schemas to process.
 * 
*/
    stateIncludesPending,

/**
 * 
 * State when all included schemas have been processed.
 * 
*/
    stateIncludesProcessed

}
