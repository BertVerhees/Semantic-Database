package nl.rosa.semanticdatabase.bmm.class_features;

/**
 * 
 * Meta-type of a property definition within a class definition of an object model.
 * The is_composition attribute indicates whether the property has sub-part or an association semantics with respect to the owning class.
 * 
*/
public class BmmPropertyImpl implements BmmInstantiable,BmmClassFeature{

    //***** BmmProperty *****

/* * FIELDS * */

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
