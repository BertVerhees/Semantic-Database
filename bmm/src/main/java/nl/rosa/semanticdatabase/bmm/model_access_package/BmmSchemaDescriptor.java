package nl.rosa.semanticdatabase.bmm.model_access_package;

import nl.rosa.semanticdatabase.bmm.model_structure.BmmModel;

/**
 * 
 * #Generated: 2020-11-15T17:28:03.861+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Descriptor for a BMM schema.
 * Contains a meta-data table of attributes obtained from a mini-ODIN parse of the schema file.
 * 
*/
public abstract class BmmSchemaDescriptor {

    //***** BmmSchemaDescriptor *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * Persistent form of model.
 * cardinality: 0..1
 * 
*/
    private BmmSchema bmmSchema;

/**
 * 
 * Computable form of model.
 * cardinality: 0..1
 * 
*/
    private BmmModel bmmModel;

/**
 * 
 * Schema id, formed by {BMM_DEFINITIONS}.create_schema_id( meta_data.item({BMM_DEFINITIONS}.Metadata_model_publisher), meta_data.item({BMM_DEFINITIONS}.Metadata_schema_name), meta_data.item({BMM_DEFINITIONS}.Metadata_model_release) e.g.
 * openehr_rm_1.0.3, openehr_test_1.0.1, iso_13606_1_2008_2.1.2.
 * cardinality: 1..1
 * 
*/
    private String schemaId;

/**
 * 
 * Table of {key, value} of schema meta-data, keys are string values defined by {BMM_DEFINITIONS}.Metadata_* constants.
 * cardinality: 1..1
 * 
*/
    private Map<String, String> metaData = new HashMap<> ();

/**
 * 
 * Identifiers of schemas included by this schema.
 * cardinality: 0..1
 * 
*/
    private List<String> includes;

/**
 * 
 * Load schema into in-memory form, i.e.
 * a P_BMM_SCHEMA instance, if structurally valid.
 * If successful, p_schema will be set.
 * cardinality: 0..1
 * 
*/
    private  ;

/**
 * 
 * Validate loaded schema and report errors.
 * cardinality: 0..1
 * 
*/
    private  ;

/**
 * 
 * Create schema, i.e.
 * the BMM_MODEL from one P_BMM_SCHEMA schema.
 * cardinality: 0..1
 * 
*/
    private  ;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * Persistent form of model.
 * cardinality: 0..1
 * 
*/
    public BmmSchema getBmmSchema() {
        return bmm_schema;
    }
    public void setBmmSchema(BmmSchema value) {
        this.bmm_schema = bmm_schema;
    }

/**
 * 
 * Computable form of model.
 * cardinality: 0..1
 * 
*/
    public BmmModel getBmmModel() {
        return bmm_model;
    }
    public void setBmmModel(BmmModel value) {
        this.bmm_model = bmm_model;
    }

/**
 * 
 * Schema id, formed by {BMM_DEFINITIONS}.create_schema_id( meta_data.item({BMM_DEFINITIONS}.Metadata_model_publisher), meta_data.item({BMM_DEFINITIONS}.Metadata_schema_name), meta_data.item({BMM_DEFINITIONS}.Metadata_model_release) e.g.
 * openehr_rm_1.0.3, openehr_test_1.0.1, iso_13606_1_2008_2.1.2.
 * cardinality: 1..1
 * 
*/
    public String getSchemaId() {
        return schema_id;
    }
    public void setSchemaId(String value) {
        if (schema_id == null ) {
            throw new NullPointerException(" schema_id has cardinality NonNull, but is null")
        }
        this.schema_id = schema_id;
    }

/**
 * 
 * Table of {key, value} of schema meta-data, keys are string values defined by {BMM_DEFINITIONS}.Metadata_* constants.
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
 * Identifiers of schemas included by this schema.
 * cardinality: 0..1
 * 
*/

    public void addToInclude(String value ) {
        if (includes == null ) {
            includes = new ArrayList<> ();
        }
        includes.add( value);
    }

    public void addToIncludes(List<String> values ) {
        values.forEach(value -> addInclude(value));
    }

    public void removeFromInclude(String item ) {
        if (includes != null ) {
            includes.remove(item);
        }
    }
    public void removeFromIncludes( Collection <String> values ) {
        values.forEach(this::removeInclude);
    }
    String getIncludes() {
        return this.includes;
    }
    void setIncludes(String includes) {
        this.includes = includes;
    }
    public List<String> includes() {
        return Collections.unmodifiableList(this.includes);
    }

/**
 * 
 * Load schema into in-memory form, i.e.
 * a P_BMM_SCHEMA instance, if structurally valid.
 * If successful, p_schema will be set.
 * cardinality: 0..1
 * 
*/
    public  get() {
        return ;
    }
    public void set( value) {
        this. = ;
    }

/**
 * 
 * Validate loaded schema and report errors.
 * cardinality: 0..1
 * 
*/
    public  get() {
        return ;
    }
    public void set( value) {
        this. = ;
    }

/**
 * 
 * Create schema, i.e.
 * the BMM_MODEL from one P_BMM_SCHEMA schema.
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
 * True if this is a top-level schema, i.e.
 * not included by some other schema.
 * cardinality: 1..1
 * 
*/
    public Boolean  isTopLevel() {
        Boolean  result;

        return  result;
    }

/**
 * 
 * True if the BMM version found in the schema (or assumed, if none) is compatible with that in this software.
 * cardinality: 1..1
 * 
*/
    public Boolean  isBmmCompatible() {
        Boolean  result;

        return  result;
    }

/**
 * 
 * Validate includes list for this schema, to see if each mentioned schema exists in all_schemas list.
 * cardinality: 0..1
 * 
*/
    public void  validateIncludes() {
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
