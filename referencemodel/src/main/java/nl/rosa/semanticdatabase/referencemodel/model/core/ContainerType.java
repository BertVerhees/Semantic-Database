package nl.rosa.semanticdatabase.referencemodel.model.core;

import lombok.Getter;
import lombok.Setter;

/**
 * Default created on 29-4-2020
 */

@Getter
@Setter
public class ContainerType extends Type{
    private Clasz containerType;
    private Type baseType;
}
