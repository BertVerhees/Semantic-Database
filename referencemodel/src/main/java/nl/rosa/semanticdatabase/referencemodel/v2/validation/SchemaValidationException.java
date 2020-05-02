package nl.rosa.semanticdatabase.referencemodel.v2.validation;

import org.openehr.utils.message.MessageLogger;

public class SchemaValidationException extends Exception {
    public SchemaValidationException(MessageLogger logger) {
        super(logger.toString());
    }
}
