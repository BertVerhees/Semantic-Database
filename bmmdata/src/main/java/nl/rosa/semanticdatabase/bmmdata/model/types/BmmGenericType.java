package nl.rosa.semanticdatabase.bmmdata.model.types;

import lombok.Data;
import nl.rosa.semanticdatabase.bmmdata.model.BmmBaseEntity;
import nl.rosa.semanticdatabase.bmmdata.model.classes.BmmClass;
import nl.rosa.semanticdatabase.bmmdata.model.classes.BmmGenericClass;
import nl.rosa.semanticdatabase.bmmdata.model.classes.BmmValueSpec;

import javax.validation.constraints.NotNull;
import java.util.List;


/**
 * Class BmmGenericType
 * Meta-type based on a non-container generic class, e.g. Packet<Header>.
 * 
 * (effected) type_name (): String
 * Return the full name of the type including generic parameters, e.g.
 * DV_INTERVAL<T>, TABLE<List<THING>,String>.
 * (effected) is_abstract (): Boolean
 * True if base_class.is_abstract or if any (non-open) parameter type is abstract.
 * (effected) flattened_type_list (): List<String>
 * Result is base_class.name followed by names of all generic parameter type names,
 * which may be open or closed.
 * 
 */
@Data
public class BmmGenericType extends BmmBaseEntity implements BmmModelType {
  /**
   * BmmModelType
   *  BmmEffectiveType
   *    BmmUnitaryType
   *      BmmType
   *        BmmEntity
   */
  /**
   *  BmmModelType
   */
  private BmmValueSpec valueConstraint;
  @NotNull
  private BmmClass baseCLass;
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
  //==================================================================================
  // Bmm ModelType
  private BmmValueSpec valueConstraint;


  /**
   * Generic parameters of the root_type in this type specifier. The order must match the order of the owning class�s formal generic parameter declarations, and the nl.rosa.semanticdatabase.bmm.model.types may be defined nl.rosa.semanticdatabase.bmm.model.types or formal parameter nl.rosa.semanticdatabase.bmm.model.types.
   */
  private List<BmmUnitaryType> genericParameters;
  /**
   * The target type; this converts to the first parameter in generic_parameters in BMM_GENERIC_TYPE.
   */
  private BmmGenericClass baseClass;
  private BmmUnitaryType new_attribute;
  
  //
  // Constructors
  //
  public BmmGenericType () { };

  /**
   * Signature form of the type, which for generics includes generic parameter
   * constrainer nl.rosa.semanticdatabase.bmm.model.types E.g. Interval<T:Ordered>.
   * @return       String
   */
  public String typeSignature()
  {
    //TODO
    return null;
  }


  /**
   * Returns True if there is any substituted generic parameter.
   * @return       Boolean
   */
  public Boolean isPartiallyClosed()
  {
    //TODO
    return false;
  }


  /**
   * Effective underlying class for this type, abstracting away any container type.
   * @return       classes.BmmGenericClass
   */
  public BmmGenericClass effectiveBaseClass()
  {
    //TODO
    return null;
  }


  /**
   * True if all generic parameters from ancestor generic nl.rosa.semanticdatabase.bmm.model.types have been substituted
   * in this type.
   * @return       Boolean
   */
  public Boolean isOpen()
  {
    //TODO
    return false;
  }

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
  public void setBaseClass(BmmClass newVar) {
    this.baseClass = (BmmGenericClass) newVar;
  }

  @Override
  public String typeBaseName() {
    //TODO
    return null;
  }
}
