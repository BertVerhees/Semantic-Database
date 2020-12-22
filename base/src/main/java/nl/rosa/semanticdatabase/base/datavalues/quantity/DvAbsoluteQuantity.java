package nl.rosa.semanticdatabase.base.datavalues.quantity;

import nl.rosa.semanticdatabase.base.datatype.CodePhrase;

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

    /**
     * Sum of this quantity and another whose formal type must be the
     * difference type of this quantity.
     *
     * @param s
     * @return product of addition
     */
    public abstract MT add(AT s);

    /**
     * Difference of this quantity and another whose formal type must
     * be the difference type of this quantity type.
     *
     * @param s
     * @return product of substration
     */
    public abstract MT subtract(AT s);

    /**
     * Difference of two quantities.
     *
     * @return diff type
     */
    public abstract AT diff(MT other);
}
