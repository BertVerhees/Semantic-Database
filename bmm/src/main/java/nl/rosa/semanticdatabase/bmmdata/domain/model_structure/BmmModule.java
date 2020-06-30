package nl.rosa.semanticdatabase.bmmdata.domain.model_structure;


import lombok.Getter;
import lombok.NonNull;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Class BmmModule
 */
@DiscriminatorValue("3")
@Entity
public abstract class BmmModule extends BmmDeclaration{
    /**
     * 1..1
     * (redefined)
     * scope: BMM_MODEL
     * Model within which module is defined.
     */
    @Getter
    @NonNull
    private BmmModel scope;

    public BmmModule setScope(BmmModel scope) {
        this.scope = scope;
        return this;
    }
}
