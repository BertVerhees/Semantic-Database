package nl.rosa.semanticdatabase.referencemodel.model.internal.datavalues;

import org.springframework.lang.Nullable;

public class DvIdentifier extends DataValue{
    @Nullable
    private String issuer;
    @Nullable
    private String assigner;
    private String id;
    @Nullable
    private String type;

    public DvIdentifier(@Nullable String issuer, @Nullable String assigner, String id, @Nullable String type) {
        this.issuer = issuer;
        this.assigner = assigner;
        this.id = id;
        this.type = type;
    }
}
