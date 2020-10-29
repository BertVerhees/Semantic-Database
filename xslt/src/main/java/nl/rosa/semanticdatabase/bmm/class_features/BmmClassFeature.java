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
    void setVisibility(value BmmClassFeature);

/**
 * 
 * Extensions to feature-level meta-types.
 * 
*/
    BmmClassFeature getFeatureExtensions();
    void setFeatureExtensions(value BmmClassFeature);

/**
 * 
 * Group containing this feature.
 * 
*/
    BmmClassFeature getGroup();
    void setGroup(value BmmClassFeature);

/**
 * 
 * Class within which a referenceable element is known.
 * 
*/
    BmmClassFeature getScope();
    void setScope(value BmmClassFeature);

/* * FUNCTION * */

}
