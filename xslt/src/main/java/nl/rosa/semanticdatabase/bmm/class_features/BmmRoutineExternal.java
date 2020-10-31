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
    BmmRoutineExternal getMetaData();
    void setMetaData(BmmRoutineExternal value);

/**
 * 
 * Optional argument-mapping meta-data.
 * 
*/
    BmmRoutineExternal getArgumentMapping();
    void setArgumentMapping(BmmRoutineExternal value);

/* * FUNCTION * */

}
