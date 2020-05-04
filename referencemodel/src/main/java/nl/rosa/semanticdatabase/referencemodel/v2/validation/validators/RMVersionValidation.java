package nl.rosa.semanticdatabase.referencemodel.v2.validation.validators;


import nl.rosa.semanticdatabase.message.MessageLogger;
import nl.rosa.semanticdatabase.referencemodel.persistence.validation.MessageIds;
import nl.rosa.semanticdatabase.referencemodel.persistence.validation.RMDefinitions;
import nl.rosa.semanticdatabase.referencemodel.v2.persistence.PRMSchema;
import nl.rosa.semanticdatabase.referencemodel.v2.validation.RMRepository;
import nl.rosa.semanticdatabase.referencemodel.v2.validation.RMValidation;
import nl.rosa.semanticdatabase.referencemodel.v2.validation.RMValidationResult;

public class RMVersionValidation implements RMValidation {
    @Override
    public void validate(RMValidationResult validationResult, RMRepository repository, MessageLogger logger, PRMSchema schema) {
        if (!RMDefinitions.isVersionCompatible(schema.getRmVersion())) {
            logger.addError(MessageIds.EC_INCOMPATIBLE_BMM_VERSION,
                    schema.getSchemaId(),
                    schema.getRmVersion(),
                    RMDefinitions.BMM_INTERNAL_VERSION);
        }
    }
}
