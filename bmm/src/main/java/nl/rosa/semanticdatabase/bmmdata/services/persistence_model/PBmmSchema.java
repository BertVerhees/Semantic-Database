package nl.rosa.semanticdatabase.bmmdata.services.persistence_model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import nl.rosa.semanticdatabase.bmmdata.services.model_access.data.BmmIncludeSpec;
import nl.rosa.semanticdatabase.bmmdata.services.model_access.data.BmmSchema;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Default created on 31-7-2020
 */

public class PBmmSchema extends BmmSchema implements PBmmPackageContainer {

    /**
     * 1..1
     * packages: Hash<String, P_BMM_PACKAGE>
     * Package structure as a hierarchy of packages each potentially containing names of classes in that package in the original model.
     * (********  inherits from PBmmPackageContainer)
     */
    @Getter
    @Setter
    @NonNull
    private Map<String, PBmmPackage> packages = new HashMap<>();

    /**
     * 0..1
     * (redefined)
     * primitive_types: List<P_BMM_CLASS>
     * Primitive type definitions. Persisted attribute.
     */
    @Getter
    @Setter
    private Set<PBmmClass> primitiveTypes;
    /**
     * 0..1
     * (redefined)
     * class_definitions: List<P_BMM_CLASS>
     * Class definitions. Persisted attribute.
     */
    @Getter
    @Setter
    private Set<PBmmClass> classDefinitions;
    /**
     * 0..1
     * (redefined)
     * includes: Hash<String,BMM_INCLUDE_SPEC>
     * Inclusion list, in the form of a hash of individual include specifications, each of which at least specifies
     * the id of another schema, and may specify a namespace via which types from the included schemas are known
     * in this schema. Persisted attribute.
     */
    @Getter
    @Setter
    private Map<String, BmmIncludeSpec> includes;
    //==============================================================================================================
    /**
     * 0..1
     * (effected)
     * validate_created
     * Pre_state: state = State_created
     * Post_state: passed implies state = State_validated_created
     * Implementation of validate_created()
     */
    public void validateCreated(){

    }

    /**
     * 0..1
     * (effected)
     * load_finalise
     * Pre_state: state = State_validated_created
     * Post_state: state = State_includes_processed or state = State_includes_pending
     * Implementation of load_finalise()
     */
    public void loadFinalise(){

    }

    /**
     * 0..1
     * (effected)
     * merge ( * other: P_BMM_SCHEMA[1] * )
     * Pre_state: state = State_includes_pending
     * Pre_other_valid: includes_to_process.has (included_schema.schema_id)
     * Implementation of merge()
     */
    public void merge(BmmSchema schema){

    }

    /**
     * 0..1
     * (effected)
     * validate
     * Implementation of validate()
     */
    public void validate(){

    }

    /**
     * 0..1
     * (effected)
     * create_bmm_model
     * Pre_state: state = P_BMM_PACKAGE_STATE.State_includes_processed
     * Implementation of create_bmm_model()
     */
    public void createBmmModel(){

    }

    /**
     * 1..1
     * canonical_packages (): P_BMM_PACKAGE
     * Package structure in which all top-level qualified package names like xx.yy.zz have been expanded out
     * to a hierarchy of BMM_PACKAGE objects.
     * @return
     */
    public PBmmPackage canonicalPackages (){
        return null;
    }

}
