package nl.rosa.semanticdatabase.referencemodel.core;

import lombok.Getter;
import lombok.Setter;
import nl.rosa.semanticdatabase.base.MultiplicityInterval;

/**
 * Default created on 29-4-2020
 */
@Getter
@Setter
public class RMContainerProperty extends RMProperty<RMContainerType> {
    private MultiplicityInterval cardinality;

    public RMContainerProperty() {
    }

    public RMContainerProperty(String name, RMContainerType type) {
        super(name, type);
    }
}
