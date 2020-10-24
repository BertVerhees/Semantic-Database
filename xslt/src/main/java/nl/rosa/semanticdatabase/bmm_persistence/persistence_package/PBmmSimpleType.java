package nl.rosa.semanticdatabase.bmm_persistence.persistence_package;

/**
 * 
 * Persistent form of BMM_SIMPLE_TYPE.
 * 
*/
public interface PBmmSimpleType extends PBmmBaseType {

/**
 * 
 * Name of type - must be a simple class name.
 * 
*/
String getType()
setType(var String)

/**
 * 
 * Result of create_bmm_type() call.
 * 
*/
BmmSimpleType getBmmType()
setBmmType(var BmmSimpleType)

}
