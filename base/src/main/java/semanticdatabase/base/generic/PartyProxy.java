package semanticdatabase.base.generic;

import semanticdatabase.base_types.identification_package.PartyRef;

import javax.annotation.Nullable;
import java.util.Objects;

/**
 * Created by pieter.bos on 04/11/15.
 * TODO: move to correct package
 */
public abstract class PartyProxy {

    private PartyRef externalRef;

    public PartyProxy() {
    }

    public PartyProxy(@Nullable PartyRef externalRef) {
        this.externalRef = externalRef;
    }

    public PartyRef getExternalRef() {
        return externalRef;
    }

    public void setExternalRef(PartyRef externalRef) {
        this.externalRef = externalRef;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PartyProxy that = (PartyProxy) o;
        return Objects.equals(externalRef, that.externalRef);
    }

    @Override
    public int hashCode() {
        return Objects.hash(externalRef);
    }
}
