package nl.rosa.semanticdatabase.bmm.model_access_package;

import nl.rosa.semanticdatabase.bmm.model_structure.BmmModel;
import nl.rosa.semanticdatabase.foundation_types.primitive_types.String;
import nl.rosa.semanticdatabase.foundation_types.primitive_types.Boolean;

/**
 * 
 * #Generated: 2020-11-19T08:28:08.518+01:00
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
        return bmmSchema;
    }
    public BmmSchemaDescriptor setBmmSchema(BmmSchema value) {
        this.bmmSchema = bmmSchema;
        return this;
    }

/**
 * 
 * Computable form of model.
 * cardinality: 0..1
 * 
*/
    public BmmModel getBmmModel() {
        return bmmModel;
    }
    public BmmSchemaDescriptor setBmmModel(BmmModel value) {
        this.bmmModel = bmmModel;
        return this;
    }

/**
 * 
 * Schema id, formed by {BMM_DEFINITIONS}.create_schema_id( meta_data.item({BMM_DEFINITIONS}.Metadata_model_publisher), meta_data.item({BMM_DEFINITIONS}.Metadata_schema_name), meta_data.item({BMM_DEFINITIONS}.Metadata_model_release) e.g.
 * openehr_rm_1.0.3, openehr_test_1.0.1, iso_13606_1_2008_2.1.2.
 * cardinality: 1..1
 * 
*/
    public String getSchemaId() {
        return schemaId;
    }
    public BmmSchemaDescriptor setSchemaId(String value) {
        if ( value == null ) {
            throw new NullPointerException(" Setting property:schemaId failed, it has cardinality NonNull, but is null");
        }
        this.schemaId = schemaId;
        return this;
    }

/**
 * 
 * Table of {key, value} of schema meta-data, keys are string values defined by {BMM_DEFINITIONS}.Metadata_* constants.
 * cardinality: 1..1
 * 
*/

    public void putMetaData(String key, String value ) {
        metaData.put( key, value);
    }

    public void putMetaData(Map<String, String> items ) {
        items.keySet().forEach(key -> putMetadat(key, items.get(key)));
    }

    public String getMetaData(String key ) {
        return metaData.get( key);
    }

    public void removeMetaData(String key ) {
        if (metaData != null ) {
            metaData.remove(key);
        }
    }
    public void removeMetaData( Collection <String> keys ) {
        keys.forEach(this::removeMetaData);
    }
    public Map<String, String> getMetaData() {
        return this.metaData;
    }
    public BmmSchemaDescriptor setMetaData(Map<String, String> metaData) {
        if (metaData == null ) {
            throw new NullPointerException(" metaData has cardinality NonNull, but is null");
        }
        this.metaData = metaData;
        return this;
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
    public BmmSchemaDescriptor setIncludes(String includes) {
        this.includes = includes;
        return this;
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
    public BmmSchemaDescriptor set( value) {
        this. = ;
        return this;
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
    public BmmSchemaDescriptor set( value) {
        this. = ;
        return this;
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
    public BmmSchemaDescriptor set( value) {
        this. = ;
        return this;
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


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
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


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * Validate includes list for this schema, to see if each mentioned schema exists in all_schemas list.
 * cardinality: 0..1
 * 
*/
    public void  validateIncludes(List<String> all_schemas_list) {
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
