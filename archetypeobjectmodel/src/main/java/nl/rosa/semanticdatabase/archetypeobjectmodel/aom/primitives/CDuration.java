package nl.rosa.semanticdatabase.archetypeobjectmodel.aom.primitives;

import lombok.Getter;
import lombok.Setter;
import nl.rosa.semanticdatabase.referencemodel.model.internal.base.Interval;

import java.time.temporal.TemporalAmount;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CDuration extends CTemporal<TemporalAmount> {

    private TemporalAmount assumedValue;
    private List<Interval<TemporalAmount>> constraint = new ArrayList<>();

    public List<Interval<TemporalAmount>> getConstraints() {
        return constraint;
    }

    @Override
    public void addConstraint(Interval<TemporalAmount> constraint) {
        this.constraint.add(constraint);
    }

}
