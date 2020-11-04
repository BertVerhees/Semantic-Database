package nl.rosa.semanticdatabase.bmm.model_structure;

/**
 * 
 * Meta-type defining a generalised module concept.
 * Descendants define actual structure and contents.
 * 
*/
public class BmmModuleImpl implements BmmDeclaration{

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
