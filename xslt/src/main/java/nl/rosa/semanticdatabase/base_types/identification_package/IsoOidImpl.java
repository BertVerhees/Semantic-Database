package nl.rosa.semanticdatabase.base_types.identification_package;

/**
 * 
 * Model of ISO’s Object Identifier (oid) as defined by the standard ISO/IEC 8824.
 * Oids are formed from integers separated by dots.
 * Each non-leaf node in an Oid starting from the left corresponds to an assigning authority, and identifies that authority’s namespace, inside which the remaining part of the identifier is locally unique.
 * 
*/
public class IsoOidImpl implements Uid{

    //***** IsoOid *****

/* * FIELDS * */

    //***** Uid *****

/* * FIELDS * */

/**
 * 
 * The value of the id.
 * 
*/
    private String value;

        />
    
/* * ATTRIBUTE * */

/* * POJO * */

/* * FUNCTION * */

}
