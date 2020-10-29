package nl.rosa.semanticdatabase.bmm.statements;

/**
 * 
 * Multi-branch conditional statement structure
 * 
*/
public interface BmmActionTable extends BmmStatement {

/* * ATTRIBUTE * */

/**
 * 
 * Decision branches.
 * 
*/
    BmmActionTable getItems();
    void setItems(value BmmActionTable);

/* * FUNCTION * */

}
