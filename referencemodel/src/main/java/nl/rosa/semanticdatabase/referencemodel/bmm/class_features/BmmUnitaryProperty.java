package nl.rosa.semanticdatabase.referencemodel.bmm.class_features;

import lombok.Data;
import nl.rosa.semanticdatabase.referencemodel.bmm.classes.BmmClass;
import nl.rosa.semanticdatabase.referencemodel.bmm.model_structure.BmmDeclaration;
import nl.rosa.semanticdatabase.referencemodel.bmm.types.BmmType;
import nl.rosa.semanticdatabase.referencemodel.bmm.types.BmmUnitaryType;

import java.util.Map;


/**
 * Class BmmUnitaryProperty
 * Meta-type of for properties of unitary type.
 */
@Data
public class BmmUnitaryProperty implements BmmProperty {

  //
  // Fields
  //

  // BmmDeclaration
  private String name;
  private Map<String,Object> documentation;
  private BmmDeclaration scope;
  private Map<String,Object> extensions;

  // BmmClassEntity
  private boolean isSynthesisedGeneric;

  // BmmTypedFeature
  /**
   * True if this element can be null (Void) at execution time. May be interpreted as optionality in subtypes..
   * {default = false}   */

  private boolean isNullable;


  // BmmTyped
  /**
   * Declared or inferred static type of the entity.
   */
  private BmmType type;


  //BmmClassScoped
  /**
   * Visibility of this item to client entities.
   * TODO: define scheme; probably need to support C++/Java scheme as well as better type-based schemes.   */

  private Object visibility;
  private BmmClass scope;
  //BmmProperty
  private boolean isSynthesisedGeneric;
  /**

   * True if this property is marked with info model im_runtime property.
   * {default = false}   */

  private boolean isImRuntime;
  /**
   * True if this property was marked with info model im_infrastructure flag.{default = false}
   */
  private boolean isImInfrastructure;  /**

   * True if this property instance is a compositional sub-part of the owning class instance. Equivalent to 'composition' in UML associations (but missing from UML properties without associations) and also 'cascade-delete' semantics in ER schemas.
   * {default = false}   */

  private boolean isComposition;



  /**
   * Declared or inferred static type of the entity.
   */
  private BmmUnitaryType type;
  
  //
  // Constructors
  //
  public BmmUnitaryProperty () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of type
   * Declared or inferred static type of the entity.
   * @param newVar the new value of type
   */
  public void setType (BmmUnitaryType newVar) {
    type = newVar;
  }

  /**
   * Get the value of type
   * Declared or inferred static type of the entity.
   * @return the value of type
   */
  public BmmUnitaryType getType () {
    return type;
  }

  //
  // Other methods
  //

}
