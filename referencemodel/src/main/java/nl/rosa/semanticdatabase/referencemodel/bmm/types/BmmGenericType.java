package nl.rosa.semanticdatabase.referencemodel.bmm.types;

import com.sun.xml.bind.v2.TODO;
import lombok.Data;
import nl.rosa.semanticdatabase.referencemodel.bmm.classes.BmmClass;
import nl.rosa.semanticdatabase.referencemodel.bmm.classes.BmmGenericClass;
import nl.rosa.semanticdatabase.referencemodel.bmm.classes.BmmValueSpec;

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
public class BmmGenericType extends BmmModelType {

  //
  // Fields
  //

  // Bmm ModelType
  private BmmValueSpec valueConstraint;
  /**
   * Defining class of this type.
   */
  private BmmClass baseClass;


  /**
   * Generic parameters of the root_type in this type specifier. The order must match the order of the owning class�s formal generic parameter declarations, and the types may be defined types or formal parameter types.
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
   * constrainer types E.g. Interval<T:Ordered>.
   * @return       String
   */
  public String typeSignature()
  {
    //TODO
    return null;
  }


  /**
   * Returns True if there is any substituted generic parameter.
   * @return       boolean
   */
  public boolean isPartiallyClosed()
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
   * True if all generic parameters from ancestor generic types have been substituted
   * in this type.
   * @return       boolean
   */
  public boolean isOpen()
  {
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

}
