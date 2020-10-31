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
    void setItemNames(PBmmEnumeration value);

/**
 * 
 * 
 * 
*/
    PBmmEnumeration getItemValues();
    void setItemValues(PBmmEnumeration value);

/**
 * 
 * BMM_CLASS object build by create_bmm_class_definition and populate_bmm_class_definition.
 * 
*/
    PBmmEnumeration getBmmClass();
    void setBmmClass(PBmmEnumeration value);

/* * FUNCTION * */

}
