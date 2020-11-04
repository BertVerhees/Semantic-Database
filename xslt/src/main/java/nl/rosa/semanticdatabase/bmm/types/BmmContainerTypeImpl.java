package nl.rosa.semanticdatabase.bmm.types;

/**
 * 
 * Meta-type that specifies linear containers with a generic parameter corresponding to the type of contained item, and whose container type is a generic type such as List<T>, Set<T> etc.
 * 
*/
public class BmmContainerTypeImpl implements BmmType{

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
