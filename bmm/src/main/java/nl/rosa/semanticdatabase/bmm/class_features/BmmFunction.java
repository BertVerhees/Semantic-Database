package nl.rosa.semanticdatabase.bmm.class_features;


/**
 * 
 * #Generated: 2020-11-19T08:28:08.518+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * A formal element with signature of the form: name ({arg:TArg}*):TResult.
 * A function is a computed (rather than data) element, generally assumed to be non-state-changing.
 * 
*/
public class BmmFunction extends BmmRoutine implements BmmTypedFeature {

    //***** BmmFunction *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * Optional details enabling a function to be represented as an operator in a syntactic representation.
 * cardinality: 0..1
 * 
*/
    private BmmOperator operatorDefinition;

/**
 * 
 * Automatically created Result variable, usable in body and post-condition.
 * cardinality: 1..1
 * 
*/
    private BmmResult result;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * Optional details enabling a function to be represented as an operator in a syntactic representation.
 * cardinality: 0..1
 * 
*/
    public BmmOperator getOperatorDefinition() {
        return operatorDefinition;
    }
    public BmmFunction setOperatorDefinition(BmmOperator value) {
        this.operatorDefinition = operatorDefinition;
        return this;
    }

/**
 * 
 * Automatically created Result variable, usable in body and post-condition.
 * cardinality: 1..1
 * 
*/
    public BmmResult getResult() {
        return result;
    }
    public BmmFunction setResult(BmmResult value) {
        if ( value == null ) {
            throw new NullPointerException(" Setting property:result failed, it has cardinality NonNull, but is null");
        }
        this.result = result;
        return this;
    }

/*=========================================================*/
/* * CONSTANTS * */
/*=========================================================*/

/**
 * 
 * True if this element can be null (Void) at execution time.
 * May be interpreted as optionality in subtypes..
 * 
*/
    final Boolean {default isNullable = false};

    //***** BmmTyped *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * Declared or inferred static type of the entity.
 * cardinality: 1..1
 * 
*/
    private BmmType type;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * Declared or inferred static type of the entity.
 * cardinality: 1..1
 * 
*/
    public BmmType getType() {
        return type;
    }
    public BmmTyped setType(BmmType value) {
        if ( value == null ) {
            throw new NullPointerException(" Setting property:type failed, it has cardinality NonNull, but is null");
        }
        this.type = type;
        return this;
    }

/*=========================================================*/
/* * FUNCTIONS * */
/*=========================================================*/

/**
 * 
 * True if type is notionally Boolean (i.e.
 * a BMM_SIMPLE_TYPE with type_name() = 'Boolean').
 * cardinality: 1..1
 * 
*/
    public Result = type().equal( {BMM_MODEL}.boolean_type_definition())  isBoolean() {
        Result = type().equal( {BMM_MODEL}.boolean_type_definition())  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

    //***** BmmFunction *****

/*=========================================================*/
/* * BUILD PATTERN AND CONSTRUCTOR * */
/*=========================================================*/

    public BmmFunction build() {
        return new BmmFunction(
            operatorDefinition,
            result,
            type,
            parameters,
            locals,
            preConditions,
            postConditions,
            body,
            visibility,
            featureExtensions,
            group,
            scope,
            name,
            documentation,
            scope,
            extensions
        );
    }

    public BmmFunction(
            BmmOperator operatorDefinition,
            BmmResult result,
            BmmType type,
            List<BmmParameter> parameters,
            List<BmmLocal> locals,
            List<BmmAssertion> preConditions,
            List<BmmAssertion> postConditions,
            BmmRoutineBody body,
            BmmVisibility visibility,
            List<BMM_FEATURE_EXTENSION> featureExtensions,
            BmmFeatureGroup group,
            BmmClass scope,
            String name,
            Map<String, Any> documentation,
            BmmDeclaration scope,
            Map<String, Any> extensions
    ){
        if ( result == null ) {
            throw new NullPointerException("Property:result has cardinality NonNull, but is null");
        }
        if ( type == null ) {
            throw new NullPointerException("Property:type has cardinality NonNull, but is null");
        }
        if ( group == null ) {
            throw new NullPointerException("Property:group has cardinality NonNull, but is null");
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
        this.operatorDefinition = operatorDefinition;
        this.result = result;
        this.type = type;
        this.parameters = parameters;
        this.locals = locals;
        this.preConditions = preConditions;
        this.postConditions = postConditions;
        this.body = body;
        this.visibility = visibility;
        this.featureExtensions = featureExtensions;
        this.group = group;
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
