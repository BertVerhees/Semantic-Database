package nl.rosa.semanticdatabase.bmmdata.domain.model_structure;


import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Class BmmModule
 */
public abstract class BmmModule extends BmmDeclaration{

    /**
     * 1..1
     * (redefined)
     * scope: BMM_MODEL
     * Model within which module is defined.
     */
    @Setter
    @Getter
    @NonNull
    private BmmModel scope;
}
