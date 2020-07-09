package nl.rosa.semanticdatabase.bmmdata.domain.classes;

import lombok.EqualsAndHashCode;
import nl.rosa.semanticdatabase.bmmdata.domain.types.BmmSimpleType;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


/**
 * Class BmmSimpleClass
 * Definition of a simple class, i.e. a class that has no generic parameters and is
 * 1:1 with the type it generates.
 * 
 * (effected) type (): BMM_SIMPLE_TYPE
 * Generate a type object that represents the type of this class. Can only be an
 * instance of BMM_SIMPLE_TYPE or a descendant.
 * 
 */
@EqualsAndHashCode(callSuper = true)
public class BmmSimpleClass extends BmmClass {

  /**
   * 1..1
   * (effected)
   * type (): BMM_SIMPLE_TYPE
   * Generate a type object that represents the type of this class. Can only be an instance of BMM_SIMPLE_TYPE
   * or a descendant.
   * @return
   */
  @Override
  public BmmSimpleType type() {
    return null;
  }
}
