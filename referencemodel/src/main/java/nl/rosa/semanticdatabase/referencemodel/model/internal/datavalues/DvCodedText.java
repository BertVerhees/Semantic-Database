package nl.rosa.semanticdatabase.referencemodel.model.internal.datavalues;

import org.springframework.lang.Nullable;

public class DvCodedText extends DvText {

    private CodePhrase definingCode;


    public DvCodedText() {
    }

    public DvCodedText(String value, CodePhrase definingCode) {
        super(value);
        this.definingCode = definingCode;
    }

    public DvCodedText(String value, @Nullable CodePhrase language, @Nullable CodePhrase encoding, CodePhrase definingCode) {
        super(value, language, encoding);
        this.definingCode = definingCode;
    }

}
