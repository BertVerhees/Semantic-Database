package nl.rosa.semanticdatabase.bmm.literal_values;

/**
 * 
 * Meta-type for a literal Integer value, for which type is fixed to the BMM_TYPE representing Integer and value is of type Integer.
 * 
*/
public interface BmmIntegerValue extends BmmPrimitiveValue {

/**
 * 
 * Native Integer value.
 * 
*/
Integer getValue()
setValue(var Integer)

}
