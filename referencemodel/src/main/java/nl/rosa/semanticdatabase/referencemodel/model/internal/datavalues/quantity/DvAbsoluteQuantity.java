package nl.rosa.semanticdatabase.referencemodel.model.internal.datavalues.quantity;

import com.nedap.archie.rm.datatypes.CodePhrase;
import org.springframework.lang.Nullable;

import java.util.List;

public abstract class DvAbsoluteQuantity<AccuracyType extends DvAmount, MagnitudeType extends Comparable> extends DvQuantified<AccuracyType, MagnitudeType> {

    public DvAbsoluteQuantity() {
    }

    protected DvAbsoluteQuantity(@Nullable List<ReferenceRange> otherReferenceRanges, @Nullable DvInterval normalRange, @Nullable CodePhrase normalStatus, @Nullable String magnitudeStatus) {
        super(otherReferenceRanges, normalRange, normalStatus, magnitudeStatus);
    }
}
