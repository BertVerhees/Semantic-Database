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
    List<BmmConditionalAction> getItems();
    void setItems(List<BmmConditionalAction> value);

/* * FUNCTION * */

/* * CONSTANTS * */

}
