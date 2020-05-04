package nl.rosa.semanticdatabase.referencemodel.core;

import lombok.Getter;
import lombok.Setter;

/**
 * Default created on 2-5-2020
 */

@Getter
@Setter
public class RMSimpleRMTypeTypeElement extends RMTypeTypeElement {

    private RMClass baseClass;

    /**
     * Return base_class.type_name.
     *
     * @return the type name
     */
    @Override
    public String getTypeName() {
        return this.baseClass.getTypeName();
    }
}
