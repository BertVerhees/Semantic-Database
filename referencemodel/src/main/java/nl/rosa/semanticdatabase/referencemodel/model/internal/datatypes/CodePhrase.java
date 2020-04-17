package nl.rosa.semanticdatabase.referencemodel.model.internal.datatypes;

import nl.rosa.semanticdatabase.referencemodel.model.internal.RMObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodePhrase extends RMObject {

    private TerminologyId terminologyId;
    private String codeString;

    public CodePhrase() {

    }

    public CodePhrase(TerminologyId terminologyId, String codeString) {
        this.terminologyId = terminologyId;
        this.codeString = codeString;
    }

    /**
     * Construct a code phrase in the form:
     * <br>
     * [terminologyId::codeString]
     * <br>
     * or
     * <br>
     * terminologyId::codeString
     * <p>
     * terminologyId can be just a a string, or contain a version as in  terminologyId(version)
     *
     * @param phrase
     */
    public CodePhrase(String phrase) {
        //'[' NAME_CHAR+ ( '(' NAME_CHAR+ ')' )? '::' NAME_CHAR+ ']' ;
        Pattern pattern = Pattern.compile("\\[?(?<terminologyId>.+)(\\((?<terminologyVersion>.+)\\))?::(?<codeString>[^\\]]+)\\]?");
        Matcher matcher = pattern.matcher(phrase);

        if (matcher.matches()) {
            terminologyId = new TerminologyId(matcher.group("terminologyId"), matcher.group("terminologyVersion"));
            codeString = matcher.group("codeString");
        } else {
            terminologyId = new TerminologyId();
            terminologyId.setValue("UNKNOWN");
            codeString = phrase;//no id
        }
    }

}
