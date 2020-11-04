package nl.rosa.semanticdatabase.bmm.class_features;

/**
 * 
 * A typed entity that is a feature within a context, and which may therefore be Void, i.e.
 * 'nullable'.
 * 
*/
public interface BmmTypedFeature extends BmmTyped {

/* * ATTRIBUTE * */

/* * FUNCTION * */

/* * CONSTANTS * */

/**
 * 
 * True if this element can be null (Void) at execution time.
 * May be interpreted as optionality in subtypes..
 * 
*/
    Boolean {default isNullable = false};

}
