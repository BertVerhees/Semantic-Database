package nl.rosa.semanticdatabase.bmmdata.model_access;

/**
 * Default created on 6-6-2020
 */

public enum BmmSchemaState {
    /**
     * Initial state directly after instantiation of schema.
     */
    STATE_CREATED,
    /**
     * Initial validation pass after instantiation.
     */
    STATE_VALIDATED_CREATED,
    /**
     * State of schema processing if there are still included schemas to process.
     */
    STATE_INCLUDES_PENDING,
    /**
     * State when all included schemas have been processed.
     */
    STATE_INCLUDES_PROCESSED
}
