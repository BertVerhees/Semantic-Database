package nl.rosa.semanticdatabase.bmm.types;

/**
 * 
 * Meta-type of linear container type that indexes the contained items in the manner of a standard Hash table, map or dictionary.
 * 
*/
public class BmmIndexedContainerTypeImpl implements BmmContainerType{

    //***** BmmIndexedContainerType *****

/* * FIELDS * */

/**
 * 
 * Type of the element index, typically String or Integer, but may be a numeric type or indeed any type from which a hash value can be derived.
 * 
*/
    private BmmSimpleType index_type;

        />
    
    //***** BmmContainerType *****

/* * FIELDS * */

/**
 * 
 * The type of the container.
 * This converts to the root_type in BMM_GENERIC_TYPE.
 * 
*/
    private BmmGenericClass container_class;

        />
    
/**
 * 
 * The container item type.
 * 
*/
    private BmmUnitaryType item_type;

        />
    
    //***** BmmType *****

/* * FIELDS * */

/* * ATTRIBUTE * */

/* * POJO * */

/* * FUNCTION * */

}
