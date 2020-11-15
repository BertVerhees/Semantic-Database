package nl.rosa.semanticdatabase.bmm.class_features;


/**
 * 
 * #Generated: 2020-11-15T17:28:03.861+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * External routine placeholder, containing sufficient meta-data to enable a routine in an external library to be called.
 * 
*/
public class BmmRoutineExternal extends BmmRoutineBody {

    //***** BmmRoutineExternal *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * External call general meta-data, including target routine name, type mapping etc.
 * cardinality: 1..1
 * 
*/
    private Map<String, String> metaData = new HashMap<> ();

/**
 * 
 * Optional argument-mapping meta-data.
 * cardinality: 0..1
 * 
*/
    private Map<String, String> argumentMapping;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * External call general meta-data, including target routine name, type mapping etc.
 * cardinality: 1..1
 * 
*/

    public void putMetadata(String key, String value ) {
        metaData.put( key, value);
    }

    public void putMetadata(Map<String, String> items ) {
        items.keySet().forEach(key -> putMetadat(key, items.get(key)));
    }

    public String getMetadata(String key ) {
        return metaData.get( key);
    }

    public void removeMetadata(String key ) {
        if (metaData != null ) {
            metaData.remove(key);
        }
    }
    public void removeMetadata( Collection <String> keys ) {
        keys.forEach(this::removeMetadata);
    }
    Map<String, String> getMetadata() {
        return this.metaData;
    }
    void setMetadata(Map<String, String> metaData) {
        if (metaData == null ) {
            throw new NullPointerException(" metaData has cardinality NonNull, but is null")
        }
        this.metaData = metaData;
    }
    public Map<String, String> metaData() {
        return Collections.unmodifiableMap(this.metaData);
    }

/**
 * 
 * Optional argument-mapping meta-data.
 * cardinality: 0..1
 * 
*/

    public void putArgumentmapping(String key, String value ) {
        if (argumentMapping == null ) {
            argumentMapping = new HashMap<> ();
        }
        argumentMapping.put( key, value);
    }

    public void putArgumentmapping(Map<String, String> items ) {
        items.keySet().forEach(key -> putArgumentmappin(key, items.get(key)));
    }

    public String getArgumentmapping(String key ) {
        if (argumentMapping == null ) {
            return null;
        }
        return argumentMapping.get( key);
    }

    public void removeArgumentmapping(String key ) {
        if (argumentMapping != null ) {
            argumentMapping.remove(key);
        }
    }
    public void removeArgumentmapping( Collection <String> keys ) {
        keys.forEach(this::removeArgumentmapping);
    }
    Map<String, String> getArgumentmapping() {
        return this.argumentMapping;
    }
    void setArgumentmapping(Map<String, String> argumentMapping) {
        this.argumentMapping = argumentMapping;
    }
    public Map<String, String> argumentMapping() {
        return Collections.unmodifiableMap(this.argumentMapping);
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
