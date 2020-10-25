package nl.rosa.semanticdatabase.bmm.class_features;

/**
 * 
 * Automatically declared variable representing result instance of a Function call.
 * 
*/
public interface BmmResult extends BmmVariable {

/* * ATTRIBUTE * */

/**
 * 
 * Name of this model element.
 * 
*/
String {default = "result"} getName();
void setName(var String {default = "result"});

/* * FUNCTION * */

}
