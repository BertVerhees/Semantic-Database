package nl.rosa.semanticdatabase.referencemodel.v2.persistence;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;
import nl.rosa.semanticdatabase.referencemodel.persistence.validation.RMDefinitions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

@JsonPropertyOrder({"reference_model_version",
    "rm_publisher",
    "schema_name",
    "rm_release",
    "model_name",
    "schema_revision",
    "schema_lifecycle_state",
    "schema_description",
    "schema_author",
    "archetype_closure_packages",
    "archetype_parent_class",
    "archetype_data_value_parent_class",
    "archetype_visualize_descendants_of",
    "includes",
    "packages",
    "primitive_types",
    "class_definitions"

})
@Getter
@Setter
public final class PRMSchema extends PRMPackageContainer {

    private Map<String, PRMClass> primitiveTypes;
    private Map<String, PRMClass> classDefinitions;
    private Map<String, RMIncludeSpec> includes;

    private String rmPublisher;
    private String rmRelease;
    private String rmVersion;
    private String modelName;
    private String schemaName;
    private String schemaRevision;
    private String schemaLifecycleState;
    private String schemaAuthor;
    private String schemaDescription;
    private List<String> schemaContributors;

    /** this is present in older BMM files, so must be supported here */
    @Deprecated
    private List<String> archetypeRmClosurePackages;

    //these fields are now stored in the Archetype Profile files, and are
    //deprecated here - included mainly to be able to parse older P_BMM files.
    @Deprecated
    private String archetypeParentClass;
    @Deprecated
    private String archetypeDataValueParentClass;
    @Deprecated
    private String archetypeVisualizeDescendantsOf;

    public Map<String, PRMClass> getPrimitiveTypes() {
        if(primitiveTypes == null) {
            primitiveTypes = new CaseInsensitiveLinkedHashMap<>();
        }
        return primitiveTypes;
    }

    public Map<String, PRMClass> getClassDefinitions() {
        if(classDefinitions == null) {
            classDefinitions = new CaseInsensitiveLinkedHashMap<>();
        }
        return classDefinitions;
    }

    public Map<String, RMIncludeSpec> getIncludes() {
        if(includes == null) {
            includes = new CaseInsensitiveLinkedHashMap<>();
        }
        return includes;
    }

    @Deprecated
    public List<String> getArchetypeRmClosurePackages() {
        if(archetypeRmClosurePackages == null) {
            archetypeRmClosurePackages = new ArrayList();
        }
        return archetypeRmClosurePackages;
    }

    @Deprecated
    public void setArchetypeRmClosurePackages(List<String> archetypeRmClosurePackages) {
        this.archetypeRmClosurePackages = archetypeRmClosurePackages;
    }

    public String getArchetypeParentClass() {
        return archetypeParentClass;
    }

    public void setArchetypeParentClass(String archetypeParentClass) {
        this.archetypeParentClass = archetypeParentClass;
    }

    public String getArchetypeDataValueParentClass() {
        return archetypeDataValueParentClass;
    }

    public void setArchetypeDataValueParentClass(String archetypeDataValueParentClass) {
        this.archetypeDataValueParentClass = archetypeDataValueParentClass;
    }

    @JsonAlias({"archetype_visualise_descendants_of"})
    public String getArchetypeVisualizeDescendantsOf() {
        return archetypeVisualizeDescendantsOf;
    }

    public void setArchetypeVisualizeDescendantsOf(String archetypeVisualizeDescendantsOf) {
        this.archetypeVisualizeDescendantsOf = archetypeVisualizeDescendantsOf;
    }

    @JsonIgnore
    public String getSchemaId() {
        return RMDefinitions.createSchemaId(getRmPublisher(), getSchemaName(), getRmRelease());
    }

    public boolean hasClassOrPrimitiveDefinition(String persistedBmmClass) {
        return getClassDefinitions().containsKey(persistedBmmClass) || getPrimitiveTypes().containsKey(persistedBmmClass);
    }

    /**
     * Finds class either among class definitions or primitive definitions in case primitives are used directly as nl.rosa.semanticdatabase.bmm.types.
     *
     * @param className
     * @return
     */
    public PRMClass findClassOrPrimitiveDefinition(String className) {
        PRMClass clasz = getClassDefinitions().get(className);
        if (clasz == null) {
            clasz = getPrimitiveTypes().get(className);
        }
        return clasz;
    }

    public PRMClass getClassDefinition(String className) {
        return classDefinitions.get(className);
    }

    /**
     * Do some action to all primitive type and class objects
     * process in any order
     *
     * @param action
     */
    public void doAllClasses(Consumer<PRMClass> action) {
        getPrimitiveTypes().values().forEach(action);
        getClassDefinitions().values().forEach(action);
    }
}
