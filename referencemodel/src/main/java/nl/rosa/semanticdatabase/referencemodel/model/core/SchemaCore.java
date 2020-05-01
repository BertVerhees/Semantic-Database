package nl.rosa.semanticdatabase.referencemodel.model.core;

/**
 * Default created on 1-5-2020
 */

public interface SchemaCore {
    public String getSchemaId();

    /**
     * Returns the name of this model, if this schema is a model root point. Not set for sub-schemas that are not considered models on their own.
     */
}
