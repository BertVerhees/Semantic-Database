package nl.rosa.semanticdatabase.referencemodel.v2.validation;

import lombok.Getter;
import lombok.Setter;
import nl.rosa.semanticdatabase.message.MessageLogger;
import nl.rosa.semanticdatabase.referencemodel.core.RMModel;
import nl.rosa.semanticdatabase.referencemodel.v2.persistence.PRMPackage;
import nl.rosa.semanticdatabase.referencemodel.v2.persistence.PRMSchema;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * The result of validating a PBmmSchema  and converting it to a BmmModel. Contains:
 * - the original schema in persisted format
 * - the schema in persisted format, with all included other schemas merged in
 * - the resulting BmmModel. Null if the originalSchema contained validation errors that make conversion impossible.
 * - the messageLogger containing any info, warning and debug messages during validation and conversion
 * - the schema ids that have been merged in
 * - the schema ids that should have been merged in, but failed to merge
 */
@Getter
@Setter
public class RMValidationResult {

    //input from file
    /** The schema ID of the original schema */
    private String schemaId;
    /** The original schema in persisted format */
    private PRMSchema originalSchema;

    //all fields below are the result from validating and conversion
    /** a MessageLogger that any validation errors, but also information about the conversion process */
    private MessageLogger logger;
    /** The resulting BmmModel, if convesion was successful. Null otherwise.*/
    private RMModel RMModel;

    /** The PBmmSchema that contains both the orignalSchema, and all classes and packages from included schemas */
    private PRMSchema schemaWithMergedIncludes;

    /**
     * packages in canonical format, so never "org.openehr.ehr", but "org" -> "openehr" -> "ehr"
     */
    private Map<String, PRMPackage> canonicalPackages = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    /**
     * Schemas that have been merged into schemaWithMergedIncludes
     */
    private List<String> mergedSchemas = new ArrayList<>();

    /**
     * Schemas that have failed to merge into schemaWithMergedIncludes
     */
    private List<String> failedMergedSchemas = new ArrayList<>();

    public boolean passes() {
        return logger == null || !logger.hasErrors();
    }

    public void addMergedSchema(String schemaId) {
        mergedSchemas.add(schemaId);
    }

    public void addFailedMerge(String schemaId) {
        this.failedMergedSchemas.add(schemaId);
    }

}
