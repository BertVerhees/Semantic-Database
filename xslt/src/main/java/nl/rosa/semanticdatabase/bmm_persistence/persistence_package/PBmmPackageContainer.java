package nl.rosa.semanticdatabase.bmm_persistence.persistence_package;

/**
 * 
 * Persisted form of a model component that contains packages.
 * 
*/
public interface PBmmPackageContainer {

/* * ATTRIBUTE * */

/**
 * 
 * Package structure as a hierarchy of packages each potentially containing names of classes in that package in the original model.
 * 
*/
    Map<String, P_BMM_PACKAGE> getPackages();
    void setPackages(Map<String, P_BMM_PACKAGE> value);

/* * FUNCTION * */

/* * CONSTANTS * */

}
