package nl.rosa.semanticdatabase.base.datavalues.quantity;

import nl.rosa.semanticdatabase.base.datatype.CodePhrase;
import nl.rosa.semanticdatabase.base.datavalues.quantity.datetime.DvDate;

import java.util.List;

/**
 * Created by pieter.bos on 04/11/15.
 */
public abstract class DvAbsoluteQuantity<A extends DvAmount, T extends DvAbsoluteQuantity>
        extends DvQuantified<T> {

    protected DvAbsoluteQuantity(
            List<ReferenceRange> otherReferenceRanges,
            DvInterval normalRange,
            CodePhrase normalStatus,
            A  accuracy,
            String magnitudeStatus) {
        super(otherReferenceRanges, normalRange, normalStatus, magnitudeStatus);
        this.accuracy = accuracy;
    }

    /**
     * Sum of this quantity and another whose formal type must be the
     * difference type of this quantity.
     *
     * @param s
     * @return product of addition
     */
    public abstract T add(A s);

    /**
     * Difference of this quantity and another whose formal type must
     * be the difference type of this quantity type.
     *
     * @param s
     * @return product of substration
     */
    public abstract T subtract(A s);

    /**
     * Difference of two quantities.
     *
     * @return diff type
     */
    public abstract DvAmount diff(T other);

    /**
     * Accuracy of measurement, expressed as a half-range value
     * of the diff type for this quantity (i.e. an accuracy of
     * x means +/−x).
     *
     * @return accuracy
     */
    public A getAccuracy() {
        return accuracy;
    }


    /* fields */
    private final A accuracy;


}
