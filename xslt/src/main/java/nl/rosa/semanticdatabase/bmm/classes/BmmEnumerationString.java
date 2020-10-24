package nl.rosa.semanticdatabase.bmm.classes;

/**
 * 
 * String-based enumeration meta-type.
 * 
*/
public interface BmmEnumerationString extends BmmEnumeration {

/**
 * 
 * Optional list of specific values.
 * Must be 1:1 with item_names list.
 * 
*/
List<bmmStringValue> getItemValues()
setItemValues(var List<bmmStringValue>)

}
