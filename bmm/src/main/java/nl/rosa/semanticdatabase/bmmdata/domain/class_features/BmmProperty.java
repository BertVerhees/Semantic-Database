package nl.rosa.semanticdatabase.bmmdata.domain.class_features;


import lombok.Getter;
import lombok.Setter;
import nl.rosa.semanticdatabase.base.MultiplicityInterval;
import nl.rosa.semanticdatabase.bmmdata.domain.types.BmmType;

/**
 * Class BmmProperty
 * Meta-type of a property definition within a class definition of an object model.
 * The is_composition attribute indicates whether the property has sub-part or an
 * association semantics with respect to the owning class.
 *
 * Invariants
 * Inv_signature_no_args: signature.arguments = Void
 */
public abstract class BmmProperty extends BmmClassFeature implements BmmInstantiable {

  /**
   * 0..1
   *
   * is_nullable: Boolean
   * {default = false}
   *
   * True if this element can be null (Void) at execution time. May be interpreted as optionality in subtypes..
   *
   * Implemented because of implemented derived interface from BmmTyped
   */
  @Getter
  @Setter
  protected Boolean isNullable;
  /**
   * 1..1
   * type: BMM_TYPE
   * Declared or inferred static type of the entity.
   *
   * Implemented because of implemented derived interface from BmmTyped
   */
  @Getter
  @Setter
  protected BmmType type;

  /**
   * 0..1
   * is_im_runtime: Boolean
   * {default = false}
   * True if this property is marked with info model im_runtime property.
   */
  @Getter
  @Setter
  private Boolean isImRuntime;

  /**
   * 0..1
   * is_im_infrastructure: Boolean
   * {default = false}
   * True if this property was marked with info model im_infrastructure flag.
   */
  @Getter
  @Setter
  private Boolean isImInfrastructure;

  /**
   * 0..1
   * is_composition: Boolean
   * {default = false}
   * True if this property instance is a compositional sub-part of the owning class instance.
   * Equivalent to 'composition' in UML associations (but missing from UML properties without associations)
   * and also 'cascade-delete' semantics in ER schemas.
   */
  @Getter
  @Setter
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
}
