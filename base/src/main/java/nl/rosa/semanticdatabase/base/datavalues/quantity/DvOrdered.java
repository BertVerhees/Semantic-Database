package nl.rosa.semanticdatabase.base.datavalues.quantity;

import nl.rosa.semanticdatabase.base.datatype.CodePhrase;
import nl.rosa.semanticdatabase.base.datavalues.DataValue;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by pieter.bos on 04/11/15.
 */
public abstract class DvOrdered<T extends DvOrdered>
        extends DataValue
        implements Comparable<T> {

    /**
     * Optional normal status indicator of value with respect to normal range for this value.
     * Often included by lab, even if the normal range itself is not included. Coded by ordinals in series HHH, HH, H,
     * (nothing), L, LL, LLL; see openEHR terminology group normal_status.
     */
    private CodePhrase normalStatus;
    /**
     * Optional normal range.
     */
    private DvInterval<T> normalRange;
    /**
     * Optional tagged other reference ranges for this value in its particular measurement context.
     */
    private List<ReferenceRange<T>> otherReferenceRanges;

    protected DvOrdered(
            List<ReferenceRange<T>> otherReferenceRanges,
            DvInterval<T> normalRange) {
        this.normalRange = normalRange;
        this.otherReferenceRanges = otherReferenceRanges;
    }

    protected DvOrdered(
            List<ReferenceRange<T>> otherReferenceRanges,
            DvInterval<T> normalRange,
            CodePhrase normalStatus) {
        this.normalStatus = normalStatus;
        this.normalRange = normalRange;
        this.otherReferenceRanges = otherReferenceRanges;
    }


    public DvInterval<T> getNormalRange() {
        return normalRange;
    }

    public void setNormalRange(DvInterval<T> normalRange) {
        this.normalRange = normalRange;
    }

    public List<ReferenceRange<T>> getOtherReferenceRanges() {
        return otherReferenceRanges;
    }

    public void setOtherReferenceRanges(List<ReferenceRange<T>> otherReferenceRanges) {
        this.otherReferenceRanges = otherReferenceRanges;
    }

    public void addOtherReferenceRange(ReferenceRange<T> range) {
        if(otherReferenceRanges==null){
            otherReferenceRanges = new ArrayList<>();
        }
        otherReferenceRanges.add(range);
    }

    
    public CodePhrase getNormalStatus() {
        return normalStatus;
    }

    public void setNormalStatus( CodePhrase normalStatus) {
        this.normalStatus = normalStatus;
    }
    /**
     * Value is in the normal range, determined by comparison of the value to normal_range if present,
     * or by the normal_status marker if present.
     * @return true if normal
     * @throws IllegalStateException if both normalRange and normalStatus null
     * Pre: normal_range /= Void or normal_status /= Void
     * Post_range: normal_range /= Void implies Result = normal_range.has (self)
     * Post_status: normal_status /= Void implies normal_status.code_string.is_equal (“N”)
     */
    public boolean isNormal() throws IllegalStateException {
        if(normalRange == null && normalStatus == null) {
            throw new IllegalStateException(
                    "Both normalRange and normalStatus must not be null");
        }
        if(normalRange != null) {
            return getNormalRange().has(this);
        } else {
            return normalStatus.getCodeString().equals("N");
        }
    }

    /**
     * Test if two instances are strictly comparable. Effected in descendants.
     * @param other
     * @return
     */
    public abstract Boolean isStrictlyComparableTo(DvOrdered<T> other);

    /**
     * True if this quantity has no reference ranges.
     * @return
     */
    public Boolean isSimple(){
        return otherReferenceRanges == null || otherReferenceRanges.size() == 0;
    }

    public abstract Boolean lessThen(DvOrdered<T> other);


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DvOrdered<?> dvOrdered = (DvOrdered<?>) o;
        return Objects.equals(normalStatus, dvOrdered.normalStatus) &&
                Objects.equals(normalRange, dvOrdered.normalRange) &&
                Objects.equals(otherReferenceRanges, dvOrdered.otherReferenceRanges);
    }

    @Override
    public int hashCode() {
        return Objects.hash(normalStatus, normalRange, otherReferenceRanges);
    }
}
