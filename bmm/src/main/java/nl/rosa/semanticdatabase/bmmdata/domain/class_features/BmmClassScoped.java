package nl.rosa.semanticdatabase.bmmdata.domain.class_features;

import lombok.Data;
import lombok.EqualsAndHashCode;
import nl.rosa.semanticdatabase.bmmdata.domain.classes.BmmClass;

import javax.persistence.DiscriminatorValue;


/**
 * Class BmmClassScoped
 * A class entity having a signature and a class as its scope.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class BmmClassScoped extends BmmClassEntity {

  /**
   * 0..1
   * visibility: Any
   * Visibility of this item to client entities.
   */
  private Object visibility;

  /**
   * 1..1
   * (redefined)
   * scope: BMM_CLASS
   * Class within which a referenceable element is known.
   */
  private BmmClass scope;
}
