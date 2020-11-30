package semanticdatabase.base.support.identification;

import semanticdatabase.model.internal.RMObject;

public class ObjectRef<Idtype extends ObjectId> extends RMObject {
    private String namespace;
    private String type;
    private Idtype id;

    public ObjectRef() {
    }

    public ObjectRef(Idtype id, String namespace, String type) {
        this.namespace = namespace;
        this.type = type;
        this.id = id;
    }
}
