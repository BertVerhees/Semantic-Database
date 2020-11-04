package nl.rosa.semanticdatabase.bmm.class_features;

/**
 * 
 * A logical group of features, with a name and set of properties that applies to the group.
 * 
*/
public interface BmmFeatureGroup {

/* * ATTRIBUTE * */

/**
 * 
 * Set of properties of this group, represented as name/value pairs.
 * These are understood to apply logically to all of the features contained within the group.
 * 
*/
    Map<String, String> getProperties();
    void setProperties(Map<String, String> value);

/**
 * 
 * Set of features in this group.
 * 
*/
    List<BmmClassFeature> getFeatures();
    void setFeatures(List<BmmClassFeature> value);

/**
 * 
 * Optional visibility to apply to all features in this group.
 * 
*/
    BmmVisibility getVisibility();
    void setVisibility(BmmVisibility value);

/* * FUNCTION * */

/* * CONSTANTS * */

/**
 * 
 * Name of this feature group; defaults to 'feature'.
 * 
*/
    String {default name = "feature"};

}
