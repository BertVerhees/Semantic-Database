package nl.rosa.semanticdatabase.bmmdata.domain.classes;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import nl.rosa.semanticdatabase.bmmdata.domain.class_features.BmmFunction;
import nl.rosa.semanticdatabase.bmmdata.domain.types.BmmGenericType;
import nl.rosa.semanticdatabase.bmmdata.domain.types.BmmParameterType;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.*;


/**
 * Class BmmGenericClass
 * Definition of a generic class in an object model.
 * 
 * (effected) type (): BMM_GENERIC_TYPE
 * Generate a fully open BMM_GENERIC_TYPE instance that corresponds to this class
 * definition
 */
@EqualsAndHashCode(callSuper = true)
public class BmmGenericClass extends BmmClass {
  /**
   * 1..1
   * generic_parameters: Hash<String,BMM_PARAMETER_TYPE>
   * List of formal generic parameters, keyed by name.
   * These are defined either directly on this class or by the inclusion of an ancestor class which is generic.
   */
  private Map<String, BmmParameterType> genericParameters;

  public void putGenericParameter(@NonNull String key, @NonNull BmmParameterType value){
    if(genericParameters==null){
      genericParameters = new HashMap<>();
    }
    genericParameters.put(key,  value);

  }
  public void putGenericParameters(Map<String, BmmParameterType> items){
    items.keySet().forEach(key -> putGenericParameter(key, items.get(key)));

  }
  public BmmParameterType getGenericParameter(String key){
    if(genericParameters==null){
      return null;
    }
    return genericParameters.get(key);
  }
  public void removeGenericParameter(String key){
    if(genericParameters!=null) {
      genericParameters.remove(key);
    }
  }
  public void removeGenericParameters(Collection<String> keys){
    keys.forEach(this::removeGenericParameter);
  }
  private void setGenericParameters(Map<String, BmmParameterType> parameters) {
    this.genericParameters = parameters;
  }
  private Map<String,BmmParameterType> getGenericParameters() {
    return genericParameters;
  }
  public Map<String,BmmParameterType> genericParameters() {
    return Collections.unmodifiableMap(genericParameters);
  }
//====================== functions ========================================
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
