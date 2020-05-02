package nl.rosa.semanticdatabase.referencemodel.core;

import java.io.Serializable;

/**
 * Default created on 2-5-2020
 */

public class EnumerationInteger extends Enumeration<Integer> implements Serializable {
    public EnumerationInteger() {
        setUnderlyingTypeName("INTEGER");
    }
    public EnumerationInteger(String name) {
        this();
        setName(name);
    }
}
