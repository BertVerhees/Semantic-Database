package nl.rosa.semanticdatabase.bmmdata.domain.class_features;

import lombok.*;
import nl.rosa.semanticdatabase.bmmdata.domain.classes.BmmClass;
import nl.rosa.semanticdatabase.bmmdata.domain.model_structure.BmmPackageContainer;

import javax.persistence.DiscriminatorValue;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


/**
 * Class BmmClassScoped
 * A class entity having a signature and a class as its scope.
 */
public abstract class BmmClassFeature extends BmmClassEntity {

  /**
   * 0..1
   * visibility: Any
   * Visibility of this item to client entities.
   */
  @Getter
  @Setter
  private BmmVisibility visibility;

  /**
   * 0..1
   * feature_extensions: List<BMM_FEATURE_EXTENSION>
   * Extensions to feature-level meta-types.
   */
  private Set<BmmFeatureExtension> featureExtensions;
  public void addFeatureExtension(@NonNull BmmFeatureExtension value){
    if(featureExtensions==null){
      featureExtensions = new HashSet<>();
    }
    featureExtensions.add(value);

  }
  public void addFeatureExtensionExtensions(Set<BmmFeatureExtension> items){
    items.forEach(item -> addFeatureExtension(item));

  }
  public void removeFeatureExtension(BmmFeatureExtension item){
    if(featureExtensions!=null) {
      featureExtensions.remove(item);
    }
  }
  public void removeFeatureExtensionExtensions(Collection<BmmFeatureExtension> items){
    items.forEach(this::removeFeatureExtension);
  }
  void setFeatureExtensionExtensions(Set<BmmFeatureExtension> items) {
    this.featureExtensions = items;
  }
  private Set<BmmFeatureExtension> getFeatureExtensionExtensions() {
    return featureExtensions;
  }
  public Set<BmmFeatureExtension> featureExtensions() {
    return Collections.unmodifiableSet(featureExtensions);
  }

  /**
   * 1..1
   * group: BMM_FEATURE_GROUP
   * Group containing this feature.
   */
  @Getter
  @Setter
  @NonNull
  private BmmFeatureGroup group;
  

  /**
   * 1..1
   * (redefined)
   * scope: BMM_CLASS
   * Class within which a referenceable element is known.
   */
  @Setter
  @NonNull
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

}
