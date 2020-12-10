package nl.rosa.semanticdatabase.base.datavalues;

import java.util.Objects;

/**
 * Originally: Created by pieter.bos on 04/11/15.
 */
public class DvBoolean extends DataValue implements SingleValuedDataValue<Boolean> {

    private Boolean value;

    @Override
    public Boolean getValue() {
        return value;
    }

    @Override
    public void setValue(Boolean value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DvBoolean dvBoolean = (DvBoolean) o;
        return Objects.equals(value, dvBoolean.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
