package nl.rosa.semanticdatabase.referencemodel.core;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Default created on 2-5-2020
 */

@Getter
@Setter
public class RMGenericParameter extends RMTypeElement implements Serializable {
    /**
     * Name of the parameter, e.g. 'T' etc.
     */
    private String name;
    /**
     * Optional conformance constraint that must be another valid class name.
     */
    private RMClass conformsToType;
    /**
     * If set, is the corresponding generic parameter definition in an ancestor class.
     */
    private RMGenericParameter inheritancePrecursor;

    /**
     * Get any ultimate type conformance constraint on this generic parameter due to inheritance.
     *
     * @return
     */
    public String flattenedConformsToType() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * Generate ultimate conformance type, which is either from `conforms_to_type' or if not set, 'Any'.
     *
     * @return
     */
    public RMClass effectiveConformsToType() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * Result is name of conformance type, else 'Any'.
     *
     * @return
     */
    public String getConformanceTypeName() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * Signature form of the open type, including constrainer type if there is one, e.g. 'T:Ordered'.
     *
     * @return
     */
    public String getTypeSignature() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

}
