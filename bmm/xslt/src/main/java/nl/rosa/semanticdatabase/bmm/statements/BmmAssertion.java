package nl.rosa.semanticdatabase.bmm.statements;

/**
 * 
 * A statement that asserts the truth of its expression.
 * If not, generates an exception (depending on run-time settings).
 * May be rendered in syntax as assert condition or similar.
 * 
*/
public interface BmmAssertion extends BmmStatement {
}
