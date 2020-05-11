package nl.rosa.semanticdatabase.referencemodel.core;

import java.io.Serializable;

/**
 * Default created on 2-5-2020
 */

public class RMEnumerationString extends RMEnumeration<String> implements Serializable {
    public RMEnumerationString() {
        setUnderlyingTypeName("STRING");
    }

    public RMEnumerationString(String name) {
        this();
        setName(name);
    }
}
