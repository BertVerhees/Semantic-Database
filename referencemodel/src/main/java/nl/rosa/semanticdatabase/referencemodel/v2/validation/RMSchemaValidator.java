package nl.rosa.semanticdatabase.referencemodel.v2.validation;

import nl.rosa.semanticdatabase.message.MessageLogger;
import nl.rosa.semanticdatabase.referencemodel.v2.persistence.PRMSchema;
import nl.rosa.semanticdatabase.referencemodel.v2.validation.validators.*;


/**
 * Class that has methods for all available BMM schema validations.
 * Objects are for single use only, to validate one P_BMM schema
 */
public class RMSchemaValidator {

    private final RMRepository rmRepository;
    private MessageLogger logger;

    public RMSchemaValidator(RMRepository RMRepository) {
        this.rmRepository = RMRepository;
        logger = new MessageLogger();
    }

    public void validateSchemaAfterMergeOfIncludes(RMValidationResult result) {
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
    public void validateCreated(RMValidationResult RMValidationResult, PRMSchema schema) {
        run(new CreatedSchemaValidation(), RMValidationResult, schema);
    }

    public void validateRMVersion(RMValidationResult rmValidationResult, PRMSchema schema) {
        run(new RMVersionValidation(), rmValidationResult, schema);
    }

    public void validateIncludes(RMValidationResult rmValidationResult, PRMSchema schema) {
        run(new IncludesValidation(), rmValidationResult, schema);
    }

    private void run(RMValidation validation, RMValidationResult RMValidationResult, PRMSchema schema) {
        validation.validate(RMValidationResult, rmRepository, logger, schema);
    }

    public MessageLogger getLogger() {
        return logger;
    }


    /**
     * Throw a BmmSchemaValidationException in case any errors were encountered in any previously run validations
     * @throws RMSchemaValidationException
     */
    public void checkNoExceptions() throws RMSchemaValidationException {

        if(logger.hasErrors()) {
            throw new RMSchemaValidationException(logger);
        }
    }

}
