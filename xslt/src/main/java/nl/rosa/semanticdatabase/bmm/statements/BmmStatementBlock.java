package nl.rosa.semanticdatabase.bmm.statements;

/**
 * 
 * A statement 'block' corresponding to the programming language concept of the same name.
 * May be used to establish scope in specific languages.
 * 
*/
public interface BmmStatementBlock extends BmmStatementItem {

/* * ATTRIBUTE * */

/**
 * 
 * Child blocks of the current block.
 * 
*/
    List<bmmStatementItem> getItems();
    void setItems(value List<bmmStatementItem>);

/* * FUNCTION * */

}
