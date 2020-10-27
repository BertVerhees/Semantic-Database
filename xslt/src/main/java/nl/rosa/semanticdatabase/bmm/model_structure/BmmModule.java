package nl.rosa.semanticdatabase.bmm.model_structure;

/**
 * 
 * Meta-type defining a generalised module concept.
 * Descendants define actual structure and contents.
 * 
*/
public interface BmmModule extends BmmDeclaration {

/* * ATTRIBUTE * */

/**
 * 
 * Model within which module is defined.
 * 
*/
    BmmModel getScope();
    void setScope(value BmmModel);

/* * FUNCTION * */

}
