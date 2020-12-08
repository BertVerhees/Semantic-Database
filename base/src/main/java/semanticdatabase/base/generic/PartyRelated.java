package semanticdatabase.base.generic;

import semanticdatabase.base_types.datavalues.DvCodedText;
import semanticdatabase.base_types.datavalues.DvIdentifier;
import semanticdatabase.base_types.identification_package.PartyRef;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Objects;

/**
 * Created by pieter.bos on 08/07/16.
 */
public class PartyRelated extends PartyIdentified {
    private DvCodedText relationship;

    public PartyRelated() {
    }

    public PartyRelated(@Nullable PartyRef externalRef, @Nullable String name, @Nullable List<DvIdentifier> identifiers, DvCodedText relationship) {
        super(externalRef, name, identifiers);
        this.relationship = relationship;
    }

    public DvCodedText getRelationship() {
        return relationship;
    }

    public void setRelationship(DvCodedText relationship) {
        this.relationship = relationship;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PartyRelated that = (PartyRelated) o;
        return Objects.equals(relationship, that.relationship);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), relationship);
    }
}
