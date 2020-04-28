package nl.rosa.semanticdatabase.archetypeobjectmodel.aom.primitives;

import lombok.Getter;
import lombok.Setter;
import nl.rosa.semanticdatabase.base.Interval;

import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CDateTime extends CTemporal<TemporalAccessor> {

    private TemporalAccessor assumedValue;
    private List<Interval<TemporalAccessor>> constraint = new ArrayList<>();

    public List<Interval<TemporalAccessor>> getConstraints() {
        return constraint;
    }

    @Override
    public void addConstraint(Interval<TemporalAccessor> constraint) {
        this.constraint.add(constraint);
    }
}
