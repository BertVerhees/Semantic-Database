package nl.rosa.semanticdatabase.bmm_persistence.persistence_package;

/**
 * 
 * Persistent form of BMM_ENUMERATION attributes.
 * 
*/
public interface PBmmEnumeration extends PBmmClass {

/**
 * 
 * 
 * 
*/
List<string> getItemNames()
setItemNames(var List<string>)

/**
 * 
 * 
 * 
*/
List<any> getItemValues()
setItemValues(var List<any>)

/**
 * 
 * BMM_CLASS object build by create_bmm_class_definition and populate_bmm_class_definition.
 * 
*/
BmmEnumeration getBmmClass()
setBmmClass(var BmmEnumeration)

}
