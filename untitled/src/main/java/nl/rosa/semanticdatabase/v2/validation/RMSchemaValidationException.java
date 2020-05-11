package nl.rosa.semanticdatabase.referencemodel.v2.validation;

import nl.rosa.semanticdatabase.message.MessageLogger;

public class RMSchemaValidationException extends Exception {
    public RMSchemaValidationException(MessageLogger logger) {
        super(logger.toString());
    }
}
