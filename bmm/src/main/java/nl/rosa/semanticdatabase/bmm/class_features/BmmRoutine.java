package nl.rosa.semanticdatabase.bmm.class_features;

import nl.rosa.semanticdatabase.bmm.statements.BmmAssertion;
import nl.rosa.semanticdatabase.foundation_types.primitive_types.Integer;

/**
 * 
 * #Generated: 2020-11-24T17:04:33.085+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * A feature defining a routine, scoped to a class.
 * 
*/
public abstract class BmmRoutine extends BmmClassFeature {

    //***** BmmRoutine *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * Formal parameters of the routine.
 * cardinality: 0..1
 * 
*/
    private List<BmmParameter> parameters;

/**
 * 
 * Local variables of the routine.
 * cardinality: 0..1
 * 
*/
    private List<BmmLocal> locals;

/**
 * 
 * cardinality: 0..1
 * 
*/
    private List<BmmAssertion> preConditions;

/**
 * 
 * cardinality: 0..1
 * 
*/
    private List<BmmAssertion> postConditions;

/**
 * 
 * Body of a routine, i.e.
 * executable program.
 * cardinality: 0..1
 * 
*/
    private BmmRoutineBody body;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * Formal parameters of the routine.
 * cardinality: 0..1
 * 
*/

    public void addToParameter(BmmParameter value ) {
        if (parameters == null ) {
            parameters = new ArrayList<> ();
        }
        parameters.add( value);
    }

    public void addToParameters(List<BmmParameter> values ) {
        values.forEach(value -> addParameter(value));
    }

    public void removeFromParameter(BmmParameter item ) {
        if (parameters != null ) {
            parameters.remove(item);
        }
    }
    public void removeFromParameters( Collection <BmmParameter> values ) {
        values.forEach(this::removeParameter);
    }
    BmmParameter getParameters() {
        return this.parameters;
    }
    public BmmRoutine setParameters(BmmParameter parameters) {
        this.parameters = parameters;
        return this;
    }
    public List<BmmParameter> parameters() {
        return Collections.unmodifiableList(this.parameters);
    }

/**
 * 
 * Local variables of the routine.
 * cardinality: 0..1
 * 
*/

    public void addToLocal(BmmLocal value ) {
        if (locals == null ) {
            locals = new ArrayList<> ();
        }
        locals.add( value);
    }

    public void addToLocals(List<BmmLocal> values ) {
        values.forEach(value -> addLocal(value));
    }

    public void removeFromLocal(BmmLocal item ) {
        if (locals != null ) {
            locals.remove(item);
        }
    }
    public void removeFromLocals( Collection <BmmLocal> values ) {
        values.forEach(this::removeLocal);
    }
    BmmLocal getLocals() {
        return this.locals;
    }
    public BmmRoutine setLocals(BmmLocal locals) {
        this.locals = locals;
        return this;
    }
    public List<BmmLocal> locals() {
        return Collections.unmodifiableList(this.locals);
    }

/**
 * 
 * cardinality: 0..1
 * 
*/

    public void addToPreCondition(BmmAssertion value ) {
        if (preConditions == null ) {
            preConditions = new ArrayList<> ();
        }
        preConditions.add( value);
    }

    public void addToPreConditions(List<BmmAssertion> values ) {
        values.forEach(value -> addPrecondition(value));
    }

    public void removeFromPreCondition(BmmAssertion item ) {
        if (preConditions != null ) {
            preConditions.remove(item);
        }
    }
    public void removeFromPreConditions( Collection <BmmAssertion> values ) {
        values.forEach(this::removePreCondition);
    }
    BmmAssertion getPreConditions() {
        return this.preConditions;
    }
    public BmmRoutine setPreConditions(BmmAssertion preConditions) {
        this.preConditions = preConditions;
        return this;
    }
    public List<BmmAssertion> preConditions() {
        return Collections.unmodifiableList(this.preConditions);
    }

/**
 * 
 * cardinality: 0..1
 * 
*/

    public void addToPostCondition(BmmAssertion value ) {
        if (postConditions == null ) {
            postConditions = new ArrayList<> ();
        }
        postConditions.add( value);
    }

    public void addToPostConditions(List<BmmAssertion> values ) {
        values.forEach(value -> addPostcondition(value));
    }

    public void removeFromPostCondition(BmmAssertion item ) {
        if (postConditions != null ) {
            postConditions.remove(item);
        }
    }
    public void removeFromPostConditions( Collection <BmmAssertion> values ) {
        values.forEach(this::removePostCondition);
    }
    BmmAssertion getPostConditions() {
        return this.postConditions;
    }
    public BmmRoutine setPostConditions(BmmAssertion postConditions) {
        this.postConditions = postConditions;
        return this;
    }
    public List<BmmAssertion> postConditions() {
        return Collections.unmodifiableList(this.postConditions);
    }

/**
 * 
 * Body of a routine, i.e.
 * executable program.
 * cardinality: 0..1
 * 
*/
    public BmmRoutineBody getBody() {
        return body;
    }
    public setBody(BmmRoutineBody value) {
        this.body = body;
    }

/*=========================================================*/
/* * FUNCTIONS * */
/*=========================================================*/

/**
 * 
 * Return number of arguments of this routine.
 * cardinality: 1..1
 * 
*/
    public Integer  arity() {
        Integer  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * Formal signature of this element, in the form '[arg1_name: T_arg1, …​]:T_value'.
 * cardinality: 1..1 (effected)
 * 
*/
    public void  signature() {
    }

    //***** BmmRoutine *****

/*=========================================================*/
/* * BUILD PATTERN AND CONSTRUCTOR * */
/*=========================================================*/


    protected BmmRoutine(
            List<bmmParameter> parameters,
            List<bmmLocal> locals,
            List<bmmAssertion> preConditions,
            List<bmmAssertion> postConditions,
            BmmRoutineBody body,
            BmmVisibility visibility,
            List<bmmFeatureExtension> featureExtensions,
            BmmFeatureGroup group,
            BmmClass scope,
            String name,
            Map<string, any> documentation,
            BmmDeclaration scope,
            Map<string, any> extensions
        ){
        super( 
            visibility,
            featureExtensions,
            group,
            scope,
            name,
            documentation,
            scope,
            extensions
        );
        this.parameters = parameters;
        this.locals = locals;
        this.preConditions = preConditions;
        this.postConditions = postConditions;
        this.body = body;
    }


    //***** BmmRoutine *****

/*=========================================================*/
/* * TOSTRING, EQUALS AND HASHCODE * */
/*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        BmmRoutine that = (BmmRoutine) object;
        return
            java.util.Objects.equals(parameters, that.parameters) &&
            java.util.Objects.equals(locals, that.locals) &&
            java.util.Objects.equals(preConditions, that.preConditions) &&
            java.util.Objects.equals(postConditions, that.postConditions) &&
            java.util.Objects.equals(body, that.body);
        }
    }

    public int hashCode() {
        return Objects.hash(
            super.hashCode(),
            parameters,
            locals,
            preConditions,
            postConditions,
            body
        );
    }

    @java.lang.Override
    public java.lang.String toString() {
        return
            "BmmRoutine {" +
            "parameters='" + parameters + '\''; +
            "locals='" + locals + '\''; +
            "preConditions='" + preConditions + '\''; +
            "postConditions='" + postConditions + '\''; +
            "body='" + body + '\''; +
            '}';
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
