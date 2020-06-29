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
  private List<BmmClass> immediateDescendantsList = new ArrayList<>();

  public List<BmmClass> getImmediateDescendantsList() {
    return Collections.unmodifiableList(immediateDescendantsList);
  }

  public BmmClass setImmediateDescendants(List<BmmClass> immediateDescendants) {
    this.immediateDescendantsList = immediateDescendants;
    return this;
  }

  public BmmClass addImmediateDescendant(BmmClass immediateDescendant) {
    this.immediateDescendantsList.add(immediateDescendant);
    return this;
  }

  public BmmClass addAllImmediateDescendants(List<BmmClass> immediateDescendants) {
    this.immediateDescendantsList.addAll(immediateDescendants);
    return this;
  }

  public BmmClass removeImmediateDescendant(BmmClass immediateDescendant) {
    this.immediateDescendantsList.remove(immediateDescendant);
    return this;
  }

  public BmmClass removeAllImmediateDescendants(List<BmmClass> immediateDescendants) {
    this.immediateDescendantsList.removeAll(immediateDescendants);
    return this;
  }

  /**
   * 0..1
   * constants: Hash<String,BMM_CONSTANT>
   * List of constants defined in this class.
   */
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "constants_list")
  private List<BmmConstant> constantsList;
  public BmmClass setConstantsList(List<BmmConstant> constantsList) {
    this.constantsList = constantsList;
    constants = constantsList.stream()
            .collect(Collectors.toMap(BmmConstant::getName, constant -> constant));
    return this;
  }
  public List<BmmConstant> getConstantsList() {
    return Collections.unmodifiableList(constantsList);
  }

  public BmmClass addConstant(BmmConstant constant) {
    this.constantsList.add(constant);
    this.constants.put(constant.getName(), constant);
    return this;
  }

  public BmmClass addAllConstants(List<BmmConstant> constantsList) {
    this.constantsList.addAll(constantsList);
    constantsList.forEach(constant -> this.addConstant(constant));
    return this;
  }

  public BmmClass removeConstant(BmmConstant constant) {
    this.constantsList.remove(constant);
    this.constants.remove(constant.getName());
    return this;
  }

  public BmmClass removeAllConstants(List<BmmConstant> constantsList) {
    this.constantsList.removeAll(constantsList);
    constantsList.forEach(constant -> this.constants.remove(constant.getName()));
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
  private List<BmmFunction> functionsList;
  public BmmClass setFunctionsList(List<BmmFunction> functionsList) {
    this.functionsList = functionsList;
    functions = functionsList.stream()
            .collect(Collectors.toMap(BmmFunction::getName, function -> function));
    return this;
  }
  public List<BmmFunction> getFunctionsList() {
    return Collections.unmodifiableList(functionsList);
  }
  public BmmClass addFunction(BmmFunction function) {
    this.functionsList.add(function);
    this.functions.put(function.getName(), function);
    return this;
  }

  public BmmClass addAllFunctions(List<BmmFunction> functionsList) {
    this.functionsList.addAll(functionsList);
    functionsList.forEach(function -> this.addFunction(function));
    return this;
  }

  public BmmClass removeFunction(BmmFunction function) {
    this.functionsList.remove(function);
    this.functions.remove(function.getName());
    return this;
  }

  public BmmClass removeAllFunctions(List<BmmFunction> functionsList) {
    this.functionsList.removeAll(functionsList);
    functionsList.forEach(function -> this.removeFunction(function));
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
  private List<BmmProcedure> proceduresList;
  public BmmClass setProceduresList(List<BmmProcedure> proceduresList) {
    this.proceduresList = proceduresList;
    procedures = proceduresList.stream()
            .collect(Collectors.toMap(BmmProcedure::getName, procedure -> procedure));
    return this;
  }
  public List<BmmProcedure> getProceduresList() {
    return Collections.unmodifiableList(proceduresList);
  }
  public BmmClass addProcedure(BmmProcedure procedure) {
    this.proceduresList.add(procedure);
    this.procedures.put(procedure.getName(), procedure);
    return this;
  }

  public BmmClass addAllProcedures(List<BmmProcedure> proceduresList) {
    this.proceduresList.addAll(proceduresList);
    proceduresList.forEach(procedure -> this.addProcedure(procedure));
    return this;
  }

  public BmmClass removeProcedure(BmmProcedure procedure) {
    this.proceduresList.remove(procedure);
    this.procedures.remove(procedure.getName());
    return this;
  }

  public BmmClass removeAllProcedures(List<BmmProcedure> proceduresList) {
    this.proceduresList.removeAll(proceduresList);
    proceduresList.forEach(procedure -> this.removeProcedure(procedure));
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
  private List<BmmModelType> ancestorsList;
  public BmmClass setAncestorsList(List<BmmModelType> ancestorsList) {
    this.ancestorsList = ancestorsList;
    ancestors = ancestorsList.stream()
            .collect(Collectors.toMap(BmmModelType::typeBaseName, ancestor -> ancestor));
    return this;
  }
  public List<BmmModelType> getAncestorsList() {
    return Collections.unmodifiableList(ancestorsList);
  }
  public BmmClass addAncestor(BmmModelType ancestor) {
    this.ancestorsList.add(ancestor);
    this.ancestors.put(ancestor.typeBaseName(), ancestor);
    return this;
  }

  public BmmClass addAllAncestors(List<BmmModelType> ancestorsList) {
    this.ancestorsList.addAll(ancestorsList);
    ancestorsList.forEach(ancestor -> this.addAncestor(ancestor));
    return this;
  }

  public BmmClass removeAncestor(BmmModelType ancestor) {
    this.ancestorsList.remove(ancestor);
    this.ancestors.remove(ancestor.typeBaseName());
    return this;
  }

  public BmmClass removeAllAncestors(List<BmmModelType> ancestorsList) {
    this.ancestorsList.removeAll(ancestorsList);
    ancestorsList.forEach(ancestor -> this.removeAncestor(ancestor));
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
  private List<BmmProperty> propertiesList;
  public BmmClass setPropertiesList(List<BmmProperty> propertysList) {
    this.propertiesList = propertiesList;
    properties = propertiesList.stream()
            .collect(Collectors.toMap(BmmProperty::getName, property -> property));
    return this;
  }
  public List<BmmProperty> getPropertiesList() {
    return Collections.unmodifiableList(propertiesList);
  }
  public BmmClass addProperty(BmmProperty property) {
    this.propertiesList.add(property);
    this.properties.put(property.getName(), property);
    return this;
  }

  public BmmClass addAllProperties(List<BmmProperty> propertiesList) {
    this.propertiesList.addAll(propertiesList);
    propertiesList.forEach(property -> this.addProperty(property));
    return this;
  }

  public BmmClass removeProperty(BmmProperty property) {
    this.propertiesList.remove(property);
    this.properties.remove(property.getName());
    return this;
  }

  public BmmClass removeAllProperties(List<BmmProperty> propertiesList) {
    this.propertiesList.removeAll(propertiesList);
    propertiesList.forEach(property -> this.removeProperty(property));
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
  private List<BmmProcedure> creatorsList;
  public BmmClass setCreatorsList(List<BmmProcedure> creatorsList) {
    this.creatorsList = creatorsList;
    creators = creatorsList.stream()
            .collect(Collectors.toMap(BmmProcedure::getName, creator -> creator));
    return this;
  }
  public List<BmmProcedure> getCreatorsList() {
    return Collections.unmodifiableList(creatorsList);
  }
  public BmmClass addCreator(BmmProcedure creator) {
    this.creatorsList.add(creator);
    this.creators.put(creator.getName(), creator);
    return this;
  }

  public BmmClass addAllCreators(List<BmmProcedure> creatorsList) {
    this.creatorsList.addAll(creatorsList);
    creatorsList.forEach(creator -> this.addCreator(creator));
    return this;
  }

  public BmmClass removeCreator(BmmProcedure creator) {
    this.creatorsList.remove(creator);
    this.creators.remove(creator.getName());
    return this;
  }

  public BmmClass removeAllCreators(List<BmmProcedure> creatorsList) {
    this.creatorsList.removeAll(creatorsList);
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
  private List<BmmProcedure> convertorsList;
  public BmmClass setConvertorsList(List<BmmProcedure> convertorsList) {
    this.convertorsList = convertorsList;
    convertors = convertorsList.stream()
            .collect(Collectors.toMap(BmmProcedure::getName, convertor -> convertor));
    return this;
  }
  public List<BmmProcedure> getConvertorsList() {
    return Collections.unmodifiableList(convertorsList);
  }
  public BmmClass addConvertor(BmmProcedure convertor) {
    this.convertorsList.add(convertor);
    this.convertors.put(convertor.getName(), convertor);
    return this;
  }

  public BmmClass addAllConvertors(List<BmmProcedure> convertorsList) {
    this.convertorsList.addAll(convertorsList);
    convertorsList.forEach(convertor -> this.addConvertor(convertor));
    return this;
  }

  public BmmClass removeConvertor(BmmProcedure convertor) {
    this.convertorsList.remove(convertor);
    this.convertors.remove(convertor.getName());
    return this;
  }

  public BmmClass removeAllConvertors(List<BmmProcedure> convertorsList) {
    this.convertorsList.removeAll(convertorsList);
    convertorsList.forEach(convertor -> this.removeConvertor(convertor));
    return this;
  }
  @Transient
  private Map<String, BmmProcedure> convertors;
  public Map<String,BmmProcedure> getConvertors() {
    return Collections.unmodifiableMap(convertors);
  }
  //=====================================================================================================

  /**
   * 1..1
   * is_override: Boolean
   * True if this definition overrides a class of the same name in an included
   * schema.
   */
  @NonNull
  @Transient
  private Boolean isOverride;

  public Boolean getOverride() {
    //TODO
    return isOverride;
  }

  /**
   * 0..1
   * is_primitive: Boolean
   * {default = false}
   * True if this class represents a type considered to be primitive in the type system, i.e. any typically built-in
   * or standard library type such as String, Date, Hash<K,V> etc.
   */
  @Transient
  private Boolean isPrimitive;
  /**
   * 0..1
   * is_abstract: Boolean
   * {default = false}
   * True if this class is marked as abstract, i.e. direct instances cannot be created from its direct type.
   */
  @Column(name = "is_abstract")
  private Boolean isAbstract;
  /**
   * 0..1
   * invariants: List<EL_ASSERTION>
   */
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "invariants")
  private List<ElAssertion> invariants;
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
