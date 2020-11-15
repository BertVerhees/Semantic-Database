package nl.rosa.semanticdatabase.bmm.model_structure;

import nl.rosa.semanticdatabase.bmm.model_access_package.BmmModelMetadata;
import nl.rosa.semanticdatabase.bmm.classes.BmmClass;
import nl.rosa.semanticdatabase.bmm.classes.BmmEnumeration;
import nl.rosa.semanticdatabase.bmm.class_features.BmmProperty;
import nl.rosa.semanticdatabase.bmm.classes.BmmSimpleClass;
import nl.rosa.semanticdatabase.bmm.types.BmmSimpleType;

/**
 * 
 * #Generated: 2020-11-15T18:16:51.043+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Definition of the root of a BMM model (along with what is inherited from BMM_SCHEMA_CORE).
 * 
*/
public class BmmModel extends BmmPackageContainer implements BmmModelMetadata {

    //***** BmmModel *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * All classes in this model, keyed by type name.
 * cardinality: 0..1
 * 
*/
    private Map<String,BmmClass> classDefinitions;

/**
 * 
 * List of other models 'used' (i.e.
 * 'imported' by this model).
 * Classes in the current model may refer to classes in a used model by specifying the other class’s scope meta-attribute.
 * cardinality: 0..1
 * 
*/
    private List<BmmModel> usedModels;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * All classes in this model, keyed by type name.
 * cardinality: 0..1
 * 
*/

    public void putClassdefinition(String key, BmmClass value ) {
        if (classDefinitions == null ) {
            classDefinitions = new HashMap<> ();
        }
        classDefinitions.put( key, value);
    }

    public void putClassdefinitions(Map<String,BmmClass> items ) {
        items.keySet().forEach(key -> putClassdefinition(key, items.get(key)));
    }

    public BmmClass getClassdefinition(String key ) {
        if (classDefinitions == null ) {
            return null;
        }
        return classDefinitions.get( key);
    }

    public void removeClassdefinition(String key ) {
        if (classDefinitions != null ) {
            classDefinitions.remove(key);
        }
    }
    public void removeClassdefinitions( Collection <String> keys ) {
        keys.forEach(this::removeClassdefinition);
    }
    Map<String,BmmClass> getClassdefinitions() {
        return this.classDefinitions;
    }
    void setClassdefinitions(Map<String,BmmClass> classDefinitions) {
        this.classDefinitions = classDefinitions;
    }
    public Map<String,BmmClass> classDefinitions() {
        return Collections.unmodifiableMap(this.classDefinitions);
    }

/**
 * 
 * List of other models 'used' (i.e.
 * 'imported' by this model).
 * Classes in the current model may refer to classes in a used model by specifying the other class’s scope meta-attribute.
 * cardinality: 0..1
 * 
*/

    public void addToUsedModel(BmmModel value ) {
        if (usedModels == null ) {
            usedModels = new ArrayList<> ();
        }
        usedModels.add( value);
    }

    public void addToUsedModels(List<BmmModel> values ) {
        values.forEach(value -> addUsedmodel(value));
    }

    public void removeFromUsedModel(BmmModel item ) {
        if (usedModels != null ) {
            usedModels.remove(item);
        }
    }
    public void removeFromUsedModels( Collection <BmmModel> values ) {
        values.forEach(this::removeUsedModel);
    }
    BmmModel getUsedModels() {
        return this.usedModels;
    }
    void setUsedModels(BmmModel usedModels) {
        this.usedModels = usedModels;
    }
    public List<BmmModel> usedModels() {
        return Collections.unmodifiableList(this.usedModels);
    }

/*=========================================================*/
/* * FUNCTIONS * */
/*=========================================================*/

/**
 * 
 * Identifier of this model, lower-case, formed from: <rm_publisher>_<model_name>_<rm_release> E.g.
 * "openehr_ehr_1.0.4".
 * cardinality: 1..1
 * 
*/
    public abstract String  modelId();

/**
 * 
 * Retrieve the class definition corresponding to a_type_name (which may contain a generic part).
 * cardinality: 1..1
 * 
*/
    public abstract BmmClass  classDefinition();

/**
 * 
 * Retrieve the class definition corresponding to a_type_name.
 * If it contains a generic part, this will be removed if it is a fully open generic name, otherwise it will remain intact, i.e.
 * if it is an effective generic name that identifies a BMM_GENERIC_CLASS_EFFECTIVE.
 * cardinality: 1..1
 * 
*/
    public abstract BmmClass  typeDefinition();

/**
 * 
 * True if a_class_name has a class definition in the model.
 * cardinality: 1..1
 * 
*/
    public abstract Boolean  hasClassDefinition();

/**
 * 
 * True if a_type_name is already concretely known in the system, including if it is generic, which may be open, partially open or closed.
 * cardinality: 1..1
 * 
*/
    public abstract Boolean  hasTypeDefinition();

/**
 * 
 * Retrieve the enumeration definition corresponding to a_type_name.
 * cardinality: 1..1
 * 
*/
    public abstract BmmEnumeration  enumerationDefinition();

/**
 * 
 * List of keys in class_definitions of items marked as primitive types.
 * cardinality: 0..1
 * 
*/
    public abstract List<String>  primitiveTypes();

/**
 * 
 * List of keys in class_definitions of items that are enumeration types.
 * cardinality: 0..1
 * 
*/
    public abstract List<String>  enumerationTypes();

/**
 * 
 * Retrieve the property definition for a_prop_name in flattened class corresponding to a_type_name.
 * cardinality: 1..1
 * 
*/
    public abstract BmmProperty  propertyDefinition();

/**
 * 
 * True if a_ms_property_type is a valid 'MS' dynamic type for a_property in BMM type a_bmm_type_name.
 * 'MS' conformance means 'model-semantic' conformance, which abstracts away container types like List<>, Set<> etc and compares the dynamic type with the relation target type in the UML sense, i.e.
 * regardless of whether there is single or multiple containment.
 * cardinality: 1..1
 * 
*/
    public abstract Boolean  msConformantPropertyType();

/**
 * 
 * Retrieve the property definition for a_property_path in flattened class corresponding to a_type_name.
 * cardinality: 1..1
 * 
*/
    public abstract BmmProperty  propertyDefinitionAtPath();

/**
 * 
 * Retrieve the class definition for the class that owns the terminal attribute in a_prop_path in flattened class corresponding to a_type_name.
 * cardinality: 1..1
 * 
*/
    public abstract BmmClass  classDefinitionAtPath();

/**
 * 
 * Return all ancestor types of a_class_name up to root class (usually Any, Object or something similar).
 * Does not include current class.
 * Returns empty list if none.
 * cardinality: 0..1
 * 
*/
    public abstract List<String>  allAncestorClasses();

/**
 * 
 * True if a_class_name is a descendant in the model of a_parent_class_name.
 * cardinality: 1..1
 * 
*/
    public abstract Boolean  isDescendantOf();

/**
 * 
 * Check conformance of a_desc_type to an_anc_type; the types may be generic, and may contain open generic parameters like 'T' etc.
 * These are replaced with their appropriate constrainer types, or Any during the conformance testing process.
 * Conformance is found if: [base class test] types are non-generic, and either type names are identical, or else a_desc_type has an_anc_type in its ancestors; both types are generic and pass base class test; number of generic params matches, and each generic parameter type, after 'open parameter' substitution, recursively passes; type_name_conforms_to test descendant type is generic and ancestor type is not, and they pass base classes test.
 * cardinality: 1..1
 * 
*/
    public abstract Boolean  typeConformsTo();

/**
 * 
 * Generate type substitutions for the supplied type, which may be simple, generic (closed, open or partially open), or a container type.
 * In the generic and container cases, the result is the permutation of the base class type and type substitutions of all generic parameters.
 * Parameters a_type Name of a type.
 * cardinality: 1..1
 * 
*/
    public abstract List<String>  subtypes();

/**
 * 
 * BMM_SIMPLE_CLASS instance for the Any class.
 * This may be defined in the BMM schema, but if not, use BMM_DEFINITIONS.any_class.
 * cardinality: 1..1
 * 
*/
    public abstract BmmSimpleClass  anyClassDefinition();

/**
 * 
 * BMM_SIMPLE_TYPE instance for the Any type.
 * cardinality: 1..1
 * 
*/
    public abstract BmmSimpleType  anyTypeDefinition();

/**
 * 
 * BMM_SIMPLE_TYPE instance for the Boolean type.
 * cardinality: 1..1
 * 
*/
    public abstract BmmSimpleType  booleanTypeDefinition();

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
