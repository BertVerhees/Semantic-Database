package nl.rosa.semanticdatabase.archetypeobjectmodel.aom.primitives;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import nl.rosa.semanticdatabase.base.Interval;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CInteger extends COrdered<Long> {
    private Long assumedValue;
    private List<Interval<Long>> constraint = new ArrayList<>();

    @Override
    public void addConstraint(Interval<Long> constraint) {
        this.constraint.add(constraint);
    }

    @JsonIgnore
    @Transient
    public List<Long> getConstraintValues() {
        List<Long> result = new ArrayList<>();
        for(Interval<Long> singleConstraint:constraint) {
            if(singleConstraint.isLowerUnbounded() || singleConstraint.isUpperUnbounded()) {
                throw new RuntimeException("cannot get the constraint values of an unbounded Integer64 constraint");
            }
            long constraintLower = singleConstraint.getLower();
            if(!singleConstraint.isLowerIncluded()) {
                constraintLower++;
            }
            long constraintUpper = singleConstraint.getUpper();
            if(singleConstraint.isUpperIncluded()) {
                constraintUpper++;
            }
            for(long i = constraintLower; i < constraintUpper; i++) {
                result.add(i);
            }
        }
        return result;
    }
}
