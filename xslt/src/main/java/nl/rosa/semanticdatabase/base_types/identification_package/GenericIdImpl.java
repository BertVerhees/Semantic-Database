package nl.rosa.semanticdatabase.base_types.identification_package;

/**
 * 
 * Generic identifier type for identifiers whose format is otherwise unknown to openEHR.
 * Includes an attribute for naming the identification scheme (which may well be local).
 * 
*/
public class GenericIdImpl implements ObjectId{

    //***** GenericId *****

/* * FIELDS * */

/**
 * 
 * Name of the scheme to which this identifier conforms.
 * Ideally this name will be recognisable globally but realistically it may be a local ad hoc scheme whose name is not controlled or standardised in any way.
 * 
*/
    private String scheme;

        />
    
    //***** ObjectId *****

/* * FIELDS * */

/**
 * 
 * The value of the id in the form defined below.
 * 
*/
    private String value;

        />
    
/* * ATTRIBUTE * */

/* * POJO * */

/* * FUNCTION * */

}
