package nl.rosa.semanticdatabase.referencemodel.core;

import lombok.Getter;
import lombok.Setter;
import nl.rosa.semanticdatabase.referencemodel.persistence.validation.RMBasicDefinitions;
import nl.rosa.semanticdatabase.referencemodel.persistence.validation.RMDefinitions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Default created on 29-4-2020
 */

@Getter
@Setter
public class RMModel extends RMPackageContainerImpl implements RMSchemaCore, RMPackageContainer, Serializable {

    private Map<String, RMClass> classDefinitions;
    private RMSchemaCore RMSchemaCore;

    @Override
    public String getSchemaId() {
        return null;
    }

    /**
     * Retrieve the class definition corresponding to `a_type_name' (which may contain a generic part) or null
     * if the class is not found.
     *
     * @param bmmClassName
     * @return
     */
    public RMClass getClassDefinition(String bmmClassName) {
        return this.classDefinitions.get(bmmClassName.toUpperCase());
    }

    public void addClassDefinition(RMClass bmmClassDefinition) {
        this.classDefinitions.put(bmmClassDefinition.getName().toUpperCase(), bmmClassDefinition);
    }

    public void addClassDefinition(RMClass bmmClassDefinition, RMPackage RMPackageDefinition) {
        if(getClassDefinition(bmmClassDefinition.getName()) == null) {// && recursiveHasPackage(packageDefinition)) {
            addClassDefinition(bmmClassDefinition);
            RMPackageDefinition.addClass(bmmClassDefinition);
            bmmClassDefinition.set_RM_package(RMPackageDefinition);
            bmmClassDefinition.setRMModel(this);
        }
    }

    /**
     * List of keys in `class_definitions' of items marked as primitive types, as defined in input schema.
     *
     * Note: no caching at this time. This list is created from scratch every time.
     *
     * @return
     */
    public List<String> getPrimitiveTypes() {
        List<String> primitives = new ArrayList<>();
        classDefinitions.forEach( (id, bmmClass) -> {
            if(bmmClass != null && bmmClass.isPrimitiveType()) {
                primitives.add(id);
            }
        });
        return primitives;
    }

    /**
     * List of keys in `class_definitions' of items that are enumeration types, as defined in input schema.
     *
     * Note: no caching at this time. This list is created from scratch every time.
     *
     * @return
     */
    public List<String> getEnumerationTypes() {
        List<String> enumerations = new ArrayList<>();
        classDefinitions.forEach( (id, bmmClass) -> {
            if(bmmClass != null && bmmClass instanceof RMEnumeration<?>) {
                enumerations.add(id);
            }
        });
        return enumerations;
    }

    /**
     * Retrieve the enumeration definition corresponding to `a_type_name'.
     *
     * @param bmmEnumerationName
     * @return
     */
    public RMEnumeration<?> getEnumerationDefinition(String bmmEnumerationName) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    /**
     * Retrieve the property definition for `a_prop_name' in flattened class corresponding to `a_type_name'.
     *
     * @param bmmClassName
     * @return
     */
    public RMProperty getPropertyDefinition(String bmmClassName) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * True if `a_ms_property_type' is a valid 'MS' dynamic type for `a_property' in BMM type `a_bmm_type_name'.
     * 'MS' conformance means 'model-semantic' conformance, which abstracts away container types like List&lt;&gt;, Set&lt;&gt;
     *  etc and compares the dynamic type with the relation target type in the UML sense, i.e. regardless of whether
     *  there is single or multiple containment.
     *
     * @param bmmTypeName
     * @param bmmPropertyName
     * @param msPropertyName
     * @return
     */
    public boolean isMsConformantPropertyType(String bmmTypeName, String bmmPropertyName, String msPropertyName) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * Retrieve the property definition for `a_property_path' in flattened class corresponding to `a_type_name'.
     *
     * @param propertyPath
     * @return
     */
    public RMProperty getPropertyDefinitionAtPath(String propertyPath) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * Return all ancestor types of `a_class_name' up to root class (usually 'ANY', 'Object' or something similar).
     * Does not include current class. Returns empty list if none.
     *
     * @param className
     * @return
     */
    public List<String> getAllAncestorClasses(String className) {
        Map<String, RMClass> classMap = new LinkedHashMap<>();
        RMClass RMClass = getClassDefinition(className);
        populateAllAncestorClassMap(RMClass, classMap);
        List<String> classNames = new ArrayList<>();
        classNames.addAll(classMap.keySet());
        return classNames;
    }

    public Map<String, RMClass> getAllAncestorClassObjects(RMClass bmmClass) {
        Map<String, RMClass> classMap = new LinkedHashMap<>();
        populateAllAncestorClassMap(bmmClass, classMap);
        List<String> classNames = new ArrayList<>();
        classNames.addAll(classMap.keySet());
        return classMap;
    }

    protected void populateAllAncestorClassMap(RMClass bmmClass, Map<String, RMClass> classMap) {
        bmmClass.getAncestors().forEach((className, classDef) ->{
            classMap.put(className, classDef);
            populateAllAncestorClassMap(classDef, classMap);
        });
    }

    public Map<String, RMClass> getAllDescendantClassObjects(RMClass bmmClass) {
        Map<String, RMClass> descendants = new LinkedHashMap<>();
        getClassDefinitions().forEach((className, classDef) -> {
            Map<String, RMClass> allAncestors = getAllAncestorClassObjects(classDef);
            if(allAncestors.containsKey(bmmClass.getName())) {
                descendants.put(classDef.getName(), classDef);
            }
        });
        return descendants;
    }

    public RMClass getAnyClassDefinition() {
        if(getClassDefinition(RMBasicDefinitions.ANY_TYPE) != null) {
            return getClassDefinition(RMBasicDefinitions.ANY_TYPE);
        }
        RMClass result = new RMClass(RMBasicDefinitions.ANY_TYPE);
        result.setAbstract(true);
        result.setDocumentation("Root class of type system");
        return result;
    }

    /**
     * Check conformance of `a_desc_type' to `an_anc_type'; the types may be generic, and may contain open generic
     * parameters like 'T' etc. These are replaced with their apporpriate constrainer types, or Any during the conformance
     * testing process.
     *
     * Conformance is found if:
     *
     * [base class test] types are non-generic, and either type names are identical, or else `a_desc_type' has
     * `an_anc_type' in its ancestors both types are generic and pass base class test; number of generic params matches,
     * and each generic parameter type, after 'open parameter' substitution, recursively passes `type_name_conforms_to'
     * test descendant type is generic and ancestor type is not, and they pass base classes test
     *
     * @param descendantType
     * @param ancestorType
     * @return
     */
    public boolean doesTypeConformTo(String descendantType, String ancestorType) {
        throw new UnsupportedOperationException("Not yet implememented");
    }


    /****************************************************************************
     ***  From Bmm Schema Core
     ****************************************************************************/

    /**
     * Returns the publisher of model expressed in the schema.
     *
     * @return
     */
    @Override
    public String getRmPublisher() {
        return RMSchemaCore.getRmPublisher();
    }

    /**
     * Sets the publisher of model expressed in the schema.
     *
     * @param rmPublisher
     */
    @Override
    public void setRmPublisher(String rmPublisher) {
        RMSchemaCore.setRmPublisher(rmPublisher);
    }

    /**
     * Returns the release of model expressed in the schema as a 3-part numeric, e.g. "3.1.0" .
     *
     * @return
     */
    @Override
    public String getRmRelease() {
        return RMSchemaCore.getRmRelease();
    }

    /**
     * Sets the release of model expressed in the schema as a 3-part numeric, e.g. "3.1.0" .
     *
     * @param rmRelease
     */
    @Override
    public void setRmRelease(String rmRelease) {
        RMSchemaCore.setRmRelease(rmRelease);
    }

    /**
     * Returns the name of model expressed in schema; a 'schema' usually contains all of the packages of one 'model'
     * of a publisher. A publisher with more than one model can have multiple schemas. Persisted attribute.
     *
     * @return
     */
    @Override
    public String getSchemaName() {
        return RMSchemaCore.getSchemaName();
    }

    /**
     * Sets the name of model expressed in schema; a 'schema' usually contains all of the packages of one 'model'
     * of a publisher. A publisher with more than one model can have multiple schemas. Persisted attribute.
     *
     * @param schemaName
     */
    @Override
    public void setSchemaName(String schemaName) {
        RMSchemaCore.setSchemaName(schemaName);
    }

    /**
     * Returns the revision of schema.
     *
     * @return
     */
    @Override
    public String getSchemaRevision() {
        return RMSchemaCore.getSchemaRevision();
    }

    /**
     * Sets the revision of schema.
     *
     * @param schemaRevision
     */
    @Override
    public void setSchemaRevision(String schemaRevision) {
        RMSchemaCore.setSchemaRevision(schemaRevision);
    }

    /**
     * Returns the lifecycle state of the schema.
     *
     * @return
     */
    @Override
    public String getSchemaLifecycleState() {
        return RMSchemaCore.getSchemaLifecycleState();
    }

    /**
     * Sets the lifecycle state of the schema.
     *
     * @param schemaLifecycleState
     */
    @Override
    public void setSchemaLifecycleState(String schemaLifecycleState) {
        RMSchemaCore.setSchemaLifecycleState(schemaLifecycleState);
    }

    /**
     * Returns the primary author of schema.
     *
     * @return
     */
    @Override
    public String getSchemaAuthor() {
        return RMSchemaCore.getSchemaAuthor();
    }

    /**
     * Sets the primary author of schema.
     *
     * @param schemaAuthor
     */
    @Override
    public void setSchemaAuthor(String schemaAuthor) {
        RMSchemaCore.setSchemaAuthor(schemaAuthor);
    }

    /**
     * Returns the description of schema.
     *
     * @return
     */
    @Override
    public String getSchemaDescription() {
        return RMSchemaCore.getSchemaDescription();
    }

    /**
     * Sets the description of schema.
     *
     * @param schemaDescription
     */
    @Override
    public void setSchemaDescription(String schemaDescription) {
        RMSchemaCore.setSchemaDescription(schemaDescription);
    }

    /**
     * Returns the contributing authors of schema.
     *
     * @return
     */
    @Override
    public List<String> getSchemaContributors() {
        return RMSchemaCore.getSchemaContributors();
    }

    /**
     * Sets the contributing authors of schema.
     *
     * @param schemaContributors
     */
    @Override
    public void setSchemaContributors(List<String> schemaContributors) {
        RMSchemaCore.setSchemaContributors(schemaContributors);
    }

    /**
     * Returns the name of a parent class used within the schema to provide archetype capability, enabling filtering of
     * classes in RM visualisation. If empty, 'Any' is assumed. Persisted attribute.
     *
     * @return
     */
    @Override
    public String getArchetypeParentClass() {
        return RMSchemaCore.getArchetypeParentClass();
    }

    /**
     * Sets the name of a parent class used within the schema to provide archetype capability, enabling filtering of
     * classes in RM visualisation. If empty, 'Any' is assumed. Persisted attribute.
     *
     * @param archetypeParentClass
     */
    @Override
    public void setArchetypeParentClass(String archetypeParentClass) {
        RMSchemaCore.setArchetypeParentClass(archetypeParentClass);
    }

    /**
     * Returns the name of a parent class of logical 'data types' used within the schema to provide archetype capability, enabling
     * filtering of classes in RM visualisation. If empty, 'Any' is assumed. Persisted attribute.
     *
     * @return
     */
    @Override
    public String getArchetypeDataValueParentClass() {
        return RMSchemaCore.getArchetypeDataValueParentClass();
    }

    /**
     * Sets the name of a parent class of logical 'data types' used within the schema to provide archetype capability,
     * enabling filtering of classes in RM visualisation. If empty, 'Any' is assumed. Persisted attribute.
     *
     * @param archetypeDataValueParentClass
     */
    @Override
    public void setArchetypeDataValueParentClass(String archetypeDataValueParentClass) {
        RMSchemaCore.setArchetypeDataValueParentClass(archetypeDataValueParentClass);
    }

    /**
     * List of top-level package paths that provide the RM 'model' part in archetype identifiers, e.g. the path "org.openehr.ehr"
     * gives "EHR" in "openEHR-EHR". Within this namespace, archetypes can be based on any class reachable from classes defined directly in these packages.
     *
     * @return
     */
    @Override
    public List<String> getArchetypeRmClosurePackages() {
        return RMSchemaCore.getArchetypeRmClosurePackages();
    }

    /**
     * Returns the list of top-level package paths that provide the RM 'model' part in achetype identifiers, e.g. the path
     * "org.openehr.ehr" gives "EHR" in "openEHR-EHR". Within this namespace, archetypes can be based on any class reachable
     * from classes defined directly in these packages.
     *
     * @param rmClosurePackages
     */
    @Override
    public void setArchetypeRmClosurePackages(List<String> rmClosurePackages) {
        RMSchemaCore.setArchetypeRmClosurePackages(rmClosurePackages);
    }

    /**
     * Method adds a top-level package paths that provide the RM 'model' part in achetype identifiers, e.g. the path
     * "org.openehr.ehr" gives "EHR" in "openEHR-EHR". Within this namespace, archetypes can be based on any class reachable from classes defined directly in these packages.
     *
     * @param rmClosurePackage
     */
    @Override
    public void addArchetypeRmClosurePackage(String rmClosurePackage) {
        RMSchemaCore.addArchetypeRmClosurePackage(rmClosurePackage);
    }

    /**
     * Method returns a class whose descendants should be made visible in tree and grid renderings of the archetype
     * definition, if archetype_parent_class is not set, designate . For openEHR and CEN this class is normally the
     * same as the archetype_parent_class, i.e. LOCATABLE and RECORD_COMPONENT respectively. It is typically set for CEN,
     * because archetype_parent_class may not be stated, due to demographic types not inheriting from it.
     *
     * @return
     */
    @Override
    public String getArchetypeVisualizeDescendantsOf() {
        return RMSchemaCore.getArchetypeVisualizeDescendantsOf();
    }

    /**
     * Method a class whose descendants should be made visible in tree and grid renderings of the archetype
     * definition, if archetype_parent_class is not set, designate . For openEHR and CEN this class is normally the
     * same as the archetype_parent_class, i.e. LOCATABLE and RECORD_COMPONENT respectively. It is typically set for CEN,
     * because archetype_parent_class may not be stated, due to demographic types not inheriting from it.
     *
     * @param archetypeVisualizeDescendantsOf
     */
    @Override
    public void setArchetypeVisualizeDescendantsOf(String archetypeVisualizeDescendantsOf) {
        RMSchemaCore.setArchetypeVisualizeDescendantsOf(archetypeVisualizeDescendantsOf);
    }

    @Override
    public String getModelName() {
        return RMSchemaCore.getModelName();
    }

    @Override
    public void setModelName(String modelName) {
        this.RMSchemaCore.setModelName(modelName);
    }

    public String effectivePropertyType(String typeName, String propertyName) {
        RMClass bmmClass = getClassDefinition(RMDefinitions.typeNameToClassKey(typeName));
        if(bmmClass == null) {
            return RMDefinitions.UNKNOWN_TYPE_NAME;
        }
        return bmmClass.effectivePropertyType(propertyName);
    }
}
