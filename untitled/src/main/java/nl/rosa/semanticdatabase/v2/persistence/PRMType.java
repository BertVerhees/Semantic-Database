package nl.rosa.semanticdatabase.referencemodel.v2.persistence;

import java.util.List;

public abstract class PRMType extends PRMBase {

    /**
     * Formal name of the type for display.
     *
     * @return
     */
    public abstract String asTypeString();

    /**
     * Flattened list of type names making up full type.
     *
     * @return
     */
    public abstract List<String> flattenedTypeList();

}
