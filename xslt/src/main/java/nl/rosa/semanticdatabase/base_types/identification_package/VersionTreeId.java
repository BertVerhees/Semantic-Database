package nl.rosa.semanticdatabase.base_types.identification_package;

/**
 * 
 * Version tree identifier for one version.
 * Lexical form: trunk_version [ '.' branch_number '.' branch_version ]
 * 
*/
public interface VersionTreeId {

/* * ATTRIBUTE * */

/**
 * 
 * String form of this identifier.
 * 
*/
    String getValue();
    void setValue(String value);

/* * FUNCTION * */

/**
 * 
 * Trunk version number; numbering starts at 1.
 * 
*/
    String  trunk_version();

/**
 * 
 * True if this version identifier represents a branch, i.e.
 * has branch_number and branch_version parts.
 * 
*/
    Boolean  is_branch();

/**
 * 
 * Number of branch from the trunk point; numbering starts at 1.
 * 
*/
    String  branch_number();

/**
 * 
 * Version of the branch; numbering starts at 1.
 * 
*/
    String  branch_version();

}
