package nl.rosa.semanticdatabase.bmm_persistence.persistence_package;

import nl.rosa.semanticdatabase.bmm.classes.BmmClass;
import nl.rosa.semanticdatabase.bmm.model_structure.BmmModel;

/**
 * 
 * #Generated: 2020-11-15T18:16:51.043+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Definition of persistent form of BMM_CLASS for serialisation to ODIN, JSON, XML etc.
 * 
*/
public class PBmmClass extends PBmmModelElement {

    //***** PBmmClass *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * Name of the class.
 * Persisted attribute.
 * cardinality: 1..1
 * 
*/
    private String name;

/**
 * 
 * List of immediate inheritance parents.
 * If there are generic ancestors, use ancestor_defs instead.
 * Persisted attribute.
 * cardinality: 0..1
 * 
*/
    private List<String> ancestors;

/**
 * 
 * List of attributes defined in this class.
 * Persistent attribute.
 * cardinality: 0..1
 * 
*/
    private Map<String,PBmmProperty> properties;

/**
 * 
 * True if this is an abstract type.
 * Persisted attribute.
 * cardinality: 0..1
 * 
*/
    private Boolean isAbstract;

/**
 * 
 * True if this class definition overrides one found in an included schema.
 * cardinality: 0..1
 * 
*/
    private Boolean isOverride;

/**
 * 
 * List of generic parameter definitions.
 * Persisted attribute.
 * cardinality: 0..1
 * 
*/
    private Map<String,PBmmGenericParameter> genericParameterDefs;

/**
 * 
 * Reference to original source schema defining this class.
 * Set during BMM_SCHEMA materialise.
 * Useful for GUI tools to enable user to edit the schema file containing a given class (i.e.
 * taking into account that a class may be in any of the schemas in a schema inclusion hierarchy).
 * cardinality: 1..1
 * 
*/
    private String sourceSchemaId;

/**
 * 
 * BMM_CLASS object built by create_bmm_class_definition and populate_bmm_class_definition.
 * cardinality: 0..1
 * 
*/
    private BmmClass bmmClass;

/**
 * 
 * Unique id generated for later comparison during merging, in order to detect if two classes are the same.
 * Assigned in post-load processing.
 * cardinality: 1..1
 * 
*/
    private Integer uid;

/**
 * 
 * List of structured inheritance ancestors, used only in the case of generic inheritance.
 * Persisted attribute.
 * cardinality: 0..1
 * 
*/
    private List<PBmmGenericType> ancestorDefs;

/**
 * 
 * Create bmm_class_definition.
 * cardinality: 0..1
 * 
*/
    private  ;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * Name of the class.
 * Persisted attribute.
 * cardinality: 1..1
 * 
*/
    public String getName() {
        return name;
    }
    public void setName(String value) {
        if (name == null ) {
            throw new NullPointerException(" name has cardinality NonNull, but is null")
        }
        this.name = name;
    }

/**
 * 
 * List of immediate inheritance parents.
 * If there are generic ancestors, use ancestor_defs instead.
 * Persisted attribute.
 * cardinality: 0..1
 * 
*/

    public void addToAncestor(String value ) {
        if (ancestors == null ) {
            ancestors = new ArrayList<> ();
        }
        ancestors.add( value);
    }

    public void addToAncestors(List<String> values ) {
        values.forEach(value -> addAncestor(value));
    }

    public void removeFromAncestor(String item ) {
        if (ancestors != null ) {
            ancestors.remove(item);
        }
    }
    public void removeFromAncestors( Collection <String> values ) {
        values.forEach(this::removeAncestor);
    }
    String getAncestors() {
        return this.ancestors;
    }
    void setAncestors(String ancestors) {
        this.ancestors = ancestors;
    }
    public List<String> ancestors() {
        return Collections.unmodifiableList(this.ancestors);
    }

/**
 * 
 * List of attributes defined in this class.
 * Persistent attribute.
 * cardinality: 0..1
 * 
*/

    public void putProperty(String key, PBmmProperty value ) {
        if (properties == null ) {
            properties = new HashMap<> ();
        }
        properties.put( key, value);
    }

    public void putProperties(Map<String,PBmmProperty> items ) {
        items.keySet().forEach(key -> putProperty(key, items.get(key)));
    }

    public PBmmProperty getProperty(String key ) {
        if (properties == null ) {
            return null;
        }
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
    Map<String,PBmmProperty> getProperties() {
        return this.properties;
    }
    void setProperties(Map<String,PBmmProperty> properties) {
        this.properties = properties;
    }
    public Map<String,PBmmProperty> properties() {
        return Collections.unmodifiableMap(this.properties);
    }

/**
 * 
 * True if this is an abstract type.
 * Persisted attribute.
 * cardinality: 0..1
 * 
*/
    public Boolean getIsAbstract() {
        return is_abstract;
    }
    public void setIsAbstract(Boolean value) {
        this.is_abstract = is_abstract;
    }

/**
 * 
 * True if this class definition overrides one found in an included schema.
 * cardinality: 0..1
 * 
*/
    public Boolean getIsOverride() {
        return is_override;
    }
    public void setIsOverride(Boolean value) {
        this.is_override = is_override;
    }

/**
 * 
 * List of generic parameter definitions.
 * Persisted attribute.
 * cardinality: 0..1
 * 
*/

    public void putGenericparameterdef(String key, PBmmGenericParameter value ) {
        if (genericParameterDefs == null ) {
            genericParameterDefs = new HashMap<> ();
        }
        genericParameterDefs.put( key, value);
    }

    public void putGenericparameterdefs(Map<String,PBmmGenericParameter> items ) {
        items.keySet().forEach(key -> putGenericparameterdef(key, items.get(key)));
    }

    public PBmmGenericParameter getGenericparameterdef(String key ) {
        if (genericParameterDefs == null ) {
            return null;
        }
        return genericParameterDefs.get( key);
    }

    public void removeGenericparameterdef(String key ) {
        if (genericParameterDefs != null ) {
            genericParameterDefs.remove(key);
        }
    }
    public void removeGenericparameterdefs( Collection <String> keys ) {
        keys.forEach(this::removeGenericparameterdef);
    }
    Map<String,PBmmGenericParameter> getGenericparameterdefs() {
        return this.genericParameterDefs;
    }
    void setGenericparameterdefs(Map<String,PBmmGenericParameter> genericParameterDefs) {
        this.genericParameterDefs = genericParameterDefs;
    }
    public Map<String,PBmmGenericParameter> genericParameterDefs() {
        return Collections.unmodifiableMap(this.genericParameterDefs);
    }

/**
 * 
 * Reference to original source schema defining this class.
 * Set during BMM_SCHEMA materialise.
 * Useful for GUI tools to enable user to edit the schema file containing a given class (i.e.
 * taking into account that a class may be in any of the schemas in a schema inclusion hierarchy).
 * cardinality: 1..1
 * 
*/
    public String getSourceSchemaId() {
        return source_schema_id;
    }
    public void setSourceSchemaId(String value) {
        if (source_schema_id == null ) {
            throw new NullPointerException(" source_schema_id has cardinality NonNull, but is null")
        }
        this.source_schema_id = source_schema_id;
    }

/**
 * 
 * BMM_CLASS object built by create_bmm_class_definition and populate_bmm_class_definition.
 * cardinality: 0..1
 * 
*/
    public BmmClass getBmmClass() {
        return bmm_class;
    }
    public void setBmmClass(BmmClass value) {
        this.bmm_class = bmm_class;
    }

/**
 * 
 * Unique id generated for later comparison during merging, in order to detect if two classes are the same.
 * Assigned in post-load processing.
 * cardinality: 1..1
 * 
*/
    public Integer getUid() {
        return uid;
    }
    public void setUid(Integer value) {
        if (uid == null ) {
            throw new NullPointerException(" uid has cardinality NonNull, but is null")
        }
        this.uid = uid;
    }

/**
 * 
 * List of structured inheritance ancestors, used only in the case of generic inheritance.
 * Persisted attribute.
 * cardinality: 0..1
 * 
*/

    public void addToAncestorDef(PBmmGenericType value ) {
        if (ancestorDefs == null ) {
            ancestorDefs = new ArrayList<> ();
        }
        ancestorDefs.add( value);
    }

    public void addToAncestorDefs(List<PBmmGenericType> values ) {
        values.forEach(value -> addAncestordef(value));
    }

    public void removeFromAncestorDef(PBmmGenericType item ) {
        if (ancestorDefs != null ) {
            ancestorDefs.remove(item);
        }
    }
    public void removeFromAncestorDefs( Collection <PBmmGenericType> values ) {
        values.forEach(this::removeAncestorDef);
    }
    PBmmGenericType getAncestorDefs() {
        return this.ancestorDefs;
    }
    void setAncestorDefs(PBmmGenericType ancestorDefs) {
        this.ancestorDefs = ancestorDefs;
    }
    public List<PBmmGenericType> ancestorDefs() {
        return Collections.unmodifiableList(this.ancestorDefs);
    }

/**
 * 
 * Create bmm_class_definition.
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
 * True if this class is a generic class.
 * cardinality: 1..1
 * 
*/
    public abstract = generic_parameter_defs /= Void  isGeneric();

/**
 * 
 * Add remaining model elements from Current to bmm_class_definition.
 * cardinality: 0..1
 * 
*/
    public abstract void  populateBmmClass();

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
