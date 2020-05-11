package nl.rosa.semanticdatabase.referencemodel.model.internal.datavalues;

import lombok.Getter;
import lombok.Setter;
import nl.rosa.semanticdatabase.referencemodel.model.internal.RMObject;
import nl.rosa.semanticdatabase.referencemodel.model.internal.datatypes.CodePhrase;
import org.springframework.lang.Nullable;

@Getter
@Setter
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
