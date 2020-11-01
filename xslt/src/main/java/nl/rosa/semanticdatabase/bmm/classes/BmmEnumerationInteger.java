package nl.rosa.semanticdatabase.bmm.classes;

/**
 * 
 * Integer-based enumeration meta-type.
 * 
*/
public interface BmmEnumerationInteger extends BmmEnumeration {

/* * ATTRIBUTE * */

/**
 * 
 * Optional list of specific values.
 * Must be 1:1 with item_names list.
 * 
*/
     getItemValues();
    void setItemValues( value);

/* * FUNCTION * */

}
