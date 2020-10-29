package nl.rosa.semanticdatabase.bmm_persistence.persistence_package;

/**
 * 
 * Persistent form of BMM_ENUMERATION attributes.
 * 
*/
public interface PBmmEnumeration extends PBmmClass {

/* * ATTRIBUTE * */

/**
 * 
 * 
 * 
*/
    PBmmEnumeration getItemNames();
    void setItemNames(value PBmmEnumeration);

/**
 * 
 * 
 * 
*/
    PBmmEnumeration getItemValues();
    void setItemValues(value PBmmEnumeration);

/**
 * 
 * BMM_CLASS object build by create_bmm_class_definition and populate_bmm_class_definition.
 * 
*/
    PBmmEnumeration getBmmClass();
    void setBmmClass(value PBmmEnumeration);

/* * FUNCTION * */

}
