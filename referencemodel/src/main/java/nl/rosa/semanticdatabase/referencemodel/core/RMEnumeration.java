package nl.rosa.semanticdatabase.referencemodel.core;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * Default created on 1-5-2020
 */

@Getter
@Setter
public class RMEnumeration<T> extends RMClass implements Serializable {
    /**
     * The list of names of the enumeration. If no values are supplied, the integer values 0, 1, 2, …​ are assumed.
     */
    private List<String> itemNames;
    /**
     * Optional list of specific values. Must be 1:1 with `items_names' list.
     */
    private List<T> itemValues;
    /**
     * Name of type any concrete BMM_ENUMERATION_* sub-type is based on, i.e. the name of type bound to 'T' in a
     * declared use of this type.
     */
    private String underlyingTypeName;

}
