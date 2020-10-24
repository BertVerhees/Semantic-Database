package nl.rosa.semanticdatabase.bmm.model_access_package;

/**
 * 
 * Core properties of BMM_MODEL, may be used in a serial representation as well, such as P_BMM_SCHEMA.
 * 
*/
public interface BmmModelMetadata {

/**
 * 
 * Publisher of model expressed in the schema.
 * 
*/
String getRmPublisher()
setRmPublisher(var String)

/**
 * 
 * Release of model expressed in the schema as a 3-part numeric, e.g.
 * "3.1.0" .
 * 
*/
String getRmRelease()
setRmRelease(var String)

}
