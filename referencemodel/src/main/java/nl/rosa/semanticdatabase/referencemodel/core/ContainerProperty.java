package nl.rosa.semanticdatabase.referencemodel.core;

import lombok.Getter;
import lombok.Setter;
import nl.rosa.semanticdatabase.base.MultiplicityInterval;

/**
 * Default created on 29-4-2020
 */
@Getter
@Setter
public class ContainerProperty extends Property<ContainerType>{
    private MultiplicityInterval cardinality;

    public ContainerProperty() {
    }

    public ContainerProperty(String name, ContainerType type) {
        super(name, type);
    }
}
