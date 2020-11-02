package nl.rosa.semanticdatabase.base_types.identification_package;

/**
 * 
 * Globally unique identifier for one version of a versioned object; lexical form: object_id '::' creating_system_id '::' version_tree_id.
 * 
*/
public interface ObjectVersionId extends UidBasedId {

/* * ATTRIBUTE * */

/* * FUNCTION * */

/**
 * 
 * Unique identifier for logical object of which this identifier identifies one version; normally the object_id will be the unique identifier of the version container containing the version referred to by this OBJECT_VERSION_ID instance.
 * 
*/
    Uid  object_id();

/**
 * 
 * Identifier of the system that created the Version corresponding to this Object version id.
 * 
*/
    Uid  creating_system_id();

/**
 * 
 * Tree identifier of this version with respect to other versions in the same version tree, as either 1 or 3 part dot-separated numbers, e.g.
 * 1 , 2.1.4 .
 * 
*/
    VersionTreeId  version_tree_id();

/**
 * 
 * True if this version identifier represents a branch.
 * 
*/
    Boolean  is_branch();

}
