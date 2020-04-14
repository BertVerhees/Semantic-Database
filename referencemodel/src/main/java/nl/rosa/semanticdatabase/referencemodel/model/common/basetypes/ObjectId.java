package nl.rosa.semanticdatabase.referencemodel.model.common.basetypes;


/*
Ancestor class of identifiers of informational objects. Ids may be completely meaningless, in which case their only job is to refer to something,
or may carry some information to do with the identified object.
Object ids are used inside an object to identify that object.
To identify another object in another service, use an OBJECT_REF, or else use a UID for local objects identified by UID.
If none of the subtypes is suitable, direct instances of this class may be used.
 */
public class ObjectId {
    private String value;

    public ObjectId(String value) {
        if (value.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
        this.value = value;
    }

    public ObjectId() {

    }
}
