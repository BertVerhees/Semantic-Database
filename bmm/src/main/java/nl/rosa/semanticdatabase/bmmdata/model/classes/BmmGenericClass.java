package nl.rosa.semanticdatabase.bmmdata.model.classes;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmGenericType;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmParameterType;

import java.util.List;
import java.util.Map;


/**
 * Class BmmGenericClass
 * Definition of a generic class in an object model.
 * 
 * (effected) type (): BMM_GENERIC_TYPE
 * Generate a fully open BMM_GENERIC_TYPE instance that corresponds to this class
 * definition
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BmmGenericClass extends BmmClass {
  /**
   * 1..1
   * generic_parameters: Hash<String,BMM_PARAMETER_TYPE>
   * List of formal generic parameters, keyed by name.
   * These are defined either directly on this class or by the inclusion of an ancestor class which is generic.
   */
  private Map<String, BmmParameterType> genericParameters;

  /**
   * 0..1
   * (redefined)
   * suppliers (): List<String>
   * Add suppliers from generic parameters.
   * @return
   */
  @Override
  public List<String> suppliers(){
    return null;
  }

  /**
   * 1..1
   * (effected)
   * type (): BMM_GENERIC_TYPE
   * Generate a fully open BMM_GENERIC_TYPE instance that corresponds to this class definition
   * @return
   */
  @Override
  public BmmGenericType type() {
    return null;
  }

  /**
   * 1..1
   * generic_parameter_conformance_type (
   * a_name: String[1]
   * ): String
   * For a generic class, type to which generic parameter a_name conforms
   * e.g. if this class is Interval <T:Comparable> then the Result will be the single type Comparable.
   * For an unconstrained type T, the Result will be Any.
   * @param name
   * @return
   */
  public String genericParameterConformanceType(@NonNull String name){
    return null;
  }

}
