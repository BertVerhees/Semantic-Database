package nl.rosa.semanticdatabase.referencemodel.bmm.classes;

import lombok.Data;
import nl.rosa.semanticdatabase.referencemodel.bmm.class_features.BmmConstant;
import nl.rosa.semanticdatabase.referencemodel.bmm.class_features.BmmFunction;
import nl.rosa.semanticdatabase.referencemodel.bmm.class_features.BmmProcedure;
import nl.rosa.semanticdatabase.referencemodel.bmm.class_features.BmmProperty;
import nl.rosa.semanticdatabase.referencemodel.bmm.expressions.ElAssertion;
import nl.rosa.semanticdatabase.referencemodel.bmm.model_structure.BmmPackage;
import nl.rosa.semanticdatabase.referencemodel.bmm.types.BmmModelType;
import nl.rosa.semanticdatabase.referencemodel.classes.BmmClass;
import nl.rosa.semanticdatabase.referencemodel.bmm.types.BmmGenericType;
import nl.rosa.semanticdatabase.referencemodel.bmm.types.BmmParameterType;

import java.util.List;
import java.util.Map;


/**
 * Class BmmGenericClass
 * Definition of a generic class in an object model.
 * 
 * (effected) type (): BMM_GENERIC_TYPE
 * Generate a fully open BMM_GENERIC_TYPE instance that corresponds to this class
 * definition
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
@Data
public class BmmGenericClass extends BmmClass {

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


  private BmmParameterType genericParameters;
  
  //
  // Constructors
  //
  public BmmGenericClass () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of genericParameters
   * @param newVar the new value of genericParameters
   */
  public void setGenericParameters (BmmParameterType newVar) {
    genericParameters = newVar;
  }

  /**
   * Get the value of genericParameters
   * @return the value of genericParameters
   */
  public BmmParameterType getGenericParameters () {
    return genericParameters;
  }

  //
  // Other methods
  //

  /**
   * Add suppliers from generic parameters.
   * @return       List<String>
   */
  public List<String> suppliers()
  {
  }


  /**
   * For a generic class, type to which generic parameter a_name conforms e.g. if
   * this class is Interval <T:Comparable> then the Result will be the single type
   * Comparable. For an unconstrained type T, the Result will be Any.
   * @return       String
   * @param        name
   */
  public String genericParameterConformanceType(String name)
  {
  }


  /**
   * Generate a fully open BMM_GENERIC_TYPE instance that corresponds to this class
   * definition
   * @return       types.BmmGenericType
   */
  public BmmGenericType type()
  {
  }


}
