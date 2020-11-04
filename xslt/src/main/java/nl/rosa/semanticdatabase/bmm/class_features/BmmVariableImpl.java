package nl.rosa.semanticdatabase.bmm.class_features;

/**
 * 
 * A mutable entity whose scope is a routine.
 * 
*/
public class BmmVariableImpl implements BmmInstantiable,BmmClassEntity{

    //***** BmmVariable *****

/* * FIELDS * */

/**
 * 
 * Routine within which variable is defined.
 * 
*/
    private BmmRoutine scope;

        />
    
    //***** BmmInstantiable *****

/* * FIELDS * */

    //***** BmmTypedFeature *****

/* * FIELDS * */

    //***** BmmTyped *****

/* * FIELDS * */

/**
 * 
 * Declared or inferred static type of the entity.
 * 
*/
    private BmmType type;

        />
    
    //***** BmmClassEntity *****

/* * FIELDS * */

    //***** BmmDeclaration *****

/* * FIELDS * */

/**
 * 
 * Name of this model element.
 * 
*/
    private String name;

        />
    
/**
 * 
 * Optional documentation of this element, as a keyed list.
 * It is strongly recommended to use the following key /type combinations for the relevant purposes: "purpose": String "keywords": List<String> "use": String "misuse": String "references": String Other keys and value types may be freely added.
 * 
*/
    private Map<String, Any> documentation;

        />
    
/**
 * 
 * Model element within which an element is declared.
 * 
*/
    private BmmDeclaration scope;

        />
    
/**
 * 
 * Optional meta-data of this element, as a keyed list.
 * May be used to extend the meta-model.
 * 
*/
    private Map<String, Any> extensions;

        />
    
/* * ATTRIBUTE * */

/* * POJO * */

/* * FUNCTION * */

}
