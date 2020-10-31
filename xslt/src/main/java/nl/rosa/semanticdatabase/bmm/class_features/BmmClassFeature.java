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
    BmmClassFeature getVisibility();
    void setVisibility(BmmClassFeature value);

/**
 * 
 * Extensions to feature-level meta-types.
 * 
*/
    BmmClassFeature getFeatureExtensions();
    void setFeatureExtensions(BmmClassFeature value);

/**
 * 
 * Group containing this feature.
 * 
*/
    BmmClassFeature getGroup();
    void setGroup(BmmClassFeature value);

/**
 * 
 * Class within which a referenceable element is known.
 * 
*/
    BmmClassFeature getScope();
    void setScope(BmmClassFeature value);

/* * FUNCTION * */

}
