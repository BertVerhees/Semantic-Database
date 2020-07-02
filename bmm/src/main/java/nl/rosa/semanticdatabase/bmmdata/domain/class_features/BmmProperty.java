package nl.rosa.semanticdatabase.bmmdata.domain.class_features;


import lombok.EqualsAndHashCode;
import nl.rosa.semanticdatabase.base.MultiplicityInterval;
import nl.rosa.semanticdatabase.bmmdata.domain.classes.BmmClass;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Class BmmProperty
 * Meta-type of a property definition within a class definition of an object model.
 * The is_composition attribute indicates whether the property has sub-part or an
 * association semantics with respect to the owning class.
 *
 * Invariants
 * Inv_signature_no_args: signature.arguments = Void
 */
@EqualsAndHashCode(callSuper = true)
@Entity
public abstract class BmmProperty extends BmmClassScoped implements BmmInstantiable {
  /**
   * 0..1
   * is_im_runtime: Boolean
   * {default = false}
   * True if this property is marked with info model im_runtime property.
   */
  private Boolean isImRuntime;

  /**
   * 0..1
   * is_im_infrastructure: Boolean
   * {default = false}
   * True if this property was marked with info model im_infrastructure flag.
   */
  private Boolean isImInfrastructure;

  /**
   * 0..1
   * is_composition: Boolean
   * {default = false}
   * True if this property instance is a compositional sub-part of the owning class instance.
   * Equivalent to 'composition' in UML associations (but missing from UML properties without associations)
   * and also 'cascade-delete' semantics in ER schemas.
   */
  private Boolean isComposition;

  // Functions
  /**
   * 1..1
   * existence (): Multiplicity_interval
   * Interval form of 0..1, 1..1 etc, derived from is_nullable.
   * @return
   */
  public MultiplicityInterval existence(){
    return null;
  }

  /**
   * 1..1
   * display_name (): String
   * Name of this property to display in UI.
   *
   * Invariants
   * Inv_signature_no_args: signature.arguments = Void
   * @return
   */
  public String displayName(){
    return null;
  }
  //========== counterparts =====================================================
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "fk_bmm_class_id")
  private BmmClass bmmClass;

}
