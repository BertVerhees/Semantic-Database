package nl.rosa.semanticdatabase.referencemodel.model.internal.datavalues.quantity;

import lombok.Getter;
import lombok.Setter;
import nl.rosa.semanticdatabase.referencemodel.model.internal.base.Interval;
import nl.rosa.semanticdatabase.referencemodel.model.internal.datavalues.DataValue;

@Getter
@Setter
public class DvInterval<Type extends DvOrdered> extends DataValue {

    private final Interval<DvOrdered> interval;

    public DvInterval() {
        interval = new Interval<>();
    }

    public DvInterval(Type lower, Type upper) {
        interval = new Interval<>(lower, upper);
    }

    public boolean has(DvOrdered value) {
        return interval.has(value);
    }
}
