package nl.rosa.semanticdatabase.bmm.model_structure;

import nl.rosa.semanticdatabase.foundation_types.primitive_types.String;

/**
 * 
 * #Generated: 2020-11-19T08:28:08.518+01:00
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
    public BmmDeclaration setName(String value) {
        if ( value == null ) {
            throw new NullPointerException(" Setting property:name failed, it has cardinality NonNull, but is null");
        }
        this.name = name;
        return this;
    }

/**
 * 
 * Optional documentation of this element, as a keyed list.
 * It is strongly recommended to use the following key /type combinations for the relevant purposes: "purpose": String "keywords": List<String> "use": String "misuse": String "references": String Other keys and value types may be freely added.
 * cardinality: 0..1
 * 
*/

    public void putDocumentation(String key, Any value ) {
        if (documentation == null ) {
            documentation = new HashMap<> ();
        }
        documentation.put( key, value);
    }

    public void putDocumentation(Map<String, Any> items ) {
        items.keySet().forEach(key -> putDocumentatio(key, items.get(key)));
    }

    public Any getDocumentation(String key ) {
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
    public Map<String, Any> getDocumentation() {
        return this.documentation;
    }
    public BmmDeclaration setDocumentation(Map<String, Any> documentation) {
        this.documentation = documentation;
        return this;
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
    public BmmDeclaration setScope(BmmDeclaration value) {
        if ( value == null ) {
            throw new NullPointerException(" Setting property:scope failed, it has cardinality NonNull, but is null");
        }
        this.scope = scope;
        return this;
    }

/**
 * 
 * Optional meta-data of this element, as a keyed list.
 * May be used to extend the meta-model.
 * cardinality: 0..1
 * 
*/

    public void putExtension(String key, Any value ) {
        if (extensions == null ) {
            extensions = new HashMap<> ();
        }
        extensions.put( key, value);
    }

    public void putExtensions(Map<String, Any> items ) {
        items.keySet().forEach(key -> putExtension(key, items.get(key)));
    }

    public Any getExtension(String key ) {
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
    public Map<String, Any> getExtensions() {
        return this.extensions;
    }
    public BmmDeclaration setExtensions(Map<String, Any> extensions) {
        this.extensions = extensions;
        return this;
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
    public Result = (scope = self)  isRootScope() {
        Result = (scope = self)  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

}

/**
 * 
 * ***** BEGIN LICENSE BLOCK *****
 * 
 * ISC License
 * 
 * Copyright (c) 2020, Bert Verhees
 * 
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS.
 * IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 * 
 * ***** END LICENSE BLOCK *****
 * 
*/
