package nl.rosa.semanticdatabase.base.generic;


import semanticdatabase.base.base_types.datavalues.DvIdentifier;
import semanticdatabase.base.foundation_types.identification_package.PartyRef;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Originally: Created by pieter.bos on 01/03/16.
 */
public class PartyIdentified extends PartyProxy {
    @Nullable
    private String name;
    @Nullable
    private List<DvIdentifier> identifiers = new ArrayList<>();

    public PartyIdentified() {
    }

    public PartyIdentified(@Nullable PartyRef externalRef, @Nullable String name, @Nullable List<DvIdentifier> identifiers) {
        super(externalRef);
        this.name = name;
        this.identifiers = identifiers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DvIdentifier> getIdentifiers() {
        return identifiers;
    }

    public void setIdentifiers(List<DvIdentifier> identifiers) {
        this.identifiers = identifiers;
    }

    public void addIdentifier(DvIdentifier identifier) {
        identifiers.add(identifier);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PartyIdentified that = (PartyIdentified) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(identifiers, that.identifiers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, identifiers);
    }
}
