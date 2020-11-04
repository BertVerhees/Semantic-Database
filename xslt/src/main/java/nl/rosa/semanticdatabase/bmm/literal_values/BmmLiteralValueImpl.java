package nl.rosa.semanticdatabase.bmm.literal_values;

/**
 * 
 * Meta-type for literal instance values declared in a model.
 * Instance values may be inline values of primitive types in the usual fashion or complex objects in syntax form, e.g.
 * JSON.
 * 
*/
public class BmmLiteralValueImpl implements BmmTyped{

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
