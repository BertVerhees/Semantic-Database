package nl.rosa.semanticdatabase.bmm.class_features;

import nl.rosa.semanticdatabase.bmm.statements.BmmAssertion;

/**
 * 
 * #Generated: 2020-11-15T18:16:51.043+01:00
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
    void setParameters(BmmParameter parameters) {
        this.parameters = parameters;
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
    void setLocals(BmmLocal locals) {
        this.locals = locals;
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
    void setPreConditions(BmmAssertion preConditions) {
        this.preConditions = preConditions;
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
    void setPostConditions(BmmAssertion postConditions) {
        this.postConditions = postConditions;
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
    public void setBody(BmmRoutineBody value) {
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
    public abstract Integer  arity();

/**
 * 
 * Formal signature of this element, in the form '[arg1_name: T_arg1, …​]:T_value'.
 * cardinality: 1..1 (effected)
 * 
*/
    public abstract void  signature();

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
