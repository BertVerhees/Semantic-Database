package nl.rosa.semanticdatabase.referencemodel.model.internal.datavalues.quantity.datetime;

import nl.rosa.semanticdatabase.referencemodel.model.internal.datatypes.CodePhrase;
import nl.rosa.semanticdatabase.referencemodel.model.internal.datavalues.SingleValuedDataValue;
import nl.rosa.semanticdatabase.referencemodel.model.internal.datavalues.quantity.DvAmount;
import nl.rosa.semanticdatabase.referencemodel.model.internal.datavalues.quantity.DvInterval;
import nl.rosa.semanticdatabase.referencemodel.model.internal.datavalues.quantity.ReferenceRange;
import nl.rosa.semanticdatabase.referencemodel.model.internal.datetime.DateTimeParsers;
import org.springframework.lang.Nullable;

import java.time.temporal.TemporalAmount;
import java.util.List;

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

	public DvDuration(
			@Nullable List<ReferenceRange> otherReferenceRanges,
			@Nullable DvInterval normalRange,
			@Nullable CodePhrase normalStatus,
			@Nullable Double accuracy,
			@Nullable Boolean accuracyIsPercent,
			@Nullable String magnitudeStatus,
			TemporalAmount value) {
		super(otherReferenceRanges, normalRange, normalStatus, accuracy, accuracyIsPercent, magnitudeStatus);
		this.value = value;
	}

}
