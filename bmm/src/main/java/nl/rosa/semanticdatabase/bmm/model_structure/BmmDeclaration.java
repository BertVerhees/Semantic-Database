package nl.rosa.semanticdatabase.bmm.model_structure;


/**
 * 
 * #Generated: 2020-11-15T18:16:51.043+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Meta-type of BMM declared model elements.
 * A declaration is a an element of a model specified by an author within a model definition within a context, which defines the scope of the element.
 * Thus, a class definition and its property and routine definitions are model elements, but Types are not, since they are derived from model elements.
 * 
*/
public abstract class BmmDeclaration {

    //***** BmmDeclaration *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * Name of this model element.
 * cardinality: 1..1
 * 
*/
    private String name;

/**
 * 
 * Optional documentation of this element, as a keyed list.
 * It is strongly recommended to use the following key /type combinations for the relevant purposes: "purpose": String "keywords": List<String> "use": String "misuse": String "references": String Other keys and value types may be freely added.
 * cardinality: 0..1
 * 
*/
    private Map<String, Any> documentation;

/**
 * 
 * Model element within which an element is declared.
 * cardinality: 1..1
 * 
*/
    private BmmDeclaration scope;

/**
 * 
 * Optional meta-data of this element, as a keyed list.
 * May be used to extend the meta-model.
 * cardinality: 0..1
 * 
*/
    private Map<String, Any> extensions;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * Name of this model element.
 * cardinality: 1..1
 * 
*/
    public String getName() {
        return name;
    }
    public void setName(String value) {
        if (name == null ) {
            throw new NullPointerException(" name has cardinality NonNull, but is null")
        }
        this.name = name;
    }

/**
 * 
 * Optional documentation of this element, as a keyed list.
 * It is strongly recommended to use the following key /type combinations for the relevant purposes: "purpose": String "keywords": List<String> "use": String "misuse": String "references": String Other keys and value types may be freely added.
 * cardinality: 0..1
 * 
*/

    public void putDocumentation(String key, Object value ) {
        if (documentation == null ) {
            documentation = new HashMap<> ();
        }
        documentation.put( key, value);
    }

    public void putDocumentation(Map<String, Any> items ) {
        items.keySet().forEach(key -> putDocumentatio(key, items.get(key)));
    }

    public Object getDocumentation(String key ) {
        if (documentation == null ) {
            return null;
        }
        return documentation.get( key);
    }

    public void removeDocumentation(String key ) {
        if (documentation != null ) {
            documentation.remove(key);
        }
    }
    public void removeDocumentation( Collection <String> keys ) {
        keys.forEach(this::removeDocumentation);
    }
    Map<String, Any> getDocumentation() {
        return this.documentation;
    }
    void setDocumentation(Map<String, Any> documentation) {
        this.documentation = documentation;
    }
    public Map<String, Any> documentation() {
        return Collections.unmodifiableMap(this.documentation);
    }

/**
 * 
 * Model element within which an element is declared.
 * cardinality: 1..1
 * 
*/
    public BmmDeclaration getScope() {
        return scope;
    }
    public void setScope(BmmDeclaration value) {
        if (scope == null ) {
            throw new NullPointerException(" scope has cardinality NonNull, but is null")
        }
        this.scope = scope;
    }

/**
 * 
 * Optional meta-data of this element, as a keyed list.
 * May be used to extend the meta-model.
 * cardinality: 0..1
 * 
*/

    public void putExtension(String key, Object value ) {
        if (extensions == null ) {
            extensions = new HashMap<> ();
        }
        extensions.put( key, value);
    }

    public void putExtensions(Map<String, Any> items ) {
        items.keySet().forEach(key -> putExtension(key, items.get(key)));
    }

    public Object getExtension(String key ) {
        if (extensions == null ) {
            return null;
        }
        return extensions.get( key);
    }

    public void removeExtension(String key ) {
        if (extensions != null ) {
            extensions.remove(key);
        }
    }
    public void removeExtensions( Collection <String> keys ) {
        keys.forEach(this::removeExtension);
    }
    Map<String, Any> getExtensions() {
        return this.extensions;
    }
    void setExtensions(Map<String, Any> extensions) {
        this.extensions = extensions;
    }
    public Map<String, Any> extensions() {
        return Collections.unmodifiableMap(this.extensions);
    }

/*=========================================================*/
/* * FUNCTIONS * */
/*=========================================================*/

/**
 * 
 * True if this declaration entity is the root of the declaration hierarchy.
 * cardinality: 1..1
 * 
*/
    public abstract Result = (scope = self)  isRootScope();

}

/**
 * 
 * ***** BEGIN LICENSE BLOCK ***** Version: MPL 1.1/GPL 2.0/LGPL 2.1
 * 
 * The contents of this file are subject to the Mozilla Public License Version
 * 1.1 (the "License"); you may not use this file except in compliance with the
 * License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * 
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied.
 * See the License for
 * the specific language governing rights and limitations under the License.
 * 
 * The Initial Developer of the Original Code is Bert Verhees.
 * the Initial Developer Copyright (C) 2020 the Initial Developer.
 * All Rights Reserved.
 * 
 * Contributor(s): Bert Verhees
 * 
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied.
 * See the License for
 * the specific language governing rights and limitations under the License.
 * 
 * ***** END LICENSE BLOCK *****
 * 
*/
