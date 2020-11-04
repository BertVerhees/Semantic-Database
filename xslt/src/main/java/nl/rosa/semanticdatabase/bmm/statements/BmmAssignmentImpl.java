package nl.rosa.semanticdatabase.bmm.statements;

/**
 * 
 * Statement type representing an assignment from a value-generating source to a writable entity, i.e.
 * a variable reference or property.
 * 
*/
public class BmmAssignmentImpl implements BmmStatement{

    //***** BmmAssignment *****

/* * FIELDS * */

/**
 * 
 * The target variable on the notional left-hand side of this assignment.
 * 
*/
    private EL_INSTANTIABLE_REF target;

        />
    
/**
 * 
 * Source right hand side) of the assignment.
 * 
*/
    private ElExpression source;

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
