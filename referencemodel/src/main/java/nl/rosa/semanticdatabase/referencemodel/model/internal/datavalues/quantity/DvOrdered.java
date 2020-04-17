package nl.rosa.semanticdatabase.referencemodel.model.internal.datavalues.quantity;

import org.springframework.lang.Nullable;

import java.util.ArrayList;
import java.util.List;

public abstract class DvOrdered<ComparableType> extends DataValue implements Comparable<ComparableType> {

    @Nullable
    private CodePhrase normalStatus;
    @Nullable
    private DvInterval normalRange;

    @Nullable
    private List<ReferenceRange> otherReferenceRanges = new ArrayList<>();

    public DvOrdered() {
    }

    public DvOrdered(@Nullable List<ReferenceRange> otherReferenceRanges, @Nullable DvInterval normalRange) {
        this.normalRange = normalRange;
        this.otherReferenceRanges = otherReferenceRanges;
    }

    protected DvOrdered(@Nullable List<ReferenceRange> otherReferenceRanges, @Nullable DvInterval normalRange, @Nullable CodePhrase normalStatus) {
        this.normalStatus = normalStatus;
        this.normalRange = normalRange;
        this.otherReferenceRanges = otherReferenceRanges;
    }
    public void addOtherReferenceRange(ReferenceRange range) {
        otherReferenceRanges.add(range);
    }
}
