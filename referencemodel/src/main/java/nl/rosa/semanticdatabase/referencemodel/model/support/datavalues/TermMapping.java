package nl.rosa.semanticdatabase.referencemodel.model.support.datavalues;

import nl.rosa.semanticdatabase.referencemodel.model.support.RMObject;
import nl.rosa.semanticdatabase.referencemodel.model.support.datatypes.CodePhrase;
import org.springframework.lang.Nullable;

public class TermMapping extends RMObject {
    private Character match = '?';
    @Nullable
    private DvCodedText purpose;
    private CodePhrase target;

    public TermMapping() {
    }

    public TermMapping(CodePhrase target, Character match, @Nullable DvCodedText purpose) {
        this.match = match;
        this.purpose = purpose;
        this.target = target;
    }
}
