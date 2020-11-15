package nl.rosa.semanticdatabase.bmm.expressions;


/**
 * 
 * #Generated: 2020-11-15T17:28:03.861+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * A single tuple item, with an optional name.
 * 
*/
public class ElTupleItem {

    //***** ElTupleItem *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * Reference to value entity.
 * If Void, this indicates that the item in this position is Void, e.g.
 * within a routine call parameter list.
 * cardinality: 0..1
 * 
*/
    private ElExpression item;

/**
 * 
 * Optional name of tuple item.
 * cardinality: 0..1
 * 
*/
    private String name;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * Reference to value entity.
 * If Void, this indicates that the item in this position is Void, e.g.
 * within a routine call parameter list.
 * cardinality: 0..1
 * 
*/
    public ElExpression getItem() {
        return item;
    }
    public void setItem(ElExpression value) {
        this.item = item;
    }

/**
 * 
 * Optional name of tuple item.
 * cardinality: 0..1
 * 
*/
    public String getName() {
        return name;
    }
    public void setName(String value) {
        this.name = name;
    }

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
