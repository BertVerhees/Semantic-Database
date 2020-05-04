package nl.rosa.semanticdatabase.referencemodel.core;

import lombok.Getter;
import lombok.Setter;

/**
 * Default created on 29-4-2020
 */

@Getter
@Setter
public class RMContainerTypeElement extends RMTypeTypeElement {
    private RMClass containerType;
    private RMTypeTypeElement baseRMType;

    @Override
    public RMClass getBaseClass() {
        return baseRMType.getBaseClass();
    }
}
