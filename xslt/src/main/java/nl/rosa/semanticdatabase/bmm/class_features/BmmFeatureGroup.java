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
     getProperties();
    void setProperties( value);

/**
 * 
 * Set of features in this group.
 * 
*/
     getFeatures();
    void setFeatures( value);

/**
 * 
 * Optional visibility to apply to all features in this group.
 * 
*/
     getVisibility();
    void setVisibility( value);

/* * FUNCTION * */

}
