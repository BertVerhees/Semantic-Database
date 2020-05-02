package nl.rosa.semanticdatabase.referencemodel.v2.validation;

import nl.rosa.semanticdatabase.message.MessageLogger;
import nl.rosa.semanticdatabase.referencemodel.v2.persistence.PSchema;
import nl.rosa.semanticdatabase.referencemodel.v2.validation.validators.*;


/**
 * Class that has methods for all available BMM schema validations.
 * Objects are for single use only, to validate one P_BMM schema
 */
public class SchemaValidator {

    private final Repository repository;
    private MessageLogger logger;

    public SchemaValidator(Repository repository) {
        this.repository = repository;
        logger = new MessageLogger();
    }

    public void validateSchemaAfterMergeOfIncludes(ValidationResult result) {
        run(new BasicSchemaValidations(), result, result.getSchemaWithMergedIncludes());
        run(new ClassesValidator(), result, result.getSchemaWithMergedIncludes());
    }

    /**
     * do some basic validation post initial creation
     * 1. check that package structure is regular:
     *     a) only top-level packages can have qualified names
     *     b) no top-level package name can be a direct parent or child of another
     *     (child package must be declared under the parent)
     * 2. check that all classes are mentioned in the package structure
     * 3. check that all models refer to valid packages
     */
    public void validateCreated(ValidationResult validationResult, PSchema schema) {
        run(new CreatedSchemaValidation(), validationResult, schema);
    }

    public void validateBmmVersion(ValidationResult validationResult, PSchema schema) {
        run(new VersionValidation(), validationResult, schema);
    }

    public void validateIncludes(ValidationResult validationResult, PSchema schema) {
        run(new IncludesValidation(), validationResult, schema);
    }

    private void run(Validation validation, ValidationResult validationResult, PSchema schema) {
        validation.validate(validationResult, repository, logger, schema);
    }

    public MessageLogger getLogger() {
        return logger;
    }


    /**
     * Throw a BmmSchemaValidationException in case any errors were encountered in any previously run validations
     * @throws SchemaValidationException
     */
    public void checkNoExceptions() throws SchemaValidationException {

        if(logger.hasErrors()) {
            throw new SchemaValidationException(logger);
        }
    }

}
