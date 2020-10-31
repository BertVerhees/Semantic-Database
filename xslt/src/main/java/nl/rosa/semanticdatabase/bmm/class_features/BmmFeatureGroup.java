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
    BmmFeatureGroup getProperties();
    void setProperties(BmmFeatureGroup value);

/**
 * 
 * Set of features in this group.
 * 
*/
    BmmFeatureGroup getFeatures();
    void setFeatures(BmmFeatureGroup value);

/**
 * 
 * Optional visibility to apply to all features in this group.
 * 
*/
    BmmFeatureGroup getVisibility();
    void setVisibility(BmmFeatureGroup value);

/* * FUNCTION * */

}
