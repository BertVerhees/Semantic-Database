package nl.rosa.semanticdatabase.bmm.model_structure;

/**
 * 
 * Definition of the root of a BMM model (along with what is inherited from BMM_SCHEMA_CORE).
 * 
*/
public class BmmModelImpl implements BmmPackageContainer,BmmModelMetadata{

    //***** BmmModel *****

/* * FIELDS * */

/**
 * 
 * All classes in this model, keyed by type name.
 * 
*/
    private Map<String,BmmClass> class_definitions;

        />
    
/**
 * 
 * List of other models 'used' (i.e.
 * 'imported' by this model).
 * Classes in the current model may refer to classes in a used model by specifying the other class’s scope meta-attribute.
 * 
*/
    private List<BmmModel> used_models;

        />
    
    //***** BmmPackageContainer *****

/* * FIELDS * */

/**
 * 
 * Child packages; keys all in upper case for guaranteed matching.
 * 
*/
    private Map<String,BmmPackage> packages;

        />
    
/**
 * 
 * Model element within which a referenceable element is known.
 * 
*/
    private BmmPackageContainer scope;

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
    
    //***** BmmModelMetadata *****

/* * FIELDS * */

/**
 * 
 * Publisher of model expressed in the schema.
 * 
*/
    private String rm_publisher;

        />
    
/**
 * 
 * Release of model expressed in the schema as a 3-part numeric, e.g.
 * "3.1.0" .
 * 
*/
    private String rm_release;

        />
    
/* * ATTRIBUTE * */

/* * POJO * */

/* * FUNCTION * */

}
