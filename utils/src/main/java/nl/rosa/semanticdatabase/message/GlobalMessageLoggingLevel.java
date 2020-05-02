package nl.rosa.semanticdatabase.message;

/**
 * Default created on 2-5-2020
 */

public class GlobalMessageLoggingLevel {
    /**
     * At this level and above, list entries are included in `as_string' and any other output function
     */
    private static MessageSeverity globalLoggingLevel = MessageSeverity.WARNING;

    public static MessageSeverity getGlobalLoggingLevel() {
        return globalLoggingLevel;
    }

    public static void setGlobalLoggingLevel(MessageSeverity globalLoggingLevel) {
        GlobalMessageLoggingLevel.globalLoggingLevel = globalLoggingLevel;
    }

    public static boolean shouldLog(MessageSeverity severity) {
        return severity.getLevel() >= globalLoggingLevel.getLevel();
    }
}
