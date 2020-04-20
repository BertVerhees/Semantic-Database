package nl.rosa.semanticdatabase.referencemodel.model.internal.datavalues.quantity;

import nl.rosa.semanticdatabase.referencemodel.model.internal.RMObject;
import nl.rosa.semanticdatabase.referencemodel.model.internal.datavalues.DvText;

public class ReferenceRange<T extends DvOrdered> extends RMObject {

    private DvInterval<T> range;
    private DvText meaning;

    public ReferenceRange() {
    }

    public ReferenceRange(DvText meaning, DvInterval<T> range) {
        this.range = range;
        this.meaning = meaning;
    }

}
