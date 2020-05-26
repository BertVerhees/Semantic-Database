package nl.rosa.semanticdatabase.referencemodel.core;

import lombok.Getter;
import lombok.Setter;
import nl.rosa.semanticdatabase.referencemodel.persistence.validation.RMDefinitions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Default created on 1-5-2020
 */

@Getter
@Setter
public class RMSchemaCoreImpl implements RMSchemaCore, Serializable {
    @Override
    public String getSchemaId() {
        return RMDefinitions.createSchemaId(rmPublisher, schemaName, rmRelease);
    }

    /**
     * Method adds a top-level package paths that provide the RM 'model' part in achetype identifiers, e.g. the path
     * "org.openehr.ehr" gives "EHR" in "openEHR-EHR". Within this namespace, archetypes can be based on any class reachable from classes defined directly in these packages.
     *
     * @param rmClosurePackage
     */
    public void addArchetypeRmClosurePackage(String rmClosurePackage) {
        archetypeRmClosurePackages.add(rmClosurePackage);
    }
    public void addSchemaContributor(String aContributor) {
        this.schemaContributors.add(aContributor);
    }


    public RMSchemaCoreImpl() {
        schemaContributors = new ArrayList<>();
        archetypeRmClosurePackages = new ArrayList<>();
    }

    public RMSchemaCoreImpl(String rmPublisher, String rmRelease, String schemaName) {
        this();
        this.rmPublisher = rmPublisher;
        this.rmRelease = rmRelease;
        this.schemaName = schemaName;
    }

    /**
     * Returns the publisher of model expressed in the schema.
     *
     * @return
     */
    private String rmPublisher;
    /**
     * Returns the release of model expressed in the schema as a 3-part numeric, e.g. "3.1.0" .
     *
     * @return
     */
    private String rmRelease;
    /**
     * Returns the name of model expressed in schema; a 'schema' usually contains all of the packages of one 'model'
     * of a publisher. A publisher with more than one model can have multiple schemas. Persisted attribute.
     *
     * @return
     */
    private String schemaName;
    /**
     * Returns the revision of schema.
     *
     * @return
     */
    private String schemaRevision;
    /**
     * Returns the lifecycle state of the schema.
     *
     * @return
     */
    private String schemaLifecycleState;
    /**
     * Returns the primary author of schema.
     *
     * @return
     */
    private String schemaAuthor;
    /**
     * Returns the description of schema.
     *
     * @return
     */
    private String schemaDescription;
    /**
     * Returns the contributing authors of schema.
     *
     * @return
     */
    private List<String> schemaContributors;

    /**
     * Returns the name of a parent class used within the schema to provide archetype capability, enabling filtering of
     * classes in RM visualisation. If empty, 'Any' is assumed. Persisted attribute.
     *
     * @return
     */
    private String archetypeParentClass;
    /**
     * Returns the name of a parent class of logical 'data nl.rosa.semanticdatabase.bmm.model.types' used within the schema to provide archetype capability, enabling
     * filtering of classes in RM visualisation. If empty, 'Any' is assumed. Persisted attribute.
     *
     * @return
     */
    private String archetypeDataValueParentClass;
    /**
     * List of top-level package paths that provide the RM 'model' part in archetype identifiers, e.g. the path "org.openehr.ehr"
     * gives "EHR" in "openEHR-EHR". Within this namespace, archetypes can be based on any class reachable from classes defined directly in these packages.
     *
     * @return
     */
    private List<String> archetypeRmClosurePackages;

    /**
     * Method returns a class whose descendants should be made visible in tree and grid renderings of the archetype
     * definition, if archetype_parent_class is not set, designate . For openEHR and CEN this class is normally the
     * same as the archetype_parent_class, i.e. LOCATABLE and RECORD_COMPONENT respectively. It is typically set for CEN,
     * because archetype_parent_class may not be stated, due to demographic nl.rosa.semanticdatabase.bmm.model.types not inheriting from it.
     *
     * @return
     */
    private String archetypeVisualizeDescendantsOf;

    /**
     * Returns the name of this model, if this schema is a model root point. Not set for sub-schemas that are not considered models on their own.
     */
    private String modelName;
}
