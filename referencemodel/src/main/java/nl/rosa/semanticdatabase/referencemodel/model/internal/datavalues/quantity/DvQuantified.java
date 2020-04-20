package nl.rosa.semanticdatabase.referencemodel.model.internal.datavalues.quantity;


import lombok.Getter;
import lombok.Setter;
import nl.rosa.semanticdatabase.referencemodel.model.internal.datatypes.CodePhrase;
import org.springframework.lang.Nullable;

import java.util.List;

@Getter
@Setter
public abstract class DvQuantified<AccuracyType, MagnitudeType extends Comparable> extends DvOrdered<MagnitudeType> {

    @Nullable
    private String magnitudeStatus;

    public DvQuantified() {
    }

    public DvQuantified(
            @Nullable List<ReferenceRange> otherReferenceRanges,
            @Nullable DvInterval normalRange,
            @Nullable CodePhrase normalStatus,
            @Nullable String magnitudeStatus) {
        super(otherReferenceRanges, normalRange, normalStatus);
        this.magnitudeStatus = magnitudeStatus;
    }
    @Nullable
    public abstract AccuracyType getAccuracy();

    public abstract MagnitudeType getMagnitude();

    @Override
    public int compareTo(MagnitudeType other) {
        return getMagnitude().compareTo(other);
    }


}
