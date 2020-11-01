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
    BmmTupleType getArgumentTypes();
    void setArgumentTypes(BmmTupleType value);

/**
 * 
 * Result type of signature, if any.
 * 
*/
     getResultType();
    void setResultType( value);

/* * FUNCTION * */

/**
 * 
 * Return base_name.
 * 
*/
      type_base_name();

/**
 * 
 * Result = False.
 * 
*/
      is_abstract();

/**
 * 
 * Result = True.
 * 
*/
      is_primitive();

/**
 * 
 * Return base_name
 * 
*/
      type_name();

/**
 * 
 * Return the logical set (i.e.
 * unique items) consisting of argument_types.flattened_type_list() and result_type.flattened_type_list().
 * 
*/
      flattened_type_list();

}
