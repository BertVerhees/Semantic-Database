package nl.rosa.semanticdatabase.bmm.class_features;

/**
 * 
 * Meta-type of for properties of unitary type.
 * 
*/
public interface BmmUnitaryProperty extends BmmProperty {

/* * ATTRIBUTE * */

/**
 * 
 * Declared or inferred static type of the entity.
 * 
*/
    BmmUnitaryProperty getType();
    void setType(value BmmUnitaryProperty);

/* * FUNCTION * */

}
