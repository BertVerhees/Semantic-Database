package nl.rosa.semanticdatabase.referencemodel.v2.validation.validators;

import nl.rosa.semanticdatabase.message.MessageLogger;
import nl.rosa.semanticdatabase.referencemodel.persistence.validation.MessageIds;
import nl.rosa.semanticdatabase.referencemodel.v2.persistence.PRMSchema;
import nl.rosa.semanticdatabase.referencemodel.v2.persistence.RMIncludeSpec;
import nl.rosa.semanticdatabase.referencemodel.v2.validation.RMRepository;
import nl.rosa.semanticdatabase.referencemodel.v2.validation.RMValidation;
import nl.rosa.semanticdatabase.referencemodel.v2.validation.RMValidationResult;

public class IncludesValidation implements RMValidation {
    @Override
    public void validate(RMValidationResult validationResult, RMRepository repository, MessageLogger logger, PRMSchema schema) {
        if(schema.getIncludes() != null) {
            for(RMIncludeSpec includeSpec:schema.getIncludes().values()) {
                if (!repository.containsPersistentSchema(includeSpec.getId())) {
                    logger.addError(MessageIds.EC_INCLUDE_NOT_FOUND, schema.getSchemaId(), includeSpec.getId());
                }
            }
        }
    }
}
