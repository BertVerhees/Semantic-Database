package nl.rosa.semanticdatabase.referencemodel.model.internal.datavalues.encapsulated;

import nl.rosa.semanticdatabase.referencemodel.model.internal.datatypes.CodePhrase;
import nl.rosa.semanticdatabase.referencemodel.model.internal.datavalues.DataValue;
import org.springframework.lang.Nullable;

public abstract class DvEncapsulated extends DataValue {
    @Nullable
    private CodePhrase charset;
    @Nullable
    private CodePhrase language;


    public DvEncapsulated() {
    }

    public DvEncapsulated(@Nullable CodePhrase charset, @Nullable CodePhrase language) {
        this.charset = charset;
        this.language = language;
    }
}
