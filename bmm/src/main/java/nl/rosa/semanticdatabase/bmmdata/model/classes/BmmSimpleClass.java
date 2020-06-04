package nl.rosa.semanticdatabase.bmmdata.model.classes;

import lombok.Data;
import lombok.EqualsAndHashCode;
import nl.rosa.semanticdatabase.bmmdata.model.BmmBaseEntity;
import nl.rosa.semanticdatabase.bmmdata.model.class_features.*;
import nl.rosa.semanticdatabase.bmmdata.model.expressions.ElAssertion;
import nl.rosa.semanticdatabase.bmmdata.model.model_structure.BmmDeclaration;
import nl.rosa.semanticdatabase.bmmdata.model.model_structure.BmmModel;
import nl.rosa.semanticdatabase.bmmdata.model.model_structure.BmmPackage;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmModelType;

import javax.validation.constraints.NotNull;
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
@EqualsAndHashCode(callSuper = true)
public class BmmSimpleClass extends BmmBaseEntity implements BmmClass {
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
  // Functions;
    @Override
  public Boolean isRootScope(){
    return scope.equals(this);
  }

  //============================================================
  @Override
  @Deprecated
  public void setScope(BmmDeclaration newVar) {
    this.scope = (BmmModel) newVar;
  }

  @Override
  public void setScope(BmmModel scope) {
    this.scope = scope;
  }

}
