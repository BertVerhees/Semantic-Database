package nl.rosa.semanticdatabase.bmm.expressions;

/**
 * 
 * A single tuple item, with an optional name.
 * 
*/
public interface ElTupleItem {

/* * ATTRIBUTE * */

/**
 * 
 * Reference to value entity.
 * If Void, this indicates that the item in this position is Void, e.g.
 * within a routine call parameter list.
 * 
*/
    ElExpression getItem();
    void setItem(value ElExpression);

/**
 * 
 * Optional name of tuple item.
 * 
*/
    String getName();
    void setName(value String);

/* * FUNCTION * */

}
