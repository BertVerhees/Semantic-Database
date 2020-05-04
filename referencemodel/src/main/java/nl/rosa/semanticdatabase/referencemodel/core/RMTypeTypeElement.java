package nl.rosa.semanticdatabase.referencemodel.core;

public abstract class RMTypeTypeElement extends RMTypeElement {

    public static final String SIMPLE_TYPE = "SIMPLE_TYPE";
    public static final String SIMPLE_TYPE_OPEN = "SIMPLE_TYPE_OPEN";
    public static final String CONTAINER_TYPE = "CONTAINER_TYPE";
    public static final String GENERIC_TYPE = "GENERIC_TYPE";
    public static final String GENERIC_PARAMETER = "GENERIC_PARAMETER";

    public static final String P_SIMPLE_TYPE = "P_SIMPLE_TYPE";
    public static final String P_SIMPLE_TYPE_OPEN = "P_SIMPLE_TYPE_OPEN";
    public static final String P_CONTAINER_TYPE = "P_CONTAINER_TYPE";
    public static final String P_GENERIC_TYPE = "P_GENERIC_TYPE";
    public static final String P_GENERIC_PARAMETER = "P_GENERIC_PARAMETER";

    /**
     * Determine if there are any type substitutions.
     *
     * @return
     */
    public boolean hasTypeSubstitutions() {
        throw new UnsupportedOperationException("Not implemented yet");
    }


}
