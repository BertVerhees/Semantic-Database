package nl.rosa.semanticdatabase.base.datavalues.quantity;

import nl.rosa.semanticdatabase.base.datatype.CodePhrase;

import java.util.List;
import java.util.Objects;

/**
 * Created by pieter.bos on 04/11/15.
 */
public class DvCount extends DvAmount<Long> {

    private Long magnitude;

    public DvCount() {
    }

    public DvCount(Long magnitude) {
        this.magnitude = magnitude;
    }

    public DvCount(
            List<ReferenceRange> otherReferenceRanges,
            DvInterval normalRange,
            CodePhrase normalStatus,
            Double accuracy,
            Boolean accuracyIsPercent,
            String magnitudeStatus,
            Long magnitude) {
        super(
                otherReferenceRanges,
                normalRange,
                normalStatus,
                accuracy,
                accuracyIsPercent,
                magnitudeStatus);
        this.magnitude = magnitude;
    }

    @Override
    public Long getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(Long magnitude) {
        this.magnitude = magnitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DvCount dvCount = (DvCount) o;
        return Objects.equals(magnitude, dvCount.magnitude);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), magnitude);
    }
}
