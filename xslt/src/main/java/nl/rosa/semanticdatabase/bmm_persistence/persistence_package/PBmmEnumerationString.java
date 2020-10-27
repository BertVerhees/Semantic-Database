package nl.rosa.semanticdatabase.bmm_persistence.persistence_package;

/**
 * 
 * Persistent form of BMM_ENUMERATION_STRING.
 * 
*/
public interface PBmmEnumerationString extends PBmmEnumeration {

/* * ATTRIBUTE * */

/**
 * 
 * BMM_CLASS object build by create_bmm_class_definition and populate_bmm_class_definition.
 * 
*/
    BmmEnumerationString getBmmClass();
    void setBmmClass(value BmmEnumerationString);

/* * FUNCTION * */

}
