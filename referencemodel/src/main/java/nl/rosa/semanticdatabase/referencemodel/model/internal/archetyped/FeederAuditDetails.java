package nl.rosa.semanticdatabase.referencemodel.model.internal.archetyped;

import nl.rosa.semanticdatabase.referencemodel.model.internal.RMObject;
import nl.rosa.semanticdatabase.referencemodel.model.internal.generic.PartyIdentified;
import nl.rosa.semanticdatabase.referencemodel.model.internal.generic.PartyProxy;
import org.springframework.lang.Nullable;

public class FeederAuditDetails extends RMObject {

    protected String systemId;
    @Nullable
    protected PartyIdentified location;
    @Nullable
    protected PartyIdentified provider;
    @Nullable
    protected PartyProxy subject;
    @Nullable
    protected DvDateTime time;
    @Nullable
    protected String versionId;

    public FeederAuditDetails() {
    }

    public FeederAuditDetails(String systemId, @Nullable PartyIdentified provider, @Nullable PartyIdentified location, @Nullable DvDateTime time, @Nullable PartyProxy subject, @Nullable String versionId) {
        this.systemId = systemId;
        this.location = location;
        this.provider = provider;
        this.subject = subject;
        this.time = time;
        this.versionId = versionId;
    }
}