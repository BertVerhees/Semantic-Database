package nl.rosa.semanticdatabase.bmm.class_features;

/**
 * 
 * A class entity having a signature and a class as its scope.
 * 
*/
public interface BmmClassFeature extends BmmClassEntity {

/* * ATTRIBUTE * */

/**
 * 
 * Visibility of this item to client entities.
 * 
*/
    BmmVisibility getVisibility();
    void setVisibility(BmmVisibility value);

/**
 * 
 * Extensions to feature-level meta-types.
 * 
*/
    List<BMM_FEATURE_EXTENSION> getFeatureExtensions();
    void setFeatureExtensions(List<BMM_FEATURE_EXTENSION> value);

/**
 * 
 * Group containing this feature.
 * 
*/
    BmmFeatureGroup getGroup();
    void setGroup(BmmFeatureGroup value);

/**
 * 
 * Class within which a referenceable element is known.
 * 
*/
    BmmClass getScope();
    void setScope(BmmClass value);

/* * FUNCTION * */

}
