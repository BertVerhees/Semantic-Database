package nl.rosa.semanticdatabase.bmmdata.model.model_structure;


/**
 * Class BmmModule
 */
public interface BmmModule extends BmmDeclaration{

    BmmModel getScope();

    void setScope(BmmModel scope);
}
