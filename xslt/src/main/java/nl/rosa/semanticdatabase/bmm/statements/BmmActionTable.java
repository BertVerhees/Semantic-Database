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
     getItems();
    void setItems( value);

/* * FUNCTION * */

}
