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
     getMetaData();
    void setMetaData( value);

/**
 * 
 * Optional argument-mapping meta-data.
 * 
*/
     getArgumentMapping();
    void setArgumentMapping( value);

/* * FUNCTION * */

}
