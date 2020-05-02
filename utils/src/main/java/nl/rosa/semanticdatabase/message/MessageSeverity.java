package nl.rosa.semanticdatabase.message;

/**
 * Default created on 2-5-2020
 */

public enum MessageSeverity {
    DEBUG(9000), INFO(9001), WARNING(9002), ERROR(9003);


    private final int level;

    MessageSeverity(int level) {
        this.level = level;
    }

    /**
     /**
     * Method returns true if a valid error code is passed in as a method argument.
     *
     * @param anErrorType
     * @return
     */
    public static boolean isValidErrorType(int anErrorType) {
        return anErrorType >= DEBUG.level && anErrorType <= ERROR.level;
    }

    public int getLevel() {
        return level;
    }
}
