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
    ElTupleItem getItem();
    void setItem(ElTupleItem value);

/**
 * 
 * Optional name of tuple item.
 * 
*/
    ElTupleItem getName();
    void setName(ElTupleItem value);

/* * FUNCTION * */

}
