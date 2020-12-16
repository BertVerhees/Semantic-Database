package nl.rosa.semanticdatabase.base.datavalues.quantity;


import nl.rosa.semanticdatabase.base.datatype.CodePhrase;

import java.util.List;
import java.util.Objects;

/**
 * Created by pieter.bos on 04/11/15.
 */
public abstract class DvQuantified<AccuracyType, MagnitudeType extends Comparable> extends DvOrdered<MagnitudeType> {

    
    private String magnitudeStatus;

    public DvQuantified() {
    }

    public DvQuantified(List<ReferenceRange> otherReferenceRanges, DvInterval normalRange, CodePhrase normalStatus, String magnitudeStatus) {
        super(otherReferenceRanges, normalRange, normalStatus);
        this.magnitudeStatus = magnitudeStatus;
    }

    
    public String getMagnitudeStatus() {
        return magnitudeStatus;
    }

    public void setMagnitudeStatus( String magnitudeStatus) {
        this.magnitudeStatus = magnitudeStatus;
    }

    
    public abstract AccuracyType getAccuracy();

    public abstract MagnitudeType getMagnitude();

    @Override
    public int compareTo(MagnitudeType other) {
        return getMagnitude().compareTo(other);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DvQuantified<?, ?> that = (DvQuantified<?, ?>) o;
        return Objects.equals(magnitudeStatus, that.magnitudeStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), magnitudeStatus);
    }
}
