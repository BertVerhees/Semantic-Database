package nl.rosa.semanticdatabase.message;

/**
 * Default created on 2-5-2020
 */

@Deprecated
class UnknownMessageCode implements MessageCode {
    @Override
    public String getCode() {
        return "";
    }

    @Override
    public String getMessageTemplate() {
        return "{0}";
    }
}