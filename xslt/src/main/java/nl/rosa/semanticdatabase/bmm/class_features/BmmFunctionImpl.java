package nl.rosa.semanticdatabase.bmm.class_features;

/**
 * 
 * A formal element with signature of the form: name ({arg:TArg}*):TResult.
 * A function is a computed (rather than data) element, generally assumed to be non-state-changing.
 * 
*/
public class BmmFunctionImpl implements BmmTypedFeature,BmmRoutine{

    //***** BmmFunction *****

/* * FIELDS * */

/**
 * 
 * Optional details enabling a function to be represented as an operator in a syntactic representation.
 * 
*/
    private BmmOperator operator_definition;

        />
    
/**
 * 
 * Automatically created Result variable, usable in body and post-condition.
 * 
*/
    private BmmResult result;

        />
    
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
    
    //***** BmmRoutine *****

/* * FIELDS * */

/**
 * 
 * Formal parameters of the routine.
 * 
*/
    private List<BmmParameter> parameters;

        />
    
/**
 * 
 * Local variables of the routine.
 * 
*/
    private List<BmmLocal> locals;

        />
    
/**
 * 
 * 
 * 
*/
    private List<BmmAssertion> pre_conditions;

        />
    
/**
 * 
 * 
 * 
*/
    private List<BmmAssertion> post_conditions;

        />
    
/**
 * 
 * Body of a routine, i.e.
 * executable program.
 * 
*/
    private BmmRoutineBody body;

        />
    
    //***** BmmClassFeature *****

/* * FIELDS * */

/**
 * 
 * Visibility of this item to client entities.
 * 
*/
    private BmmVisibility visibility;

        />
    
/**
 * 
 * Extensions to feature-level meta-types.
 * 
*/
    private List<BMM_FEATURE_EXTENSION> feature_extensions;

        />
    
/**
 * 
 * Group containing this feature.
 * 
*/
    private BmmFeatureGroup group;

        />
    
/**
 * 
 * Class within which a referenceable element is known.
 * 
*/
    private BmmClass scope;

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
