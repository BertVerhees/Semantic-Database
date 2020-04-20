package nl.rosa.semanticdatabase.referencemodel.model.internal.datavalues.quantity;

import nl.rosa.semanticdatabase.referencemodel.model.internal.datatypes.CodePhrase;
import org.springframework.lang.Nullable;

import javax.xml.bind.annotation.*;
import java.util.List;

public abstract class DvAmount<MagnitudeType extends Comparable> extends DvQuantified<Double, MagnitudeType> {
    @Nullable
    private Double accuracy;
    @Nullable
    @XmlElement(name = "accuracy_is_percent")
    private Boolean accuracyIsPercent;

    public DvAmount() {
    }

    public DvAmount(
            @Nullable List<ReferenceRange> otherReferenceRanges,
            @Nullable DvInterval normalRange,
            @Nullable CodePhrase normalStatus,
            @Nullable Double accuracy,
            @Nullable Boolean accuracyIsPercent,
            @Nullable String magnitudeStatus) {
        super(otherReferenceRanges, normalRange, normalStatus, magnitudeStatus);
        this.accuracy = accuracy;
        this.accuracyIsPercent = accuracyIsPercent;
    }
}
