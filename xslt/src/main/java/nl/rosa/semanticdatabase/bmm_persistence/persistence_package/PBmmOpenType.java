package nl.rosa.semanticdatabase.bmm_persistence.persistence_package;

/**
 * 
 * Persistent form of BMM_PARAMETER_TYPE.
 * 
*/
public interface PBmmOpenType extends PBmmBaseType {

/**
 * 
 * Simple type parameter as a single letter like 'T', 'G' etc.
 * 
*/
String getType()
setType(var String)

/**
 * 
 * Result of create_bmm_type() call.
 * 
*/
@@ getBmmType()
setBmmType(var @@)

}
