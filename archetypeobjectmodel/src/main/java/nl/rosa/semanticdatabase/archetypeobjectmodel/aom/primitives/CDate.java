package nl.rosa.semanticdatabase.archetypeobjectmodel.aom.primitives;

import lombok.Getter;
import lombok.Setter;
import nl.rosa.semanticdatabase.base.Interval;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CDate extends CTemporal<Temporal> {

    private Temporal assumedValue;
    private List<Interval<Temporal>> constraint = new ArrayList<>();

    public List<Interval<Temporal>> getConstraints() {
        return constraint;
    }

    @Override
    public void addConstraint(Interval<Temporal> constraint) {
        this.constraint.add(constraint);
    }
}
