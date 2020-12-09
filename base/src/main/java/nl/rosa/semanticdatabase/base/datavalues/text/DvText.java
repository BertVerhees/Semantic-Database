package nl.rosa.semanticdatabase.base.datavalues.text;


import semanticdatabase.base.base_types.datavalues.DataValue;
import semanticdatabase.base.base_types.datavalues.DvURI;
import semanticdatabase.base.base_types.datavalues.SingleValuedDataValue;
import semanticdatabase.base.base_types.datavalues.TermMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Originally: Created by pieter.bos on 04/11/15.
 */
public class DvText extends DataValue implements SingleValuedDataValue<String> {


    private String value;
    private DvURI hyperlink;
    private String formatting;
    private List<TermMapping> mappings = new ArrayList<>();
    private CodePhrase language;
    private CodePhrase encoding;

    public DvText() {

    }

    public DvText(String value) {
        this.value = value;
    }

    public DvText(String value, CodePhrase language, CodePhrase encoding) {
        this.value = value;
        this.language = language;
        this.encoding = encoding;
    }

    public List<TermMapping> getMappings() {
        return mappings;
    }

    public void setMappings(List<TermMapping> mappings) {
        this.mappings = mappings;
    }

    public void addMapping(TermMapping mapping) {
        this.mappings.add(mapping);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public DvURI getHyperlink() {
        return hyperlink;
    }

    public void setHyperlink(DvURI hyperlink) {
        this.hyperlink = hyperlink;
    }

    public String getFormatting() {
        return formatting;
    }

    public void setFormatting(String formatting) {
        this.formatting = formatting;
    }

    public CodePhrase getLanguage() {
        return language;
    }

    public void setLanguage(CodePhrase language) {
        this.language = language;
    }

    public CodePhrase getEncoding() {
        return encoding;
    }

    public void setEncoding(CodePhrase encoding) {
        this.encoding = encoding;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DvText dvText = (DvText) o;
        return Objects.equals(value, dvText.value) &&
                Objects.equals(hyperlink, dvText.hyperlink) &&
                Objects.equals(formatting, dvText.formatting) &&
                Objects.equals(mappings, dvText.mappings) &&
                Objects.equals(language, dvText.language) &&
                Objects.equals(encoding, dvText.encoding);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, hyperlink, formatting, mappings, language, encoding);
    }
}
