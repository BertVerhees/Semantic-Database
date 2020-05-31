package nl.rosa.semanticdatabase.bmmdata.model.classes;

import lombok.Data;
import lombok.NonNull;
import nl.rosa.semanticdatabase.bmmdata.model.BmmBaseEntity;
import nl.rosa.semanticdatabase.bmmdata.model.class_features.*;
import nl.rosa.semanticdatabase.bmmdata.model.expressions.ElAssertion;
import nl.rosa.semanticdatabase.bmmdata.model.model_structure.BmmDeclaration;
import nl.rosa.semanticdatabase.bmmdata.model.model_structure.BmmModel;
import nl.rosa.semanticdatabase.bmmdata.model.model_structure.BmmPackage;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmModelType;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmSimpleType;

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
public class BmmSimpleClass extends BmmBaseEntity implements BmmClass {

  /**
   * BmmDeclaration
   */
  @NonNull
  private String name;
  private Map<String, Object> documentation;
  private Map<String, Object> extensions;

  @Override
  public boolean isRootScope(){
    return scope.equals(this);
  }
  /**
   * BmmModule
   */
  @NotNull
  private BmmModel scope;
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
  private boolean isOverride;
  private Map<String, BmmConstant> constants;
  private Map<String, BmmFunction> functions;
  private Map<String, BmmProcedure> procedures;
  private boolean isPrimitive;
  private boolean isAbstract;
  private List<ElAssertion> inVariants;
  private Map<String, BmmProcedure> creators;
  private Map<String, BmmProcedure> convertors;


  //
  // Constructors
  //
  public BmmSimpleClass () { };
  
  /**
   * Generate a type object that represents the type of this class. Can only be an
   * instance of BMM_SIMPLE_TYPE or a descendant.
   * @return       nl.rosa.semanticdatabase.bmm.model.types.BmmSimpleType
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

  // BmmEntity
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
