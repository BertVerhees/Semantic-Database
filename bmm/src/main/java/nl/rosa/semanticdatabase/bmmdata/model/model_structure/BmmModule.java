package nl.rosa.semanticdatabase.bmmdata.model.model_structure;


/**
 * Class BmmModule
 */
public interface BmmModule extends BmmDeclaration{
    /**
     * 1..1
     * (redefined)
     * scope: BMM_MODEL
     * Model within which module is defined.
     */
    BmmModel getScope();
    void setScope(BmmModel scope);
}
