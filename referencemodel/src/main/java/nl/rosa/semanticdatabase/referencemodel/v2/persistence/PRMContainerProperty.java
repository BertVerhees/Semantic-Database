package nl.rosa.semanticdatabase.referencemodel.v2.persistence;

import nl.rosa.semanticdatabase.base.Interval;

public final class PRMContainerProperty extends PRMProperty<PRMContainerType> {

    private Interval<Integer> cardinality;
    
    public Interval<Integer> getCardinality() {
        return cardinality;
    }

    public void setCardinality(Interval<Integer> cardinality) {
        this.cardinality = cardinality;
    }

}
