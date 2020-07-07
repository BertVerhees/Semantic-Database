package nl.rosa.semanticdatabase.bmmdata.domain.class_features;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import nl.rosa.semanticdatabase.bmmdata.domain.types.BmmSignature;
import nl.rosa.semanticdatabase.bmmdata.domain.types.BmmUnitaryType;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


/**
 * Class BmmUnitaryProperty
 * Meta-type of for properties of unitary type.
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@DiscriminatorValue("BBE_BD_BCE_BCS_BP_BUP")
public class BmmUnitaryProperty extends BmmProperty  {
  /**
   * 1..1
   * (redefined)
   * type: BMM_UNITARY_TYPE
   * Declared or inferred static type of the entity.
   */
  @NonNull
  private BmmUnitaryType type;
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
   * (effected)
   * signature ()
   * Formal signature of this element, in the form
   * '[arg1_name: T_arg1, …​]:T_value'.
   * @return
   */
  @Override
  public BmmSignature signature() {
    return null;
  }
}
