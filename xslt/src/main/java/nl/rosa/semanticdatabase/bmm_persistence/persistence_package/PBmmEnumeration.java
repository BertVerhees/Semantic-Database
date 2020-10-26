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
List<string> getItemNames();
void setItemNames(value List<string>);

/**
 * 
 * 
 * 
*/
List<any> getItemValues();
void setItemValues(value List<any>);

/**
 * 
 * BMM_CLASS object build by create_bmm_class_definition and populate_bmm_class_definition.
 * 
*/
BmmEnumeration getBmmClass();
void setBmmClass(value BmmEnumeration);

/* * FUNCTION * */

}
