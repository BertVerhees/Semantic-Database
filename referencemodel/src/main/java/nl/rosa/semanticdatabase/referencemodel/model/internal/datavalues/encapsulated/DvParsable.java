package nl.rosa.semanticdatabase.referencemodel.model.internal.datavalues.encapsulated;

import nl.rosa.semanticdatabase.referencemodel.model.internal.datatypes.CodePhrase;
import nl.rosa.semanticdatabase.referencemodel.model.internal.datavalues.SingleValuedDataValue;
import org.springframework.lang.Nullable;

public class DvParsable extends DvEncapsulated implements SingleValuedDataValue<String> {

    private String value;
    private String formalism;

    public DvParsable() {
    }

    public DvParsable(String value, String formalism) {
        this.value = value;
        this.formalism = formalism;
    }

    public DvParsable(@Nullable CodePhrase charset, @Nullable CodePhrase language, String value, String formalism) {
        super(charset, language);
        this.value = value;
        this.formalism = formalism;
    }
}
