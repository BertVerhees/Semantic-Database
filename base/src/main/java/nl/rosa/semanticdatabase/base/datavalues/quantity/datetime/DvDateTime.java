package nl.rosa.semanticdatabase.base.datavalues.quantity.datetime;

import nl.rosa.semanticdatabase.base.datatype.CodePhrase;
import nl.rosa.semanticdatabase.base.datavalues.SingleValuedDataValue;
import nl.rosa.semanticdatabase.base.datavalues.quantity.DvInterval;
import nl.rosa.semanticdatabase.base.datavalues.quantity.ReferenceRange;
import nl.rosa.semanticdatabase.base.utils.datetime.DateTimeParsers;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQueries;
import java.util.List;
import java.util.Objects;

/**
 * Originally: Created by pieter.bos on 04/11/15.
 */
public class DvDateTime extends DvTemporal<Long> implements SingleValuedDataValue<TemporalAccessor> {

    private TemporalAccessor value;


    public DvDateTime() {
    }

    public DvDateTime(TemporalAccessor value) {
        this.value = value;
    }

    /**
     * Constructs a DvDateTime from an ISO 8601 Date-Time String
     *
     * @param iso8601DateTime
     */
    public DvDateTime(String iso8601DateTime) {
        this.value = DateTimeParsers.parseDateTimeValue(iso8601DateTime);
    }


    public DvDateTime(List<ReferenceRange> otherReferenceRanges, DvInterval normalRange, CodePhrase normalStatus, String magnitudeStatus, DvDuration accuracy, TemporalAccessor value) {
        super(otherReferenceRanges, normalRange, normalStatus, magnitudeStatus, accuracy);
        this.value = value;
    }

    @Override
//    @XmlElements({
//            @XmlElement(type = OffsetDateTime.class),
//            @XmlElement(type = LocalDateTime.class)
//    })
    public TemporalAccessor getValue() {
        return value;
    }

    @Override
    public void setValue(TemporalAccessor value) {
        this.value = value;
    }

    @Override
    public Long getMagnitude() {
        if (value == null) {
            return null;
        }
        if (value.query(TemporalQueries.zone()) != null) {
            return ZonedDateTime.from(value).toEpochSecond();
        } else {
            return LocalDateTime.from(value).toEpochSecond(ZoneOffset.UTC);
        }
    }

    public void setMagnitude(Long magnitude) {
        if (magnitude == null) {
            value = null;
        } else {
            value = LocalDateTime.ofEpochSecond(magnitude, 0, ZoneOffset.UTC);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        DvDateTime that = (DvDateTime) o;

        return Objects.equals(value, that.value);

    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), value);
    }
}
