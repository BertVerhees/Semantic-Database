package nl.rosa.semanticdatabase.referencemodel.bmm.model_structure;


/**
 * Class BmmModule
 */
public interface BmmModule extends BmmDeclaration{

    BmmModel getScope();

    void setScope(BmmModel scope);
}
