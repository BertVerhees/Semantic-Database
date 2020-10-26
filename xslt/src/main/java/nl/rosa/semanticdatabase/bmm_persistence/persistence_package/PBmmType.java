package nl.rosa.semanticdatabase.bmm_persistence.persistence_package;

/**
 * 
 * Persistent form of BMM_TYPE.
 * 
*/
public interface PBmmType {

/* * ATTRIBUTE * */

/**
 * 
 * Result of create_bmm_type() call.
 * 
*/
BmmType getBmmType();
void setBmmType(value BmmType);

/* * FUNCTION * */

/**
 * 
 * Create appropriate BMM_XXX object; effected in descendants.
 * create_bmm_type ( a_schema: BMM_MODEL[1], a_class_def: BMM_CLASS[1] )
 * 
*/
void createBmmType ( aSchema: bmmModel[1], aClassDef: bmmClass[1] );

/**
 * 
 * Formal name of the type for display.
 * as_type_string (): String
 * 
*/
String asTypeString ();

}
