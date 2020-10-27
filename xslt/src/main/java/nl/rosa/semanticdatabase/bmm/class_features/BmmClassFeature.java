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
    void setVisibility(value BmmVisibility);

/**
 * 
 * Extensions to feature-level meta-types.
 * 
*/
    List<bmmFeatureExtension> getFeatureExtensions();
    void setFeatureExtensions(value List<bmmFeatureExtension>);

/**
 * 
 * Group containing this feature.
 * 
*/
    BmmFeatureGroup getGroup();
    void setGroup(value BmmFeatureGroup);

/**
 * 
 * Class within which a referenceable element is known.
 * 
*/
    BmmClass getScope();
    void setScope(value BmmClass);

/* * FUNCTION * */

}
