package nl.rosa.semanticdatabase.bmm.literal_values;

/**
 * 
 * Meta-type for literals whose concrete type is an indexed container, i.e.
 * Hash table, Map etc.
 * 
*/
public class BmmIndexedContainerValueImpl implements BmmContainerValue{

    //***** BmmIndexedContainerValue *****

/* * FIELDS * */

/**
 * 
 * Declared or inferred static type of the entity.
 * 
*/
    private BmmIndexedContainerType type;

        />
    
    //***** BmmContainerValue *****

/* * FIELDS * */

/**
 * 
 * Declared or inferred static type of the entity.
 * 
*/
    private BmmContainerType type;

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
