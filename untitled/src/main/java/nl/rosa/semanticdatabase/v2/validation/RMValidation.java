package nl.rosa.semanticdatabase.referencemodel.v2.validation;

import nl.rosa.semanticdatabase.message.MessageLogger;
import nl.rosa.semanticdatabase.referencemodel.v2.persistence.PRMSchema;

/**
 * A single BMM Validation
 */
public interface RMValidation {

    public void validate(RMValidationResult RMValidationResult, RMRepository RMRepository, MessageLogger logger, PRMSchema schema);
}
