package nl.rosa.semanticdatabase.archetypeobjectmodel.aom.primitives;

import lombok.Getter;
import lombok.Setter;
import nl.rosa.semanticdatabase.referencemodel.model.internal.base.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: a real is perhaps not a double.
 */
@Getter
@Setter
public class CReal extends COrdered<Double> {

    private Double assumedValue;
    private List<Interval<Double>> constraint = new ArrayList<>();

    public List<Interval<Double>> getConstraints() {
        return constraint;
    }

    @Override
    public void addConstraint(Interval<Double> constraint) {
        this.constraint.add(constraint);
    }
}
