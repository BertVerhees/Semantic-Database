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
     getItemNames();
    void setItemNames( value);

/**
 * 
 * 
 * 
*/
     getItemValues();
    void setItemValues( value);

/**
 * 
 * BMM_CLASS object build by create_bmm_class_definition and populate_bmm_class_definition.
 * 
*/
    BmmEnumeration getBmmClass();
    void setBmmClass(BmmEnumeration value);

/* * FUNCTION * */

}
