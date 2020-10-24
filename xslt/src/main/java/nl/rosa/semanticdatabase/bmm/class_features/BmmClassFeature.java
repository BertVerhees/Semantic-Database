package nl.rosa.semanticdatabase.bmm.class_features;

/**
 * 
 * A class entity having a signature and a class as its scope.
 * 
*/
public interface BmmClassFeature extends BmmClassEntity {

/**
 * 
 * Visibility of this item to client entities.
 * 
*/
BmmVisibility getVisibility()
setVisibility(var BmmVisibility)

/**
 * 
 * Extensions to feature-level meta-types.
 * 
*/
List<bmmFeatureExtension> getFeatureExtensions()
setFeatureExtensions(var List<bmmFeatureExtension>)

/**
 * 
 * Group containing this feature.
 * 
*/
BmmFeatureGroup getGroup()
setGroup(var BmmFeatureGroup)

/**
 * 
 * Class within which a referenceable element is known.
 * 
*/
BmmClass getScope()
setScope(var BmmClass)

}
