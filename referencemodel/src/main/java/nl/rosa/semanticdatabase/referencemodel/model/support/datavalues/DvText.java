package nl.rosa.semanticdatabase.referencemodel.model.support.datavalues;

import nl.rosa.semanticdatabase.referencemodel.model.support.datatypes.CodePhrase;
import org.springframework.lang.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DvText extends DataValue {
    private String value;
    @Nullable
    private DvURI hyperlink;
    @Nullable
    private String formatting;
    @Nullable
    private List<TermMapping> mappings = new ArrayList<>();
    @Nullable
    private CodePhrase language;
    @Nullable
    private CodePhrase encoding;

    public DvText() {

    }

    public DvText(String value) {
        this.value = value;
    }

    public DvText(String value, @Nullable CodePhrase language, @Nullable CodePhrase encoding) {
        this.value = value;
        this.language = language;
        this.encoding = encoding;
    }
}
