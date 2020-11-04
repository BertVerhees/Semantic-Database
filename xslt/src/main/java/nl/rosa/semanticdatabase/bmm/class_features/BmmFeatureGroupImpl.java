package nl.rosa.semanticdatabase.bmm.class_features;

/**
 * 
 * A logical group of features, with a name and set of properties that applies to the group.
 * 
*/
public class BmmFeatureGroupImpl implements {

    //***** BmmFeatureGroup *****

/* * FIELDS * */

/**
 * 
 * Set of properties of this group, represented as name/value pairs.
 * These are understood to apply logically to all of the features contained within the group.
 * 
*/
    private Map<String, String> properties;

        />
    
/**
 * 
 * Set of features in this group.
 * 
*/
    private List<BmmClassFeature> features;

        />
    
/**
 * 
 * Optional visibility to apply to all features in this group.
 * 
*/
    private BmmVisibility visibility;

        />
    
/* * ATTRIBUTE * */

/* * POJO * */

/* * FUNCTION * */

}
