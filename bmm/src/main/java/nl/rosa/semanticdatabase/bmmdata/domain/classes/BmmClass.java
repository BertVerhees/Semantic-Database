package nl.rosa.semanticdatabase.bmmdata.domain.classes;

import lombok.Getter;
import lombok.NonNull;
import nl.rosa.semanticdatabase.bmmdata.domain.class_features.*;
import nl.rosa.semanticdatabase.bmmdata.domain.expressions.ElAssertion;
import nl.rosa.semanticdatabase.bmmdata.domain.model_structure.BmmModule;
import nl.rosa.semanticdatabase.bmmdata.domain.model_structure.BmmPackage;
import nl.rosa.semanticdatabase.bmmdata.domain.types.BmmModelType;

import javax.persistence.*;
import java.util.*;
import java.util.stream.Collectors;


/**
 * Class BmmClass
 * Meta-type corresponding a class definition in an object model. Inheritance is
 * specified by the ancestors attribute, which contains a list of nl.rosa.semanticdatabase.bmm.model.types rather than
 * classes. Inheritance is thus understood in BMM as a stated relationship between
 * classes. The equivalent relationship between nl.rosa.semanticdatabase.bmm.model.types is conformance.
 * 
 * NOTE
 * unlike UML, the name is just the root name, even if the class is generic. Use
 * type_name() to obtain the qualified type name.
 * 
 * 
 * (effected) is_primitive (): Boolean
 * True if this class is designated a primitive type within the overall type system
 * of the schema. Set from schema.
 * (effected) is_abstract (): Boolean
 * True if this class is abstract in its model. Value provided from an underlying
 * data property set at creation or construction time.
 * 
 */
@DiscriminatorValue("4")
@Entity
public abstract class BmmClass extends BmmModule {

  /**
   * 1..1
   * package: BMM_PACKAGE
   * Package this class belongs to.
   */
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "package_id")
  @Getter
  private BmmPackage _package;

  public BmmClass setAncestors(Map<String, BmmModelType> ancestors) {
    this.ancestors = ancestors;
    return this;
  }

  /**
   * 1..1
   * source_schema_id: String
   * Reference to original source schema defining this class.
   * Useful for UI tools to determine which original schema file to open for a given class for manual editing.
   */
  @NonNull
  @Column(name = "source_schema_id")
  private String sourceSchemaId;

  public BmmClass setSourceSchemaId(String sourceSchemaId) {
    this.sourceSchemaId = sourceSchemaId;
    return this;
  }

  /**
   * 0..1
   * immediate_descendants: List<BMM_CLASS>
   * List of computed references to base classes of immediate inheritance
   * descendants, derived when members of ancestors are attached at creation time.
   */
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "immediate_descendants")
  private Set<BmmClass> immediateDescendantsSet = new HashSet<>();

  public Set<BmmClass> getImmediateDescendantsSet() {
    return Collections.unmodifiableSet(immediateDescendantsSet);
  }

  public BmmClass setImmediateDescendants(Set<BmmClass> immediateDescendants) {
    this.immediateDescendantsSet = immediateDescendants;
    return this;
  }

  public BmmClass addImmediateDescendant(BmmClass immediateDescendant) {
    this.immediateDescendantsSet.add(immediateDescendant);
    return this;
  }

  public BmmClass addAllImmediateDescendants(Set<BmmClass> immediateDescendants) {
    this.immediateDescendantsSet.addAll(immediateDescendants);
    return this;
  }

  public BmmClass removeImmediateDescendant(BmmClass immediateDescendant) {
    this.immediateDescendantsSet.remove(immediateDescendant);
    return this;
  }

  public BmmClass removeAllImmediateDescendants(Set<BmmClass> immediateDescendants) {
    this.immediateDescendantsSet.removeAll(immediateDescendants);
    return this;
  }

  /**
   * 0..1
   * constants: Hash<String,BMM_CONSTANT>
   * List of constants defined in this class.
   */
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "constants_list")
  private Set<BmmConstant> constantsSet = new HashSet<>();
  public BmmClass setConstantsSet(Set<BmmConstant> constantsSet) {
    this.constantsSet = constantsSet;
    constants = constantsSet.stream()
            .collect(Collectors.toMap(BmmConstant::getName, constant -> constant));
    return this;
  }
  public Set<BmmConstant> getConstantsSet() {
    return Collections.unmodifiableSet(constantsSet);
  }

  public BmmClass addConstant(BmmConstant constant) {
    this.constantsSet.add(constant);
    this.constants.put(constant.getName(), constant);
    return this;
  }

  public BmmClass addAllConstants(Set<BmmConstant> constantsSet) {
    this.constantsSet.addAll(constantsSet);
    constantsSet.forEach(constant -> this.addConstant(constant));
    return this;
  }

  public BmmClass removeConstant(BmmConstant constant) {
    this.constantsSet.remove(constant);
    this.constants.remove(constant.getName());
    return this;
  }

  public BmmClass removeAllConstants(Set<BmmConstant> constantsSet) {
    this.constantsSet.removeAll(constantsSet);
    constantsSet.forEach(constant -> this.constants.remove(constant.getName()));
    return this;
  }
  @Transient
  private Map<String, BmmConstant>  constants = new HashMap<>();
  public Map<String,BmmConstant> getConstants() {
    return Collections.unmodifiableMap(constants);
  }

  /**
   * 0..1
   * functions: Hash<String,BMM_FUNCTION>
   * List of functions defined in this class.
   */
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "functions_list")
  private Set<BmmFunction> functionsSet = new HashSet<>();
  public BmmClass setFunctionsSet(Set<BmmFunction> functionsSet) {
    this.functionsSet = functionsSet;
    functions = functionsSet.stream()
            .collect(Collectors.toMap(BmmFunction::getName, function -> function));
    return this;
  }
  public Set<BmmFunction> getFunctionsSet() {
    return Collections.unmodifiableSet(functionsSet);
  }
  public BmmClass addFunction(BmmFunction function) {
    this.functionsSet.add(function);
    this.functions.put(function.getName(), function);
    return this;
  }

  public BmmClass addAllFunctions(Set<BmmFunction> functionsSet) {
    this.functionsSet.addAll(functionsSet);
    functionsSet.forEach(function -> this.addFunction(function));
    return this;
  }

  public BmmClass removeFunction(BmmFunction function) {
    this.functionsSet.remove(function);
    this.functions.remove(function.getName());
    return this;
  }

  public BmmClass removeAllFunctions(Set<BmmFunction> functionsSet) {
    this.functionsSet.removeAll(functionsSet);
    functionsSet.forEach(function -> this.removeFunction(function));
    return this;
  }
  @Transient
  private Map<String, BmmFunction> functions = new HashMap<>();
  public Map<String,BmmFunction> getFunctions() {
    return Collections.unmodifiableMap(functions);
  }
  /**
   * 0..1
   * procedures: Hash<String,BMM_PROCEDURE>
   * List of procedures defined in this class.
   */
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "procedures_list")
  private Set<BmmProcedure> proceduresSet = new HashSet<>();
  public BmmClass setProceduresSet(Set<BmmProcedure> proceduresSet) {
    this.proceduresSet = proceduresSet;
    procedures = proceduresSet.stream()
            .collect(Collectors.toMap(BmmProcedure::getName, procedure -> procedure));
    return this;
  }
  public Set<BmmProcedure> getProceduresSet() {
    return Collections.unmodifiableSet(proceduresSet);
  }
  public BmmClass addProcedure(BmmProcedure procedure) {
    this.proceduresSet.add(procedure);
    this.procedures.put(procedure.getName(), procedure);
    return this;
  }

  public BmmClass addAllProcedures(Set<BmmProcedure> proceduresSet) {
    this.proceduresSet.addAll(proceduresSet);
    proceduresSet.forEach(procedure -> this.addProcedure(procedure));
    return this;
  }

  public BmmClass removeProcedure(BmmProcedure procedure) {
    this.proceduresSet.remove(procedure);
    this.procedures.remove(procedure.getName());
    return this;
  }

  public BmmClass removeAllProcedures(Set<BmmProcedure> proceduresSet) {
    this.proceduresSet.removeAll(proceduresSet);
    proceduresSet.forEach(procedure -> this.removeProcedure(procedure));
    return this;
  }
  @Transient
  private Map<String, BmmProcedure> procedures;
  public Map<String,BmmProcedure> getProcedures() {
    return Collections.unmodifiableMap(procedures);
  }
  /**
   * 0..1
   * ancestors: Hash<String,BMM_MODEL_TYPE>
   * List of immediate inheritance parents.
   */
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "ancestors_list")
  private Set<BmmModelType> ancestorsSet = new HashSet<>();
  public BmmClass setAncestorsSet(Set<BmmModelType> ancestorsSet) {
    this.ancestorsSet = ancestorsSet;
    ancestors = ancestorsSet.stream()
            .collect(Collectors.toMap(BmmModelType::typeBaseName, ancestor -> ancestor));
    return this;
  }
  public Set<BmmModelType> getAncestorsSet() {
    return Collections.unmodifiableSet(ancestorsSet);
  }
  public BmmClass addAncestor(BmmModelType ancestor) {
    this.ancestorsSet.add(ancestor);
    this.ancestors.put(ancestor.typeBaseName(), ancestor);
    return this;
  }

  public BmmClass addAllAncestors(Set<BmmModelType> ancestorsSet) {
    this.ancestorsSet.addAll(ancestorsSet);
    ancestorsSet.forEach(ancestor -> this.addAncestor(ancestor));
    return this;
  }

  public BmmClass removeAncestor(BmmModelType ancestor) {
    this.ancestorsSet.remove(ancestor);
    this.ancestors.remove(ancestor.typeBaseName());
    return this;
  }

  public BmmClass removeAllAncestors(Set<BmmModelType> ancestorsSet) {
    this.ancestorsSet.removeAll(ancestorsSet);
    ancestorsSet.forEach(ancestor -> this.removeAncestor(ancestor));
    return this;
  }
  @Transient
  private Map<String, BmmModelType> ancestors;
  public Map<String,BmmModelType> getAncestors() {
    return Collections.unmodifiableMap(ancestors);
  }
  /**
   * 0..1
   * properties: Hash<String,BMM_PROPERTY>
   * List of attributes defined in this class.
   */
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "propertys_list")
  private Set<BmmProperty> propertiesSet = new HashSet<>();
  public BmmClass setPropertiesSet(Set<BmmProperty> propertysSet) {
    this.propertiesSet = propertiesSet;
    properties = propertiesSet.stream()
            .collect(Collectors.toMap(BmmProperty::getName, property -> property));
    return this;
  }
  public Set<BmmProperty> getPropertiesSet() {
    return Collections.unmodifiableSet(propertiesSet);
  }
  public BmmClass addProperty(BmmProperty property) {
    this.propertiesSet.add(property);
    this.properties.put(property.getName(), property);
    return this;
  }

  public BmmClass addAllProperties(Set<BmmProperty> propertiesSet) {
    this.propertiesSet.addAll(propertiesSet);
    propertiesSet.forEach(property -> this.addProperty(property));
    return this;
  }

  public BmmClass removeProperty(BmmProperty property) {
    this.propertiesSet.remove(property);
    this.properties.remove(property.getName());
    return this;
  }

  public BmmClass removeAllProperties(Set<BmmProperty> propertiesSet) {
    this.propertiesSet.removeAll(propertiesSet);
    propertiesSet.forEach(property -> this.removeProperty(property));
    return this;
  }
  @Transient
  private Map<String, BmmProperty> properties;
  public Map<String,BmmProperty> getProperties() {
    return Collections.unmodifiableMap(properties);
  }
  /**
   * 0..1
   * creators: Hash<String,BMM_PROCEDURE>
   * Subset of procedures that may be used to initialise a new instance of an object,
   * and whose execution will guarantee that class invariants are satisfied.
   */
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "creators_list")
  private Set<BmmProcedure> creatorsSet = new HashSet<>();
  public BmmClass setCreatorsList(Set<BmmProcedure> creatorsSet) {
    this.creatorsSet = creatorsSet;
    creators = creatorsSet.stream()
            .collect(Collectors.toMap(BmmProcedure::getName, creator -> creator));
    return this;
  }
  public Set<BmmProcedure> getCreatorsList() {
    return Collections.unmodifiableSet(creatorsSet);
  }
  public BmmClass addCreator(BmmProcedure creator) {
    this.creatorsSet.add(creator);
    this.creators.put(creator.getName(), creator);
    return this;
  }

  public BmmClass addAllCreators(List<BmmProcedure> creatorsList) {
    this.creatorsSet.addAll(creatorsList);
    creatorsList.forEach(creator -> this.addCreator(creator));
    return this;
  }

  public BmmClass removeCreator(BmmProcedure creator) {
    this.creatorsSet.remove(creator);
    this.creators.remove(creator.getName());
    return this;
  }

  public BmmClass removeAllCreators(List<BmmProcedure> creatorsList) {
    this.creatorsSet.removeAll(creatorsList);
    creatorsList.forEach(creator -> this.removeCreator(creator));
    return this;
  }
  @Transient
  private Map<String, BmmProcedure> creators;
  public Map<String,BmmProcedure> getCreators() {
    return Collections.unmodifiableMap(creators);
  }
  /**
   * 0..1
   * converters: Hash<String,BMM_PROCEDURE>
   * Subset of creators that create a new instance from a single argument of another type.
   */
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "convertors_list")
  private Set<BmmProcedure> convertorsSet = new HashSet<>();
  public BmmClass setConvertorsList(Set<BmmProcedure> convertorsSet) {
    this.convertorsSet = convertorsSet;
    convertors = convertorsSet.stream()
            .collect(Collectors.toMap(BmmProcedure::getName, convertor -> convertor));
    return this;
  }
  public Set<BmmProcedure> getConvertorsList() {
    return Collections.unmodifiableSet(convertorsSet);
  }
  public BmmClass addConvertor(BmmProcedure convertor) {
    this.convertorsSet.add(convertor);
    this.convertors.put(convertor.getName(), convertor);
    return this;
  }

  public BmmClass addAllConvertors(List<BmmProcedure> convertorsList) {
    this.convertorsSet.addAll(convertorsList);
    convertorsList.forEach(convertor -> this.addConvertor(convertor));
    return this;
  }

  public BmmClass removeConvertor(BmmProcedure convertor) {
    this.convertorsSet.remove(convertor);
    this.convertors.remove(convertor.getName());
    return this;
  }

  public BmmClass removeAllConvertors(List<BmmProcedure> convertorsList) {
    this.convertorsSet.removeAll(convertorsList);
    convertorsList.forEach(convertor -> this.removeConvertor(convertor));
    return this;
  }
  @Transient
  private Map<String, BmmProcedure> convertors;
  public Map<String,BmmProcedure> getConvertors() {
    return Collections.unmodifiableMap(convertors);
  }

  /**
   * 0..1
   * is_primitive: Boolean
   * {default = false}
   * True if this class represents a type considered to be primitive in the type system, i.e. any typically built-in
   * or standard library type such as String, Date, Hash<K,V> etc.
   */
  @Getter
  @Column(name = "is_primitive")
  private Boolean isPrimitive;

  public BmmClass setPrimitive(Boolean primitive) {
    isPrimitive = primitive;
    return this;
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

  public BmmClass setAbstract(Boolean anAbstract) {
    isAbstract = anAbstract;
    return this;
  }
  /**
   * 0..1
   * invariants: List<EL_ASSERTION>
   */
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "invariants")
  private List<ElAssertion> invariants;
  //=====================================================================================================
  /**
   * 1..1
   * is_override: Boolean
   * True if this definition overrides a class of the same name in an included schema.
   */
  @NonNull
  @Transient
  @Getter
  private Boolean isOverride = false;

  public BmmClass setOverride(Boolean override) {
    isOverride = override;
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
  public Boolean isAbstract(){
    return null;
  }

  /**
   * 1..1
   * is_primitive (): Boolean
   * If True, indicates that the entity in a BMM model is considered to relate to a primitive type set,
   * i.e. be a primitive type, or be a definer of one.
   */
  public Boolean isPrimitive(){
    return null;
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
   * @return       List<String>
   */
  public List<String> allAncestors(){
    return null;
  }

  /**
   * Compute all descendants by following immediate_descendants.
   * @return       List<String>
   */
  public List<String> allDescendants(){
    return null;
  }

  /**
   * List of names of immediate supplier classes, including concrete generic
   * parameters, concrete descendants of abstract statically defined nl.rosa.semanticdatabase.bmm.model.types, and
   * inherited suppliers. (Where generics are unconstrained, no class name is added,
   * since logically it would be Any and this can always be assumed anyway). This
   * list includes primitive nl.rosa.semanticdatabase.bmm.model.types.
   * @return       List<String>
   */
  public List<String> suppliers(){
    return null;
  }

  /**
   * Same as suppliers minus primitive nl.rosa.semanticdatabase.bmm.model.types, as defined in input schema.
   * @return       List<String>
   */
  public List<String> suppliersNonPrimitive(){
    return null;
  }

  /**
   * ist of names of all classes in full supplier closure, including concrete generic
   * parameters; (where generics are unconstrained, no class name is added, since
   * logically it would be Any and this can always be assumed anyway). This list
   * includes primitive nl.rosa.semanticdatabase.bmm.model.types.
   * @return       List<String>
   */
  public List<String> supplierClosure(){
    return null;
  }

  /**
   * Fully qualified package name, of form: package.package
   * @return       String
   */
  public String packagePath(){
    return null;
  }

  /**
   * Fully qualified class name, of form: package.package.CLASS with package path in
   * lower-case and class in original case.
   * @return       String
   */
  public String classPath(){
    return null;
  }

  /**
   * List of all feature definitions introduced in this class.
   */
  public List<BmmClassScoped> features(){
    return null;
  }

  /**
   * Consolidated list of all feature definitions from this class and all inheritance
   * ancestors.
   */
  public List<BmmClassScoped> flatFeatures(){
    return null;
  }

  /**
   * List of all properties due to current and ancestor classes, keyed by property
   * name.
   * @return       class_features.BmmProperty
   */
  public List<BmmProperty> flatProperties(){
    return null;
  }
}
