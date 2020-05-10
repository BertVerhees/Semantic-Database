package nl.rosa.semanticdatabase.referencemodel.bmm.class_features;

import lombok.*;
import nl.rosa.semanticdatabase.referencemodel.bmm.classes.BmmClass;
import nl.rosa.semanticdatabase.referencemodel.bmm.literal_values.BmmLiteralValue;
import nl.rosa.semanticdatabase.referencemodel.bmm.model_structure.BmmDeclaration;
import nl.rosa.semanticdatabase.referencemodel.bmm.types.BmmSignature;
import nl.rosa.semanticdatabase.referencemodel.bmm.types.BmmType;

import java.util.Map;


/**
 * Class BmmConstant
 * An immutable, static value-returning element scoped to a class.
 */
@Data
public class BmmConstant implements BmmClassScoped, BmmInstantiableClass {

  //
  // Fields
  //
  // BmmClassEntity
  private boolean isSynthesisedGeneric;

  // BmmDeclaration
  private String name;
  private Map<String,Object> documentation;
  private BmmDeclaration scope;
  private Map<String,Object> extensions;


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


  // BmmClassScoped
  /**
   * Visibility of this item to client entities.
   * TODO: define scheme; probably need to support C++/Java scheme as well as better type-based schemes.   */

  private Object visibility;
  private BmmClass scope;

  /**
   * The value of the constant.
   */
  private BmmLiteralValue value;
  
  //
  // Constructors
  //
  public BmmConstant () { };

  /**
   * Formal signature of this element, in the form:
   * name [arg1_name: T_arg1, �?][:T_value]
   * Specific implementations in descendants.
   */
  public BmmSignature signature(){
    //TODO
    return null;
  }

}
