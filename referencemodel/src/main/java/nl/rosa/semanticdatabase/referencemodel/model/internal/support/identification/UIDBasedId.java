package nl.rosa.semanticdatabase.referencemodel.model.internal.support.identification;

import org.springframework.lang.Nullable;

public abstract class UIDBasedId extends ObjectId {

    public static final String UUID_REGEXP = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}";

    public UIDBasedId() {
    }

    public UIDBasedId(String value) {
        super(value);
    }

    public UID getRoot() {
        String value = this.value;
        if (value == null) {
            return null;
        }
        int index = value.indexOf("::");
        String resultString = null;
        if (index < 0) {
            resultString = value;
        } else {
            resultString = value.substring(index);
        }
        if (resultString.matches(UUID_REGEXP)) {
            UID result = new UUID();
            result.value = resultString;
            return result;
        } else if (resultString.matches("([0-9]\\.?)+")) {
            IsoOID result = new IsoOID();
            result.value = resultString;
            return result;
        } else {
            InternetId result = new InternetId();
            result.value = resultString;
            return result;
        }
    }

    @Nullable
    public String getExtension() {
        String value = this.value;
        if (value == null) {
            return null;
        }
        int index = value.indexOf("::");
        if (index < 0) {
            return "";
        } else {
            return value.substring(index + 2);
        }
    }

}
