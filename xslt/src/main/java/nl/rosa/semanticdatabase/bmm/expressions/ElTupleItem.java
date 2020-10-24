package nl.rosa.semanticdatabase.bmm.expressions;

/**
 * 
 * A single tuple item, with an optional name.
 * 
*/
public interface ElTupleItem {

/**
 * 
 * Reference to value entity.
 * If Void, this indicates that the item in this position is Void, e.g.
 * within a routine call parameter list.
 * 
*/
ElExpression getItem()
setItem(var ElExpression)

/**
 * 
 * Optional name of tuple item.
 * 
*/
String getName()
setName(var String)

}
