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

    public DvOrdered() {
    }

    public DvOrdered(
            List<ReferenceRange> otherReferenceRanges,
            DvInterval normalRange) {
        this.normalRange = normalRange;
        this.otherReferenceRanges = otherReferenceRanges;
    }

    protected DvOrdered(
            List<ReferenceRange> otherReferenceRanges,
            DvInterval normalRange,
            CodePhrase normalStatus) {
        this.normalStatus = normalStatus;
        this.normalRange = normalRange;
        this.otherReferenceRanges = otherReferenceRanges;
    }


    public DvInterval getNormalRange() {
        return normalRange;
    }

    public void setNormalRange(DvInterval normalRange) {
        this.normalRange = normalRange;
    }

    public List<ReferenceRange> getOtherReferenceRanges() {
        return otherReferenceRanges;
    }

    public void setOtherReferenceRanges(List<ReferenceRange> otherReferenceRanges) {
        this.otherReferenceRanges = otherReferenceRanges;
    }

    public void addOtherReferenceRange(ReferenceRange range) {
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
     * Value is in the normal range if there is one, otherwise True
     *
     * @return true if normal
     * @throws IllegalStateException if both normalRange and normalStatus null
     */
    public boolean isNormal() throws IllegalStateException {
        if(normalRange == null && normalStatus == null) {
            throw new IllegalStateException(
                    "both normalRange and normalStatus null");
        }
        if(normalRange != null) {
            return getNormalRange().has(this);
        } else {
            return normalStatus.getCodeString().equals("N");
        }
    }


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
