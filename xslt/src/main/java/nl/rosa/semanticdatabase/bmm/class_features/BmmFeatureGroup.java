package nl.rosa.semanticdatabase.bmm.class_features;

/**
 * 
 * A logical group of features, with a name and set of properties that applies to the group.
 * 
*/
public interface BmmFeatureGroup {

/**
 * 
 * Name of this feature group; defaults to 'feature'.
 * 
*/
String {default = "feature"} getName()
setName(var String {default = "feature"})

/**
 * 
 * Set of properties of this group, represented as name/value pairs.
 * These are understood to apply logically to all of the features contained within the group.
 * 
*/
Hash<string, string> getProperties()
setProperties(var Hash<string, string>)

/**
 * 
 * Set of features in this group.
 * 
*/
List<bmmClassFeature> getFeatures()
setFeatures(var List<bmmClassFeature>)

/**
 * 
 * Optional visibility to apply to all features in this group.
 * 
*/
BmmVisibility getVisibility()
setVisibility(var BmmVisibility)

}
