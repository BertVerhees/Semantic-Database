package nl.rosa.semanticdatabase.bmm.model_access_package;

import nl.rosa.semanticdatabase.bmm.model_structure.BmmModel;

/**
 * 
 * #Generated: 2020-11-15T17:28:03.861+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Access to BMM models that have been loaded and validated from one or more schema sets.
 * 
*/
public class BmmModelAccess {

    //***** BmmModelAccess *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * List of directories where all the schemas loaded here are found.
 * cardinality: 0..1
 * 
*/
    private List<String> schemaDirectories;

/**
 * 
 * All schemas found and loaded from schema_directory.
 * Keyed by schema_id.
 * cardinality: 0..1
 * 
*/
    private Map<String,BmmSchemaDescriptor> allSchemas;

/**
 * 
 * Top-level (root) models in use, keyed by model_id.
 * cardinality: 0..1
 * 
*/
    private Map<String,BmmModel> bmmModels;

/**
 * 
 * Validated models, keyed by model_id() and any shorter forms of id, with some or no versioning information.
 * For example, the keys "openEHR_EHR_1.0.4", "openEHR_EHR_1.0", "openEHR_EHR_1", and "openEHR_EHR" will all match the "openEHR_EHR_1.0.4" model, assuming it is the most recent version available.
 * cardinality: 0..1
 * 
*/
    private Map<String,BmmModel> matchingBmmModels;

/**
 * 
 * Reload BMM schemas.
 * cardinality: 0..1
 * 
*/
    private  ;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * List of directories where all the schemas loaded here are found.
 * cardinality: 0..1
 * 
*/

    public void addToSchemaDirectory(String value ) {
        if (schemaDirectories == null ) {
            schemaDirectories = new ArrayList<> ();
        }
        schemaDirectories.add( value);
    }

    public void addToSchemaDirectories(List<String> values ) {
        values.forEach(value -> addSchemadirectory(value));
    }

    public void removeFromSchemaDirectory(String item ) {
        if (schemaDirectories != null ) {
            schemaDirectories.remove(item);
        }
    }
    public void removeFromSchemaDirectories( Collection <String> values ) {
        values.forEach(this::removeSchemaDirectory);
    }
    String getSchemaDirectories() {
        return this.schemaDirectories;
    }
    void setSchemaDirectories(String schemaDirectories) {
        this.schemaDirectories = schemaDirectories;
    }
    public List<String> schemaDirectories() {
        return Collections.unmodifiableList(this.schemaDirectories);
    }

/**
 * 
 * All schemas found and loaded from schema_directory.
 * Keyed by schema_id.
 * cardinality: 0..1
 * 
*/

    public void putAllschema(String key, BmmSchemaDescriptor value ) {
        if (allSchemas == null ) {
            allSchemas = new HashMap<> ();
        }
        allSchemas.put( key, value);
    }

    public void putAllschemas(Map<String,BmmSchemaDescriptor> items ) {
        items.keySet().forEach(key -> putAllschema(key, items.get(key)));
    }

    public BmmSchemaDescriptor getAllschema(String key ) {
        if (allSchemas == null ) {
            return null;
        }
        return allSchemas.get( key);
    }

    public void removeAllschema(String key ) {
        if (allSchemas != null ) {
            allSchemas.remove(key);
        }
    }
    public void removeAllschemas( Collection <String> keys ) {
        keys.forEach(this::removeAllschema);
    }
    Map<String,BmmSchemaDescriptor> getAllschemas() {
        return this.allSchemas;
    }
    void setAllschemas(Map<String,BmmSchemaDescriptor> allSchemas) {
        this.allSchemas = allSchemas;
    }
    public Map<String,BmmSchemaDescriptor> allSchemas() {
        return Collections.unmodifiableMap(this.allSchemas);
    }

/**
 * 
 * Top-level (root) models in use, keyed by model_id.
 * cardinality: 0..1
 * 
*/

    public void putBmmmodel(String key, BmmModel value ) {
        if (bmmModels == null ) {
            bmmModels = new HashMap<> ();
        }
        bmmModels.put( key, value);
    }

    public void putBmmmodels(Map<String,BmmModel> items ) {
        items.keySet().forEach(key -> putBmmmodel(key, items.get(key)));
    }

    public BmmModel getBmmmodel(String key ) {
        if (bmmModels == null ) {
            return null;
        }
        return bmmModels.get( key);
    }

    public void removeBmmmodel(String key ) {
        if (bmmModels != null ) {
            bmmModels.remove(key);
        }
    }
    public void removeBmmmodels( Collection <String> keys ) {
        keys.forEach(this::removeBmmmodel);
    }
    Map<String,BmmModel> getBmmmodels() {
        return this.bmmModels;
    }
    void setBmmmodels(Map<String,BmmModel> bmmModels) {
        this.bmmModels = bmmModels;
    }
    public Map<String,BmmModel> bmmModels() {
        return Collections.unmodifiableMap(this.bmmModels);
    }

/**
 * 
 * Validated models, keyed by model_id() and any shorter forms of id, with some or no versioning information.
 * For example, the keys "openEHR_EHR_1.0.4", "openEHR_EHR_1.0", "openEHR_EHR_1", and "openEHR_EHR" will all match the "openEHR_EHR_1.0.4" model, assuming it is the most recent version available.
 * cardinality: 0..1
 * 
*/

    public void putMatchingbmmmodel(String key, BmmModel value ) {
        if (matchingBmmModels == null ) {
            matchingBmmModels = new HashMap<> ();
        }
        matchingBmmModels.put( key, value);
    }

    public void putMatchingbmmmodels(Map<String,BmmModel> items ) {
        items.keySet().forEach(key -> putMatchingbmmmodel(key, items.get(key)));
    }

    public BmmModel getMatchingbmmmodel(String key ) {
        if (matchingBmmModels == null ) {
            return null;
        }
        return matchingBmmModels.get( key);
    }

    public void removeMatchingbmmmodel(String key ) {
        if (matchingBmmModels != null ) {
            matchingBmmModels.remove(key);
        }
    }
    public void removeMatchingbmmmodels( Collection <String> keys ) {
        keys.forEach(this::removeMatchingbmmmodel);
    }
    Map<String,BmmModel> getMatchingbmmmodels() {
        return this.matchingBmmModels;
    }
    void setMatchingbmmmodels(Map<String,BmmModel> matchingBmmModels) {
        this.matchingBmmModels = matchingBmmModels;
    }
    public Map<String,BmmModel> matchingBmmModels() {
        return Collections.unmodifiableMap(this.matchingBmmModels);
    }

/**
 * 
 * Reload BMM schemas.
 * cardinality: 0..1
 * 
*/
    public  get() {
        return ;
    }
    public void set( value) {
        this. = ;
    }

/*=========================================================*/
/* * FUNCTIONS * */
/*=========================================================*/

/**
 * 
 * Initialise with a specific schema load list, usually a sub-set of schemas that will be found in a specified directories a_schema_dirs.
 * cardinality: 0..1
 * 
*/
    public void  initialiseWithLoadList() {
    }

/**
 * 
 * Load all schemas found in a specified directories a_schema_dirs.
 * cardinality: 0..1
 * 
*/
    public void  initialiseAll() {
    }

/**
 * 
 * Return model containing the model key which is a model_id or any shorter form e.g.
 * model id minus the version.
 * If a shorter key is used, the BMM_MODEL with the most recent version will be selected.
 * Uses matching_bmm_models table to find matches if partial version information is supplied in key.
 * cardinality: 1..1
 * 
*/
    public BmmModel  bmmModel() {
        BmmModel  result;

        return  result;
    }

/**
 * 
 * True if a model for a model_key is available.
 * A model key is a model_id or any shorter form e.g.
 * model id minus the version.
 * If a shorter key is used, the Result s True if a BMM_MODEL with any version exists.
 * cardinality: 1..1
 * 
*/
    public Boolean  hasBmmModel() {
        Boolean  result;

        return  result;
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
