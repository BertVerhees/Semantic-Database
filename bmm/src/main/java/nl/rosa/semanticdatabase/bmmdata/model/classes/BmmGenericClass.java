package nl.rosa.semanticdatabase.bmmdata.model.classes;

import lombok.Data;
import nl.rosa.semanticdatabase.bmmdata.model.BmmBaseEntity;
import nl.rosa.semanticdatabase.bmmdata.model.class_features.*;
import nl.rosa.semanticdatabase.bmmdata.model.expressions.ElAssertion;
import nl.rosa.semanticdatabase.bmmdata.model.model_structure.BmmDeclaration;
import nl.rosa.semanticdatabase.bmmdata.model.model_structure.BmmModel;
import nl.rosa.semanticdatabase.bmmdata.model.model_structure.BmmPackage;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmModelType;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmParameterType;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;


/**
 * Class BmmGenericClass
 * Definition of a generic class in an object model.
 * 
 * (effected) type (): BMM_GENERIC_TYPE
 * Generate a fully open BMM_GENERIC_TYPE instance that corresponds to this class
 * definition
 */
@Data
public class BmmGenericClass extends BmmBaseEntity implements BmmClass {
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
  @NotNull
  public Boolean isAbstract(){
    return null;
  }
  @NotNull
  public Boolean isPrimitive(){
    return null;
  }
  /**
   * BmmClass
   */
  private Map<String, BmmModelType> ancestors;
  @NotNull
  private BmmPackage _package;
  private Map<String, BmmProperty> properties;
  @NotNull
  private String sourceSchemaId;
  private List<BmmClass> immediateDescendants;
  @NotNull
  private Boolean isOverride;
  private Map<String, BmmConstant> constants;
  private Map<String, BmmFunction> functions;
  private Map<String, BmmProcedure> procedures;
  private List<ElAssertion> inVariants;
  private Map<String, BmmProcedure> creators;
  private Map<String, BmmProcedure> convertors;
  // Functions
  @NotNull
  public BmmModelType type(){
    return null;
  }
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
  @NotNull
  public String packagePath(){
    return null;
  }
  @NotNull
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
  @NotNull
  private BmmModel scope;
  /**
   * BmmDeclaration
   */
  @NotNull
  private String name;
  private Map<String, Object> documentation;
  private Map<String, Object> extensions;
  @Override
  public Boolean isRootScope(){
    return scope.equals(this);
  }
  //============================================================
  private BmmParameterType genericParameters;

  @Override
  @Deprecated
  public void setScope(BmmDeclaration newVar) {
    this.scope = (BmmModel) newVar;
  }
  @Override
  public void setProperties(Map<String, BmmProperty> newVar) {

  }

  @Override
  public void setConstants(Map<String, BmmConstant> newVar) {

  }

  @Override
  public void setFunctions(Map<String, BmmFunction> newVar) {

  }

  @Override
  public void setProcedures(Map<String, BmmProcedure> newVar) {

  }
  @Override
  public void setScope(BmmModel scope) {
    this.scope = scope;
  }
}
