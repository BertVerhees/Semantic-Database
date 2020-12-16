package nl.rosa.semanticdatabase.base.datatype;

import nl.rosa.semanticdatabase.base.identification.TerminologyId;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * TODO: reuse archetype model TerminologyCode? Thing is, that doesn't constrain as nicely with the archetype model...
 * Created by pieter.bos on 04/11/15.
 */
public class CodePhrase {

    private TerminologyId terminologyId;
    private String codeString;
    
    private String preferredTerm;

    public CodePhrase() {

    }
    public CodePhrase(String terminologyId, String codeString) {
        this(new TerminologyId(terminologyId), codeString, null);
    }


    public CodePhrase(TerminologyId terminologyId, String codeString) {
        this(terminologyId, codeString, null);
    }

    public CodePhrase(String terminologyId, String codeString, String preferredTerm) {
        this.terminologyId = new TerminologyId(terminologyId);
        this.codeString = codeString;
        this.preferredTerm = preferredTerm;
    }

    public CodePhrase(TerminologyId terminologyId, String codeString, String preferredTerm) {
        this.terminologyId = terminologyId;
        this.codeString = codeString;
        this.preferredTerm = preferredTerm;
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

    public TerminologyId getTerminologyId() {
        return terminologyId;
    }

    public void setTerminologyId(TerminologyId terminologyId) {
        this.terminologyId = terminologyId;
    }

    public String getCodeString() {
        return codeString;
    }

    public void setCodeString(String codeString) {
        this.codeString = codeString;
    }

    public String getPreferredTerm() {
        return preferredTerm;
    }

    public void setPreferredTerm(String preferredTerm) {
        this.preferredTerm = preferredTerm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CodePhrase that = (CodePhrase) o;
        return Objects.equals(terminologyId, that.terminologyId) &&
                Objects.equals(codeString, that.codeString) &&
                Objects.equals(preferredTerm, that.preferredTerm);

    }

    @Override
    public int hashCode() {
        return Objects.hash(terminologyId, codeString, preferredTerm);
    }

    public String toString() {
        return terminologyId + "::" + codeString;//TODO: preferredTerm?
    }
}