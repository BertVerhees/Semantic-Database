package nl.rosa.semanticdatabase.bmm.types;

/**
 * 
 * Non-entity meta-type that expresses the type structure of any referenceable element of a model.
 * Consists of potential arguments and result, with constraints in descendants determining the exact form.
 * 
*/
public class BmmSignatureImpl implements BmmEffectiveType{

    //***** BmmSignature *****

/* * FIELDS * */

/**
 * 
 * Type of arguments in the signature, if any; represented as a type-tuple (list of arbitrary types).
 * 
*/
    private BmmTupleType argument_types;

        />
    
/**
 * 
 * Result type of signature, if any.
 * 
*/
    private BmmType result_type;

        />
    
    //***** BmmEffectiveType *****

/* * FIELDS * */

    //***** BmmUnitaryType *****

/* * FIELDS * */

    //***** BmmType *****

/* * FIELDS * */

/* * ATTRIBUTE * */

/* * POJO * */

/* * FUNCTION * */

}
