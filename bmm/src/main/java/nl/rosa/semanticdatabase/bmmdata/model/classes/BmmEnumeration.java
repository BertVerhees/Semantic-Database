package nl.rosa.semanticdatabase.bmmdata.model.classes;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import nl.rosa.semanticdatabase.bmmdata.model.class_features.*;
import nl.rosa.semanticdatabase.bmmdata.model.expressions.ElAssertion;
import nl.rosa.semanticdatabase.bmmdata.model.literal_values.BmmLiteralValue;
import nl.rosa.semanticdatabase.bmmdata.model.model_structure.BmmModel;
import nl.rosa.semanticdatabase.bmmdata.model.model_structure.BmmPackage;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmModelType;

import lombok.NonNull;
import java.util.List;
import java.util.Map;


/**
 * Class BmmEnumeration
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BmmEnumeration extends BmmSimpleClass {
/**
 * BmmClass
 *  BmmModule
 *    BmmDeclaration
 *  BmmEntity
 */
  /**
   * BmmEntity
   */
  // Functions
  @NonNull
  public Boolean isAbstract(){
    return null;
  }
  @NonNull
  public Boolean isPrimitive(){
    return null;
  }
  /**
   * BmmClass
   */
  private Map<String, BmmModelType> ancestors;
  @NonNull
  private BmmPackage _package;
  private Map<String, BmmProperty> properties;
  @NonNull
  private String sourceSchemaId;
  private List<BmmClass> immediateDescendants;
  @NonNull
  private Boolean isOverride;
  private Map<String, BmmConstant> constants;
  private Map<String, BmmFunction> functions;
  private Map<String, BmmProcedure> procedures;
  private List<ElAssertion> inVariants;
  private Map<String, BmmProcedure> creators;
  private Map<String, BmmProcedure> convertors;
  // Functions
  public List<String> allAncestors(){
    return null;
  }
  public List<String> allDescendants(){
    return null;
  }
  public List<String> suppliers(){
    return null;
  }
  public List<String> suppliersNonPrimitive(){
    return null;
  }
  public List<String> supplierClosure(){
    return null;
  }
  @NonNull
  public String packagePath(){
    return null;
  }
  @NonNull
  public String classPath(){
    return null;
  }
  public List<BmmClassScoped> features(){
    return null;
  }
  public List<BmmClassScoped> flatFeatures(){
    return null;
  }
  public List<BmmProperty> flatProperties(){
    return null;
  }
  /**
   * BmmModule
   */
  @NonNull
  private BmmModel scope;
  /**
   * BmmDeclaration
   */
  @NonNull
  private String name;
  private Map<String, Object> documentation;
  private Map<String, Object> extensions;

  @Override
  public Boolean isRootScope(){
    return scope.equals(this);
  }
  //============================================================

  public BmmEnumeration() {
  }

  /**
   * The list of names of the enumeration. If no values are supplied, the integer values 0, 1, 2, �? are assumed.
   */
  private List<String> itemNames;
  /**
   * Optional list of specific values. Must be 1:1 with item_names list.
   */
  private BmmLiteralValue itemValues;
  /**
   * @return       Hash<String,String>
   */
  public Map<String,String> nameMap()
  {
    //TODO
    return null;
  }
}
