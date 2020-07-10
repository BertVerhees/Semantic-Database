package nl.rosa.semanticdatabase.bmmdata.domain.classes;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import nl.rosa.semanticdatabase.bmmdata.domain.Bmm;
import nl.rosa.semanticdatabase.bmmdata.domain.class_features.*;
import nl.rosa.semanticdatabase.bmmdata.domain.expressions.ElAssertion;
import nl.rosa.semanticdatabase.bmmdata.domain.model_structure.BmmModule;
import nl.rosa.semanticdatabase.bmmdata.domain.model_structure.BmmPackage;
import nl.rosa.semanticdatabase.bmmdata.domain.model_structure.BmmPackageContainer;
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
public abstract class BmmClass extends BmmModule {

    /**
     * 1..1
     * package: BMM_PACKAGE
     * Package this class belongs to.
     */
    //=====bmmPackage=============================================================
    @Getter
    @Setter
    @NonNull
    private BmmPackage bmmPackage;

    /**
     * 1..1
     * source_schema_id: String
     * Reference to original source schema defining this class.
     * Useful for UI tools to determine which original schema file to open for a given class for manual editing.
     */
    //======sourceSchemaId=======================================================================
    @NotEmpty
    @Getter
    @Setter
    private String sourceSchemaId;

    /**
     * 0..1
     * constants: Hash<String,BMM_CONSTANT>
     * List of constants defined in this class.
     */
    //======constants=======================================================================
    private Map<String, BmmConstant> constants;

    public void putConstant(@NonNull String key, @NonNull BmmConstant value){
        if(constants==null){
            constants = new HashMap<>();
        }
        constants.put(key,  value);

    }
    public void putConstants(Map<String, BmmConstant> items){
        items.keySet().forEach(key -> putConstant(key, items.get(key)));

    }
    public BmmConstant getConstant(String key){
        if(constants==null){
            return null;
        }
        return constants.get(key);
    }
    public void removeConstant(String key){
        if(constants!=null) {
            constants.remove(key);
        }
    }
    public void removeConstants(Collection<String> keys){
        keys.forEach(this::removeConstant);
    }
    private void setConstants(Map<String, BmmConstant> constants) {
        this.constants = constants;
    }
    private Map<String,BmmConstant> getConstants() {
        return constants;
    }
    public Map<String,BmmConstant> constants() {
        return Collections.unmodifiableMap(constants);
    }
    /**
     * 0..1
     * functions: Hash<String,BMM_FUNCTION>
     * List of functions defined in this class.
     */
    //======functions=======================================================================
    private Map<String, BmmFunction> functions;

    public void putFunction(@NonNull String key, @NonNull BmmFunction value){
        if(functions==null){
            functions = new HashMap<>();
        }
        functions.put(key,  value);

    }
    public void putFunctions(Map<String, BmmFunction> items){
        items.keySet().forEach(key -> putFunction(key, items.get(key)));

    }
    public BmmFunction getFunction(String key){
        if(functions==null){
            return null;
        }
        return functions.get(key);
    }
    public void removeFunction(String key){
        if(functions!=null) {
            functions.remove(key);
        }
    }
    public void removeFunctions(Collection<String> keys){
        keys.forEach(this::removeFunction);
    }
    private void setFunctions(Map<String, BmmFunction> functions) {
        this.functions = functions;
    }
    private Map<String,BmmFunction> getFunctions() {
        return functions;
    }
    public Map<String,BmmFunction> functions() {
        return Collections.unmodifiableMap(functions);
    }
    /**
     * 0..1
     * procedures: Hash<String,BMM_PROCEDURE>
     * List of procedures defined in this class.
     */
    //======procedures=======================================================================
    private Map<String, BmmProcedure> procedures;

    public void putProcedure(@NonNull String key, @NonNull BmmProcedure value){
        if(procedures==null){
            procedures = new HashMap<>();
        }
        procedures.put(key,  value);

    }
    public void putProcedures(Map<String, BmmProcedure> items){
        items.keySet().forEach(key -> putProcedure(key, items.get(key)));

    }
    public BmmProcedure getProcedure(String key){
        if(procedures==null){
            return null;
        }
        return procedures.get(key);
    }
    public void removeProcedure(String key){
        if(procedures!=null) {
            procedures.remove(key);
        }
    }
    public void removeProcedures(Collection<String> keys){
        keys.forEach(this::removeProcedure);
    }
    private void setProcedures(Map<String, BmmProcedure> procedures) {
        this.procedures = procedures;
    }
    private Map<String,BmmProcedure> getProcedures() {
        return procedures;
    }
    public Map<String,BmmProcedure> procedures() {
        return Collections.unmodifiableMap(procedures);
    }
    /**
     * 0..1
     * ancestors: Hash<String,BMM_MODEL_TYPE>
     * List of immediate inheritance parents.
     */
    //======ancestors=======================================================================
    private Map<String, BmmModelType> ancestors;

    public void putAncestor(@NonNull String key, @NonNull BmmModelType value){
        if(ancestors==null){
            ancestors = new HashMap<>();
        }
        ancestors.put(key,  value);

    }
    public void putAncestors(Map<String, BmmModelType> items){
        items.keySet().forEach(key -> putAncestor(key, items.get(key)));

    }
    public BmmModelType getAncestor(String key){
        if(ancestors==null){
            return null;
        }
        return ancestors.get(key);
    }
    public void removeAncestor(String key){
        if(ancestors!=null) {
            ancestors.remove(key);
        }
    }
    public void removeAncestors(Collection<String> keys){
        keys.forEach(this::removeAncestor);
    }
    private void setAncestors(Map<String, BmmModelType> ancestors) {
        this.ancestors = ancestors;
    }
    private Map<String,BmmModelType> getAncestors() {
        return ancestors;
    }
    public Map<String,BmmModelType> ancestors() {
        return Collections.unmodifiableMap(ancestors);
    }


    /**
     * 0..1
     * properties: Hash<String,BMM_PROPERTY>
     * List of attributes defined in this class.
     */
    //======properties=======================================================================
    private Map<String, BmmProperty> properties;

    public void putProperty(@NonNull String key, @NonNull BmmProperty value){
        if(properties==null){
            properties = new HashMap<>();
        }
        properties.put(key,  value);

    }
    public void putProperties(Map<String, BmmProperty> items){
        items.keySet().forEach(key -> putProperty(key, items.get(key)));

    }
    public BmmProperty getProperty(String key){
        if(properties==null){
            return null;
        }
        return properties.get(key);
    }
    public void removeProperty(String key){
        if(properties!=null) {
            properties.remove(key);
        }
    }
    public void removeProperties(Collection<String> keys){
        keys.forEach(this::removeProperty);
    }
    private void setProperties(Map<String, BmmProperty> properties) {
        this.properties = properties;
    }
    private Map<String,BmmProperty> getProperties() {
        return properties;
    }
    public Map<String,BmmProperty> properties() {
        return Collections.unmodifiableMap(properties);
    }
    
    /**
     * 0..1
     * creators: Hash<String,BMM_PROCEDURE>
     * Subset of procedures that may be used to initialise a new instance of an object,
     * and whose execution will guarantee that class invariants are satisfied.
     */
    //======creators=======================================================================
    private Map<String, BmmProcedure> creators;

    public void putCreator(@NonNull String key, @NonNull BmmProcedure value){
        if(creators==null){
            creators = new HashMap<>();
        }
        creators.put(key,  value);

    }
    public void putCreators(Map<String, BmmProcedure> items){
        items.keySet().forEach(key -> putCreator(key, items.get(key)));

    }
    public BmmProcedure getCreator(String key){
        if(creators==null){
            return null;
        }
        return creators.get(key);
    }
    public void removeCreator(String key){
        if(creators!=null) {
            creators.remove(key);
        }
    }
    public void removeCreators(Collection<String> keys){
        keys.forEach(this::removeCreator);
    }
    private void setCreators(Map<String, BmmProcedure> creators) {
        this.creators = creators;
    }
    private Map<String,BmmProcedure> getCreators() {
        return creators;
    }
    public Map<String,BmmProcedure> creators() {
        return Collections.unmodifiableMap(creators);
    }
    /**
     * 0..1
     * converters: Hash<String,BMM_PROCEDURE>
     * Subset of creators that create a new instance from a single argument of another type.
     */
    //======convertor=======================================================================
    private Map<String, BmmProcedure> convertors;

    public void putConvertor(@NonNull String key, @NonNull BmmProcedure value){
        if(convertors==null){
            convertors = new HashMap<>();
        }
        convertors.put(key,  value);

    }
    public void putConvertors(Map<String, BmmProcedure> items){
        items.keySet().forEach(key -> putConvertor(key, items.get(key)));

    }
    public BmmProcedure getConvertor(String key){
        if(convertors==null){
            return null;
        }
        return convertors.get(key);
    }
    public void removeConvertor(String key){
        if(convertors!=null) {
            convertors.remove(key);
        }
    }
    public void removeConvertors(Collection<String> keys){
        keys.forEach(this::removeConvertor);
    }
    private void setConvertors(Map<String, BmmProcedure> convertors) {
        this.convertors = convertors;
    }
    private Map<String,BmmProcedure> getConvertors() {
        return convertors;
    }
    public Map<String,BmmProcedure> convertors() {
        return Collections.unmodifiableMap(convertors);
    }
    /**
     * 0..1
     * is_primitive: Boolean
     * {default = false}
     * True if this class represents a type considered to be primitive in the type system, i.e. any typically built-in
     * or standard library type such as String, Date, Hash<K,V> etc.
     */
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
    @Setter
    private Boolean isAbstract;

    /**
     * 0..1
     * invariants: List<EL_ASSERTION>
     */
    private Set<ElAssertion> invariants;
    public void addInvariant(@NonNull ElAssertion value){
        if(invariants==null){
            invariants = new HashSet<>();
        }
        invariants.add(value);

    }
    public void addInvariants(Set<ElAssertion> items){
        items.forEach(item -> addInvariant(item));

    }
    public void removeInvariant(ElAssertion item){
        if(invariants!=null) {
            invariants.remove(item);
        }
    }
    public void removeInvariants(Collection<ElAssertion> items){
        items.forEach(this::removeInvariant);
    }
    private void setInvariants(Set<ElAssertion> items) {
        this.invariants = items;
    }
    private Set<ElAssertion> getInvariants() {
        return invariants;
    }
    public Set<ElAssertion> invariants() {
        return Collections.unmodifiableSet(invariants);
    }
    //====== transients =================================================================
    /**
     * 1..1
     * is_override: Boolean
     * True if this definition overrides a class of the same name in an included schema.
     */
    @NonNull
    @Transient
    @Getter
    @Setter
    private Boolean isOverride = false;
    public void setOverride(@NotNull Boolean override) {
        isOverride = override;

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
    private Set<BmmClass> immediateDescendants;
    public void addImmediateDescendant(@NonNull BmmClass value){
        if(immediateDescendants==null){
            immediateDescendants = new HashSet<>();
        }
        immediateDescendants.add(value);

    }
    public void addImmediateDescendants(Set<BmmClass> items){
        items.forEach(item -> addImmediateDescendant(item));

    }
    public void removeImmediateDescendant(BmmClass item){
        if(immediateDescendants!=null) {
            immediateDescendants.remove(item);
        }
    }
    public void removeImmediateDescendants(Collection<BmmClass> items){
        items.forEach(this::removeImmediateDescendant);
    }
    private void setImmediateDescendants(Set<BmmClass> items) {
        this.immediateDescendants = items;
    }
    private Set<BmmClass> getImmediateDescendants() {
        return immediateDescendants;
    }
    public Set<BmmClass> immediateDescendants() {
        return Collections.unmodifiableSet(immediateDescendants);
    }

    public BmmClass removeImmediateDescendants(Set<BmmClass> immediateDescendants) {
        this.immediateDescendants.removeAll(immediateDescendants);

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

    }
}
