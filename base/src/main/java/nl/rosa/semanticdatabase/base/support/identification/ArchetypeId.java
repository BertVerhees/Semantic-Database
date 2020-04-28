package nl.rosa.semanticdatabase.base.support.identification;

import org.springframework.lang.Nullable;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Identifier for archetypes. Ideally these would identify globally unique archetypes.
Lexical form: rm_originator '-' rm_name '-' rm_entity '.' concept_name { '-' specialisation }* '.v' number.
 */
public class ArchetypeId extends ObjectId {
    @Nullable
    private String namespace;
    // Globally qualified reference model entity, e.g. openehr-EHR-OBSERVATION.
    @Nullable
    private String qualifiedRmEntity;
    // Name of the concept represented by this archetype, including specialisation, e.g. Biochemistry_result-cholesterol.
    @Nullable
    private String domainConcept;
    // Version of this archetype.
    @Nullable
    private String versionId;
    // Organisation originating the reference model on which this archetype is based, e.g. openehr, cen, hl7 .
    @Nullable
    private String rmOriginator;
    // Name of the reference model, e.g. rim, ehr_rm, en13606 .
    @Nullable
    private String rmName;
    // Name of the ontological level within the reference model to which this archetype is targeted, e.g. for openEHR, folder , composition , section , entry .
    @Nullable
    private String rmEntity;
    // Name of specialisation of concept, if this archetype is a specialisation of another archetype, e.g. cholesterol .
    @Nullable
    private String specialisation;

    private final static Pattern ArchetypeIdPattern = Pattern.compile("((?<namespace>.*)::)?(?<publisher>[^.-]*)-(?<package>[^.-]*)-(?<class>[^.-]*)\\.(?<concept>[^.]*)(-(?<specialisation>[^.]*))?(\\.v(?<version>.*))?");

    public ArchetypeId() {
    }

    /**
     * Parse the Archetype id from a string
     *
     * @param value
     */
    public ArchetypeId(String value) {

        parseValue(value);

        this.value = value;
    }

    private void parseValue(String value) {
        Matcher m = ArchetypeIdPattern.matcher(value);

        if (!m.matches()) {
            throw new IllegalArgumentException(value + " is not a valid archetype human readable id");
        }
        namespace = m.group("namespace");
        rmOriginator = m.group("publisher");
        rmName = m.group("package");
        rmEntity = m.group("class");
        buildQualifiedRmEntity();

        specialisation = m.group("specialisation");

        domainConcept = m.group("concept");
        versionId = m.group("version");
    }

    public void buildQualifiedRmEntity() {
        qualifiedRmEntity = rmOriginator + "-" + rmName + "-" + rmEntity;
    }

    /**
     * Constructor for creating the archetype id based on all fields separate in json
     *
     * @param qualifiedRmEntity
     * @param domainConcept
     * @param rmOriginator
     * @param rmName
     * @param rmEntity
     * @param specialisation
     * @param versionId
     */
    public ArchetypeId(String qualifiedRmEntity,
                       String domainConcept,
                       String rmOriginator,
                       String rmName,
                       String rmEntity,
                       String specialisation,
                       String versionId,
                       String value) {
        if (value != null) {
            parseValue(value);
            setValue(value);
        } else {
            this.qualifiedRmEntity = qualifiedRmEntity;
            this.domainConcept = domainConcept;
            this.rmOriginator = rmOriginator;
            this.rmName = rmName;
            this.rmEntity = rmEntity;
            this.specialisation = specialisation;
            this.versionId = versionId;
            setValue(getFullId());
        }

    }

    @RMPropertyIgnore
    public String getFullId() {
        StringBuilder result = new StringBuilder(30);
        if (namespace != null) {
            result.append(namespace);
            result.append("::");
        }
        result.append(rmOriginator);
        result.append("-");
        result.append(rmName);
        result.append("-");
        result.append(rmEntity);
        result.append(".");
        result.append(domainConcept);
        if (specialisation != null) {
            result.append("-");
            result.append(specialisation);
        }
        if (versionId == null) {
            return result.toString();
        } else if (versionId.startsWith("v")) {
            result.append(".");
        } else {
            result.append(".v");
        }
        result.append(versionId);
        return result.toString();
    }

    @RMPropertyIgnore
    public String getSemanticId() {
        StringBuilder result = new StringBuilder();
        if (namespace != null) {
            result.append(namespace);
            result.append("::");
        }
        result.append(rmOriginator);
        result.append("-");
        result.append(rmName);
        result.append("-");
        result.append(rmEntity);
        result.append(".");
        result.append(domainConcept);
        if (versionId == null) {
            return result.toString();
        } else if (versionId.startsWith("v")) {
            result.append(".");
        } else {
            result.append(".v");
        }
        result.append(versionId.split("\\.")[0]);
        return result.toString();

    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getQualifiedRmEntity() {
        return qualifiedRmEntity;
    }

    public void setQualifiedRmEntity(String qualifiedRmEntity) {
        this.qualifiedRmEntity = qualifiedRmEntity;
    }

    public String getDomainConcept() {
        return domainConcept;
    }

    public void setDomainConcept(String domainConcept) {
        this.domainConcept = domainConcept;
    }

    public String getRmOriginator() {
        return rmOriginator;
    }

    public void setRmOriginator(String rmOriginator) {
        this.rmOriginator = rmOriginator;
    }

    public String getRmName() {
        return rmName;
    }

    public void setRmName(String rmName) {
        this.rmName = rmName;
    }

    public String getRmEntity() {
        return rmEntity;
    }

    public void setRmEntity(String rmEntity) {
        this.rmEntity = rmEntity;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    public String getVersionId() {
        return versionId;
    }

    public void setVersionId(String versionId) {
        this.versionId = versionId;
    }

    @Override
    public String toString() {
        return getFullId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ArchetypeId that = (ArchetypeId) o;
        return Objects.equals(namespace, that.namespace) &&
                Objects.equals(qualifiedRmEntity, that.qualifiedRmEntity) &&
                Objects.equals(domainConcept, that.domainConcept) &&
                Objects.equals(rmOriginator, that.rmOriginator) &&
                Objects.equals(rmName, that.rmName) &&
                Objects.equals(rmEntity, that.rmEntity) &&
                Objects.equals(specialisation, that.specialisation) &&
                Objects.equals(versionId, that.versionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), namespace, qualifiedRmEntity, domainConcept, rmOriginator, rmName, rmEntity, specialisation, versionId);
    }
}