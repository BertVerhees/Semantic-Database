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
 * BmmClass
 *  BmmModule
 *    BHmmDeclaration
 *  BmmEntity
 */

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
  /**
   * BmmModule
   */
  @NotNull
  private BmmModel scope;
  /**
   * BmmEntity
   */
  /**
   * 0..1
   * is_primitive: Boolean
   * True if this class represents a type considered to be primitive in the type system,
   * i.e. any typically built-in or standard library type such as String, Date, Hash<K,V> etc.
   * @return
   */
  @NotNull
  public Boolean isPrimitive(){
    return false;
  };
  /**
   * 0..1
   * is_abstract: Boolean
   * True if this class is marked as abstract, i.e. direct instances cannot be created from its direct type.
   */
  @NotNull
  private Boolean isAbstract;
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
