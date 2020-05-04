package nl.rosa.semanticdatabase.referencemodel.v2.validation;


import nl.rosa.semanticdatabase.referencemodel.core.RMModel;
import nl.rosa.semanticdatabase.referencemodel.persistence.validation.RMDefinitions;
import nl.rosa.semanticdatabase.referencemodel.persistence.validation.MessageIds;
import nl.rosa.semanticdatabase.referencemodel.v2.persistence.PRMPackage;
import nl.rosa.semanticdatabase.referencemodel.v2.persistence.PRMSchema;
import nl.rosa.semanticdatabase.referencemodel.v2.validation.converters.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Converts a Persisted BMM Schema into a computable BMM Model. Validates the schema along the way. Returns a
 * BmmValidationResult, which contains the source PBmmSchema, the converted BmmModel, plus any validation info, warning
 * and error messages from the validation and conversion process.
 * This does not change the PBmmSchema objects, unlike the Eiffel implementation and the P_BMM specifications,
 * all state information is stored in the BmmValidationResult instead.
 *
 * One BmmSchemaConverter can be reused for conversion of multiple schemas. Not thread-safe.
 */
public class RMSchemaConverter {

    private static final Logger logger = LoggerFactory.getLogger(RMSchemaConverter.class);

    private final RMRepository RMRepository;
    /**
     * package structure in which all top-level qualified package names like xx.yy.zz have been
     * expanded out to a hierarchy of BMM_PACKAGE objects
     */
    private RMSchemaValidator RMSchemaValidator;

    /**
     * Create the BmmSchemaConverter for the given BmmRepository. The given BmmRepository will be used as the source
     * for any included schemas
     * @param RMRepository The BmmRepository for use as a source of included Bmm schemas
     */
    public RMSchemaConverter(RMRepository RMRepository) {
        this.RMRepository = RMRepository;
        RMSchemaValidator = new RMSchemaValidator(RMRepository);
    }

    /**
     * validate the P_BMM schema. If validation succeeds, convert the schema to a BMM Model.
     * Side effects: will add the BmmValidationResult to the repository. Will also add the BmmValidationResult of all
     * included BmmValidationResult to the repository, recursively
     * @param schema the P_BMM schema to convert.
     * @return the BmmValidationResult that contains the origina PBmmSchema, any validation results, and if validation
     *          succeeded, the converted BmmModel.
     */
    public RMValidationResult validateConvertAndAddToRepo(PRMSchema schema) {
        //clear error messages
        RMSchemaValidator = new RMSchemaValidator(RMRepository);

        logger.info("loading " + schema.getSchemaId());

        RMValidationResult result = new RMValidationResult();
        result.setLogger(RMSchemaValidator.getLogger());
        result.setSchemaId(schema.getSchemaId());
        result.setOriginalSchema(schema);
        try {
            //Step 1: run validations that can be run on the persisted file format
            //validate some basics of the schema: check that everything defined in tje packages part appears in classes
            //and the other way around
            RMSchemaValidator.validateCreated(result, schema);
            RMSchemaValidator.checkNoExceptions();

            //Check that this P_BMM file has a version compatible with this library
            RMSchemaValidator.validateBmmVersion(result, schema);
            RMSchemaValidator.checkNoExceptions();
            //validate that includes exist
            RMSchemaValidator.validateIncludes(result, schema);
            RMSchemaValidator.checkNoExceptions();

            //convert some maps into case insensitive ones, to make some lookups case insensitive
            //this keeps the original casing, just the lookup is different
            new PreprocessPersistedSchema().preprocess(schema);

            //step 2: create canonical packages (org.openehr.ehr becomes org -> openehr -> ehr)
            Map<String, PRMPackage> canonicalPackages = new CanonicalPackagesGenerator().generateCanonicalPackages(schema);
            result.setCanonicalPackages(canonicalPackages);

            //and process included schemas, storing a clone of the original schema in the BmmValidationResult
            //this step also validates and converts any included schemas, storing the result in the repository
            new IncludesProcessor().cloneSchemaAndAddIncludes(result, RMRepository, RMSchemaValidator.getLogger());
            RMSchemaValidator.checkNoExceptions();

            //step 3: validate the merged schema, including the includes
            RMSchemaValidator.validateSchemaAfterMergeOfIncludes(result);
            RMSchemaValidator.checkNoExceptions();

            //step 4: create model
            RMModel RMModel = new RMModelCreator().create(result);

            RMSchemaValidator.checkNoExceptions();

            //set the descendants and ancestors properties
            new DescendantsCalculator().calculateDescendants(RMModel);
            result.setRMModel(RMModel);

            //add the model and closure to the repository, but only if no errors
            createModelsByClosureAndVersion(result);

            return result;
        } catch (RMSchemaValidationException ex) {
            //cannot continue on validation error
            return result;
        } finally {
            //add the result to the repo, even in case of errors
            RMRepository.addModel(result);
        }
    }

    /**
     * Convert and validate all schemas in the repository. Stores the results in the repository
     */
    public void validateAndConvertRepository() {
        for(PRMSchema schema: RMRepository.getPersistentSchemas()) {
            if(RMRepository.getModel(schema.getSchemaId()) == null) {
                RMValidationResult RMValidationResult = validateConvertAndAddToRepo(schema);
            }
        }
    }

    private void createModelsByClosureAndVersion(RMValidationResult RMValidationResult) {
        RMModel RMModel = RMValidationResult.getRMModel();
        List<String> rmClosures = new ArrayList<>();
        String schemaId = RMModel.getSchemaId();
        String modelPublisher = RMModel.getRmPublisher();
        String modelName = RMModel.getModelName();
        if(modelName != null) {
            addClosure(schemaId, RMValidationResult, modelPublisher, modelName);
        } else {
            //possibly old style BMM, test
            for(String closureName: RMModel.getArchetypeRmClosurePackages()) {
                addClosure(schemaId, RMValidationResult, modelPublisher, closureName);
            }
        }
    }

    private void addClosure(String schemaId, RMValidationResult RMValidationResult, String modelPublisher, String modelName) {
        String qualifiedRmClosureName = RMDefinitions.publisherQualifiedRmClosureName(modelPublisher, modelName) + "_" + RMValidationResult.getRMModel().getRmRelease();
        RMValidationResult existingSchema = RMRepository.getModelByClosure(qualifiedRmClosureName);
        if (existingSchema != null) {
            RMSchemaValidator.getLogger().addInfo(MessageIds.ec_schema_duplicate_found,
                    qualifiedRmClosureName,
                    existingSchema.getSchemaId(),
                    schemaId);
        } else {
            RMRepository.addModelByClosure(qualifiedRmClosureName, RMValidationResult);
        }

    }


}
