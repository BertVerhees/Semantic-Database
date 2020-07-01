package nl.rosa.semanticdatabase.bmmdata.domain.classes;

import lombok.Getter;
import lombok.NonNull;
import nl.rosa.semanticdatabase.bmmdata.domain.class_features.*;
import nl.rosa.semanticdatabase.bmmdata.domain.expressions.ElAssertion;
import nl.rosa.semanticdatabase.bmmdata.domain.model_structure.BmmModule;
import nl.rosa.semanticdatabase.bmmdata.domain.model_structure.BmmPackage;
import nl.rosa.semanticdatabase.bmmdata.domain.types.BmmModelType;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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
 private Set<BmmConstant> constantsSet = new HashSet<>();

  public BmmClass addConstant(BmmConstant constant) {
    if(constantsSet == null){
      constantsSet  = new HashSet<>();
      constants = new HashMap<>();
    }
    this.constantsSet.add(constant);
    this.constants.put(constant.getName(), constant);
    return this;
  }

  public BmmClass addAllConstants(Set<BmmConstant> constantsSet) {
    if(constantsSet == null){
      constantsSet  = new HashSet<>();
      constants = new HashMap<>();
    }
    this.constantsSet.addAll(constantsSet);
    constantsSet.forEach(constant -> this.addConstant(constant));
    return this;
  }

  public BmmClass removeConstant(BmmConstant constant) {
    if(constantsSet != null) {
      this.constantsSet.remove(constant);
      constants = setToBmmConstantMap(constantsSet);
    }
    return this;
  }

  public BmmClass removeAllConstants(Set<BmmConstant> constantsSet) {
    if(constantsSet != null) {
      this.constantsSet.removeAll(constantsSet);
    }
    constants = setToBmmConstantMap(constantsSet);
    return this;
  }
  @Transient
  private Map<String, BmmConstant> constants;
  public Map<String,BmmConstant> getConstants() {
    constants = setToBmmConstantMap(constantsSet);
    return Collections.unmodifiableMap(constants);
  }
  /**
   * Helper constant to convert Set of BmmProcedure to Map<BmmProcedure
   * @param input
   * @return
   */
  private Map<String, BmmConstant> setToBmmConstantMap(Set<BmmConstant> input){
    Map<String, BmmConstant> base = null;
    if(input != null) {
      base = input.stream()
              .collect(Collectors.toMap(BmmConstant::getName, ancestor -> ancestor));
    }
    return base;
  }

  /**
   * 0..1
   * functions: Hash<String,BMM_FUNCTION>
   * List of functions defined in this class.
   */
  //======functions=======================================================================
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "class", orphanRemoval = true)
  private Set<BmmFunction> functionsSet = new HashSet<>();

  public BmmClass addFunction(BmmFunction function) {
    if(functionsSet == null){
      functionsSet  = new HashSet<>();
      functions = new HashMap<>();
    }
    this.functionsSet.add(function);
    this.functions.put(function.getName(), function);
    return this;
  }

  public BmmClass addAllFunctions(Set<BmmFunction> functionsSet) {
    if(functionsSet == null){
      functionsSet  = new HashSet<>();
      functions = new HashMap<>();
    }
    this.functionsSet.addAll(functionsSet);
    functionsSet.forEach(function -> this.addFunction(function));
    return this;
  }

  public BmmClass removeFunction(BmmFunction function) {
    if(functionsSet != null) {
      this.functionsSet.remove(function);
      functions = setToBmmFunctionMap(functionsSet);
    }
    return this;
  }

  public BmmClass removeAllFunctions(Set<BmmFunction> functionsSet) {
    if(functionsSet != null) {
      this.functionsSet.removeAll(functionsSet);
    }
    functions = setToBmmFunctionMap(functionsSet);
    return this;
  }
  @Transient
  private Map<String, BmmFunction> functions;
  public Map<String,BmmFunction> getFunctions() {
    functions = setToBmmFunctionMap(functionsSet);
    return Collections.unmodifiableMap(functions);
  }
  /**
   * Helper function to convert Set of BmmProcedure to Map<BmmProcedure
   * @param input
   * @return
   */
  private Map<String, BmmFunction> setToBmmFunctionMap(Set<BmmFunction> input){
    Map<String, BmmFunction> base = null;
    if(input != null) {
      base = input.stream()
              .collect(Collectors.toMap(BmmFunction::getName, ancestor -> ancestor));
    }
    return base;
  }
  /**
   * 0..1
   * procedures: Hash<String,BMM_PROCEDURE>
   * List of procedures defined in this class.
   */
  //======procedures=======================================================================
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "class", orphanRemoval = true)
  private Set<BmmProcedure> proceduresSet = new HashSet<>();

  public BmmClass addProcedure(BmmProcedure procedure) {
    if(proceduresSet == null){
      proceduresSet  = new HashSet<>();
      procedures = new HashMap<>();
    }
    this.proceduresSet.add(procedure);
    this.procedures.put(procedure.getName(), procedure);
    return this;
  }

  public BmmClass addAllProcedures(Set<BmmProcedure> proceduresSet) {
    if(proceduresSet == null){
      proceduresSet  = new HashSet<>();
      procedures = new HashMap<>();
    }
    this.proceduresSet.addAll(proceduresSet);
    proceduresSet.forEach(procedure -> this.addProcedure(procedure));
    return this;
  }

  public BmmClass removeProcedure(BmmProcedure procedure) {
    if(proceduresSet != null) {
      this.proceduresSet.remove(procedure);
      procedures = setToBmmProcedureMap(proceduresSet);
    }
    return this;
  }

  public BmmClass removeAllProcedures(Set<BmmProcedure> proceduresSet) {
    if(proceduresSet != null) {
      this.proceduresSet.removeAll(proceduresSet);
    }
    procedures = setToBmmProcedureMap(proceduresSet);
    return this;
  }
  @Transient
  private Map<String, BmmProcedure> procedures;
  public Map<String,BmmProcedure> getProcedures() {
    procedures = setToBmmProcedureMap(proceduresSet);
    return Collections.unmodifiableMap(procedures);
  }
  /**
   * 0..1
   * ancestors: Hash<String,BMM_MODEL_TYPE>
   * List of immediate inheritance parents.
   */
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "class")
  private Set<BmmModelType> ancestorsSet;

  public BmmClass addAncestor(BmmModelType ancestor) {
    if(ancestorsSet == null){
      ancestorsSet  = new HashSet<>();
      ancestors = new HashMap<>();
    }
    this.ancestorsSet.add(ancestor);
    this.ancestors.put(ancestor.typeBaseName(), ancestor);
    return this;
  }

  public BmmClass addAllAncestors(Set<BmmModelType> ancestorsSet) {
    if(ancestorsSet == null){
      ancestorsSet  = new HashSet<>();
      ancestors = new HashMap<>();
    }
    this.ancestorsSet.addAll(ancestorsSet);
    ancestorsSet.forEach(ancestor -> this.addAncestor(ancestor));
    return this;
  }

  public BmmClass removeAncestor(BmmModelType ancestor) {
    if(ancestorsSet!=null) {
      this.ancestorsSet.remove(ancestor);
      ancestors = setToBmmModelTypeMap(ancestorsSet);
    }
    return this;
  }

  public BmmClass removeAllAncestors(Set<BmmModelType> ancestorsSet) {
    if(ancestorsSet!=null) {
      this.ancestorsSet.removeAll(ancestorsSet);
    }
    ancestors = setToBmmModelTypeMap(ancestorsSet);
    return this;
  }
  @Transient
  private Map<String, BmmModelType> ancestors;
  public Map<String,BmmModelType> getAncestors() {
    ancestors = setToBmmModelTypeMap(ancestorsSet);
    return Collections.unmodifiableMap(ancestors);
  }
  /**
   * Helper function to convert Set of BmmProcedure to Map<BmmProcedure
   * @param input
   * @return
   */
  private Map<String, BmmModelType> setToBmmModelTypeMap(Set<BmmModelType> input){
    Map<String, BmmModelType> base = null;
    if(input != null) {
      base = input.stream()
              .collect(Collectors.toMap(BmmModelType::typeBaseName, ancestor -> ancestor));
    }
    return base;
  }
  /**
   * 0..1
   * properties: Hash<String,BMM_PROPERTY>
   * List of attributes defined in this class.
   */
  //======properties=======================================================================
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "class")
  private Set<BmmProperty> propertiesSet = new HashSet<>();

  public BmmClass addProperty(BmmProperty property) {
    if(propertiesSet == null){
      propertiesSet  = new HashSet<>();
      properties = new HashMap<>();
    }
    this.propertiesSet.add(property);
    this.properties.put(property.getName(), property);
    return this;
  }

  public BmmClass addAllProperties(Set<BmmProperty> propertiesSet) {
    if(propertiesSet == null){
      propertiesSet  = new HashSet<>();
      properties = new HashMap<>();
    }
    this.propertiesSet.addAll(propertiesSet);
    propertiesSet.forEach(property -> this.addProperty(property));
    return this;
  }

  public BmmClass removeProperty(BmmProperty property) {
    if(propertiesSet != null) {
      this.propertiesSet.remove(property);
      properties = setToBmmPropertyMap(propertiesSet);
    }
    return this;
  }

  public BmmClass removeAllProperties(Set<BmmProperty> propertiesSet) {
    if(propertiesSet != null) {
      this.propertiesSet.removeAll(propertiesSet);
    }
    properties = setToBmmPropertyMap(propertiesSet);
    return this;
  }
  @Transient
  private Map<String, BmmProperty> properties;
  public Map<String,BmmProperty> getProperties() {
    properties = setToBmmPropertyMap(propertiesSet);
    return Collections.unmodifiableMap(properties);
  }
  /**
   * Helper function to convert Set of BmmProcedure to Map<BmmProcedure
   * @param input
   * @return
   */
  private Map<String, BmmProperty> setToBmmPropertyMap(Set<BmmProperty> input){
    Map<String, BmmProperty> base = null;
    if(input != null) {
      base = input.stream()
              .collect(Collectors.toMap(BmmProperty::getName, property -> property));
    }
    return base;
  }
  /**
   * 0..1
   * creators: Hash<String,BMM_PROCEDURE>
   * Subset of procedures that may be used to initialise a new instance of an object,
   * and whose execution will guarantee that class invariants are satisfied.
   */
  //======creators=======================================================================
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "creators_list")
  private Set<BmmProcedure> creatorsSet;

  public BmmClass addCreator(BmmProcedure creator) {
    if(creatorsSet == null){
      creatorsSet = new HashSet<>();
      creators = new HashMap<>();
    }
    this.creatorsSet.add(creator);
    this.creators.put(creator.getName(), creator);
    return this;
  }

  public BmmClass addAllCreators(List<BmmProcedure> creatorsList) {
    if(creatorsSet == null){
      creatorsSet = new HashSet<>();
      creators = new HashMap<>();
    }
    this.creatorsSet.addAll(creatorsList);
    creatorsList.forEach(creator -> this.addCreator(creator));
    return this;
  }

  public BmmClass removeCreator(BmmProcedure creator) {
    if(creatorsSet != null) {
      this.creatorsSet.remove(creator);
      creators = setToBmmProcedureMap(convertersSet);
    }
    return this;
  }

  public BmmClass removeAllCreators(List<BmmProcedure> creatorsList) {
    if(creatorsSet != null) {
      this.creatorsSet.removeAll(creatorsList);
    }
    creators = setToBmmProcedureMap(creatorsSet);
    return this;
  }
  @Transient
  private Map<String, BmmProcedure> creators;
  public Map<String,BmmProcedure> getCreators() {
    creators = setToBmmProcedureMap(creatorsSet);
    return Collections.unmodifiableMap(creators);
  }
  /**
   * 0..1
   * converters: Hash<String,BMM_PROCEDURE>
   * Subset of creators that create a new instance from a single argument of another type.
   */
  //======convertor=======================================================================
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "convertors_list")
  private Set<BmmProcedure> convertersSet = new HashSet<>();

  public BmmClass addConvertor(BmmProcedure convertor) {
    if(convertersSet == null){
      convertersSet = new HashSet<>();
      converters = new HashMap<>();
    }
    this.convertersSet.add(convertor);
    this.converters.put(convertor.getName(), convertor);
    return this;
  }

  public BmmClass addAllConvertors(List<BmmProcedure> convertorsList) {
    if(convertersSet == null){
      convertersSet = new HashSet<>();
      converters = new HashMap<>();
    }
    this.convertersSet.addAll(convertorsList);
    convertorsList.forEach(convertor -> this.addConvertor(convertor));
    return this;
  }

  public BmmClass removeConverter(BmmProcedure convertor) {
    if(convertersSet != null) {
      this.convertersSet.remove(convertor);
      converters = setToBmmProcedureMap(convertersSet);
    }
    return this;
  }

  public BmmClass removeAllConverters(List<BmmProcedure> convertorsList) {
    if(convertersSet != null) {
      this.convertersSet.removeAll(convertorsList);
    }
    converters = setToBmmProcedureMap(convertersSet);
    return this;
  }
  @Transient
  private Map<String, BmmProcedure> converters;
  public Map<String,BmmProcedure> getConverters() {
    converters = setToBmmProcedureMap(convertersSet);
    return Collections.unmodifiableMap(converters);
  }

  /**
   * Helper function to convert Set of BmmProcedure to Map<BmmProcedure
   * @param input
   * @return
   */
  private Map<String, BmmProcedure> setToBmmProcedureMap(Set<BmmProcedure> input){
    Map<String, BmmProcedure> base = null;
    if(input != null) {
      base = input.stream()
              .collect(Collectors.toMap(BmmProcedure::getName, procedure -> procedure));
    }
    return base;
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

  public BmmClass setPrimitive(@NotNull Boolean primitive) {
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

  public BmmClass setAbstract(@NotNull Boolean anAbstract) {
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

  public BmmClass setOverride(@NotNull Boolean override) {
    isOverride = override;
    return this;
  }

  //====== transients =================================================================
  /**
   * 0..1
   * immediate_descendants: List<BMM_CLASS>
   * List of computed references to base classes of immediate inheritance
   * descendants, derived when members of ancestors are attached at creation time.
   *
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

  public BmmClass addAllImmediateDescendants(Set<BmmClass> immediateDescendants) {
    this.immediateDescendants.addAll(immediateDescendants);
    return this;
  }

  public BmmClass removeImmediateDescendant(BmmClass immediateDescendant) {
    this.immediateDescendants.remove(immediateDescendant);
    return this;
  }

  public BmmClass removeAllImmediateDescendants(Set<BmmClass> immediateDescendants) {
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
