package nl.rosa.semanticdatabase.bmm.model_access_package;


/**
 * 
 * #Generated: 2020-11-15T18:16:51.043+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Core properties of BMM_MODEL, may be used in a serial representation as well, such as P_BMM_SCHEMA.
 * 
*/
public interface BmmModelMetadata {

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * Publisher of model expressed in the schema.
 * cardinality: 1..1
 * 
*/
    String getRmPublisher();
    void setRmPublisher(String value);

/**
 * 
 * Release of model expressed in the schema as a 3-part numeric, e.g.
 * "3.1.0" .
 * cardinality: 1..1
 * 
*/
    String getRmRelease();
    void setRmRelease(String value);

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
