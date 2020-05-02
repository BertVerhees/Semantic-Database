package nl.rosa.semanticdatabase.message;

import lombok.Getter;
import lombok.Setter;

/**
 * Default created on 2-5-2020
 */

@Getter
@Setter
public class MessageDescriptor {
    private MessageCode code;
    private MessageSeverity severity;
    private String message;
    private String location;

    public MessageDescriptor() {
    }

    public MessageDescriptor(MessageCode aCode, MessageSeverity aSeverity, String aMessage, String aLoc) {
        code = aCode;
        severity = aSeverity;
        message = aMessage;
        location = aLoc;
    }

    public static MessageDescriptor createError(MessageCode aCode, String aMessage, String aLoc) {
        return create(aCode, MessageSeverity.ERROR, aMessage, aLoc);
    }

    public static MessageDescriptor createWarning(MessageCode aCode, String aMessage, String aLoc) {
        return create(aCode, MessageSeverity.WARNING, aMessage, aLoc);
    }

    public static MessageDescriptor createInfo(MessageCode aCode, String aMessage, String aLoc) {
        return create(aCode, MessageSeverity.INFO, aMessage, aLoc);
    }

    public static MessageDescriptor createDebug(MessageCode aCode, String aMessage, String aLoc) {
        return create(aCode, MessageSeverity.DEBUG, aMessage, aLoc);
    }

    public static MessageDescriptor create(MessageCode aCode, MessageSeverity aSeverity, String aMessage, String aLoc) {
        return new MessageDescriptor(aCode, aSeverity, aMessage, aLoc);
    }
}
