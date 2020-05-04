package nl.rosa.semanticdatabase.referencemodel.v2.validation;

import org.openehr.utils.message.MessageLogger;

public class RMSchemaValidationException extends Exception {
    public RMSchemaValidationException(MessageLogger logger) {
        super(logger.toString());
    }
}
