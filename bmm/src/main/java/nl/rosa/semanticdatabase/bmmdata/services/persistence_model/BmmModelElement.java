package nl.rosa.semanticdatabase.bmmdata.services.persistence_model;

/**
 * Default created on 31-7-2020
 * Persistent form of BMM_MODEL_ELEMENT.
 */

public interface BmmModelElement {
    /**
     * 0..1
     * documentation: String
     * Optional documentation of this element.
     * @return
     */
    String getDocumentation();
}
