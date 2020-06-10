package nl.rosa.semanticdatabase.bmmdata.model.types;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

/**
 * Class BmmEffectiveType
 * Meta-type for a A concrete, unitary type that can be used as an actual parameter
 * type in a generic type declaration.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class BmmEffectiveType extends BmmUnitaryType {
    // Functions
    /**
     * 1..1
     * (effected)
     * effective_type (): BMM_EFFECTIVE_TYPE
     * Result = self.
     */
    @Override
    public @NonNull BmmEffectiveType effectiveType() {
        return null;
    }

    /**
     * 1..1
     * (abstract)
     * type_base_name (): String
     * Name of base generator type, i.e. excluding any generic parts if present.
     * @return
     */
    public abstract String typeBaseName();
}
