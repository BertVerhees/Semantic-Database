package nl.rosa.semanticdatabase.base.datavalues.quantity.datetime;

<<<<<<< HEAD:base/src/main/java/nl/rosa/semanticdatabase/base/datavalues/quantity/datetime/DvTime.java
import nl.rosa.semanticdatabase.base.datatype.CodePhrase;
import nl.rosa.semanticdatabase.base.datavalues.SingleValuedDataValue;
import nl.rosa.semanticdatabase.base.datavalues.quantity.DvInterval;
import nl.rosa.semanticdatabase.base.datavalues.quantity.ReferenceRange;
import nl.rosa.semanticdatabase.base.utils.datetime.DateTimeParsers;

=======
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nedap.archie.datetime.DateTimeParsers;
import com.nedap.archie.json.TimeDeserializer;
import com.nedap.archie.rm.datatypes.CodePhrase;
import com.nedap.archie.rm.datavalues.SingleValuedDataValue;
import com.nedap.archie.rm.datavalues.quantity.DvInterval;
import com.nedap.archie.rm.datavalues.quantity.ReferenceRange;
import com.nedap.archie.xml.adapters.TimeXmlAdapter;

import javax.annotation.Nullable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
>>>>>>> 555568c612c426eda0c539017b7a13c84fabaefa:base/src/main/java/nl/rosa/semanticdatabase/base_types/datavalues/quantity/datetime/DvTime.java
import java.time.LocalTime;
import java.time.temporal.TemporalAccessor;
import java.util.List;
import java.util.Objects;

/**
 * TODO: implement java.time.Temporal for this object?
 * <p>
 * Deviation from the standard: the standard uses a String to represent a value here.
 * We do not, we use the java time types. Perhaps we will add a parser later.
 * possible issue: people constraining the String field of DvTime directly instead of using a Ctime. Ask people if this is an issue.
 * <p>
 * Originally: Created by pieter.bos on 04/11/15.
 */
public class DvTime extends DvTemporal<Double> implements SingleValuedDataValue<TemporalAccessor> {

    private TemporalAccessor value;


    public DvTime(TemporalAccessor value) {
        this.value = value;
    }

    /**
     * Constructs a DVTime form an Iso8601 Time String
     *
     * @param iso8601Time
     */
    public DvTime(String iso8601Time) {
        this.value = DateTimeParsers.parseTimeValue(iso8601Time);
    }

    public DvTime(List<ReferenceRange> otherReferenceRanges, DvInterval normalRange, CodePhrase normalStatus, String magnitudeStatus, DvDuration accuracy, TemporalAccessor value) {
        super(otherReferenceRanges, normalRange, normalStatus, magnitudeStatus, accuracy);
        this.value = value;
    }

    @Override
    public void setValue(TemporalAccessor value) {
        this.value = value;
    }

    @Override
//    @XmlElements({
//            @XmlElement(type=OffsetTime.class),
//            @XmlElement(type=LocalTime.class)
//    })    
<<<<<<< HEAD:base/src/main/java/nl/rosa/semanticdatabase/base/datavalues/quantity/datetime/DvTime.java
=======
    @JsonDeserialize(using = TimeDeserializer.class)
>>>>>>> 555568c612c426eda0c539017b7a13c84fabaefa:base/src/main/java/nl/rosa/semanticdatabase/base_types/datavalues/quantity/datetime/DvTime.java
    public TemporalAccessor getValue() {
        return value;
    }

    @Override
    public Double getMagnitude() {
        return value == null ? null : (double) LocalTime.from(value).toSecondOfDay();
    }

    public void setMagnitude(Double magnitude) {
        if (magnitude == null) {
            value = null;
        } else {
            value = LocalTime.ofSecondOfDay(Math.round(magnitude));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        DvTime dvTime = (DvTime) o;

        return Objects.equals(value, dvTime.value);

    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), value);
    }
}
