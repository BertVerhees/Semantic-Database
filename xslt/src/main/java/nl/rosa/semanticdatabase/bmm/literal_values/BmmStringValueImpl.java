package nl.rosa.semanticdatabase.bmm.literal_values;

/**
 * 
 * Meta-type for a literal String value, for which type is fixed to the BMM_TYPE representing String and value is of type String.
 * 
*/
public class BmmStringValueImpl implements BmmPrimitiveValue{

    //***** BmmStringValue *****

/* * FIELDS * */

/**
 * 
 * Native String value.
 * 
*/
    private String value;

        />
    
    //***** BmmPrimitiveValue *****

/* * FIELDS * */

/**
 * 
 * Declared or inferred static type of the entity.
 * 
*/
    private BmmSimpleType type;

        />
    
    //***** BmmUnitaryValue *****

/* * FIELDS * */

/**
 * 
 * Declared or inferred static type of the entity.
 * 
*/
    private BmmUnitaryType type;

        />
    
    //***** BmmLiteralValue *****

/* * FIELDS * */

/**
 * 
 * A serial representation of the value.
 * 
*/
    private String value_literal;

        />
    
/**
 * 
 * A native representation of the value, possibly derived by deserialising value_literal.
 * 
*/
    private Any value;

        />
    
/**
 * 
 * Optional specification of formalism of the value_literal attribute for complex values.
 * Value may be any of json | yawl | xml | odin | rdf or another value agreed by the user community.
 * If not set, json is assumed.
 * 
*/
    private String syntax;

        />
    
    //***** BmmTyped *****

/* * FIELDS * */

/**
 * 
 * Declared or inferred static type of the entity.
 * 
*/
    private BmmType type;

        />
    
/* * ATTRIBUTE * */

/* * POJO * */

/* * FUNCTION * */

}
