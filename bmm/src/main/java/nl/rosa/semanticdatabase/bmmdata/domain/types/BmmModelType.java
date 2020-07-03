package nl.rosa.semanticdatabase.bmmdata.domain.types;

import lombok.Getter;
import lombok.NonNull;
import nl.rosa.semanticdatabase.bmmdata.domain.classes.BmmClass;
import nl.rosa.semanticdatabase.bmmdata.domain.classes.BmmValueSetSpec;

import javax.persistence.*;


/**
 * Class BmmModelType
 * A type that is defined by a class (or classes) in the model.
 * 
 * (effected) type_base_name (): String
 * Result = defining_class.name.
 * (effected) is_primitive (): Boolean
 * Result = defining_class.is_primitive.
 *
 *  * !!IMPORTANT!!
 *  * BmmModelType has two relations to BmmClass
 *  * 1) OneToOne because over baseClass
 *  * 2) ManyToOne, to define the ancestors of BmmClass (multiple inheritance is possible)
 * 
 */
@Entity
public abstract class BmmModelType extends BmmEffectiveType {

  /**
   * 0..1
   * value_constraint: BMM_VALUE_SET_SPEC
   */
  private BmmValueSetSpec valueConstraint;
  /**
   * 1..1
   * base_class: BMM_CLASS
   * Defining class of this type.
   */
  @Getter
  @OneToOne(mappedBy = "bmm_model_type", cascade = CascadeType.ALL,
           fetch = FetchType.LAZY)
  private BmmClass baseClass;
  // Functions

  /**
   * 1..1
   * (effected)
   * type_base_name (): String
   * Result = defining_class.name.
   * @return
   */
  @Override
  @NonNull
  @MapKey
  public String typeBaseName() {
    return null;
  }

  /**
   * 1..1
   * (effected)
   * is_primitive (): Boolean
   * Result = defining_class.is_primitive.
   * @return
   */
  @Override
  public Boolean isPrimitive() {
    return null;
  }

  //========== counterparts =====================================================
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "fk_bmm_class_id")
  private BmmClass bmmClass;
}
