package nl.rosa.semanticdatabase.referencemodel.model.internal.datavalues.quantity.datetime;

import lombok.Getter;
import lombok.Setter;
import nl.rosa.semanticdatabase.referencemodel.model.internal.datatypes.CodePhrase;
import nl.rosa.semanticdatabase.referencemodel.model.internal.datavalues.quantity.DvInterval;
import nl.rosa.semanticdatabase.referencemodel.model.internal.datavalues.quantity.ReferenceRange;
import nl.rosa.semanticdatabase.referencemodel.model.internal.datetime.DateTimeParsers;
import org.springframework.lang.Nullable;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQueries;
import java.util.List;

@Getter
@Setter
public class DvDateTime extends DvTemporal<Long> {

	private TemporalAccessor value;


	public DvDateTime() {
	}

	@Override
	public DvDuration getAccuracy() {
		return null;
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


	public DvDateTime(
			@Nullable List<ReferenceRange> otherReferenceRanges,
			@Nullable DvInterval normalRange,
			@Nullable CodePhrase normalStatus,
			@Nullable String magnitudeStatus,
			@Nullable DvDuration accuracy,
			TemporalAccessor value) {
		super(otherReferenceRanges, normalRange, normalStatus, magnitudeStatus, accuracy);
		this.value = value;
	}

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

}
