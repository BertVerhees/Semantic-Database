package nl.rosa.semanticdatabase.bmmdata.services.persistence_model;

import lombok.Getter;
import lombok.Setter;
import nl.rosa.semanticdatabase.bmmdata.services.model_access.data.BmmIncludeSpec;

import java.util.Map;
import java.util.Set;

/**
 * Default created on 31-7-2020
 */

public class BmmSchema extends nl.rosa.semanticdatabase.bmmdata.services.model_access.data.BmmSchema implements BmmPackageContainer {

    /**
     * 1..1
     * packages: Hash<String, P_BMM_PACKAGE>
     * Package structure as a hierarchy of packages each potentially containing names of classes in that package in the original model.
     * (inherits from BmmPackageContainer)
     */
    @Getter
    @Setter
    private Map<String, nl.rosa.semanticdatabase.bmmdata.domain.model_structure.BmmPackage> packages;

    /**
     * 0..1
     * (redefined)
     * primitive_types: List<P_BMM_CLASS>
     * Primitive type definitions. Persisted attribute.
     */
    @Getter
    @Setter
    private Set<BmmClass> primitiveTypes;
    /**
     * 0..1
     * (redefined)
     * class_definitions: List<P_BMM_CLASS>
     * Class definitions. Persisted attribute.
     */
    @Getter
    @Setter
    private Set<BmmClass> classDefinitions;
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
}
