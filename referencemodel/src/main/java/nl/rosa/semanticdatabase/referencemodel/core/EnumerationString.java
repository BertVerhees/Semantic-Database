package nl.rosa.semanticdatabase.referencemodel.core;

import java.io.Serializable;

/**
 * Default created on 2-5-2020
 */

public class EnumerationString extends Enumeration<String> implements Serializable {
    public EnumerationString() {
        setUnderlyingTypeName("STRING");
    }

    public EnumerationString(String name) {
        this();
        setName(name);
    }
}
