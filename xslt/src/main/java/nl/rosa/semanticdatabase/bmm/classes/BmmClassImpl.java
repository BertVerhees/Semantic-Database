package nl.rosa.semanticdatabase.bmm.classes;

/**
 * 
 * Meta-type corresponding a class definition in an object model.
 * Inheritance is specified by the ancestors attribute, which contains a list of types rather than classes.
 * Inheritance is thus understood in BMM as a stated relationship between classes.
 * The equivalent relationship between types is conformance.
 * Note unlike UML, the name is just the root name, even if the class is generic.
 * Use type_name() to obtain the qualified type name.
 * 
*/
public class BmmClassImpl implements BmmModule{

    //***** BmmClass *****

/* * FIELDS * */

/**
 * 
 * List of immediate inheritance parents.
 * 
*/
    private Map<String,BmmModelType> ancestors;

        />
    
/**
 * 
 * Package this class belongs to.
 * 
*/
    private BmmPackage package;

        />
    
/**
 * 
 * List of attributes defined in this class.
 * 
*/
    private Map<String,BmmProperty> properties;

        />
    
/**
 * 
 * Reference to original source schema defining this class.
 * Useful for UI tools to determine which original schema file to open for a given class for manual editing.
 * 
*/
    private String source_schema_id;

        />
    
/**
 * 
 * List of computed references to base classes of immediate inheritance descendants, derived when members of ancestors are attached at creation time.
 * 
*/
    private List<BmmClass> immediate_descendants;

        />
    
/**
 * 
 * True if this definition overrides a class of the same name in an included schema.
 * 
*/
    private Boolean is_override;

        />
    
/**
 * 
 * List of constants defined in this class.
 * 
*/
    private Map<String,BmmConstant> constants;

        />
    
/**
 * 
 * List of functions defined in this class.
 * 
*/
    private Map<String,BmmFunction> functions;

        />
    
/**
 * 
 * List of procedures defined in this class.
 * 
*/
    private Map<String,BmmProcedure> procedures;

        />
    
/**
 * 
 * 
 * 
*/
    private List<BmmAssertion> invariants;

        />
    
/**
 * 
 * Subset of procedures that may be used to initialise a new instance of an object, and whose execution will guarantee that class invariants are satisfied.
 * 
*/
    private Map<String,BmmProcedure> creators;

        />
    
/**
 * 
 * Subset of creators that create a new instance from a single argument of another type.
 * 
*/
    private Map<String,BmmProcedure> converters;

        />
    
/**
 * 
 * List of feature groups in this class.
 * 
*/
    private List<BmmFeatureGroup> feature_groups;

        />
    
    //***** BmmModule *****

/* * FIELDS * */

/**
 * 
 * Model within which module is defined.
 * 
*/
    private BmmModel scope;

        />
    
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
