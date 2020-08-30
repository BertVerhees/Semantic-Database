package nl.rosa.semanticdatabase.bmmdata.domain.class_features;

import lombok.*;
import nl.rosa.semanticdatabase.base.MultiplicityInterval;
import nl.rosa.semanticdatabase.bmmdata.domain.types.BmmContainerType;
import nl.rosa.semanticdatabase.bmmdata.domain.types.BmmSignature;
import nl.rosa.semanticdatabase.bmmdata.domain.types.BmmUnitaryType;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


/**
 * Class BmmContainerProperty
 * Meta-type of for properties of linear container type, such as List<T> etc.
 */
public class BmmContainerProperty extends BmmProperty  {
  /**
   * 0..1
   * cardinality: Multiplicity_interval
   * Cardinality of this container.
   */
  @Getter
  @Setter
  private MultiplicityInterval cardinality;

  /**
   * 1..1
   * (redefined)
   * type: BMM_UNITARY_TYPE
   * Declared or inferred static type of the entity.
   */
  @NonNull
  @Getter
  @Setter
  private BmmContainerType type;

  /**
   * 1..1
   * (abstract)
   * signature (): BMM_SIGNATURE
   * Formal signature of this element, in the form:
   * name [arg1_name: T_arg1, …​][:T_value]
   * Specific implementations in descendants.
   * @return
   */
   @Override
  public BmmSignature signature() {
    return null;
  }

  /**
   * 1..1
   * is_boolean (): Boolean
   * Post_result: Result = type().equal( {BMM_MODEL}.boolean_type_definition())
   * True if type is notionally Boolean (i.e. a BMM_SIMPLE_TYPE with type_name() = 'Boolean').
   * @return
   */
  @Override
  public Boolean isBoolean() {
    return null;
  }

  /**
   * 1..1
   * (redefined)
   * display_name (): String
   * Name of this property in form name: ContainerTypeName<>.
   * @return
   */
  public String displayName(){
    return null;
  }
}
