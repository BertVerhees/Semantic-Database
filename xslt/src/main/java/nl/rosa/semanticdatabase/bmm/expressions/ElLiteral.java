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
     getValue();
    void setValue( value);

/* * FUNCTION * */

/**
 * 
 * Return value.type.
 * 
*/
      eval_type();

}
