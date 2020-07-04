package nl.rosa.semanticdatabase.bmmdata.domain.class_features;

import lombok.*;
import nl.rosa.semanticdatabase.bmmdata.domain.classes.BmmClass;
import nl.rosa.semanticdatabase.bmmdata.domain.literal_values.BmmLiteralValue;
import nl.rosa.semanticdatabase.bmmdata.domain.types.BmmSignature;
import nl.rosa.semanticdatabase.bmmdata.domain.types.BmmType;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


/**
 * Class BmmConstant
 * An immutable, static value-returning element scoped to a class.
 *
 * Invariants
 * Inv_not_nullable: is_nullable = False
 * Inv_signature_no_args: signature.arguments = Void
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
public class BmmConstant extends BmmClassScoped implements BmmInstantiable{

  /**
   * 0..1
   * is_nullable: Boolean
   * {default = false}
   * True if this element can be null (Void) at execution time. May be interpreted as optionality in subtypes..
   * Implemented by interface BmmTypedFeature
   */
  @NonNull
  @Getter
  private Boolean isNullable;

  public BmmConstant setIsNullable(Boolean nullable) {
    isNullable = nullable;
    return this;
  }

  /**
   * 1..1
   * value: BMM_LITERAL_VALUE
   * The value of the constant.
   */
  @NonNull
  @Getter
  private BmmLiteralValue value;

  public BmmConstant setValue(BmmLiteralValue value) {
    this.value = value;
    return this;
  }

  /**
   * 1..1
   * type: BMM_TYPE
   * Declared or inferred static type of the entity.
   *
   * Implemented because of implemented derived interface from BmmTyped
   */
  @NonNull
  @Getter
  private BmmType type;

  public BmmConstant setType(BmmType type) {
    this.type = type;
    return this;
  }

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
  public Boolean isBoolean() {
    return null;
  }

  //======== counterparts =============================================
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "fk_bmm_class_id")
  private BmmClass bmmClass;
  private void setBmmClass(BmmClass bmmClass){
    this.bmmClass = bmmClass;
  }

}
