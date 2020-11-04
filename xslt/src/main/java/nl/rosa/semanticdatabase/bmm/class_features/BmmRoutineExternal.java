package nl.rosa.semanticdatabase.bmm.class_features;

/**
 * 
 * External routine placeholder, containing sufficient meta-data to enable a routine in an external library to be called.
 * 
*/
public interface BmmRoutineExternal extends BmmRoutineBody {

/* * ATTRIBUTE * */

/**
 * 
 * External call general meta-data, including target routine name, type mapping etc.
 * 
*/
    Map<String, String> getMetaData();
    void setMetaData(Map<String, String> value);

/**
 * 
 * Optional argument-mapping meta-data.
 * 
*/
    Map<String, String> getArgumentMapping();
    void setArgumentMapping(Map<String, String> value);

/* * FUNCTION * */

/* * CONSTANTS * */

}
