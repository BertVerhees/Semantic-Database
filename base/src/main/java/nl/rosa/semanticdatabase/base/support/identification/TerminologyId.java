package nl.rosa.semanticdatabase.base.support.identification;

public class TerminologyId extends ObjectId{
    public TerminologyId() {

    }

    public TerminologyId(String terminologyId, String terminologyVersion) {
        if (terminologyVersion == null || terminologyVersion.isEmpty()) {
            super.value = terminologyId;
        } else {
            super.value = terminologyId + "(" + terminologyVersion + ")";
        }
    }

    public TerminologyId(String terminologyId) {
        this(terminologyId, null);
    }

}
