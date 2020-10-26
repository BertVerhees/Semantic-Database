package nl.rosa.semanticdatabase.bmm.types;

/**
 * 
 * Non-entity meta-type that expresses the type structure of any referenceable element of a model.
 * Consists of potential arguments and result, with constraints in descendants determining the exact form.
 * 
*/
public interface BmmSignature extends BmmEffectiveType {

/* * ATTRIBUTE * */

/**
 * 
 * Base name (built-in).
 * 
*/
String = "signature" getBaseName();
void setBaseName(value String = "signature");

/**
 * 
 * Type of arguments in the signature, if any; represented as a type-tuple (list of arbitrary types).
 * 
*/
BmmTupleType getArgumentTypes();
void setArgumentTypes(value BmmTupleType);

/**
 * 
 * Result type of signature, if any.
 * 
*/
BmmType getResultType();
void setResultType(value BmmType);

/* * FUNCTION * */

/**
 * 
 * Return base_name.
 * type_base_name (): String Post_result: Result.is_equal (base_name())
 * 
*/
String postResult: result.isEqual (baseName()) typeBaseName ();

/**
 * 
 * Result = False.
 * is_abstract (): Boolean
 * 
*/
Boolean isAbstract ();

/**
 * 
 * Result = True.
 * is_primitive (): Boolean
 * 
*/
Boolean isPrimitive ();

/**
 * 
 * Return base_name
 * type_name (): String Post_result: Result.is_equal (base_name())
 * 
*/
String postResult: result.isEqual (baseName()) typeName ();

/**
 * 
 * Return the logical set (i.e.
 * unique items) consisting of argument_types.flattened_type_list() and result_type.flattened_type_list().
 * flattened_type_list (): List<String>
 * 
*/
List<string> flattenedTypeList ();

}
