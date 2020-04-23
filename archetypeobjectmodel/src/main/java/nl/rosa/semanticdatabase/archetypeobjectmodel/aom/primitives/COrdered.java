package nl.rosa.semanticdatabase.archetypeobjectmodel.aom.primitives;

import nl.rosa.semanticdatabase.archetypeobjectmodel.aom.CObject;
import nl.rosa.semanticdatabase.archetypeobjectmodel.aom.CPrimitiveObject;
import nl.rosa.semanticdatabase.referencemodel.model.internal.base.Interval;

import java.util.function.BiFunction;

public abstract class COrdered<T> extends CPrimitiveObject<Interval<T>, T> {

    @Override
    public boolean isValidValue(T value) {
        if(getConstraint().isEmpty()) {
            return true;
        }
        for(Interval<T> constraint:getConstraint()) {
            if(constraint.has(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean cConformsTo(CObject other, BiFunction<String, String, Boolean> rmTypesConformant) {
        if(!super.cConformsTo(other, rmTypesConformant)) {
            return false;
        }
        //now guaranteed to be the same class

        COrdered<?> otherOrdered = (COrdered) other;
        if(otherOrdered.getConstraint().isEmpty()) {
            return true;
        }


        for(Interval<T> constraint:getConstraint()) {
            boolean found = false;
            for(Interval otherConstraint:otherOrdered.getConstraint()) {
                if(otherConstraint.contains(constraint)) {
                    found = true;
                    break;
                }
            }
            if(!found) {
                return false;
            }
        }
        return true;
    }
}
