package nl.rosa.semanticdatabase.bmmdata.model.types;


import lombok.Data;
import nl.rosa.semanticdatabase.bmmdata.model.BmmBaseEntity;
import nl.rosa.semanticdatabase.bmmdata.model.classes.BmmClass;
import nl.rosa.semanticdatabase.bmmdata.model.classes.BmmValueSpec;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Class BmmParameterType
 * Definition of a generic parameter in a class definition of a generic type.
 * 
 * (effected) is_primitive (): Boolean
 * Result = False - generic parameters are understood by definition to be
 * non-primitive.
 * (effected) is_abstract (): Boolean
 * Result = False - generic parameters are understood by definition to be
 * non-abstract.
 * (effected) type_name (): String
 * Return name.
 * (effected) flattened_type_list (): List<String>
 * Result is either flattened_conforms_to_type.flattened_type_list or the Any type.
 * (effected) effective_type (): BMM_EFFECTIVE_TYPE
 * Generate ultimate conformance type, which is either flattened_conforms_to_type
 * or if not set, Any.
 * 
 */
@Data
public class BmmParameterType extends BmmBaseEntity implements BmmUnitaryType {
  /**
   *    BmmUnitaryType
   *      BmmType
   *        BmmEntity
   */
  /**
   * BmmUnitaryType
   */
  // Functions
  @NotNull
  public BmmUnitaryType unitaryType(){
    return null;
  }
  /**
   * BmmType
   */
  // Functions
  @NotNull
  public String typeName(){
    return null;
  }
  @NotNull
  public List<String> flattenedTypeList(){
    return null;
  }
  @NotNull
  public String typeSignature(){
    return null;
  }
  @NotNull
  public BmmEffectiveType effectiveType(){
    return null;
  }
  /**
   * BmmEntity
   */
  // Functions
  @NotNull
  public Boolean isAbstract(){
    return null;
  }
  @NotNull
  public Boolean isPrimitive(){
    return null;
  }
  private BmmValueSpec valueConstraint;
  @NotNull
  private BmmClass baseClass;
//==================================================================================
  //
  // Fields
  //

  /**
   * Name of the parameter, e.g. 'T' etc. The name is limited to 1 character and upper-case.
   */
  private String name;
  /**
   * Optional conformance constraint that must be the name of a defined type.
   */
  private BmmEffectiveType typeConstraint;
  /**
   * If set, is the corresponding generic parameter definition in an ancestor class.
   */
  private BmmParameterType inheritancePrecursor;
}
