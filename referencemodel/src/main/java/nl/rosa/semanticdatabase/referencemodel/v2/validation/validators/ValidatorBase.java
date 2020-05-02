package nl.rosa.semanticdatabase.referencemodel.v2.validation.validators;

import nl.rosa.semanticdatabase.message.MessageCode;
import nl.rosa.semanticdatabase.message.MessageDescriptor;
import nl.rosa.semanticdatabase.message.MessageLogger;
import nl.rosa.semanticdatabase.message.MessageSeverity;
import nl.rosa.semanticdatabase.referencemodel.persistence.validation.MessageIds;
import nl.rosa.semanticdatabase.referencemodel.v2.persistence.PSchema;

public abstract class ValidatorBase {

    protected MessageLogger logger;

    public ValidatorBase(MessageLogger logger) {
        this.logger = logger;
    }

    public ValidatorBase() {}

    public void setLogger(MessageLogger logger) {
        this.logger = logger;
    }

    /**
     * append an error with key `a_key' and `args' array to the `errors' string to the
     * error list for schema with `a_schema_id'
     *  @param schema
     * @param aKey
     * @param sourceSchemaId
     * @param arguments
     */
    protected void addValidityError(PSchema schema, String sourceSchemaId, MessageCode aKey, Object... arguments) {
        if(sourceSchemaId.equals(schema.getSchemaId())) {
            logger.addError(aKey, arguments);
        } else {
            //addSchemaErrorTableIfNotExists(sourceSchemaId);
            //schemaErrorTableCache.get(sourceSchemaId).addErrorWithLocation(aKey, "", arguments);
            MessageDescriptor messageDescriptor = new MessageDescriptor(aKey, MessageSeverity.ERROR, aKey.getMessage(arguments), null);
            logger.addError(MessageIds.ec_INCERR2, schema.getSchemaId(), sourceSchemaId, messageDescriptor.getMessage());
        }
    }
}
