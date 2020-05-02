package nl.rosa.semanticdatabase.referencemodel.v2.validation;

import nl.rosa.semanticdatabase.message.MessageLogger;
import nl.rosa.semanticdatabase.referencemodel.v2.persistence.PSchema;

/**
 * A single BMM Validation
 */
public interface Validation {

    public void validate(ValidationResult validationResult, Repository repository, MessageLogger logger, PSchema schema);
}
