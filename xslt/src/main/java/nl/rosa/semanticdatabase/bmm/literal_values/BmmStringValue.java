package nl.rosa.semanticdatabase.bmm.literal_values;

/**
 * 
 * Meta-type for a literal String value, for which type is fixed to the BMM_TYPE representing String and value is of type String.
 * 
*/
public interface BmmStringValue extends BmmPrimitiveValue {

/* * ATTRIBUTE * */

/**
 * 
 * Native String value.
 * 
*/
    BmmStringValue getValue();
    void setValue(value BmmStringValue);

/* * FUNCTION * */

}
