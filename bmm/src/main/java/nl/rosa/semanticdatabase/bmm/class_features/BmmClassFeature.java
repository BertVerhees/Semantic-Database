package nl.rosa.semanticdatabase.bmm.class_features;

import nl.rosa.semanticdatabase.bmm.classes.BmmClass;

/**
 * 
 * #Generated: 2020-11-15T18:16:51.043+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * A class entity having a signature and a class as its scope.
 * 
*/
public abstract class BmmClassFeature extends BmmClassEntity {

    //***** BmmClassFeature *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * Visibility of this item to client entities.
 * cardinality: 0..1
 * 
*/
    private BmmVisibility visibility;

/**
 * 
 * Extensions to feature-level meta-types.
 * cardinality: 0..1
 * 
*/
    private List<BMM_FEATURE_EXTENSION> featureExtensions;

/**
 * 
 * Group containing this feature.
 * cardinality: 1..1
 * 
*/
    private BmmFeatureGroup group;

/**
 * 
 * Class within which a referenceable element is known.
 * cardinality: 1..1 (redefined)
 * 
*/
    private BmmClass scope;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * Visibility of this item to client entities.
 * cardinality: 0..1
 * 
*/
    public BmmVisibility getVisibility() {
        return visibility;
    }
    public void setVisibility(BmmVisibility value) {
        this.visibility = visibility;
    }

/**
 * 
 * Extensions to feature-level meta-types.
 * cardinality: 0..1
 * 
*/

    public void addToFeatureExtension(BMM_FEATURE_EXTENSION value ) {
        if (featureExtensions == null ) {
            featureExtensions = new ArrayList<> ();
        }
        featureExtensions.add( value);
    }

    public void addToFeatureExtensions(List<BMM_FEATURE_EXTENSION> values ) {
        values.forEach(value -> addFeatureextension(value));
    }

    public void removeFromFeatureExtension(BMM_FEATURE_EXTENSION item ) {
        if (featureExtensions != null ) {
            featureExtensions.remove(item);
        }
    }
    public void removeFromFeatureExtensions( Collection <BMM_FEATURE_EXTENSION> values ) {
        values.forEach(this::removeFeatureExtension);
    }
    BMM_FEATURE_EXTENSION getFeatureExtensions() {
        return this.featureExtensions;
    }
    void setFeatureExtensions(BMM_FEATURE_EXTENSION featureExtensions) {
        this.featureExtensions = featureExtensions;
    }
    public List<BMM_FEATURE_EXTENSION> featureExtensions() {
        return Collections.unmodifiableList(this.featureExtensions);
    }

/**
 * 
 * Group containing this feature.
 * cardinality: 1..1
 * 
*/
    public BmmFeatureGroup getGroup() {
        return group;
    }
    public void setGroup(BmmFeatureGroup value) {
        if (group == null ) {
            throw new NullPointerException(" group has cardinality NonNull, but is null")
        }
        this.group = group;
    }

/**
 * 
 * Class within which a referenceable element is known.
 * cardinality: 1..1 (redefined)
 * 
*/
    public BmmClass getScope() {
        return scope;
    }
    public void setScope(BmmClass value) {
        if (scope == null ) {
            throw new NullPointerException(" scope has cardinality NonNull, but is null")
        }
        this.scope = scope;
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
