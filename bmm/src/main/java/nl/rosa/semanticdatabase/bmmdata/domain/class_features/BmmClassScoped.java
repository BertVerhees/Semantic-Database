package nl.rosa.semanticdatabase.bmmdata.domain.class_features;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import nl.rosa.semanticdatabase.bmmdata.domain.classes.BmmClass;
import nl.rosa.semanticdatabase.bmmdata.domain.model_structure.BmmPackageContainer;

import javax.persistence.DiscriminatorValue;


/**
 * Class BmmClassScoped
 * A class entity having a signature and a class as its scope.
 */
@EqualsAndHashCode(callSuper = true)
public abstract class BmmClassScoped extends BmmClassEntity {

  /**
   * 0..1
   * visibility: Any
   * Visibility of this item to client entities.
   */
  @Getter
  private Object visibility;

  public void setVisibility(Object visibility) {
    this.visibility = visibility;
  }

  /**
   * 1..1
   * (redefined)
   * scope: BMM_CLASS
   * Class within which a referenceable element is known.
   */
  private BmmClass scope;
  public BmmClass getScope(){
    if(super.getScope() == null){
      throw new NullPointerException("Scope is null");
    }
    if(super.getScope() instanceof BmmClass) {
      return (BmmClass) super.getScope();
    }else{
      throw new RuntimeException("Scope is of the type "+super.getScope().getClass().getCanonicalName()+" but should be of type BmmPackageContainer");
    }
  }

  public void setScope(BmmClass scope) {
    this.scope = scope;
  }
}
