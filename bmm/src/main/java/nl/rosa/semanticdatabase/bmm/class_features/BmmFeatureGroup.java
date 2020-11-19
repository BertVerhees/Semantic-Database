package nl.rosa.semanticdatabase.bmm.class_features;

import nl.rosa.semanticdatabase.foundation_types.primitive_types.String;

/**
 * 
 * #Generated: 2020-11-19T08:28:08.518+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * A logical group of features, with a name and set of properties that applies to the group.
 * 
*/
public class BmmFeatureGroup {

    //***** BmmFeatureGroup *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * Set of properties of this group, represented as name/value pairs.
 * These are understood to apply logically to all of the features contained within the group.
 * cardinality: 1..1
 * 
*/
    private Map<String, String> properties = new HashMap<> ();

/**
 * 
 * Set of features in this group.
 * cardinality: 0..1
 * 
*/
    private List<BmmClassFeature> features;

/**
 * 
 * Optional visibility to apply to all features in this group.
 * cardinality: 0..1
 * 
*/
    private BmmVisibility visibility;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * Set of properties of this group, represented as name/value pairs.
 * These are understood to apply logically to all of the features contained within the group.
 * cardinality: 1..1
 * 
*/

    public void putProperty(String key, String value ) {
        properties.put( key, value);
    }

    public void putProperties(Map<String, String> items ) {
        items.keySet().forEach(key -> putProperty(key, items.get(key)));
    }

    public String getProperty(String key ) {
        return properties.get( key);
    }

    public void removeProperty(String key ) {
        if (properties != null ) {
            properties.remove(key);
        }
    }
    public void removeProperties( Collection <String> keys ) {
        keys.forEach(this::removeProperty);
    }
    public Map<String, String> getProperties() {
        return this.properties;
    }
    public BmmFeatureGroup setProperties(Map<String, String> properties) {
        if (properties == null ) {
            throw new NullPointerException(" properties has cardinality NonNull, but is null");
        }
        this.properties = properties;
        return this;
    }
    public Map<String, String> properties() {
        return Collections.unmodifiableMap(this.properties);
    }

/**
 * 
 * Set of features in this group.
 * cardinality: 0..1
 * 
*/

    public void addToFeature(BmmClassFeature value ) {
        if (features == null ) {
            features = new ArrayList<> ();
        }
        features.add( value);
    }

    public void addToFeatures(List<BmmClassFeature> values ) {
        values.forEach(value -> addFeature(value));
    }

    public void removeFromFeature(BmmClassFeature item ) {
        if (features != null ) {
            features.remove(item);
        }
    }
    public void removeFromFeatures( Collection <BmmClassFeature> values ) {
        values.forEach(this::removeFeature);
    }
    BmmClassFeature getFeatures() {
        return this.features;
    }
    public BmmFeatureGroup setFeatures(BmmClassFeature features) {
        this.features = features;
        return this;
    }
    public List<BmmClassFeature> features() {
        return Collections.unmodifiableList(this.features);
    }

/**
 * 
 * Optional visibility to apply to all features in this group.
 * cardinality: 0..1
 * 
*/
    public BmmVisibility getVisibility() {
        return visibility;
    }
    public BmmFeatureGroup setVisibility(BmmVisibility value) {
        this.visibility = visibility;
        return this;
    }

/*=========================================================*/
/* * CONSTANTS * */
/*=========================================================*/

/**
 * 
 * Name of this feature group; defaults to 'feature'.
 * 
*/
    final String {default name = "feature"};

    //***** BmmFeatureGroup *****

/*=========================================================*/
/* * BUILD PATTERN AND CONSTRUCTOR * */
/*=========================================================*/

    public BmmFeatureGroup build() {
        return new BmmFeatureGroup(
            properties,
            features,
            visibility
        );
    }

    public BmmFeatureGroup(
            Map<String, String> properties,
            List<BmmClassFeature> features,
            BmmVisibility visibility
    ){
        if ( properties == null ) {
            throw new NullPointerException("Property:properties has cardinality NonNull, but is null");
        }
        this.properties = properties;
        this.features = features;
        this.visibility = visibility;
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
