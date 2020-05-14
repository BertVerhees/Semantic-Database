package nl.rosa.semanticdatabase.archetypeobjectmodel.aom.primitives;

/**
 * TODO: cConformsTo for temporal and date nl.rosa.semanticdatabase.bmm.types
 */
public abstract class CTemporal<T> extends COrdered<T>{

    private String patternedConstraint;

    public String getPatternedConstraint() {
        return patternedConstraint;
    }

    public void setPatternedConstraint(String patternedConstraint) {
        this.patternedConstraint = patternedConstraint;
    }

    public boolean isValidValue(T value) {
        if(getConstraint().isEmpty() && patternedConstraint == null) {
            return true;
        }
        if(patternedConstraint == null) {
            return super.isValidValue(value);
        } else {
            //TODO: find a library that validates ISO 8601 patterns
            return true;
        }
    }
}
