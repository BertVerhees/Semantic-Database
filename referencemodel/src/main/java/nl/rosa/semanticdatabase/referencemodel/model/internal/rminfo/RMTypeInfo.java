package nl.rosa.semanticdatabase.referencemodel.model.internal.rminfo;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by:
 * User: BV, Date: 21-4-2020, Time: 15:31
 */
public class RMTypeInfo {

    private final String rmName;
    private final Class javaClass;
    //only direct parent classes here
    private final Set<RMTypeInfo> parentClasses = new LinkedHashSet<>();
    //only direct descendant classes here
    private final Set<RMTypeInfo> descendantClasses = new LinkedHashSet<>();
    private Map<String, RMAttributeInfo> attributes = new HashMap<>();

    public RMTypeInfo(Class clazz, String rmName) {
        this.javaClass = clazz;
        this.rmName = rmName;
    }
}
