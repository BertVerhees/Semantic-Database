package nl.rosa.semanticdatabase.referencemodel.model.internal.archetyped;

import nl.rosa.semanticdatabase.referencemodel.model.internal.RMObject;
import nl.rosa.semanticdatabase.referencemodel.model.internal.datavalues.DvIdentifier;
import nl.rosa.semanticdatabase.referencemodel.model.internal.datavalues.encapsulated.DvEncapsulated;
import org.springframework.lang.Nullable;

import java.util.ArrayList;
import java.util.List;

public class FeederAudit extends RMObject {

    @Nullable
    protected List<DvIdentifier> originatingSystemItemIds = new ArrayList<>();
    @Nullable
    protected List<DvIdentifier> feederSystemItemIds = new ArrayList<>();
    @Nullable
    protected DvEncapsulated originalContent;

    protected FeederAuditDetails originatingSystemAudit;
    @Nullable
    protected FeederAuditDetails feederSystemAudit;

    public FeederAudit() {
    }

    public FeederAudit(
            FeederAuditDetails originatingSystemAudit,
            @Nullable List<DvIdentifier> originatingSystemItemIds,
            @Nullable FeederAuditDetails feederSystemAudit,
            @Nullable List<DvIdentifier> feederSystemItemIds,
            @Nullable DvEncapsulated originalContent) {
        this.originatingSystemItemIds = originatingSystemItemIds;
        this.feederSystemItemIds = feederSystemItemIds;
        this.originalContent = originalContent;
        this.originatingSystemAudit = originatingSystemAudit;
        this.feederSystemAudit = feederSystemAudit;
    }

}
