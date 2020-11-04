package nl.rosa.semanticdatabase.bmm.model_structure;

/**
 * 
 * Meta-type of BMM declared model elements.
 * A declaration is a an element of a model specified by an author within a model definition within a context, which defines the scope of the element.
 * Thus, a class definition and its property and routine definitions are model elements, but Types are not, since they are derived from model elements.
 * 
*/
public interface BmmDeclaration {

/* * ATTRIBUTE * */

/**
 * 
 * Name of this model element.
 * 
*/
    String getName();
    void setName(String value);

/**
 * 
 * Optional documentation of this element, as a keyed list.
 * It is strongly recommended to use the following key /type combinations for the relevant purposes: "purpose": String "keywords": List<String> "use": String "misuse": String "references": String Other keys and value types may be freely added.
 * 
*/
    Map<String, Any> getDocumentation();
    void setDocumentation(Map<String, Any> value);

/**
 * 
 * Model element within which an element is declared.
 * 
*/
    BmmDeclaration getScope();
    void setScope(BmmDeclaration value);

/**
 * 
 * Optional meta-data of this element, as a keyed list.
 * May be used to extend the meta-model.
 * 
*/
    Map<String, Any> getExtensions();
    void setExtensions(Map<String, Any> value);

/* * FUNCTION * */

/**
 * 
 * True if this declaration entity is the root of the declaration hierarchy.
 * 
*/
    Result = (scope = self)  is_root_scope();

/* * CONSTANTS * */

}
