package nl.rosa.semanticdatabase.bmmdata.domain.class_features;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import nl.rosa.semanticdatabase.bmmdata.domain.types.BmmSignature;
import nl.rosa.semanticdatabase.bmmdata.domain.types.BmmType;
import nl.rosa.semanticdatabase.bmmdata.domain.types.BmmUnitaryType;


/**
 * Class BmmUnitaryProperty
 * Meta-type of for properties of unitary type.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BmmUnitaryProperty extends BmmProperty  {
  /**
   * 0..1
   * is_nullable: Boolean
   * {default = false}
   * True if this element can be null (Void) at execution time. May be interpreted as optionality in subtypes..
   */
  private Boolean isNullable;
  /**
   * 1..1
   * (redefined)
   * type: BMM_UNITARY_TYPE
   * Declared or inferred static type of the entity.
   */
  @NonNull
  private BmmUnitaryType type;
  /**
   * This is an inheritiance anomaly, please ignore, it has to do with Java not supporting multiple inheritance and
   * interface use for that reason
   * @param newVar
   */
  @Override
  @Deprecated
  public void setType(BmmType newVar) {
    this.type = (BmmUnitaryType) newVar;
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
