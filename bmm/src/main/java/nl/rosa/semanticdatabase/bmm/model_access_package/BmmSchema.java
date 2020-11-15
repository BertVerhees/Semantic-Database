package nl.rosa.semanticdatabase.bmm.model_access_package;

import nl.rosa.semanticdatabase.bmm.model_structure.BmmModel;

/**
 * 
 * #Generated: 2020-11-15T18:16:51.043+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Abstract parent of any persistable form of a BMM model, e.g.
 * P_BMM_SCHEMA.
 * 
*/
public abstract class BmmSchema implements BmmModelMetadata {

    //***** BmmSchema *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * Version of BMM model, enabling schema evolution reasoning.
 * Persisted attribute.
 * cardinality: 1..1
 * 
*/
    private String bmmVersion;

/**
 * 
 * Inclusion list of any form of BMM model, in the form of a hash of individual include specifications, each of which at least specifies the id of another schema, and may specify a namespace via which types from the included schemas are known in this schema.
 * Persisted attribute.
 * cardinality: 0..1
 * 
*/
    private Map<String,BmmIncludeSpec> includes;

/**
 * 
 * Generated by create_bmm_model from persisted elements.
 * cardinality: 0..1
 * 
*/
    private BmmModel bmmModel;

/**
 * 
 * Current processing state.
 * cardinality: 1..1
 * 
*/
    private BmmSchemaState state;

/**
 * 
 * Name of this model, if this schema is a model root point.
 * Not set for sub-schemas that are not considered models on their own.
 * cardinality: 0..1
 * 
*/
    private String modelName;

/**
 * 
 * Name of model expressed in schema; a 'schema' usually contains all of the packages of one 'model' of a publisher.
 * A publisher with more than one model can have multiple schemas.
 * cardinality: 1..1
 * 
*/
    private String schemaName;

/**
 * 
 * Revision of schema.
 * cardinality: 1..1
 * 
*/
    private String schemaRevision;

/**
 * 
 * Schema development lifecycle state.
 * cardinality: 1..1
 * 
*/
    private String schemaLifecycleState;

/**
 * 
 * Primary author of schema.
 * cardinality: 1..1
 * 
*/
    private String schemaAuthor;

/**
 * 
 * Description of schema.
 * cardinality: 1..1
 * 
*/
    private String schemaDescription;

/**
 * 
 * Contributing authors of schema.
 * cardinality: 0..1
 * 
*/
    private List<String> schemaContributors;

/**
 * 
 * Main validation prior to generation of bmm_model.
 * cardinality: 0..1 (abstract)
 * 
*/
    private  ;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * Version of BMM model, enabling schema evolution reasoning.
 * Persisted attribute.
 * cardinality: 1..1
 * 
*/
    public String getBmmVersion() {
        return bmm_version;
    }
    public void setBmmVersion(String value) {
        if (bmm_version == null ) {
            throw new NullPointerException(" bmm_version has cardinality NonNull, but is null")
        }
        this.bmm_version = bmm_version;
    }

/**
 * 
 * Inclusion list of any form of BMM model, in the form of a hash of individual include specifications, each of which at least specifies the id of another schema, and may specify a namespace via which types from the included schemas are known in this schema.
 * Persisted attribute.
 * cardinality: 0..1
 * 
*/

    public void putInclude(String key, BmmIncludeSpec value ) {
        if (includes == null ) {
            includes = new HashMap<> ();
        }
        includes.put( key, value);
    }

    public void putIncludes(Map<String,BmmIncludeSpec> items ) {
        items.keySet().forEach(key -> putInclude(key, items.get(key)));
    }

    public BmmIncludeSpec getInclude(String key ) {
        if (includes == null ) {
            return null;
        }
        return includes.get( key);
    }

    public void removeInclude(String key ) {
        if (includes != null ) {
            includes.remove(key);
        }
    }
    public void removeIncludes( Collection <String> keys ) {
        keys.forEach(this::removeInclude);
    }
    Map<String,BmmIncludeSpec> getIncludes() {
        return this.includes;
    }
    void setIncludes(Map<String,BmmIncludeSpec> includes) {
        this.includes = includes;
    }
    public Map<String,BmmIncludeSpec> includes() {
        return Collections.unmodifiableMap(this.includes);
    }

/**
 * 
 * Generated by create_bmm_model from persisted elements.
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
 * Current processing state.
 * cardinality: 1..1
 * 
*/
    public BmmSchemaState getState() {
        return state;
    }
    public void setState(BmmSchemaState value) {
        if (state == null ) {
            throw new NullPointerException(" state has cardinality NonNull, but is null")
        }
        this.state = state;
    }

/**
 * 
 * Name of this model, if this schema is a model root point.
 * Not set for sub-schemas that are not considered models on their own.
 * cardinality: 0..1
 * 
*/
    public String getModelName() {
        return model_name;
    }
    public void setModelName(String value) {
        this.model_name = model_name;
    }

/**
 * 
 * Name of model expressed in schema; a 'schema' usually contains all of the packages of one 'model' of a publisher.
 * A publisher with more than one model can have multiple schemas.
 * cardinality: 1..1
 * 
*/
    public String getSchemaName() {
        return schema_name;
    }
    public void setSchemaName(String value) {
        if (schema_name == null ) {
            throw new NullPointerException(" schema_name has cardinality NonNull, but is null")
        }
        this.schema_name = schema_name;
    }

/**
 * 
 * Revision of schema.
 * cardinality: 1..1
 * 
*/
    public String getSchemaRevision() {
        return schema_revision;
    }
    public void setSchemaRevision(String value) {
        if (schema_revision == null ) {
            throw new NullPointerException(" schema_revision has cardinality NonNull, but is null")
        }
        this.schema_revision = schema_revision;
    }

/**
 * 
 * Schema development lifecycle state.
 * cardinality: 1..1
 * 
*/
    public String getSchemaLifecycleState() {
        return schema_lifecycle_state;
    }
    public void setSchemaLifecycleState(String value) {
        if (schema_lifecycle_state == null ) {
            throw new NullPointerException(" schema_lifecycle_state has cardinality NonNull, but is null")
        }
        this.schema_lifecycle_state = schema_lifecycle_state;
    }

/**
 * 
 * Primary author of schema.
 * cardinality: 1..1
 * 
*/
    public String getSchemaAuthor() {
        return schema_author;
    }
    public void setSchemaAuthor(String value) {
        if (schema_author == null ) {
            throw new NullPointerException(" schema_author has cardinality NonNull, but is null")
        }
        this.schema_author = schema_author;
    }

/**
 * 
 * Description of schema.
 * cardinality: 1..1
 * 
*/
    public String getSchemaDescription() {
        return schema_description;
    }
    public void setSchemaDescription(String value) {
        if (schema_description == null ) {
            throw new NullPointerException(" schema_description has cardinality NonNull, but is null")
        }
        this.schema_description = schema_description;
    }

/**
 * 
 * Contributing authors of schema.
 * cardinality: 0..1
 * 
*/

    public void addToSchemaContributor(String value ) {
        if (schemaContributors == null ) {
            schemaContributors = new ArrayList<> ();
        }
        schemaContributors.add( value);
    }

    public void addToSchemaContributors(List<String> values ) {
        values.forEach(value -> addSchemacontributor(value));
    }

    public void removeFromSchemaContributor(String item ) {
        if (schemaContributors != null ) {
            schemaContributors.remove(item);
        }
    }
    public void removeFromSchemaContributors( Collection <String> values ) {
        values.forEach(this::removeSchemaContributor);
    }
    String getSchemaContributors() {
        return this.schemaContributors;
    }
    void setSchemaContributors(String schemaContributors) {
        this.schemaContributors = schemaContributors;
    }
    public List<String> schemaContributors() {
        return Collections.unmodifiableList(this.schemaContributors);
    }

/**
 * 
 * Main validation prior to generation of bmm_model.
 * cardinality: 0..1 (abstract)
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
 * Merge in class and package definitions from other, except where the current schema already has a definition for the given type or package.
 * cardinality: 0..1 (abstract)
 * 
*/
    public abstract includes_to_process.has (included_schema.schema_id)  merge();

/**
 * 
 * True when validation may be commenced.
 * cardinality: 1..1
 * 
*/
    public abstract state = State_includes_processed  readToValidate();

/**
 * 
 * Identifier of this schema, used for stating inclusions and identifying files.
 * Formed as: {BMM_DEFINITIONS}.create_schema_id ( rm_publisher, schema_name, rm_release) E.g.
 * "openehr_rm_ehr_1.0.4".
 * cardinality: 1..1
 * 
*/
    public abstract String  schemaId();

/*=========================================================*/
/* * CONSTANTS * */
/*=========================================================*/

/**
 * 
 * Do some basic validation post initial creation check that package structure is regular: only top-level packages can have qualified names no top-level package name can be a direct parent or child of another (child package must be declared under the parent) check that all classes are mentioned in the package structure check that all models refer to valid packages
 * 
*/
    final state validateCreated preState = State_created Post_state: passed implies state = State_validated_created;

/**
 * 
 * Finalisation work: convert packages to canonical form, i.e.
 * full hierarchy with no packages with names like aa.bb.cc set up include processing list
 * 
*/
    final state loadFinalise preState = State_validated_created Post_state: state = State_includes_processed or state = State_includes_pending;

/**
 * 
 * Populate bmm_model from schema.
 * 
*/
    final state createBmmModel preState = P_BMM_PACKAGE_STATE.State_includes_processed;

    //***** BmmModelMetadata *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * Publisher of model expressed in the schema.
 * cardinality: 1..1
 * 
*/
    private String rmPublisher;

/**
 * 
 * Release of model expressed in the schema as a 3-part numeric, e.g.
 * "3.1.0" .
 * cardinality: 1..1
 * 
*/
    private String rmRelease;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * Publisher of model expressed in the schema.
 * cardinality: 1..1
 * 
*/
    public String getRmPublisher() {
        return rm_publisher;
    }
    public void setRmPublisher(String value) {
        if (rm_publisher == null ) {
            throw new NullPointerException(" rm_publisher has cardinality NonNull, but is null")
        }
        this.rm_publisher = rm_publisher;
    }

/**
 * 
 * Release of model expressed in the schema as a 3-part numeric, e.g.
 * "3.1.0" .
 * cardinality: 1..1
 * 
*/
    public String getRmRelease() {
        return rm_release;
    }
    public void setRmRelease(String value) {
        if (rm_release == null ) {
            throw new NullPointerException(" rm_release has cardinality NonNull, but is null")
        }
        this.rm_release = rm_release;
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
