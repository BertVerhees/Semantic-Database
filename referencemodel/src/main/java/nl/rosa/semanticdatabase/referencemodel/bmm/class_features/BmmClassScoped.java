package nl.rosa.semanticdatabase.referencemodel.bmm.class_features;

import lombok.*;
import nl.rosa.semanticdatabase.referencemodel.bmm.classes.BmmClass;


/**
 * Class BmmClassScoped
 * A class entity having a signature and a class as its scope.
 */

@Data
abstract public class BmmClassScoped extends BmmClassEntity {

  /**
   * Visibility of this item to client entities.
   * TODO: define scheme; probably need to support C++/Java scheme as well as better type-based schemes.
   */

  private Object visibility;
  private BmmClass scope;
  
  //
  // Constructors
  //

  @Builder
  public BmmClassScoped(boolean isSynthesisedGeneric, Object visibility, BmmClass scope) {
    super(isSynthesisedGeneric);
    this.visibility = visibility;
    this.scope = scope;
  }

  public BmmClassScoped(Object visibility, BmmClass scope) {
    this.visibility = visibility;
    this.scope = scope;
  }

  public BmmClassScoped () { };
}
