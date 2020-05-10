package nl.rosa.semanticdatabase.referencemodel.bmm.class_features;

import lombok.Data;
import nl.rosa.semanticdatabase.base.MultiplicityInterval;
import nl.rosa.semanticdatabase.referencemodel.bmm.classes.BmmClass;
import nl.rosa.semanticdatabase.referencemodel.bmm.model_structure.BmmDeclaration;
import nl.rosa.semanticdatabase.referencemodel.bmm.types.BmmContainerType;

import java.util.Map;


/**
 * Class BmmContainerProperty
 * Meta-type of for properties of linear container type, such as List<T> etc.
 */
@Data
public class BmmContainerProperty implements BmmProperty {

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


  // BmmTypedfeature
  /**
   * True if this element can be null (Void) at execution time. May be interpreted as optionality in subtypes..
   * {default = false}   */

  private boolean isNullable;


  // BmmTyped

  //BmmClassScoped
  /**
   * Visibility of this item to client entities.
   * TODO: define scheme; probably need to support C++/Java scheme as well as better type-based schemes.   */

  private Object visibility;
  private BmmClass scope;
  // BmmProperty
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
  private BmmContainerType type;
  /**
   * Cardinality of this container.
   */
  private MultiplicityInterval cardinality;
  
  //
  // Constructors
  //
  public BmmContainerProperty () { };
  
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
  public void setType (BmmContainerType newVar) {
    type = newVar;
  }

  /**
   * Get the value of type
   * Declared or inferred static type of the entity.
   * @return the value of type
   */
  public BmmContainerType getType () {
    return type;
  }

  /**
   * Set the value of cardinality
   * Cardinality of this container.
   * @param newVar the new value of cardinality
   */
  public void setCardinality (MultiplicityInterval newVar) {
    cardinality = newVar;
  }

  /**
   * Get the value of cardinality
   * Cardinality of this container.
   * @return the value of cardinality
   */
  public MultiplicityInterval getCardinality () {
    return cardinality;
  }

  //
  // Other methods
  //

  /**
   * Name of this property in form name: ContainerTypeName<>.
   * 
   * @return       String
   */
  public String displayName()
  {
  }


}
