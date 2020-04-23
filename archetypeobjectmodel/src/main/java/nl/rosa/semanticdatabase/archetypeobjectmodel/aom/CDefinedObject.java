package nl.rosa.semanticdatabase.archetypeobjectmodel.aom;

import lombok.Getter;
import lombok.Setter;

/**
 * Defined Object. Parameterized so the default value methods can be overridden with a different type
 */
@Getter
@Setter
public abstract class CDefinedObject<T> extends CObject {

    private T defaultValue;

    /**
     * True if there is an assumed value.
     *
     * @return
     */
    public Boolean hasDefaultValue() {
        return defaultValue != null;
    }
}
