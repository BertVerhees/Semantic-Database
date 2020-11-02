package nl.rosa.semanticdatabase.base_types.identification_package;

/**
 * 
 * Abstract parent of classes representing unique identifiers which identify information entities in a durable way.
 * UIDs only ever identify one IE in time or space and are never re-used.
 * 
*/
public interface Uid {

/* * ATTRIBUTE * */

/**
 * 
 * The value of the id.
 * 
*/
    String getValue();
    void setValue(String value);

/* * FUNCTION * */

}
