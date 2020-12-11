package nl.rosa.semanticdatabase.base.identification;

/**
 * Originally: Created by pieter.bos on 04/11/15.
 */
public class TerminologyId extends ObjectId {

    public TerminologyId() {

    }

    public TerminologyId(String terminologyId, String terminologyVersion) {
        if (terminologyVersion == null || terminologyVersion.isEmpty()) {
            super.setValue(terminologyId);
        } else {
            super.setValue(terminologyId + "(" + terminologyVersion + ")");
        }
    }

    public TerminologyId(String terminologyId) {
        this(terminologyId, null);
    }


}
