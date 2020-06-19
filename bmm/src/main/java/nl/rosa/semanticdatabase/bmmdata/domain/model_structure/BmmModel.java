package nl.rosa.semanticdatabase.bmmdata.domain.model_structure;

import lombok.*;
import nl.rosa.semanticdatabase.bmmdata.domain.class_features.BmmProperty;
import nl.rosa.semanticdatabase.bmmdata.domain.classes.BmmClass;
import nl.rosa.semanticdatabase.bmmdata.domain.classes.BmmEnumeration;
import nl.rosa.semanticdatabase.bmmdata.domain.classes.BmmSimpleClass;
import nl.rosa.semanticdatabase.bmmdata.domain.types.BmmSimpleType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Class BmmModel
 * Invariants
 *
 * Inv_top_level_scope: scope = self
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class BmmModel extends BmmPackageContainer {
   /**
   * 0..1
    * class_definitions: Hash<String,BMM_CLASS>
    * All classes in this model, keyed by type name.
   */
   @Getter
   @Setter
   @ElementCollection
   @CollectionTable(name = "bmm_model_class_definition_mapping",
           joinColumns = {@JoinColumn(name = "class_definition_id", referencedColumnName = "id")})
   @MapKeyColumn(name = "class_definition_name")
   @Column(name = "class_definition")
   private Map<String,BmmClass> classDefinitions = new HashMap<>();
  public void addClassDefinition(String key, BmmClass value){
    classDefinitions.put(key, value);
  }
  public BmmClass getClassDefinition(String key){
    return classDefinitions.get(key);
  }
  public BmmClass removeClassDefinition(String key){
    return classDefinitions.remove(key);
  }
  /**
   * 0..1
   * used_models: List<BMM_MODEL>
   * List of other models 'used' (i.e. 'imported' by this model).
   * Classes in the current model may refer to classes in a used model by specifying the other class’s scope
   * meta-attribute.
   */
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "model", orphanRemoval = true)
  private List<BmmModel> usedModels = new ArrayList<>();
  @ManyToOne(fetch = FetchType.LAZY)
  private BmmModel usedModel;
  // Functions
  /**
   * 1..1
   *
   * model_id (): String
   *
   * Identifier of this model, lower-case, formed from:
   *
   * rm_publisher '' model_name '' rm_release
   *
   * E.g. 'openehr_ehr_1.0.4'.
   * @return
   */
  public String modelId()
  {
    //TODO
    return null;
  }
  /**
   * 1..1
   * class_definition (
   * a_name: String[1]
   * ): BMM_CLASS
   * Retrieve the class definition corresponding to a_type_name (which may contain a generic part).
   * @return       classes.BmmClass
   * @param        name
   */
  public BmmClass classDefinition(@NonNull String name)
  {
    //TODO
    return null;
  }
  /**
   * 1..1
   * type_definition (): BMM_CLASS
   * Retrieve the class definition corresponding to a_type_name.
   * If it contains a generic part, this will be removed if it is a fully open generic name,
   * otherwise it will remain intact, i.e. if it is an effective generic name that identifies
   * a BMM_GENERIC_CLASS_EFFECTIVE.
   * @return       classes.BmmClass
   */
  public BmmClass typeDefinition()
  {
    //TODO
    return null;
  }
  /**
   * 1..1
   *
   * has_class_definition (
   * a_class_name: String[1]
   * ): Boolean
   *
   * True if a_class_name has a class definition in the model.
   * @return       Boolean
   * @param        className
   */
  public Boolean hasClassDefinition(@NonNull String className)
  {
    //TODO
    return false;
  }
  /**
   * 1..1
   * has_type_definition (
   * a_type_name: String[1]
   * ): Boolean
   * True if a_type_name is already concretely known in the system, including if it is generic,
   * which may be open, partially open or closed.
   * @return       Boolean
   * @param        typeName
   */
  public Boolean hasTypeDefinition(@NonNull String typeName)
  {
    //TODO
    return false;
  }
  /**
   * 1..1
   * enumeration_definition (
   * a_name: String[1]
   * ): BMM_ENUMERATION
   * Retrieve the enumeration definition corresponding to a_type_name
   * @return       classes.BmmEnumeration
   * @param        name
   */
  public BmmEnumeration enumerationDefinition(@NonNull String name)
  {
    //TODO
    return null;
  }
  /**
   * 0..1
   * primitive_types (): List<String>
   * List of keys in class_definitions of items marked as primitive types.
   * @return       List<String>
   */
  public List<String> primitiveTypes()
  {
    //TODO
    return null;
  }
  /**
   * 0..1
   * enumeration_types (): List<String>
   * List of keys in class_definitions of items that are enumeration types.
   * @return       List<String>
   */
  public List<String> enumerationTypes()
  {
    //TODO
    return null;
  }
  /**
   * 1..1
   * property_definition (): BMM_PROPERTY
   * Retrieve the property definition for a_prop_name in flattened class
   * corresponding to a_type_name.
   * @return       class_features.BmmProperty
   */
  public BmmProperty propertyDefinition()
  {
    //TODO
    return null;
  }
  /**
   * 1..1
   * ms_conformant_property_type (
   * a_bmm_type_name: String[1],
   * a_bmm_property_name: String[1],
   * a_ms_property_name: String[1]
   * ): Boolean
   * True if a_ms_property_type is a valid 'MS' dynamic type for a_property in
   * BMM type a_bmm_type_name. 'MS' conformance means 'model-semantic' conformance,
   * which abstracts away container nl.rosa.semanticdatabase.bmm.model.types like List<>, Set<> etc
   * and compares the dynamic type with the relation target type in the UML sense,
   * i.e. regardless of whether there is single or multiple containment.
   * @return       Boolean
   * @param        bmmTypeName
   * @param        bmmPropertyName
   * @param        modelSemanticPropertyName
   */
  public Boolean modelConformantPropertyType(
          @NonNull String bmmTypeName, @NonNull String bmmPropertyName, @NonNull String modelSemanticPropertyName)
  {
    //TODO
    return false;
  }
  /**
   * 1..1
   * property_definition_at_path (): BMM_PROPERTY
   * Retrieve the property definition for a_property_path in flattened class corresponding to a_type_name.
   * @return       class_features.BmmProperty
   */
  public BmmProperty propertyDefintionAtPath()
  {
    //TODO
    return null;
  }
  /**
   * 1..1
   * class_definition_at_path (
   * a_type_name: String[1],
   * a_prop_path: String[1]
   * ): BMM_CLASS
   * Retrieve the class definition for the class that owns the terminal attribute in a_prop_path
   * in flattened class corresponding to a_type_name.
   * @return       classes.BmmClass
   * @param        typeName
   * @param        propertyPath
   */
  public BmmClass classDefinitionAtPath(@NonNull String typeName, @NonNull String propertyPath)
  {
    //TODO
    return null;
  }
  /**
   * 0..1
   * all_ancestor_classes (
   * a_class: String[1]
   * ): List<String>
   * Return all ancestor nl.rosa.semanticdatabase.bmm.model.types of a_class_name up to root class (usually Any, Object or something similar).
   * Does not include current class. Returns empty list if none.
   * @return       List<String>
   * @param        aClass
   */
  public List<String> allAncestorClasses(@NonNull String aClass)
  {
    //TODO
    return null;
  }
  /**
   * 1..1
   * is_descendant_of (
   * a_class_name: String[1],
   * a_parent_class_name: String[1]
   * ): Boolean
   * True if a_class_name is a descendant in the model of a_parent_class_name.
   * @return       Boolean
   * @param        className
   * @param        parentCLassName
   */
  public Boolean isDescendantOf(@NonNull String className, @NonNull String parentCLassName)
  {
    //TODO
    return false;
  }
  /**
   * 1..1
   *
   * type_conforms_to (
   * a_desc_type: String[1],
   * an_anc_type: String[1]
   * ): Boolean
   *
   * Check conformance of a_desc_type to an_anc_type; the nl.rosa.semanticdatabase.bmm.model.types may be generic,
   * and may contain open generic parameters like 'T' etc.
   * These are replaced with their appropriate constrainer nl.rosa.semanticdatabase.bmm.model.types,
   * or Any during the conformance testing process.
   *
   * Conformance is found if:
   * * [base class test] nl.rosa.semanticdatabase.bmm.model.types are non-generic, and either type names are identical,
   *   or else a_desc_type has an_anc_type in its ancestors;
   * * both nl.rosa.semanticdatabase.bmm.model.types are generic and pass base class test; number of generic params matches,
   *   and each generic parameter type, after 'open parameter' substitution, recursively passes; type_name_conforms_to test
   * * descendant type is generic and ancestor type is not, and they pass base classes test.
   * @return       Boolean
   * @param        descType
   * @param        ancestorType
   */
  public Boolean typeConformsTo(@NonNull String descType, @NonNull String ancestorType)
  {
    //TODO
    return false;
  }
  /**
   * 1..1
   * subtypes (
   * a_type: String[1]
   * ): List<String>

   * Generate type substitutions for the supplied type, which may be simple, generic
   * (closed, open or partially open), or a container type. In the generic and container cases,
   * the result is the permutation of the base class type and type substitutions of all
   * generic parameters.
   *
   * Parameters
   * a_type
   * Name of a type.
   * @return       List<String>
   * @param        aType
   */
  public List<String> subtypes(@NonNull String aType)
  {
    //TODO
    return null;
  }

  /**
   * 1..1
   * any_class_definition
   * BMM_SIMPLE_CLASS instance for the Any class. This may be defined in the BMM schema,
   * but if not, use BMM_DEFINITIONS.any_class.
   */
  public BmmSimpleClass anyClassDefinition()
  {
    //TODO
    return null;
  }

  /**
   * 1..1
   * any_type_definition (): BMM_SIMPLE_TYPE
   * BMM_SIMPLE_TYPE instance for the Any type.
   * @return       nl.rosa.semanticdatabase.bmm.model.types.BmmSimpleType
   */
  public BmmSimpleType anyTypeDefinition()
  {
    //TODO
    return null;
  }

  /**
   * 1..1
   * boolean_type_definition (): BMM_SIMPLE_TYPE
   * BMM_SIMPLE_TYPE instance for the Boolean type.
   * @return       undef
   */
  public BmmSimpleType BooleanTypeDefinition()
  {
    //TODO
    return null;
  }
}
