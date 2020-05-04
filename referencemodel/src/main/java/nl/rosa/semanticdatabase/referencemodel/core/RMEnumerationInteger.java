package nl.rosa.semanticdatabase.referencemodel.core;

import java.io.Serializable;

/**
 * Default created on 2-5-2020
 */

public class RMEnumerationInteger extends RMEnumeration<Integer> implements Serializable {
    public RMEnumerationInteger() {
        setUnderlyingTypeName("INTEGER");
    }
    public RMEnumerationInteger(String name) {
        this();
        setName(name);
    }
}
