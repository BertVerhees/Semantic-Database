package nl.rosa.semanticdatabase.referencemodel.bmm.classes;

import lombok.Data;
import nl.rosa.semanticdatabase.referencemodel.bmm.class_features.*;
import nl.rosa.semanticdatabase.referencemodel.bmm.expressions.ElAssertion;
import nl.rosa.semanticdatabase.referencemodel.bmm.model_structure.BmmPackage;
import nl.rosa.semanticdatabase.referencemodel.bmm.types.BmmModelType;
import nl.rosa.semanticdatabase.referencemodel.bmm.types.BmmSimpleType;

import java.util.List;
import java.util.Map;


/**
 * Class BmmSimpleClass
 * Definition of a simple class, i.e. a class that has no generic parameters and is
 * 1:1 with the type it generates.
 * 
 * (effected) type (): BMM_SIMPLE_TYPE
 * Generate a type object that represents the type of this class. Can only be an
 * instance of BMM_SIMPLE_TYPE or a descendant.
 * 
 */
@Data
public class BmmSimpleClass implements BmmClass {

  //
  // Fields
  //

  // BmmClass
  /**
   * List of immediate inheritance parents.
   */
  private Map<String, BmmModelType> ancestors;
  /**
   * Package this class belongs to.
   */
  private BmmPackage _package;
  /**
   * List of attributes defined in this class.
   */
  private Map<String, BmmProperty> properties;
  /**
   * Reference to original source schema defining this class. Useful for UI tools to determine which original schema file to open for a given class for manual editing.
   */
  private String sourceSchemaId;
  /**
   * List of computed references to base classes of immediate inheritance descendants, derived when members of ancestors are attached at creation time.
   */
  private List<BmmClass> immediateDescendants;
  /**
   * True if this definition overrides a class of the same name in an included schema.
   */
  private boolean isOverride;
  /**
   * List of constants defined in this class.
   */
  private Map<String, BmmConstant> constants;
  /**
   * List of functions defined in this class.
   */
  private Map<String, BmmFunction> functions;
  private Map<String, BmmProcedure> procedures;
  private List<ElAssertion> inVariants;
  /**
   * Subset of procedures that may be used to initialise a new instance of an object, and whose execution will guarantee that class invariants are satisfied.
   */
  private Map<String, BmmProcedure> creators;
  private Map<String, BmmProcedure> convertors;


  //
  // Constructors
  //
  public BmmSimpleClass () { };
  
  /**
   * Generate a type object that represents the type of this class. Can only be an
   * instance of BMM_SIMPLE_TYPE or a descendant.
   * @return       types.BmmSimpleType
   */
  public BmmSimpleType type()
  {
    //TODO
    return null;
  }


  @Override
  public List<String> allAncestors() {
    //TODO
    return null;
  }

  @Override
  public List<String> allDescendants() {
    //TODO
    return null;
  }

  @Override
  public List<String> suppliers() {
    //TODO
    return null;
  }

  @Override
  public List<String> suppliersNonPrimitive() {
    //TODO
    return null;
  }

  @Override
  public List<String> supplierClosure() {
    //TODO
    return null;
  }

  @Override
  public String packagePath() {
    //TODO
    return null;
  }

  @Override
  public String classPath() {
    //TODO
    return null;
  }

  @Override
  public List<BmmClassScoped> features() {
    //TODO
    return null;
  }

  @Override
  public List<BmmClassScoped> flatFeatures() {
    //TODO
    return null;
  }

  @Override
  public List<BmmProperty> flatProperties() {
    //TODO
    return null;
  }

  @Override
  public boolean isAbstract() {
    //TODO
    return false;
  }

  @Override
  public boolean isPrimitive() {
    //TODO
    return false;
  }
  /**
   * True if this declaration entity is the root of the declaration hierarchy.
   * @return
   */
  @Override
  public boolean isRootScope() {
    return false;
  }
}
