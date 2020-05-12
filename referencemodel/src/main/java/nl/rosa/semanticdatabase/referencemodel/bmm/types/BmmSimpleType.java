package nl.rosa.semanticdatabase.referencemodel.bmm.types;

import lombok.Data;
import nl.rosa.semanticdatabase.referencemodel.bmm.classes.BmmClass;
import nl.rosa.semanticdatabase.referencemodel.bmm.classes.BmmSimpleClass;
import nl.rosa.semanticdatabase.referencemodel.bmm.classes.BmmValueSpec;

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
public class BmmSimpleType implements BmmModelType {

  //
  // Fields
  //

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
  public boolean isRootScope() {
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
   * Signature form of the type name, which for generics includes generic parameter constrainer types E.g. Interval<T:Ordered>.
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
  public void setBaseClass(BmmClass newVar) {
    this.baseClass = (BmmSimpleClass) newVar;
  }

  @Override
  public String typeBaseName() {
    //TODO
    return null;
  }
}
