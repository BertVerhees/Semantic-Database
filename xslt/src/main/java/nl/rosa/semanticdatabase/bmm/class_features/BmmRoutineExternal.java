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
Hash<string, string> getMetaData();
void setMetaData(var Hash<string, string>);

/**
 * 
 * Optional argument-mapping meta-data.
 * 
*/
Hash<string, string> getArgumentMapping();
void setArgumentMapping(var Hash<string, string>);

/* * FUNCTION * */

}
