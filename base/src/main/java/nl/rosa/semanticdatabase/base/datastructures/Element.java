package nl.rosa.semanticdatabase.base.datastructures;

import nl.rosa.semanticdatabase.base.archetyped.Archetyped;
import nl.rosa.semanticdatabase.base.archetyped.FeederAudit;
import nl.rosa.semanticdatabase.base.archetyped.Link;
import nl.rosa.semanticdatabase.base.archetyped.Pathable;
import nl.rosa.semanticdatabase.base.datavalues.DataValue;
import nl.rosa.semanticdatabase.base.datavalues.SingleValuedDataValue;
import nl.rosa.semanticdatabase.base.datavalues.text.DvCodedText;
import nl.rosa.semanticdatabase.base.datavalues.text.DvText;
import nl.rosa.semanticdatabase.base.identification.UidBasedId;

import java.util.List;
import java.util.Objects;

/**
 * Originally: Created by pieter.bos on 04/11/15.
 */
public class Element extends Item implements SingleValuedDataValue<DataValue> {

    private DataValue value;

    private DvCodedText nullFlavour;

    private DvText nullReason;

    public Element() {
    }

    public Element(String archetypeNodeId, DvText name, DataValue value) {
        super(archetypeNodeId, name);
        this.value = value;
    }

    public Element(UidBasedId uid, String archetypeNodeId, DvText name, Archetyped archetypeDetails,
                   FeederAudit feederAudit, List<Link> links, Pathable parent, String parentAttributeName,
                   DataValue value, DvCodedText nullFlavour, DvText nullReason) {
        super(uid, archetypeNodeId, name, archetypeDetails, feederAudit, links, parent, parentAttributeName);
        this.value = value;
        this.nullFlavour = nullFlavour;
        this.nullReason = nullReason;
    }

    public DvCodedText getNullFlavour() {
        return nullFlavour;
    }

    public void setNullFlavour(DvCodedText nullFlavour) {
        this.nullFlavour = nullFlavour;
    }

    @Override
    public DataValue getValue() {
        return value;
    }

    @Override
    public void setValue(DataValue value) {
        this.value = value;
    }

    public DvText getNullReason() {
        return nullReason;
    }

    public void setNullReason(DvText nullReason) {
        this.nullReason = nullReason;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Element element = (Element) o;
        return Objects.equals(value, element.value) &&
                Objects.equals(nullFlavour, element.nullFlavour) &&
                Objects.equals(nullReason, element.nullReason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), value, nullFlavour, nullReason);
    }
}
