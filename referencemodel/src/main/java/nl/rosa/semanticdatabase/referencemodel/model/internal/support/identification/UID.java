package nl.rosa.semanticdatabase.referencemodel.model.internal.support.identification;

import nl.rosa.semanticdatabase.referencemodel.model.internal.RMObject;

public abstract class UID extends RMObject {

    String value;

    public UID() {
    }

    public UID(String value) {
        this.value = value;
    }
}
