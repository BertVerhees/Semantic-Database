package nl.rosa.semanticdatabase.bmm.literal_values;

/**
 * 
 * Meta-type for literals whose concrete type is a unitary type in the BMM sense.
 * 
*/
public interface BmmUnitaryValue extends BmmLiteralValue {

/* * ATTRIBUTE * */

/**
 * 
 * Declared or inferred static type of the entity.
 * 
*/
BmmUnitaryType getType();
void setType(var BmmUnitaryType);

/* * FUNCTION * */

}
