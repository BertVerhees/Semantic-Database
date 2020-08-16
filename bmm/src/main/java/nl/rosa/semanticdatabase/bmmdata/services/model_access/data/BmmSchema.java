package nl.rosa.semanticdatabase.bmmdata.services.model_access.data;

import lombok.*;
import nl.rosa.semanticdatabase.bmmdata.domain.classes.BmmClass;
import nl.rosa.semanticdatabase.bmmdata.domain.model_structure.BmmModel;
import nl.rosa.semanticdatabase.bmmdata.domain.model_structure.BmmPackageContainer;
import nl.rosa.semanticdatabase.bmmdata.services.persistence_model.PBmmPackage;
import nl.rosa.semanticdatabase.bmmdata.services.persistence_model.PBmmSchema;

import java.util.*;

/**
 * Default created on 6-6-2020
 */
@NoArgsConstructor
public abstract class BmmSchema implements BmmModelMetadata {

    /**
     * BmmModelMetadata
     */
    private String rmPublisher;

    private String rmRelease;

    /**
     * 1..1
     * bmm_version: String
     * Version of BMM model, enabling schema evolution reasoning. Persisted attribute.
     */
    @NonNull
    @Getter
    @Setter
    private String bmmVersion;

    /**
     * 0..1
     * includes: Hash<String,BMM_INCLUDE_SPEC>
     * Inclusion list, in the form of a hash of individual include specifications,
     * each of which at least specifies the id of another schema,
     * and may specify a namespace via which types from the included schemas are known in this schema.
     * Persisted attribute.
     */
    @Getter
    @Setter
    private Map<String, BmmIncludeSpec> includes;

    public BmmSchema addBmmIncludeSpec(BmmIncludeSpec includeSpec) {
        if (includes == null) {
            includes = new HashMap<>();
        }
        this.includes.put(includeSpec.getBmmId(), includeSpec);
        return this;
    }

    public BmmSchema addBmmIncludeSpecs(Set<BmmIncludeSpec> includesSet) {
        includesSet.forEach(include -> this.addBmmIncludeSpec(include));
        return this;
    }

    public BmmSchema removeBmmIncludeSpec(BmmIncludeSpec includeSpec) {
        if (includes != null) {
            this.includes.remove(includeSpec.getBmmId());
        }
        return this;
    }

    public BmmSchema removeBmmIncludeSpecs(Set<BmmIncludeSpec> includesSet) {
        includesSet.forEach(include -> this.removeBmmIncludeSpec(include));
        return this;
    }

    public Optional<Map<String, BmmIncludeSpec>> getBmmIncludeSpecs() {
        if(includes!=null){
            return Optional.of(Collections.unmodifiableMap(includes));
        }else{
            return Optional.empty();
        }
    }

    /**
     * 0..1
     * bmm_model: BMM_MODEL
     * Generated by create_bmm_model from persisted elements.
     */
    @Getter
    private BmmModel bmmModel;

    /**
     * 1..1
     * state: BMM_SCHEMA_STATE
     * Current processing state.
     */
    @NonNull
    @Getter
    private BmmSchemaState state;

    /**
     * 0..1
     * model_name: String
     * Name of this model, if this schema is a model root point.
     * Not set for sub-schemas that are not considered models on their own.
     */
    @Getter
    @Setter
    private String modelName;

    /**
     * 1..1
     * schema_name: String
     * Name of model expressed in schema; a 'schema' usually contains all of the packages of one 'model' of a publisher.
     * A publisher with more than one model can have multiple schemas.
     */
    @NonNull
    @Getter
    @Setter
    private String schemaName;

    /**
     * 1..1
     * schema_revision: String
     * Revision of schema.
     */
    @NonNull
    @Getter
    @Setter
    private String schemaRevision;

    /**
     * 1..1
     * schema_lifecycle_state: String
     * Schema development lifecycle state.
     */
    @NonNull
    @Getter
    @Setter
    private String schemaLifecycleState;

    /**
     * 1..1
     * schema_author: String
     * Primary author of schema.
     */
    @NonNull
    @Getter
    @Setter
    private String schemaAuthor;

    /**
     * 1..1
     * schema_description: String
     * Description of schema.
     */
    @NonNull
    @Getter
    @Setter
    private String schemaDescription;

    /**
     * 0..1
     * schema_contributors: List<String>
     * Contributing authors of schema.
     */
    private Set<String> schemaContributors;
    public Optional<Set<String>> getSchemaContributors() {
        if(schemaContributors!=null){
            return Optional.of(Collections.unmodifiableSet(schemaContributors));
        }else{
            return Optional.empty();
        }
    }

    public BmmSchema setSchemaContributors(Set<String> schemaContributors) {
        this.schemaContributors = schemaContributors;
        return this;
    }

    public BmmSchema addSchemaContributor(String schemaContributors) {
        if(this.schemaContributors==null){
            this.schemaContributors = new HashSet<>();
        }
        this.schemaContributors.add(schemaContributors);
        return this;
    }

    public BmmSchema addSchemaContributors(Set<String> schemaContributors) {
        if(this.schemaContributors==null){
            schemaContributors = new HashSet<>();
        }
        this.schemaContributors.addAll(schemaContributors);
        return this;
    }

    public BmmSchema removeSchemaContributor(String schemaContributors) {
        if(this.schemaContributors!=null) {
            this.schemaContributors.remove(schemaContributors);
        }
        return this;
    }

    public BmmSchema removeSchemaContributors(Set<String> schemaContributors) {
        if(this.schemaContributors!=null) {
            this.schemaContributors.removeAll(schemaContributors);
        }
        return this;
    }


    //==================================================================

    /**
     * 0..1
     * (abstract)
     * validate_created
     * Pre_state: state = State_created
     * Post_state: passed implies state = State_validated_created
     * Do some basic validation post initial creation
     * check that package structure is regular:
     * only top-level packages can have qualified names
     * no top-level package name can be a direct parent or child of another (child package must be declared under the parent)
     * check that all classes are mentioned in the package structure
     * check that all models refer to valid packages
     */
    public abstract void validateCreated();

    /**
     * 0..1
     * (abstract)
     * load_finalise
     * Pre_state: state = State_validated_created
     * Post_state: state = State_includes_processed or state = State_includes_pending
     * Finalisation work:
     * convert packages to canonical form, i.e. full hierarchy with no packages with names like aa.bb.cc
     * set up include processing list
     */
    public abstract void loadFinalise();

    /**
     * 0..1
     * (abstract)
     * merge ( * other: BMM_SCHEMA[1] * )
     * Pre_state: state = State_includes_pending
     * Pre_other_valid: includes_to_process.has (included_schema.schema_id)
     * Merge in class and package definitions from other, except where the current schema already has a definition for the given type or package.
     */
    public abstract void merge(@NonNull BmmSchema schema);

    /**
     * 0..1
     * (abstract)
     * validate
     * Main validation prior to generation of bmm_model.
     */
    public abstract void validate();

    /**
     * 0..1
     * (effected)
     * create_bmm_model
     * Pre_state: state = P_BMM_PACKAGE_STATE.State_includes_processed
     * Implementation of create_bmm_model()
     */
    public abstract void createBmmModel();

    /**
     * 1..1
     * read_to_validate (): Boolean
     * Post_state: state = State_includes_processed
     * True when validation may be commenced.
     * @return
     */
    public Boolean readToValidate (){
        return null;
    }

    /**
     * 1..1
     *
     * schema_id (): String
     * Identifier of this schema, used for stating inclusions and identifying files. Formed as:
     * {BMM_DEFINITIONS}.create_schema_id( rm_publisher, schema_name, rm_release)
     * E.g. 'openehr_rm_ehr_1.0.4'.
     * @return
     */
    public String schemaId(){
        return null;
    }
}
