package nl.rosa.semanticdatabase.referencemodel.model.internal.generic;

import org.springframework.lang.Nullable;

import java.util.ArrayList;
import java.util.List;

public class PartyIdentified extends PartyProxy{
    @Nullable
    private String name;
    @Nullable
    private List<DvIdentifier> identifiers = new ArrayList<>();

    public PartyIdentified() {
    }

    public PartyIdentified(@Nullable PartyRef externalRef, @Nullable String name, @Nullable List<DvIdentifier> identifiers) {
        super(externalRef);
        this.name = name;
        this.identifiers = identifiers;
    }

}
