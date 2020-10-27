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
    List<bmmConditionalAction> getItems();
    void setItems(value List<bmmConditionalAction>);

/* * FUNCTION * */

}
