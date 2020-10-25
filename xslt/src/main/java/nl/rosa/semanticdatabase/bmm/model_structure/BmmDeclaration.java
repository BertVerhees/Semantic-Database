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
void setName(var String);

/**
 * 
 * Optional documentation of this element, as a keyed list.
 * It is strongly recommended to use the following key /type combinations for the relevant purposes: "purpose": String "keywords": List<String> "use": String "misuse": String "references": String Other keys and value types may be freely added.
 * 
*/
Hash<string, any> getDocumentation();
void setDocumentation(var Hash<string, any>);

/**
 * 
 * Model element within which an element is declared.
 * 
*/
BmmDeclaration getScope();
void setScope(var BmmDeclaration);

/**
 * 
 * Optional meta-data of this element, as a keyed list.
 * May be used to extend the meta-model.
 * 
*/
Hash<string, any> getExtensions();
void setExtensions(var Hash<string, any>);

/* * FUNCTION * */

/**
 * 
 * True if this declaration entity is the root of the declaration hierarchy.
 * is_root_scope (): Boolean Post_result: Result = (scope = self)
 * 
*/

}
