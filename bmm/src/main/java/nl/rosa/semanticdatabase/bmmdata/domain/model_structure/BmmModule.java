package nl.rosa.semanticdatabase.bmmdata.domain.model_structure;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * Class BmmModule
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
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
