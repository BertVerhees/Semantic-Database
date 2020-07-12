package nl.rosa.semanticdatabase.bmmdata.domain.types;

import lombok.*;
import nl.rosa.semanticdatabase.bmmdata.domain.class_features.BmmParameter;
import nl.rosa.semanticdatabase.bmmdata.domain.classes.BmmGenericClass;

import javax.persistence.Entity;
import java.util.*;


/**
 * Class BmmGenericType
 * Meta-type based on a non-container generic class, e.g. Packet<Header>.
 * 
 * (effected) type_name (): String
 * Return the full name of the type including generic parameters, e.g.
 * DV_INTERVAL<T>, TABLE<List<THING>,String>.
 * (effected) is_abstract (): Boolean
 * True if base_class.is_abstract or if any (non-open) parameter type is abstract.
 * (effected) flattened_type_list (): List<String>
 * Result is base_class.name followed by names of all generic parameter type names,
 * which may be open or closed.
 * 
 */
public class BmmGenericType extends BmmModelType  {
  /**
   * 1..1
   * generic_parameters: List<BMM_UNITARY_TYPE>
   * Generic parameters of the root_type in this type specifier. The order must match the order of the owning class’s
   * formal generic parameter declarations, and the types may be defined types or formal parameter types.
   */
  @NonNull
  private Set<BmmUnitaryType> genericParameters = new HashSet<>();
  public void addGenericParameter(@NonNull BmmUnitaryType value){
    genericParameters.add(value);
  }
  public void addGenericParameters(Set<BmmUnitaryType> items){
    items.forEach(this::addGenericParameter);
  }
  public void removeGenericParameter(BmmUnitaryType item){
    genericParameters.remove(item);
  }
  public void removeGenericParameters(Collection<BmmUnitaryType> items){
    items.forEach(this::removeGenericParameter);
  }
  public void removeGenericParameters(Set<BmmParameter> items) {
    this.genericParameters.removeAll(items);
  }
  void setGenericParameters(Set<BmmUnitaryType> items) {
    this.genericParameters = items;
  }
  Set<BmmUnitaryType> getGenericParameters() {
    return genericParameters;
  }
  public Set<BmmUnitaryType> genericParameters() {
    return Collections.unmodifiableSet(genericParameters);
  }

  /**
   * 1..1
   * (redefined)
   * base_class: BMM_GENERIC_CLASS
   * The target type; this converts to the first parameter in generic_parameters in BMM_GENERIC_TYPE.
   */
  @NonNull
  @Getter
  @Setter
  private BmmGenericClass baseClass;
  
  /**
   * 1-1
   * Returns True if there is any substituted generic parameter.
   * @return       Boolean
   */
  @NonNull
  public Boolean isPartiallyClosed()
  {
    //TODO
    return false;
  }

  /**
   * 1-1
   * Effective underlying class for this type, abstracting away any container type.
   * @return       classes.BmmGenericClass
   */
  @NonNull
  public BmmGenericClass effectiveBaseClass()
  {
    //TODO
    return null;
  }

  /**
   * 1-1
   * True if all generic parameters from ancestor generic nl.rosa.semanticdatabase.bmm.model.types have been substituted
   * in this type.
   * @return       Boolean
   */
  @NonNull
  public Boolean isOpen()
  {
    //TODO
    return false;
  }

  /**
   * 1..1
   * (effected)
   * type_name (): String
   * Return the full name of the type including generic parameters, e.g. DV_INTERVAL<T>, TABLE<List<THING>,String>.
   * @return
   */
  @Override
  public @NonNull String typeName() {
    return null;
  }

  /**
   * 1..1
   * (effected)
   * flattened_type_list (): List<String>
   * Result is base_class.name followed by names of all generic parameter type names, which may be open or closed.
   * @return
   */
  @Override
  public @NonNull List<String> flattenedTypeList() {
    return null;
  }

  /**
   * 1..1
   * (effected)
   * is_abstract (): Boolean
   * True if base_class.is_abstract or if any (non-open) parameter type is abstract.
   * @return
   */
  @Override
  public @NonNull Boolean isAbstract() {
    return null;
  }
}
