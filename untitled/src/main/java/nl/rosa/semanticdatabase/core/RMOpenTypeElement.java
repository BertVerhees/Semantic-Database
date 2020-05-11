package nl.rosa.semanticdatabase.referencemodel.core;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Default created on 2-5-2020
 */
@Getter
@Setter
public class RMOpenTypeElement extends RMTypeTypeElement implements Serializable {

    /**
     * The generic constraint, which will be 'Any' if nothing set in original model.
     */
    private RMGenericParameter genericConstraint;

    @Override
    public RMClass getBaseClass() {
        return getGenericConstraint().getConformsToType();
    }

    /**
     * Return generic_constraint.conformance_type_name.
     *
     * @return
     */
    @Override
    public String getConformanceTypeName() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
