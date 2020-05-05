package nl.rosa.semanticdatabase.referencemodel.model_access;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Default created on 5-5-2020
 *
 * Core properties of BMM_MODEL, may be used in a serial representation as well, such as P_BMM_SCHEMA.
 */

@Getter
@Setter
@AllArgsConstructor
public class BmmModelMetadata {
    /**
     * Publisher of model expressed in the schema.
     */
    private String rmPublisher;
    /**
     * Release of model expressed in the schema as a 3-part numeric, e.g. "3.1.0" .
     */
    private String rmRelease;
}
