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
     getVisibility();
    void setVisibility( value);

/**
 * 
 * Extensions to feature-level meta-types.
 * 
*/
     getFeatureExtensions();
    void setFeatureExtensions( value);

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
     getScope();
    void setScope( value);

/* * FUNCTION * */

}
