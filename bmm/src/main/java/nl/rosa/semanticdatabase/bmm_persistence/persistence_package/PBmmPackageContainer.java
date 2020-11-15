package nl.rosa.semanticdatabase.bmm_persistence.persistence_package;


/**
 * 
 * #Generated: 2020-11-15T18:16:51.043+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Persisted form of a model component that contains packages.
 * 
*/
public interface PBmmPackageContainer {

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * Package structure as a hierarchy of packages each potentially containing names of classes in that package in the original model.
 * cardinality: 1..1
 * 
*/

    void putPackage(String key, PBmmPackage value );
    void putPackages(Map<String, P_BMM_PACKAGE> items );
    PBmmPackage getPackage(String key );
    void removePackage(String key );
    void removePackages( Collection <String> keys );
    Map<String, P_BMM_PACKAGE> getPackages();
    void setPackages(Map<String, P_BMM_PACKAGE> packages);
    Map<String, P_BMM_PACKAGE> packages();

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
