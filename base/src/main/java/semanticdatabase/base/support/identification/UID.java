package semanticdatabase.base.support.identification;

import semanticdatabase.model.internal.RMObject;

public abstract class UID extends RMObject {

    String value;

    public UID() {
    }

    public UID(String value) {
        this.value = value;
    }
}
