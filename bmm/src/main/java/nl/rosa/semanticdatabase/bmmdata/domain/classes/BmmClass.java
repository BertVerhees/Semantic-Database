package nl.rosa.semanticdatabase.bmmdata.domain.classes;

import lombok.Getter;
import lombok.NonNull;
import nl.rosa.semanticdatabase.bmmdata.domain.BmmBaseEntity;
import nl.rosa.semanticdatabase.bmmdata.domain.class_features.*;
import nl.rosa.semanticdatabase.bmmdata.domain.expressions.ElAssertion;
import nl.rosa.semanticdatabase.bmmdata.domain.model_structure.BmmModule;
import nl.rosa.semanticdatabase.bmmdata.domain.model_structure.BmmPackage;
import nl.rosa.semanticdatabase.bmmdata.domain.types.BmmModelType;
import nl.rosa.semanticdatabase.bmmdata.services.model_access.data.BmmSchema;
import org.springframework.util.ClassUtils;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.*;

/**
 * Class BmmClass
 * Meta-type corresponding a class definition in an object model. Inheritance is
 * specified by the ancestors attribute, which contains a list of nl.rosa.semanticdatabase.bmm.model.types rather than
 * classes. Inheritance is thus understood in BMM as a stated relationship between
 * classes. The equivalent relationship between nl.rosa.semanticdatabase.bmm.model.types is conformance.
 * <p>
 * NOTE
 * unlike UML, the name is just the root name, even if the class is generic. Use
 * type_name() to obtain the qualified type name.
 * <p>
 * <p>
 * (effected) is_primitive (): Boolean
 * True if this class is designated a primitive type within the overall type system
 * of the schema. Set from schema.
 * (effected) is_abstract (): Boolean
 * True if this class is abstract in its model. Value provided from an underlying
 * data property set at creation or construction time.
 *
 * !!IMPORTANT!!
 * BmmClass has two relations to BmmModelType
 * 1) OneToOne because it serves as Class to give BmmModelType a Type
 * 2) OneToMany, to define the ancestors of BmmClass (multiple inheritance is possible)
 */
@DiscriminatorValue("4")
@Entity
public abstract class BmmClass extends BmmModule {

    /**
     * This Id is not generated because it comes from the parent-child relation BmmModelType, where the latter is the parent.
     */
    @Id
    private Long id;

    public BmmBaseEntity setId(Long id) {
        this.id = id;
        return this;
    }
    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bmm_model_type_id")
    private BmmModelType bmmModelType;


    /**
     * 1..1
     * package: BMM_PACKAGE
     * Package this class belongs to.
     */
    //=====bmmPackage=============================================================
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bmm_package_id")
    @Getter
    private BmmPackage bmmPackage;

    public BmmClass setBmmPackage(BmmPackage bmmPackage) {
        this.bmmPackage = bmmPackage;
        return this;
    }

    /**
     * 1..1
     * source_schema_id: String
     * Reference to original source schema defining this class.
     * Useful for UI tools to determine which original schema file to open for a given class for manual editing.
     */
    //======sourceSchemaId=======================================================================
    @NotEmpty
    @Column(name = "source_schema_id")
    private String sourceSchemaId;

    public BmmClass setSourceSchemaId(@NotEmpty String sourceSchemaId) {
        this.sourceSchemaId = sourceSchemaId;
        return this;
    }

    /**
     * 0..1
     * constants: Hash<String,BMM_CONSTANT>
     * List of constants defined in this class.
     */
    //======constants=======================================================================
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "class", orphanRemoval = true)
    @MapKey(name = "name")
    private Map<String, BmmConstant> constants;

    public BmmClass addConstant(BmmConstant constant) {
        if (constants == null) {
            constants = new HashMap<>();
        }
        this.constants.put(constant.getName(), constant);
        return this;
    }

    public BmmClass addConstants(Set<BmmConstant> constantsSet) {
        constantsSet.forEach(constant -> this.addConstant(constant));
        return this;
    }

    public BmmClass removeConstant(BmmConstant constant) {
        if (constants != null) {
            this.constants.remove(constant.getName());
        }
        return this;
    }

    public BmmClass removeConstants(Set<BmmConstant> constantsSet) {
        constantsSet.forEach(constant -> this.removeConstant(constant));
        return this;
    }

    public Map<String, BmmConstant> getConstants() {
        return Collections.unmodifiableMap(constants);
    }

    /**
     * 0..1
     * functions: Hash<String,BMM_FUNCTION>
     * List of functions defined in this class.
     */
    //======functions=======================================================================
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "class", orphanRemoval = true)
    @MapKey(name = "name")
    private Map<String, BmmFunction> functions;

    public BmmClass addFunction(BmmFunction function) {
        if (functions == null) {
            functions = new HashMap<>();
        }
        this.functions.put(function.getName(), function);
        return this;
    }
    public BmmClass addFunctions(Set<BmmFunction> functionsSet) {
        functionsSet.forEach(function -> this.addFunction(function));
        return this;
    }
    public BmmClass removeFunction(BmmFunction function) {
        if (functions == null) {
            functions = new HashMap<>();
        }
        this.functions.remove(function.getName());
        return this;
    }
    public BmmClass removeFunctions(Set<BmmFunction> functionsSet) {
        functionsSet.forEach(function -> this.removeFunction(function));
        return this;
    }
    public Map<String, BmmFunction> getFunctions() {
        return Collections.unmodifiableMap(functions);
    }

    /**
     * 0..1
     * procedures: Hash<String,BMM_PROCEDURE>
     * List of procedures defined in this class.
     */
    //======procedures=======================================================================
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "class", orphanRemoval = true)
    @MapKey(name = "name")
    private Map<String, BmmProcedure> procedures;

    public BmmClass addProcedure(BmmProcedure procedure) {
        if (procedures == null) {
            procedures = new HashMap<>();
        }
        this.procedures.put(procedure.getName(), procedure);
        return this;
    }

    public BmmClass addProcedures(Set<BmmProcedure> proceduresSet) {
        proceduresSet.forEach(procedure -> this.addProcedure(procedure));
        return this;
    }

    public BmmClass removeProcedure(BmmProcedure procedure) {
        if (procedures != null) {
            this.procedures.remove(procedure.getName());
        }
        return this;
    }

    public BmmClass removeProcedures(Set<BmmProcedure> proceduresSet) {
        proceduresSet.forEach(procedure -> this.removeProcedure(procedure));
        return this;
    }
    public Map<String, BmmProcedure> getProcedures() {
        return Collections.unmodifiableMap(procedures);
    }

    /**
     * 0..1
     * ancestors: Hash<String,BMM_MODEL_TYPE>
     * List of immediate inheritance parents.
     */
    //======ancestors=======================================================================
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "class")
    @MapKey(name = "type_base_name")
    private Map<String, BmmModelType> ancestors;

    public BmmClass addAncestor(BmmModelType ancestor) {
        if (ancestors == null) {
            ancestors = new HashMap<>();
        }
        this.ancestors.put(ancestor.typeBaseName(), ancestor);
        return this;
    }

    public BmmClass addAncestors(Set<BmmModelType> ancestorsSet) {
        ancestorsSet.forEach(ancestor -> this.addAncestor(ancestor));
        return this;
    }

    public BmmClass removeAncestor(BmmModelType ancestor) {
        if (ancestors != null) {
            ancestors.remove(ancestor.typeBaseName());
        }
        return this;
    }

    public BmmClass removeAncestors(Set<BmmModelType> ancestorsSet) {
        ancestorsSet.forEach(ancestor -> this.removeAncestor(ancestor));
        return this;
    }
    public Map<String, BmmModelType> getAncestors() {
        return Collections.unmodifiableMap(ancestors);
    }

    /**
     * 0..1
     * properties: Hash<String,BMM_PROPERTY>
     * List of attributes defined in this class.
     */
    //======properties=======================================================================
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "class")
    @MapKey(name = "name")
    private Map<String, BmmProperty> properties;

    public BmmClass addProperty(BmmProperty property) {
        if (properties == null) {
            properties = new HashMap<>();
        }
        this.properties.put(property.getName(), property);
        return this;
    }

    public BmmClass addProperties(Set<BmmProperty> propertiesSet) {
        propertiesSet.forEach(property -> this.addProperty(property));
        return this;
    }

    public BmmClass removeProperty(BmmProperty property) {
        if (properties != null) {
            properties.remove(property.getName());
        }
        return this;
    }

    public BmmClass removeProperties(Set<BmmProperty> propertiesSet) {
        propertiesSet.forEach(property -> this.removeProperty(property));
        return this;
    }

    public Map<String, BmmProperty> getProperties() {
        return Collections.unmodifiableMap(properties);
    }

    /**
     * 0..1
     * creators: Hash<String,BMM_PROCEDURE>
     * Subset of procedures that may be used to initialise a new instance of an object,
     * and whose execution will guarantee that class invariants are satisfied.
     */
    //======creators=======================================================================
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "class")
    @MapKey(name = "name")
    private Map<String, BmmProcedure> creators;

    public BmmClass addCreator(BmmProcedure creator) {
        if (creators == null) {
            creators = new HashMap<>();
        }
        this.creators.put(creator.getName(), creator);
        return this;
    }

    public BmmClass addCreators(List<BmmProcedure> creatorsList) {
        creatorsList.forEach(creator -> this.addCreator(creator));
        return this;
    }

    public BmmClass removeCreator(BmmProcedure creator) {
        if (creators != null) {
            this.creators.remove(creator.getName());
        }
        return this;
    }

    public BmmClass removeCreators(List<BmmProcedure> creatorsList) {
        creatorsList.forEach(creator -> this.removeCreator(creator));
        return this;
    }

    public Map<String, BmmProcedure> getCreators() {
        return Collections.unmodifiableMap(creators);
    }

    /**
     * 0..1
     * converters: Hash<String,BMM_PROCEDURE>
     * Subset of creators that create a new instance from a single argument of another type.
     */
    //======convertor=======================================================================
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "convertors_list")
    @MapKey(name = "name")
    private Map<String, BmmProcedure> converters;

    public BmmClass addConvertor(BmmProcedure convertor) {
        if (converters == null) {
            converters = new HashMap<>();
        }
        this.converters.put(convertor.getName(), convertor);
        return this;
    }

    public BmmClass addConvertors(List<BmmProcedure> convertorsList) {
        convertorsList.forEach(convertor -> this.addConvertor(convertor));
        return this;
    }

    public BmmClass removeConverter(BmmProcedure convertor) {
        if (converters != null) {
            converters.remove(convertor.getName());
        }
        return this;
    }

    public BmmClass removeConverters(List<BmmProcedure> convertorsList) {
        convertorsList.forEach(converter -> this.removeConverter(converter));
        return this;
    }

    public Map<String, BmmProcedure> getConverters() {
        return Collections.unmodifiableMap(converters);
    }

    /**
     * 0..1
     * is_primitive: Boolean
     * {default = false}
     * True if this class represents a type considered to be primitive in the type system, i.e. any typically built-in
     * or standard library type such as String, Date, Hash<K,V> etc.
     */
    @Column(name = "is_primitive")
    private Boolean isPrimitive;

    public Boolean getIsPrimitive(){
        return ClassUtils.isPrimitiveOrWrapper(this.getClass());
    }

    /**
     * 0..1
     * is_abstract: Boolean
     * {default = false}
     * True if this class is marked as abstract, i.e. direct instances cannot be created from its direct type.
     */
    @Getter
    @Column(name = "is_abstract")
    private Boolean isAbstract;

    public BmmClass setAbstract(@NotNull Boolean anAbstract) {
        isAbstract = anAbstract;
        return this;
    }

    /**
     * 0..1
     * invariants: List<EL_ASSERTION>
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "class")
    private Set<ElAssertion> invariants;
    //====== transients =================================================================
    /**
     * 1..1
     * is_override: Boolean
     * True if this definition overrides a class of the same name in an included schema.
     */
    @NonNull
    @Transient
    @Getter
    private Boolean isOverride = false;

    public BmmClass setOverride(@NotNull Boolean override) {
        isOverride = override;
        return this;
    }
    /**
     * 0..1
     * immediate_descendants: List<BMM_CLASS>
     * List of computed references to base classes of immediate inheritance
     * descendants, derived when members of ancestors are attached at creation time.
     * <p>
     * Computed
     */
    //======immediateDescendants=======================================================================
    @Transient
    private Set<BmmClass> immediateDescendants = new HashSet<>();

    public Set<BmmClass> getImmediateDescendants() {
        return Collections.unmodifiableSet(immediateDescendants);
    }

    public BmmClass setImmediateDescendants(@NotNull Set<BmmClass> immediateDescendants) {
        this.immediateDescendants = immediateDescendants;
        return this;
    }

    public BmmClass addImmediateDescendant(BmmClass immediateDescendant) {
        this.immediateDescendants.add(immediateDescendant);
        return this;
    }

    public BmmClass addImmediateDescendants(Set<BmmClass> immediateDescendants) {
        this.immediateDescendants.addAll(immediateDescendants);
        return this;
    }

    public BmmClass removeImmediateDescendant(BmmClass immediateDescendant) {
        this.immediateDescendants.remove(immediateDescendant);
        return this;
    }

    public BmmClass removeImmediateDescendants(Set<BmmClass> immediateDescendants) {
        this.immediateDescendants.removeAll(immediateDescendants);
        return this;
    }


    // Functions
    //============================================================================================================

    /**
     * 1..1
     * is_abstract (): Boolean
     * If true, indicates an abstract class in a BMM model, or a type based on an abstract class,
     * i.e. a type that cannot be directly instantiated.
     */
    public Boolean isAbstract() {
        return this.isAbstract;
    }

    /**
     * 1..1
     * is_primitive (): Boolean
     * If True, indicates that the entity in a BMM model is considered to relate to a primitive type set,
     * i.e. be a primitive type, or be a definer of one.
     */
    public Boolean isPrimitive() {
        return this.getIsPrimitive();
    }

    /**
     * 1..1
     * (abstract)
     * type (): BMM_MODEL_TYPE
     * Generate a type object that represents the type for which this class is the definer.
     */
    public abstract BmmModelType type();

    /**
     * List of all inheritance parent class names, recursively.
     *
     * @return List<String>
     */
    public List<String> allAncestors() {
//        Tree children =
        return null;
    }

    /**
     * Compute all descendants by following immediate_descendants.
     *
     * @return List<String>
     */
    public List<String> allDescendants() {
        return null;
    }

    /**
     * List of names of immediate supplier classes, including concrete generic
     * parameters, concrete descendants of abstract statically defined nl.rosa.semanticdatabase.bmm.model.types, and
     * inherited suppliers. (Where generics are unconstrained, no class name is added,
     * since logically it would be Any and this can always be assumed anyway). This
     * list includes primitive nl.rosa.semanticdatabase.bmm.model.types.
     *
     * @return List<String>
     */
    public List<String> suppliers() {
        return null;
    }

    /**
     * Same as suppliers minus primitive nl.rosa.semanticdatabase.bmm.model.types, as defined in input schema.
     *
     * @return List<String>
     */
    public List<String> suppliersNonPrimitive() {
        return null;
    }

    /**
     * ist of names of all classes in full supplier closure, including concrete generic
     * parameters; (where generics are unconstrained, no class name is added, since
     * logically it would be Any and this can always be assumed anyway). This list
     * includes primitive nl.rosa.semanticdatabase.bmm.model.types.
     *
     * @return List<String>
     */
    public List<String> supplierClosure() {
        return null;
    }

    /**
     * Fully qualified package name, of form: package.package
     *
     * @return String
     */
    public String packagePath() {
        return null;
    }

    /**
     * Fully qualified class name, of form: package.package.CLASS with package path in
     * lower-case and class in original case.
     *
     * @return String
     */
    public String classPath() {
        return null;
    }

    /**
     * List of all feature definitions introduced in this class.
     */
    public List<BmmClassScoped> features() {
        return null;
    }

    /**
     * Consolidated list of all feature definitions from this class and all inheritance
     * ancestors.
     */
    public List<BmmClassScoped> flatFeatures() {
        return null;
    }

    /**
     * List of all properties due to current and ancestor classes, keyed by property
     * name.
     *
     * @return class_features.BmmProperty
     */
    public List<BmmProperty> flatProperties() {
        return null;
    }

    //=============  counterparts =========================================================
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_bmm_schema_id")
    @Getter
    private BmmSchema bmmSchema;

    public BmmClass setBmmClass(BmmSchema bmmSchema) {
        this.bmmSchema = bmmSchema;
        return this;
    }
}
