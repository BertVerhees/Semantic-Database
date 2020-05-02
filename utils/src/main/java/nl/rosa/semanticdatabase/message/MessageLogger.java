package nl.rosa.semanticdatabase.message;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Default created on 2-5-2020
 */

@Getter
@Setter
public class MessageLogger {
    /**
     * Error output of validator - things that must be corrected
     */
    private List<MessageDescriptor> messageList = new ArrayList<>();
    private boolean hasErrors;
    private boolean hasWarnings;
    private boolean hasInfo;

    /**
     * Returns the last message added to the error cache.
     *
     * @return
     */
    public MessageDescriptor lastAdded() {
        if(messageList != null && messageList.size() > 0) {
            return messageList.get(messageList.size() - 1);
        } else {
            return null;
        }
    }

    /**
     * Returns all messages of type ERROR_TYPE_ERROR.
     *
     * @return
     */
    public List<MessageCode> getErrorCodes() {
        return getCodesForSeverity(MessageSeverity.ERROR);

    }

    private List<MessageCode> getCodesForSeverity(MessageSeverity severity) {
        return messageList.stream().filter((message) -> message.getSeverity() == severity).map( (message) -> message.getCode()).collect(Collectors.toList());
    }

    /**
     * Returns all messages of type ERROR_TYPE_WARNING
     *
     * @return
     */
    public List<MessageCode> getWarningCodes() {
        return getCodesForSeverity(MessageSeverity.WARNING);
    }

    /**
     * Returns all messages of type ERROR_TYPE_INFO
     *
     * @return
     */
    public List<MessageCode> getInfoCodes() {
        return getCodesForSeverity(MessageSeverity.INFO);
    }

    /**
     * Returns true if this error cache is empty.
     *
     * @return
     */
    public boolean isEmpty() {
        return messageList.isEmpty();
    }

    /**
     * Returns true if this error cache has errors
     *
     * @return
     */
    public boolean hasErrors() {
        return hasErrors;
    }

    /**
     * Returns true if this error cache has warnings.
     *
     * @return
     */
    public boolean hasWarnings() {
        return hasWarnings;
    }

    /**
     * Returns true if this error cache has info-level messages.
     *
     * @return
     */
    public boolean hasInfo() {
        return hasInfo;
    }

    /**
     * Returns true if this error cache has either error or warning messages.
     *
     * @return
     */
    public boolean hasErrorsOrWarnings() {
        return hasErrors || hasWarnings;
    }

    /**
     * True if there has been an error recorded with code `a_code'
     *
     * @param aCode
     * @return
     */
    public boolean hasError(MessageCode aCode) {
        return getErrorCodes().contains(aCode);
    }

    /**
     * True if there has been an error recorded with code `a_code'
     *
     * @param aCode
     * @return
     */
    public boolean hasWarning(MessageCode aCode) {
        return getWarningCodes().contains(aCode);
    }

    /**
     * True if there has been an error recorded with code `a_code'
     *
     * @param aCode
     * @return
     */
    public boolean hasInfo(MessageCode aCode) {
        return getInfoCodes().contains(aCode);
    }

    /**
     * True if there has been an error whose code starts with code `a_code'
     *
     * @param aCode
     * @return
     */
    public boolean hasMatchingError(MessageCode aCode) {
        return hasMatchingMessage(aCode, MessageSeverity.ERROR);
    }

    /**
     * True if there has been a warning whose code starts with code `a_code'
     *
     * @param aCode
     * @return
     */
    public boolean hasMatchingWarning(MessageCode aCode) {
        return hasMatchingMessage(aCode, MessageSeverity.WARNING);
    }

    private boolean hasMatchingMessage(MessageCode aCode, MessageSeverity severity) {
        for(MessageDescriptor error:messageList) {
            if(error.getSeverity().equals(severity) && error.getCode().getCode().startsWith(aCode.getCode())) {
                return true;
            }
        }
        return false;
    }

    public void addError(MessageCode code, Object... args) {
        addErrorWithLocation(code, null, args);
    }

    public void addWarning(MessageCode code, Object... args) {
        addWarningWithLocation(code, null, args);
    }

    public void addInfo(MessageCode code, Object... args) {
        addInfoWithLocation(code, null, args);
    }

    public void addDebug(String message) {
        addDebugWithLocation(null, message);
    }

    /**
     * Adds an error to this error cache and sets the error flag to true.
     * @param aCode
     * @param aLocation
     * @param args
     */
    public void addErrorWithLocation(MessageCode aCode, String aLocation, Object... args) {
        add(new MessageDescriptor(aCode, MessageSeverity.ERROR, aCode.getMessage(args), aLocation));
    }

    /**
     * Adds a warning to this error cache and sets the hasWarning flag to true.
     * @param aCode
     * @param aLocation
     * @param args
     */
    public void addWarningWithLocation(MessageCode aCode, String aLocation, Object... args) {
        add(new MessageDescriptor(aCode, MessageSeverity.WARNING, aCode.getMessage(args), aLocation));
    }

    /**
     * Adds a warning to this error cache and sets the hasInfo flag to true.
     * @param aCode
     * @param aLocation
     * @param args
     */
    public void addInfoWithLocation(MessageCode aCode, String aLocation, Object... args) {
        add(new MessageDescriptor(aCode, MessageSeverity.INFO, aCode.getMessage(args), aLocation));
    }

    /**
     * Adds a debug message to cache.
     *
     * @param aLocation
     * @param aMessage
     */
    public void addDebugWithLocation(String aLocation, String aMessage) {
        add(new MessageDescriptor(new UnknownMessageCode(), MessageSeverity.DEBUG, aMessage, aLocation));
    }

    /**
     * Generic add method for adding a message of type debug, info, warning, or error to the cache.
     *
     * @param errorDescriptor
     */
    public void add(MessageDescriptor errorDescriptor) {
        messageList.add(errorDescriptor);
        hasErrors = hasErrors || errorDescriptor.getSeverity().equals(MessageSeverity.ERROR);
        hasWarnings = hasWarnings || errorDescriptor.getSeverity().equals(MessageSeverity.WARNING);
        hasInfo = hasInfo || errorDescriptor.getSeverity().equals(MessageSeverity.INFO);
    }

    /**
     * Adds all items in the error cache of other onto this error cache.
     *
     * @param other
     */
    public void append(MessageLogger other) {
        this.messageList.addAll(other.getMessageList());
        hasErrors = hasErrors || other.hasErrors;
        hasWarnings = hasWarnings || other.hasWarnings;
        hasInfo = hasInfo || other.hasInfo;
    }

    /**
     * Clears the error message cache and resets all flags to false.
     *
     */
    public void clear() {
        messageList.clear();
        hasErrors = false;
        hasWarnings = false;
        hasInfo = false;
    }

    public List<MessageDescriptor> getMessageList() {
        return messageList;
    }

    /**
     * Generate stringified version of contents, with newlines inserted after each entry
     *
     * @return
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        messageList.forEach(error -> {
            if(GlobalMessageLoggingLevel.shouldLog(error.getSeverity())) {
                builder.append(error.toString()).append("\n");
            }
        });
        return builder.toString();
    }

    /**
     * Generate filtered stringified version of contents, with newlines inserted after each entry
     *
     * @param includeErrors
     * @param includeWarnings
     * @param includeInfo
     * @return
     */
    public String toStringFiltered(boolean includeErrors, boolean includeWarnings, boolean includeInfo) {
        StringBuilder builder = new StringBuilder();
        messageList.forEach(message -> {
            if(includeErrors && message.getSeverity().equals(MessageSeverity.ERROR)) {
                builder.append(message.toString()).append("\n");
            } else if(includeWarnings && message.getSeverity().equals(MessageSeverity.WARNING)) {
                builder.append(message.toString()).append("\n");
            } else if(includeInfo && message.getSeverity().equals(MessageSeverity.INFO)) {
                builder.append(message.toString()).append("\n");
            }
        });
        return builder.toString();
    }

    /**
     * Returns the number of messages in this error cache.
     *
     * @return
     */
    public int size() {
        return messageList.size();
    }
}
