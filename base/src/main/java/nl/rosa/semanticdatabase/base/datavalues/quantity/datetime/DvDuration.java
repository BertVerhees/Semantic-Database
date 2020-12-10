package nl.rosa.semanticdatabase.base.datavalues.quantity.datetime;

import nl.rosa.semanticdatabase.base.datatype.CodePhrase;
import nl.rosa.semanticdatabase.base.datavalues.SingleValuedDataValue;
import nl.rosa.semanticdatabase.base.datavalues.quantity.DvAmount;
import nl.rosa.semanticdatabase.base.datavalues.quantity.DvInterval;
import nl.rosa.semanticdatabase.base.datavalues.quantity.ReferenceRange;

import java.time.temporal.TemporalAmount;
import java.util.List;
import java.util.Objects;

/**
 * TODO: magnitude of duration is not defined properly
 * Originally: Created by pieter.bos on 04/11/15.
 */

public class DvDuration extends DvAmount<Long> implements SingleValuedDataValue<TemporalAmount> {

    private TemporalAmount value;

    public DvDuration() {
    }

    public DvDuration(TemporalAmount value) {
        this.value = value;
    }

    /**
     * Constructs a DvDuration form an Iso8601 Duration
     *
     * @param iso8601Duration
     */
    public DvDuration(String iso8601Duration) {
        this.value = DateTimeParsers.parseDurationValue(iso8601Duration);
    }

    public DvDuration(List<ReferenceRange> otherReferenceRanges, DvInterval normalRange, CodePhrase normalStatus, Double accuracy, Boolean accuracyIsPercent, String magnitudeStatus, TemporalAmount value) {
        super(otherReferenceRanges, normalRange, normalStatus, accuracy, accuracyIsPercent, magnitudeStatus);
        this.value = value;
    }

    @Override
    public TemporalAmount getValue() {
        return value;
    }

    @Override
    public void setValue(TemporalAmount value) {
        this.value = value;
    }

    @Override
    public Long getMagnitude() {
        return null; //no magnitude defined in spec
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        DvDuration that = (DvDuration) o;

        return Objects.equals(value, that.value);

    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), value);
    }
}
