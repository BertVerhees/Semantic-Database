package nl.rosa.semanticdatabase.bmmcontroller.model_access;

/**
 * Enumeration of processing states of a BMM_SCHEMA used by creation and validation routines in BMM_SCHEMA.
 * Default created on 11-5-2020
 */

public enum BmmSchemaState {
    /**
     * Initial state directly after instantiation of schema.
     */
    State_Created,
    /**
     * Initial validation pass after instantiation.
     */
    State_Validated_Created,
    /**
     * State of schema processing if there are still included schemas to process.
     */
    State_Includes_Pending,
    /**
     * State when all included schemas have been processed.
     */
    State_Includes_Processed
}
