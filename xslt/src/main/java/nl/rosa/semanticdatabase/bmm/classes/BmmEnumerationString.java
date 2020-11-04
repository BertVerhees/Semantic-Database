package nl.rosa.semanticdatabase.bmm.classes;

/**
 * 
 * String-based enumeration meta-type.
 * 
*/
public interface BmmEnumerationString extends BmmEnumeration {

/* * ATTRIBUTE * */

/**
 * 
 * Optional list of specific values.
 * Must be 1:1 with item_names list.
 * 
*/
    List<BmmStringValue> getItemValues();
    void setItemValues(List<BmmStringValue> value);

/* * FUNCTION * */

/* * CONSTANTS * */

}
