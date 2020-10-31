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
 * Type of arguments in the signature, if any; represented as a type-tuple (list of arbitrary types).
 * 
*/
    BmmSignature getArgumentTypes();
    void setArgumentTypes(BmmSignature value);

/**
 * 
 * Result type of signature, if any.
 * 
*/
    BmmSignature getResultType();
    void setResultType(BmmSignature value);

/* * FUNCTION * */

/**
 * 
 * Return base_name.
 * 
*/
    BmmSignature  type_base_name();

/**
 * 
 * Result = False.
 * 
*/
    BmmSignature  is_abstract();

/**
 * 
 * Result = True.
 * 
*/
    BmmSignature  is_primitive();

/**
 * 
 * Return base_name
 * 
*/
    BmmSignature  type_name();

/**
 * 
 * Return the logical set (i.e.
 * unique items) consisting of argument_types.flattened_type_list() and result_type.flattened_type_list().
 * 
*/
    BmmSignature  flattened_type_list();

}
