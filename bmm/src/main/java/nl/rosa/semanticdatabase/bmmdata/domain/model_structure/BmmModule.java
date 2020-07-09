package nl.rosa.semanticdatabase.bmmdata.domain.model_structure;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Class BmmModule
 */
@EqualsAndHashCode(callSuper = true)
@Getter
public abstract class BmmModule extends BmmDeclaration{
    /**
     * 1..1
     * (redefined)
     * scope: BMM_MODEL
     * Model within which module is defined.
     */
    @NonNull
    private BmmModel scope;

    public BmmModule setScope(BmmModel scope) {
        this.scope = scope;
        return this;
    }
}
