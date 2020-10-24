package nl.rosa.semanticdatabase.bmm.statements;

/**
 * 
 * A statement that asserts the truth of its expression.
 * If not, generates an exception (depending on run-time settings).
 * May be rendered in syntax as assert condition or similar.
 * 
*/
public interface BmmAssertion extends BmmStatement {

/**
 * 
 * 
 * 
*/
ElBooleanExpression getExpression()
setExpression(var ElBooleanExpression)

/**
 * 
 * Optional tag, typically used to designate design intention of the assertion, e.g.
 * "Inv_all_members_valid".
 * 
*/
String getTag()
setTag(var String)

}
