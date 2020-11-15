package nl.rosa.semanticdatabase.bmm.expressions;

import nl.rosa.semanticdatabase.bmm.class_features.BmmRoutine;

/**
 * 
 * #Generated: 2020-11-15T18:16:51.043+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * A delayed routine call, whose arguments may be open, partially closed or closed.
 * Instances may include closed delayed calls like calculate_age (dob="1987-09-13", today="2019-06-03") but also partially open calls such as format_structure (struct=?, style=3), where struct is an open argument.
 * Evaluation type (i.e.
 * type of runtime evaluated form) is BMM_SIGNATURE.
 * 
*/
public abstract class ElAgent extends ElScopedRef {

    //***** ElAgent *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * Name of the routine being called.
 * cardinality: 1..1
 * 
*/
    private String name;

/**
 * 
 * Closed arguments of a routine call as a tuple of objects.
 * cardinality: 0..1
 * 
*/
    private ElTuple closedArgs;

/**
 * 
 * Optional list of names of open arguments of the call.
 * If not provided, and the name refers to a routine with more arguments than supplied in closed_args, the missing arguments are inferred from the definition.
 * cardinality: 0..1
 * 
*/
    private List<String> openArgs;

/**
 * 
 * Reference to definition of a routine for which this is an agent, if one exists.
 * cardinality: 0..1
 * 
*/
    private BmmRoutine definition;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * Name of the routine being called.
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
 * Closed arguments of a routine call as a tuple of objects.
 * cardinality: 0..1
 * 
*/
    public ElTuple getClosedArgs() {
        return closed_args;
    }
    public void setClosedArgs(ElTuple value) {
        this.closed_args = closed_args;
    }

/**
 * 
 * Optional list of names of open arguments of the call.
 * If not provided, and the name refers to a routine with more arguments than supplied in closed_args, the missing arguments are inferred from the definition.
 * cardinality: 0..1
 * 
*/

    public void addToOpenArg(String value ) {
        if (openArgs == null ) {
            openArgs = new ArrayList<> ();
        }
        openArgs.add( value);
    }

    public void addToOpenArgs(List<String> values ) {
        values.forEach(value -> addOpenarg(value));
    }

    public void removeFromOpenArg(String item ) {
        if (openArgs != null ) {
            openArgs.remove(item);
        }
    }
    public void removeFromOpenArgs( Collection <String> values ) {
        values.forEach(this::removeOpenArg);
    }
    String getOpenArgs() {
        return this.openArgs;
    }
    void setOpenArgs(String openArgs) {
        this.openArgs = openArgs;
    }
    public List<String> openArgs() {
        return Collections.unmodifiableList(this.openArgs);
    }

/**
 * 
 * Reference to definition of a routine for which this is an agent, if one exists.
 * cardinality: 0..1
 * 
*/
    public BmmRoutine getDefinition() {
        return definition;
    }
    public void setDefinition(BmmRoutine value) {
        this.definition = definition;
    }

/*=========================================================*/
/* * FUNCTIONS * */
/*=========================================================*/

/**
 * 
 * Eval type is the signature corresponding to the (remaining) open arguments and return type, if any.
 * cardinality: 1..1 (effected)
 * 
*/
    public abstract Result = definition.signature  evalType();

/**
 * 
 * True if there are no open arguments.
 * cardinality: 1..1
 * 
*/
    public abstract Result = open_arguments = Void  isCallable();

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
