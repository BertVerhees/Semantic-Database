package nl.rosa.semanticdatabase.bmm.class_features;


/**
 * 
 * #Generated: 2020-11-15T17:28:03.861+01:00
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
    Map<String, String> getProperties() {
        return this.properties;
    }
    void setProperties(Map<String, String> properties) {
        if (properties == null ) {
            throw new NullPointerException(" properties has cardinality NonNull, but is null")
        }
        this.properties = properties;
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
    void setFeatures(BmmClassFeature features) {
        this.features = features;
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
    public void setVisibility(BmmVisibility value) {
        this.visibility = visibility;
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
