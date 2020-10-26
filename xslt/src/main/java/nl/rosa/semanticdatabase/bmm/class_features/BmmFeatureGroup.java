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
 * Name of this feature group; defaults to 'feature'.
 * 
*/
String {default = "feature"} getName();
void setName(value String {default = "feature"});

/**
 * 
 * Set of properties of this group, represented as name/value pairs.
 * These are understood to apply logically to all of the features contained within the group.
 * 
*/
Hash<string, string> getProperties();
void setProperties(value Hash<string, string>);

/**
 * 
 * Set of features in this group.
 * 
*/
List<bmmClassFeature> getFeatures();
void setFeatures(value List<bmmClassFeature>);

/**
 * 
 * Optional visibility to apply to all features in this group.
 * 
*/
BmmVisibility getVisibility();
void setVisibility(value BmmVisibility);

/* * FUNCTION * */

}
