package nl.rosa.semanticdatabase.bmm.types;


/**
 * 
 * #Generated: 2020-11-15T18:16:51.043+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Non-entity meta-type that expresses the type structure of any referenceable element of a model.
 * Consists of potential arguments and result, with constraints in descendants determining the exact form.
 * 
*/
public class BmmSignature extends BmmEffectiveType {

    //***** BmmSignature *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * Type of arguments in the signature, if any; represented as a type-tuple (list of arbitrary types).
 * cardinality: 0..1
 * 
*/
    private BmmTupleType argumentTypes;

/**
 * 
 * Result type of signature, if any.
 * cardinality: 0..1
 * 
*/
    private BmmType resultType;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * Type of arguments in the signature, if any; represented as a type-tuple (list of arbitrary types).
 * cardinality: 0..1
 * 
*/
    public BmmTupleType getArgumentTypes() {
        return argument_types;
    }
    public void setArgumentTypes(BmmTupleType value) {
        this.argument_types = argument_types;
    }

/**
 * 
 * Result type of signature, if any.
 * cardinality: 0..1
 * 
*/
    public BmmType getResultType() {
        return result_type;
    }
    public void setResultType(BmmType value) {
        this.result_type = result_type;
    }

/*=========================================================*/
/* * FUNCTIONS * */
/*=========================================================*/

/**
 * 
 * Return base_name.
 * cardinality: 1..1 (effected)
 * 
*/
    public abstract Result.is_equal (base_name())  typeBaseName();

/**
 * 
 * Result = False.
 * cardinality: 1..1 (effected)
 * 
*/
    public abstract Boolean  isAbstract();

/**
 * 
 * Result = True.
 * cardinality: 1..1 (effected)
 * 
*/
    public abstract Boolean  isPrimitive();

/**
 * 
 * Return base_name
 * cardinality: 1..1 (effected)
 * 
*/
    public abstract Result.is_equal (base_name())  typeName();

/**
 * 
 * Return the logical set (i.e.
 * unique items) consisting of argument_types.flattened_type_list() and result_type.flattened_type_list().
 * cardinality: 1..1 (effected)
 * 
*/
    public abstract List<String>  flattenedTypeList();

/*=========================================================*/
/* * CONSTANTS * */
/*=========================================================*/

/**
 * 
 * Base name (built-in).
 * 
*/
    final String baseName = "Signature";

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
