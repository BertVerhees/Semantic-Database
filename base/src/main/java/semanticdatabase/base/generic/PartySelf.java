package semanticdatabase.base.generic;

import semanticdatabase.base_types.identification_package.PartyRef;

/**
 * Created by pieter.bos on 01/03/16.
 */
public class PartySelf extends PartyProxy {

    public PartySelf() {
    }

    public PartySelf(PartyRef externalRef) {
        super(externalRef);
    }
}
