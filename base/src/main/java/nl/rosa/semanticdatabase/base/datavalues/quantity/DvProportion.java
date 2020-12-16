package nl.rosa.semanticdatabase.base.datavalues.quantity;

import nl.rosa.semanticdatabase.base.datatype.CodePhrase;

import java.util.List;
import java.util.Objects;

/**
 * TODO: This does not implement PROPORTION KIND, because multiple inheritance - won't work.
 * It does have a type=proportion kind enum
 * Created by pieter.bos on 04/11/15.
 */
public class DvProportion extends DvAmount<Double> {

    private Double numerator;
    private Double denominator;
    private Long type;
    
    private Long precision;

    public DvProportion() {
    }

    public DvProportion(Double numerator, Double denominator, Long type) {
        this.numerator = numerator;
        this.denominator = denominator;
        this.type = type;
    }

    public DvProportion(List<ReferenceRange> otherReferenceRanges, DvInterval normalRange, CodePhrase normalStatus, Double accuracy, Boolean accuracyIsPercent, String magnitudeStatus, Double numerator, Double denominator, Long type, Long precision) {
        super(otherReferenceRanges, normalRange, normalStatus, accuracy, accuracyIsPercent, magnitudeStatus);
        this.numerator = numerator;
        this.denominator = denominator;
        this.type = type;
        this.precision = precision;
    }

    public Double getNumerator() {
        return numerator;
    }

    public void setNumerator(Double numerator) {
        this.numerator = numerator;
    }


    public Double getDenominator() {
        return denominator;
    }

    public void setDenominator(Double denominator) {
        this.denominator = denominator;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    
    public Long getPrecision() {
        return precision;
    }

    public void setPrecision( Long precision) {
        this.precision = precision;
    }

    public boolean isIntegral() {
        return precision != null && precision == 0;
    }

    @Override
    public Double getMagnitude() {
        if (numerator != null && denominator != null && denominator != 0.0d) {
            return numerator / denominator;
        } else if (numerator == null) {
            return 0.0;
        } else {
            return Double.MAX_VALUE;//TODO: actually: infinity. Max Double value?
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DvProportion that = (DvProportion) o;
        return Objects.equals(numerator, that.numerator) &&
                Objects.equals(denominator, that.denominator) &&
                Objects.equals(type, that.type) &&
                Objects.equals(precision, that.precision);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numerator, denominator, type, precision);
    }
}
