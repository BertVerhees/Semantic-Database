package nl.rosa.semanticdatabase.bmmdata.model.types;

import lombok.Data;
import nl.rosa.semanticdatabase.bmmdata.model.BmmBaseEntity;
import nl.rosa.semanticdatabase.bmmdata.model.classes.BmmClass;
import nl.rosa.semanticdatabase.bmmdata.model.classes.BmmSimpleClass;
import nl.rosa.semanticdatabase.bmmdata.model.classes.BmmValueSpec;

import javax.validation.constraints.NotNull;
import java.util.List;


/**
 * Class BmmSimpleType
 * Type reference to a single type i.e. not generic or container type.
 * 
 * (effected) type_name (): String
 * Result is base_class.name.
 * (effected) is_abstract (): Boolean
 * Result is base_class.is_abstract.
 * (effected) flattened_type_list (): List<String>
 * Result is base_class.name .
 * 
 */
@Data
public class BmmSimpleType extends BmmBaseEntity implements BmmModelType {
  /**
   * BmmModelType
   *  BmmEffectiveType
   *    BmmUnitaryType
   *      BmmType
   *        BmmEntity
   */

  /**
   * BmmEffectiveType
   */
  // Functions;
  @NotNull
  public BmmEffectiveType getEffectiveType(){
    return null;
  }
  @NotNull
  public String typeBaseName(){
    return null;
  }
  /**
   * BmmUnitaryType
   */
  // Functions
  @NotNull
  public BmmUnitaryType unitaryType(){
    return null;
  }
  /**
   * BmmType
   */
  // Functions
  @NotNull
  public String typeName(){
    return null;
  }
  @NotNull
  public List<String> flattenedTypeList(){
    return null;
  }
  @NotNull
  public String typeSignature(){
    return null;
  }
  @NotNull
  public BmmUnitaryType unitaryType(){
    return null;
  }
  @NotNull
  public BmmEffectiveType effectiveType(){
    return null;
  }
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
   *  BmmModelType
   */
  private BmmValueSpec valueConstraint;
  @NotNull
  private BmmClass baseCLass;
//==================================================================================

  // BmmModelType
  private BmmValueSpec valueConstraint;
  /**
   * Defining class of this type.
   */
  private BmmSimpleClass baseClass;
  
  //
  // Constructors
  //
  public BmmSimpleType () { };

  /**
   * True if this declaration entity is the root of the declaration hierarchy.
   * @return
   */
  public Boolean isRootScope() {
    return false;
  }

  /**
   * Formal string form of the type as per UML.
   * @return
   */
  @Override
  public String typeName() {
    //TODO
    return null;
  }

  /**
   * Completely flattened list of type names, flattening out all generic parameters.
   * @return
   */
  @Override
  public List<String> flattenedTypeList() {
    //TODO
    return null;
  }

  /**
   * Signature form of the type name, which for generics includes generic parameter constrainer nl.rosa.semanticdatabase.bmm.model.types E.g. Interval<T:Ordered>.
   *
   * Defaults to the value of type_name().
   * @return
   */
  @Override
  public String typeSignature() {
    //TODO
    return null;
  }

  /**
   * Type with any container abstracted away.
   * @return
   */
  @Override
  public BmmUnitaryType unitaryType() {
    //TODO
    return null;
  }

  /**
   * Type with any container abstracted away, and any formal parameter replaced by its effective constraint type.
   * @return
   */
  @Override
  public BmmEffectiveType effectiveType() {
    //TODO
    return null;
  }

  // BmmEntity
  @Override
  public Boolean isAbstract() {
    //TODO
    return false;
  }

  @Override
  public Boolean isPrimitive() {
    //TODO
    return false;
  }


  @Override
  @Deprecated
  public void setBaseClass(BmmClass newVar) {
    this.baseClass = (BmmSimpleClass) newVar;
  }

  @Override
  public String typeBaseName() {
    //TODO
    return null;
  }
}
