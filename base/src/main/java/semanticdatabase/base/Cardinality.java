package semanticdatabase.base;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Cardinality extends SemanticDatabaseBase {

    private MultiplicityInterval interval;

    private boolean isOrdered = true;
    private boolean isUnique = false;

    public Cardinality() {

    }

    public Cardinality(int lower, int higher) {
        isOrdered = true;//default: list semantics
        isUnique = false;
        interval = new MultiplicityInterval(lower, higher);
    }

    public MultiplicityInterval getInterval() {
        return interval;
    }

    public void setInterval(MultiplicityInterval interval) {
        this.interval = interval;
    }

    public boolean isOrdered() {
        return isOrdered;
    }

    public void setOrdered(boolean ordered) {
        this.isOrdered = ordered;
    }

    public boolean isUnique() {
        return isUnique;
    }

    public void setUnique(boolean unique) {
        this.isUnique = unique;
    }

    public static Cardinality unbounded() {
        Cardinality result = new Cardinality();
        result.setInterval(MultiplicityInterval.unbounded());
        return result;
    }

    public static Cardinality mandatoryAndUnbounded() {
        Cardinality result = new Cardinality();
        result.setInterval(new MultiplicityInterval(1, true, false, null, true, true));
        return result;
    }

    /**
     * True if the semantics of this cardinality represent a bag, i.e. unordered, non-unique membership.
     *
     * @return true if this is a bag
     */
    @JsonIgnore
    public Boolean isBag() {
        return !isOrdered && !isUnique;
    }

    /**
     * True if the semantics of this cardinality represent a list, i.e. ordered, non-unique membership.
     *
     * @return true if this is a list
     */
    @JsonIgnore
    public Boolean isList() {
        return isOrdered && !isUnique;
    }

    /**
     * True if the semantics of this cardinality represent a set, i.e. unordered, unique membership.
     *
     * @return true if this is a set
     */
    @JsonIgnore
    public Boolean isSet() {
        return !isOrdered && isUnique;
    }


    /**
     * Checks whether the cardinality interval of 'other' is subsumed by the interval for this cardinality
     *
     * @param other the other cardinality
     * @return true if this cardinality contains the other
     */
    public Boolean contains(Cardinality other) {
        return getInterval().contains(other.getInterval());
    }


}
