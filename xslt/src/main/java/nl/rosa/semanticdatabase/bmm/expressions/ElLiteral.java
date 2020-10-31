package nl.rosa.semanticdatabase.bmm.expressions;

/**
 * 
 * Literal value of any type known in the model, including primitive types.
 * Defined via a BMM_LITERAL_VALUE.
 * 
*/
public interface ElLiteral extends ElInstanceRef {

/* * ATTRIBUTE * */

/**
 * 
 * The reference item from which the value of this node can be computed.
 * 
*/
    ElLiteral getValue();
    void setValue(ElLiteral value);

/* * FUNCTION * */

/**
 * 
 * Return value.type.
 * 
*/
    ElLiteral  eval_type();

}
