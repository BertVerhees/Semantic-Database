package nl.rosa.semanticdatabase.bmm.class_features;

import nl.rosa.semanticdatabase.bmm.classes.BmmClass;

/**
 * 
 * #Generated: 2020-11-19T08:28:08.518+01:00
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
    public BmmClassFeature setVisibility(BmmVisibility value) {
        this.visibility = visibility;
        return this;
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
    public BmmClassFeature setFeatureExtensions(BMM_FEATURE_EXTENSION featureExtensions) {
        this.featureExtensions = featureExtensions;
        return this;
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
    public BmmClassFeature setGroup(BmmFeatureGroup value) {
        if ( value == null ) {
            throw new NullPointerException(" Setting property:group failed, it has cardinality NonNull, but is null");
        }
        this.group = group;
        return this;
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
    public BmmClassFeature setScope(BmmClass value) {
        if ( value == null ) {
            throw new NullPointerException(" Setting property:scope failed, it has cardinality NonNull, but is null");
        }
        this.scope = scope;
        return this;
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
