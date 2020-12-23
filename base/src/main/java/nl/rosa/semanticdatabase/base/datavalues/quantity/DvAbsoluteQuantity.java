package nl.rosa.semanticdatabase.base.datavalues.quantity;

import nl.rosa.semanticdatabase.base.datatype.CodePhrase;
import nl.rosa.semanticdatabase.base.datavalues.quantity.datetime.DvDate;

import java.util.List;

/**
 * Created by pieter.bos on 04/11/15.
 */
public abstract class DvAbsoluteQuantity<AT extends DvAmount, MT extends Comparable>
        extends DvQuantified<AT, MT> {

    public DvAbsoluteQuantity() {
    }

    protected DvAbsoluteQuantity(
            List<ReferenceRange> otherReferenceRanges,
            DvInterval normalRange,
            CodePhrase normalStatus,
            String magnitudeStatus) {
        super(otherReferenceRanges, normalRange, normalStatus, magnitudeStatus);
    }


}
