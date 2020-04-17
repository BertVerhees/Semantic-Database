package nl.rosa.semanticdatabase.referencemodel.model.internal.datavalues.quantity;


import org.springframework.lang.Nullable;

import java.util.List;

public abstract class DvQuantified<AccuracyType, MagnitudeType extends Comparable> extends DvOrdered<MagnitudeType> {

    @Nullable
    private String magnitudeStatus;

    public DvQuantified() {
    }

    public DvQuantified(@Nullable List<ReferenceRange> otherReferenceRanges, @Nullable DvInterval normalRange, @Nullable CodePhrase normalStatus, @Nullable String magnitudeStatus) {
        super(otherReferenceRanges, normalRange, normalStatus);
        this.magnitudeStatus = magnitudeStatus;
    }
}
