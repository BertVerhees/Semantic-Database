package nl.rosa.semanticdatabase.base.datavalues.quantity;

import nl.rosa.semanticdatabase.base.datatype.CodePhrase;

import java.util.List;
import java.util.Objects;

/**
 * Created by pieter.bos on 04/11/15.
 */
public abstract class DvAmount<MT extends Comparable>
        extends DvQuantified<Double, MT> {
    
    private Double accuracy;
    private Boolean accuracyIsPercent;

    public DvAmount() {
    }

    public DvAmount(List<ReferenceRange> otherReferenceRanges, DvInterval normalRange, CodePhrase normalStatus, Double accuracy, Boolean accuracyIsPercent, String magnitudeStatus) {
        super(otherReferenceRanges, normalRange, normalStatus, magnitudeStatus);
        this.accuracy = accuracy;
        this.accuracyIsPercent = accuracyIsPercent;
    }

    
    public Boolean getAccuracyIsPercent() {
        return accuracyIsPercent;
    }

    public void setAccuracyIsPercent( Boolean accuracyIsPercent) {
        this.accuracyIsPercent = accuracyIsPercent;
    }

    @Override
    public Double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(Double accuracy) {
        this.accuracy = accuracy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DvAmount<?> dvAmount = (DvAmount<?>) o;
        return Objects.equals(accuracy, dvAmount.accuracy) &&
                Objects.equals(accuracyIsPercent, dvAmount.accuracyIsPercent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), accuracy, accuracyIsPercent);
    }
}
