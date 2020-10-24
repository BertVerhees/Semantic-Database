package nl.rosa.semanticdatabase.bmm.statements;

/**
 * 
 * Multi-branch conditional statement structure
 * 
*/
public interface BmmActionTable extends BmmStatement {

/**
 * 
 * Decision branches.
 * 
*/
List<bmmConditionalAction> getItems()
setItems(var List<bmmConditionalAction>)

}
