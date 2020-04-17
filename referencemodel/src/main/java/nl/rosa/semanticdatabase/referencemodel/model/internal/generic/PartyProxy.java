package nl.rosa.semanticdatabase.referencemodel.model.internal.generic;

import org.springframework.lang.Nullable;
import nl.rosa.semanticdatabase.referencemodel.model.internal.support.identification.PartyRef;

public abstract class PartyProxy {
    @Nullable
    private PartyRef externalRef;

    public PartyProxy() {
    }

    public PartyProxy(@Nullable PartyRef externalRef) {
        this.externalRef = externalRef;
    }
}
