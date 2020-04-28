package nl.rosa.semanticdatabase.archetypeobjectmodel.adl14.aom14;

import com.fasterxml.jackson.annotation.JsonIgnore;
import nl.rosa.semanticdatabase.archetypeobjectmodel.aom.primitives.CInteger;
import nl.rosa.semanticdatabase.archetypeobjectmodel.aom.primitives.CTerminologyCode;
import nl.rosa.semanticdatabase.base.terminology.TerminologyCode;
import nl.rosa.semanticdatabase.base.Interval;

import java.util.Arrays;

public class CDVOrdinalItem {

    private Integer value;
    private TerminologyCode symbol;

    public Integer getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public TerminologyCode getSymbol() {
        return symbol;
    }

    public void setSymbol(TerminologyCode symbol) {
        this.symbol = symbol;
    }

    @JsonIgnore
    public CTerminologyCode getSymbolAdl2() {
        if(symbol == null) {
            return null;
        }
        CTerminologyCode result = new CTerminologyCode();
        result.setConstraint(Arrays.asList(symbol.toString()));
        return result;
    }

    @JsonIgnore
    public CInteger getValueAdl2() {
        if(value == null) {
            return null;
        }
        CInteger result = new CInteger();
        result.addConstraint(new Interval(new Long(value), new Long(value)));
        return result;
    }
}
