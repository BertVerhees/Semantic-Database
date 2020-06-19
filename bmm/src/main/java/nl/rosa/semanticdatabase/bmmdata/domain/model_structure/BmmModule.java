package nl.rosa.semanticdatabase.bmmdata.domain.model_structure;


import lombok.NonNull;

import javax.persistence.MappedSuperclass;

/**
 * Class BmmModule
 */
@MappedSuperclass
public abstract class BmmModule extends BmmDeclaration{
    /**
     * 1..1
     * (redefined)
     * scope: BMM_MODEL
     * Model within which module is defined.
     */
    @NonNull
    private BmmModel scope;

}
