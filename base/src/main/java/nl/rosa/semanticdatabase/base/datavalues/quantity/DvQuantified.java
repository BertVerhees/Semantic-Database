package nl.rosa.semanticdatabase.base.datavalues.quantity;


import nl.rosa.semanticdatabase.base.datatype.CodePhrase;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Created by pieter.bos on 04/11/15.
 */
public abstract class DvQuantified<T extends DvQuantified>
        extends DvOrdered<T> {

    /**
     * Optional status of magnitude with values:
     * "=" : magnitude is a point value
     * "<" : value is < magnitude
     * ">" : value is > magnitude
     * "<=" : value is <= magnitude
     * ">=" : value is >= magnitude
     * "~" : value is approximately magnitude
     * If not present, assumed meaning is "=" .
     */
    private String magnitudeStatus;

    public DvQuantified() {
    }

    public DvQuantified(
            List<ReferenceRange> otherReferenceRanges,
            DvInterval normalRange,
            CodePhrase normalStatus,
            String magnitudeStatus) {
        super(otherReferenceRanges, normalRange, normalStatus);
        this.magnitudeStatus = magnitudeStatus;
    }

    public String getMagnitudeStatus() {
        return magnitudeStatus;
    }

    public void setMagnitudeStatus( String magnitudeStatus) {
        this.magnitudeStatus = magnitudeStatus;
    }
    public Boolean validMagnitudeStatus() {
        String[] resultTest = {"=", "<", ">", "<=", ">=", "~"};
        if(magnitudeStatus!=null && !Arrays.asList().contains(magnitudeStatus)){
            return false;
        }
        return true;
    }

    public abstract MT getMagnitude();

    /**
     * True if other is less than this Quantified object. Based on comparison of magnitude.
     * @param other
     * @return Post_result: Result = magnitude < other.magnitude
     */
    public Boolean lessThan(DvQuantified<AT,MT> other){
        return getMagnitude().compareTo(other.getMagnitude())>0;
    }


    @Override
    public int compareTo(MT other) {
        return getMagnitude().compareTo(other);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DvQuantified<?, ?> that = (DvQuantified<?, ?>) o;
        return Objects.equals(magnitudeStatus, that.magnitudeStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), magnitudeStatus);
    }
}
