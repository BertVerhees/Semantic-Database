package nl.rosa.semanticdatabase.bmm.classes;

import nl.rosa.semanticdatabase.foundation_types.primitive_types.String;
import nl.rosa.semanticdatabase.bmm.types.BmmParameterType;
import nl.rosa.semanticdatabase.bmm.types.BmmGenericType;

/**
 * 
 * #Generated: 2020-11-19T08:28:08.518+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Definition of a generic class in an object model.
 * 
*/
public class BmmGenericClass extends BmmClass {

    //***** BmmGenericClass *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * List of formal generic parameters, keyed by name.
 * These are defined either directly on this class or by the inclusion of an ancestor class which is generic.
 * cardinality: 1..1
 * 
*/
    private Map<String,BmmParameterType> genericParameters = new HashMap<> ();

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * List of formal generic parameters, keyed by name.
 * These are defined either directly on this class or by the inclusion of an ancestor class which is generic.
 * cardinality: 1..1
 * 
*/

    public void putGenericParameter(String key, BmmParameterType value ) {
        genericParameters.put( key, value);
    }

    public void putGenericParameters(Map<String,BmmParameterType> items ) {
        items.keySet().forEach(key -> putGenericparameter(key, items.get(key)));
    }

    public BmmParameterType getGenericParameter(String key ) {
        return genericParameters.get( key);
    }

    public void removeGenericParameter(String key ) {
        if (genericParameters != null ) {
            genericParameters.remove(key);
        }
    }
    public void removeGenericParameters( Collection <String> keys ) {
        keys.forEach(this::removeGenericParameter);
    }
    public Map<String, BmmParameterType> getGenericParameters() {
        return this.genericParameters;
    }
    public BmmGenericClass setGenericParameters(Map<String, BmmParameterType> genericParameters) {
        if (genericParameters == null ) {
            throw new NullPointerException(" genericParameters has cardinality NonNull, but is null");
        }
        this.genericParameters = genericParameters;
        return this;
    }
    public Map<String, BmmParameterType> genericParameters() {
        return Collections.unmodifiableMap(this.genericParameters);
    }

/*=========================================================*/
/* * FUNCTIONS * */
/*=========================================================*/

/**
 * 
 * Add suppliers from generic parameters.
 * cardinality: 0..1 (redefined)
 * 
*/
    public List<String>  suppliers() {
        List<String>  result;


        return  result;
    }

/**
 * 
 * Generate a fully open BMM_GENERIC_TYPE instance that corresponds to this class definition
 * cardinality: 1..1 (effected)
 * 
*/
    public BmmGenericType  type() {
        BmmGenericType  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * For a generic class, type to which generic parameter a_name conforms e.g.
 * if this class is Interval <T:Comparable> then the Result will be the single type Comparable.
 * For an unconstrained type T, the Result will be Any.
 * cardinality: 1..1
 * 
*/
    public String  genericParameterConformanceType(String a_name) {
        if (a_name == null ) {
            throw new NullPointerException("Parameter a_name has cardinality NonNull, but is null.");
        }
        String  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

    //***** BmmGenericClass *****

/*=========================================================*/
/* * BUILD PATTERN AND CONSTRUCTOR * */
/*=========================================================*/

    public BmmGenericClass build() {
        return new BmmGenericClass(
            genericParameters,
            ancestors,
            package,
            properties,
            sourceSchemaId,
            immediateDescendants,
            isOverride,
            constants,
            functions,
            procedures,
            invariants,
            creators,
            converters,
            featureGroups,
            scope,
            name,
            documentation,
            scope,
            extensions
        );
    }

    public BmmGenericClass(
            Map<String,BmmParameterType> genericParameters,
            Map<String,BmmModelType> ancestors,
            BmmPackage package,
            Map<String,BmmProperty> properties,
            String sourceSchemaId,
            List<BmmClass> immediateDescendants,
            Boolean isOverride,
            Map<String,BmmConstant> constants,
            Map<String,BmmFunction> functions,
            Map<String,BmmProcedure> procedures,
            List<BmmAssertion> invariants,
            Map<String,BmmProcedure> creators,
            Map<String,BmmProcedure> converters,
            List<BmmFeatureGroup> featureGroups,
            BmmModel scope,
            String name,
            Map<String, Any> documentation,
            BmmDeclaration scope,
            Map<String, Any> extensions
    ){
        if ( genericParameters == null ) {
            throw new NullPointerException("Property:genericParameters has cardinality NonNull, but is null");
        }
        if ( package == null ) {
            throw new NullPointerException("Property:package has cardinality NonNull, but is null");
        }
        if ( sourceSchemaId == null ) {
            throw new NullPointerException("Property:sourceSchemaId has cardinality NonNull, but is null");
        }
        if ( isOverride == null ) {
            throw new NullPointerException("Property:isOverride has cardinality NonNull, but is null");
        }
        if ( scope == null ) {
            throw new NullPointerException("Property:scope has cardinality NonNull, but is null");
        }
        if ( name == null ) {
            throw new NullPointerException("Property:name has cardinality NonNull, but is null");
        }
        if ( scope == null ) {
            throw new NullPointerException("Property:scope has cardinality NonNull, but is null");
        }
        this.genericParameters = genericParameters;
        this.ancestors = ancestors;
        this.package = package;
        this.properties = properties;
        this.sourceSchemaId = sourceSchemaId;
        this.immediateDescendants = immediateDescendants;
        this.isOverride = isOverride;
        this.constants = constants;
        this.functions = functions;
        this.procedures = procedures;
        this.invariants = invariants;
        this.creators = creators;
        this.converters = converters;
        this.featureGroups = featureGroups;
        this.scope = scope;
        this.name = name;
        this.documentation = documentation;
        this.scope = scope;
        this.extensions = extensions;
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
