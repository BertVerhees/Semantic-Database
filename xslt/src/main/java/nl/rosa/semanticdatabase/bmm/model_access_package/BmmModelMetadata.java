package nl.rosa.semanticdatabase.bmm.model_access_package;

/**
 * 
 * Core properties of BMM_MODEL, may be used in a serial representation as well, such as P_BMM_SCHEMA.
 * 
*/
public interface BmmModelMetadata {

/* * ATTRIBUTE * */

/**
 * 
 * Publisher of model expressed in the schema.
 * 
*/
    BmmModelMetadata getRmPublisher();
    void setRmPublisher(BmmModelMetadata value);

/**
 * 
 * Release of model expressed in the schema as a 3-part numeric, e.g.
 * "3.1.0" .
 * 
*/
    BmmModelMetadata getRmRelease();
    void setRmRelease(BmmModelMetadata value);

/* * FUNCTION * */

}
