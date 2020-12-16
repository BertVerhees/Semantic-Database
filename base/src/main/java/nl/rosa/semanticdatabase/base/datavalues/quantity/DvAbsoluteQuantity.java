package nl.rosa.semanticdatabase.base.datavalues.quantity;

import nl.rosa.semanticdatabase.base.datatype.CodePhrase;

import java.util.List;

/**
 * Created by pieter.bos on 04/11/15.
 */
public abstract class DvAbsoluteQuantity<AccuracyType extends DvAmount, MagnitudeType extends Comparable> extends DvQuantified<AccuracyType, MagnitudeType> {

    public DvAbsoluteQuantity() {
    }

    protected DvAbsoluteQuantity(List<ReferenceRange> otherReferenceRanges, DvInterval normalRange, CodePhrase normalStatus, String magnitudeStatus) {
        super(otherReferenceRanges, normalRange, normalStatus, magnitudeStatus);
    }
}
