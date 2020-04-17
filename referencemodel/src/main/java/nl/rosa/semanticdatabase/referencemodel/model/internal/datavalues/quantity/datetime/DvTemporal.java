package nl.rosa.semanticdatabase.referencemodel.model.internal.datavalues.quantity.datetime;

import nl.rosa.semanticdatabase.referencemodel.model.internal.datavalues.quantity.DvAbsoluteQuantity;
import nl.rosa.semanticdatabase.referencemodel.model.internal.datavalues.quantity.DvInterval;
import org.springframework.lang.Nullable;
import java.util.List;

public abstract class DvTemporal<MagnitudeType extends Comparable> extends DvAbsoluteQuantity<DvDuration, MagnitudeType> {

    @Nullable
    private DvDuration accuracy;

    public DvTemporal() {
    }

    public DvTemporal(@Nullable DvDuration accuracy) {
        this.accuracy = accuracy;
    }

    public DvTemporal(@Nullable List<ReferenceRange> otherReferenceRanges, @Nullable DvInterval normalRange, @Nullable CodePhrase normalStatus, @Nullable String magnitudeStatus, @Nullable DvDuration accuracy) {
        super(otherReferenceRanges, normalRange, normalStatus, magnitudeStatus);
        this.accuracy = accuracy;
    }

}
