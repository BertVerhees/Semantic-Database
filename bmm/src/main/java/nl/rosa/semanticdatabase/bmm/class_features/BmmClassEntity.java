package nl.rosa.semanticdatabase.bmm.class_features;

import nl.rosa.semanticdatabase.bmm.model_structure.BmmDeclaration;
import nl.rosa.semanticdatabase.bmm.types.BmmSignature;

/**
 * 
 * #Generated: 2020-11-15T17:28:03.861+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Any entity declared within a class.
 * 
*/
public abstract class BmmClassEntity extends BmmDeclaration {

/*=========================================================*/
/* * FUNCTIONS * */
/*=========================================================*/

/**
 * 
 * Formal signature of this element, in the form: name [arg1_name: T_arg1, …​][:T_value] Specific implementations in descendants.
 * cardinality: 1..1 (abstract)
 * 
*/
    public abstract BmmSignature  signature();

/*=========================================================*/
/* * CONSTANTS * */
/*=========================================================*/

/**
 * 
 * True if this feature was synthesised due to generic substitution in an inherited type, or further constraining of a formal generic parameter.
 * 
*/
    final Boolean {default isSynthesisedGeneric = false};

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
