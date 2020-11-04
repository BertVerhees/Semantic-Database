package nl.rosa.semanticdatabase.bmm.statements;

/**
 * 
 * A statement that asserts the truth of its expression.
 * If not, generates an exception (depending on run-time settings).
 * May be rendered in syntax as assert condition or similar.
 * 
*/
public class BmmAssertionImpl implements BmmStatement{

    //***** BmmAssertion *****

/* * FIELDS * */

/**
 * 
 * 
 * 
*/
    private ElBooleanExpression expression;

        />
    
/**
 * 
 * Optional tag, typically used to designate design intention of the assertion, e.g.
 * "Inv_all_members_valid".
 * 
*/
    private String tag;

        />
    
    //***** BmmStatement *****

/* * FIELDS * */

    //***** BmmStatementItem *****

/* * FIELDS * */

    //***** BmmRoutineBody *****

/* * FIELDS * */

/* * ATTRIBUTE * */

/* * POJO * */

/* * FUNCTION * */

}
