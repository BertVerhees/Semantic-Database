package nl.rosa.semanticdatabase.bmmdata.model_access;

/**
 * Default created on 6-6-2020
 */

/**
 * Description
 * Core properties of BMM_MODEL, may be used in a serial representation as well, such as P_BMM_SCHEMA.
 */
public interface BmmModelMetadata {
    /**
     * 1..1
     * rm_publisher: String
     * Publisher of model expressed in the schema.
     * @return
     */
    String getRmPublisher();
    void setRmPublisher(String newVar);

    /**
     * 1..1
     * rm_release: String
     * Release of model expressed in the schema as a 3-part numeric, e.g. "3.1.0" .
     * @return
     */
    String getRmRelease();
    void setRmRelease(String newVar);
}
