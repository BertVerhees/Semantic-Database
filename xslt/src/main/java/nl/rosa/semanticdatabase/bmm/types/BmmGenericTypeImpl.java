package nl.rosa.semanticdatabase.bmm.types;

/**
 * 
 * Meta-type based on a non-container generic class, e.g.
 * Packet<Header>.
 * 
*/
public class BmmGenericTypeImpl implements BmmModelType{

    //***** BmmGenericType *****

/* * FIELDS * */

/**
 * 
 * Generic parameters of the root_type in this type specifier.
 * The order must match the order of the owning class’s formal generic parameter declarations, and the types may be defined types or formal parameter types.
 * 
*/
    private List<BmmUnitaryType> generic_parameters;

        />
    
/**
 * 
 * Defining generic class of this type.
 * 
*/
    private BmmGenericClass base_class;

        />
    
    //***** BmmModelType *****

/* * FIELDS * */

/**
 * 
 * 
 * 
*/
    private BmmValueSetSpec value_constraint;

        />
    
/**
 * 
 * Base class of this type.
 * 
*/
    private BmmClass base_class;

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
