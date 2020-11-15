package nl.rosa.semanticdatabase.bmm.classes;

import nl.rosa.semanticdatabase.bmm.model_structure.BmmModule;
import nl.rosa.semanticdatabase.bmm.types.BmmModelType;
import nl.rosa.semanticdatabase.bmm.model_structure.BmmPackage;
import nl.rosa.semanticdatabase.bmm.class_features.BmmProperty;
import nl.rosa.semanticdatabase.bmm.class_features.BmmConstant;
import nl.rosa.semanticdatabase.bmm.class_features.BmmFunction;
import nl.rosa.semanticdatabase.bmm.class_features.BmmProcedure;
import nl.rosa.semanticdatabase.bmm.statements.BmmAssertion;
import nl.rosa.semanticdatabase.bmm.class_features.BmmFeatureGroup;
import nl.rosa.semanticdatabase.bmm.class_features.BmmClassFeature;

/**
 * 
 * #Generated: 2020-11-15T18:16:51.043+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Meta-type corresponding a class definition in an object model.
 * Inheritance is specified by the ancestors attribute, which contains a list of types rather than classes.
 * Inheritance is thus understood in BMM as a stated relationship between classes.
 * The equivalent relationship between types is conformance.
 * Note unlike UML, the name is just the root name, even if the class is generic.
 * Use type_name() to obtain the qualified type name.
 * 
*/
public abstract class BmmClass extends BmmModule {

    //***** BmmClass *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * List of immediate inheritance parents.
 * cardinality: 0..1
 * 
*/
    private Map<String,BmmModelType> ancestors;

/**
 * 
 * Package this class belongs to.
 * cardinality: 1..1
 * 
*/
    private BmmPackage package;

/**
 * 
 * List of attributes defined in this class.
 * cardinality: 0..1
 * 
*/
    private Map<String,BmmProperty> properties;

/**
 * 
 * Reference to original source schema defining this class.
 * Useful for UI tools to determine which original schema file to open for a given class for manual editing.
 * cardinality: 1..1
 * 
*/
    private String sourceSchemaId;

/**
 * 
 * List of computed references to base classes of immediate inheritance descendants, derived when members of ancestors are attached at creation time.
 * cardinality: 0..1
 * 
*/
    private List<BmmClass> immediateDescendants;

/**
 * 
 * True if this definition overrides a class of the same name in an included schema.
 * cardinality: 1..1
 * 
*/
    private Boolean isOverride;

/**
 * 
 * List of constants defined in this class.
 * cardinality: 0..1
 * 
*/
    private Map<String,BmmConstant> constants;

/**
 * 
 * List of functions defined in this class.
 * cardinality: 0..1
 * 
*/
    private Map<String,BmmFunction> functions;

/**
 * 
 * List of procedures defined in this class.
 * cardinality: 0..1
 * 
*/
    private Map<String,BmmProcedure> procedures;

/**
 * 
 * cardinality: 0..1
 * 
*/
    private List<BmmAssertion> invariants;

/**
 * 
 * Subset of procedures that may be used to initialise a new instance of an object, and whose execution will guarantee that class invariants are satisfied.
 * cardinality: 0..1
 * 
*/
    private Map<String,BmmProcedure> creators;

/**
 * 
 * Subset of creators that create a new instance from a single argument of another type.
 * cardinality: 0..1
 * 
*/
    private Map<String,BmmProcedure> converters;

/**
 * 
 * List of feature groups in this class.
 * cardinality: 0..1
 * 
*/
    private List<BmmFeatureGroup> featureGroups;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * List of immediate inheritance parents.
 * cardinality: 0..1
 * 
*/

    public void putAncestor(String key, BmmModelType value ) {
        if (ancestors == null ) {
            ancestors = new HashMap<> ();
        }
        ancestors.put( key, value);
    }

    public void putAncestors(Map<String,BmmModelType> items ) {
        items.keySet().forEach(key -> putAncestor(key, items.get(key)));
    }

    public BmmModelType getAncestor(String key ) {
        if (ancestors == null ) {
            return null;
        }
        return ancestors.get( key);
    }

    public void removeAncestor(String key ) {
        if (ancestors != null ) {
            ancestors.remove(key);
        }
    }
    public void removeAncestors( Collection <String> keys ) {
        keys.forEach(this::removeAncestor);
    }
    Map<String,BmmModelType> getAncestors() {
        return this.ancestors;
    }
    void setAncestors(Map<String,BmmModelType> ancestors) {
        this.ancestors = ancestors;
    }
    public Map<String,BmmModelType> ancestors() {
        return Collections.unmodifiableMap(this.ancestors);
    }

/**
 * 
 * Package this class belongs to.
 * cardinality: 1..1
 * 
*/
    public BmmPackage getPackage() {
        return package;
    }
    public void setPackage(BmmPackage value) {
        if (package == null ) {
            throw new NullPointerException(" package has cardinality NonNull, but is null")
        }
        this.package = package;
    }

/**
 * 
 * List of attributes defined in this class.
 * cardinality: 0..1
 * 
*/

    public void putProperty(String key, BmmProperty value ) {
        if (properties == null ) {
            properties = new HashMap<> ();
        }
        properties.put( key, value);
    }

    public void putProperties(Map<String,BmmProperty> items ) {
        items.keySet().forEach(key -> putProperty(key, items.get(key)));
    }

    public BmmProperty getProperty(String key ) {
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
    Map<String,BmmProperty> getProperties() {
        return this.properties;
    }
    void setProperties(Map<String,BmmProperty> properties) {
        this.properties = properties;
    }
    public Map<String,BmmProperty> properties() {
        return Collections.unmodifiableMap(this.properties);
    }

/**
 * 
 * Reference to original source schema defining this class.
 * Useful for UI tools to determine which original schema file to open for a given class for manual editing.
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
 * List of computed references to base classes of immediate inheritance descendants, derived when members of ancestors are attached at creation time.
 * cardinality: 0..1
 * 
*/

    public void addToImmediateDescendant(BmmClass value ) {
        if (immediateDescendants == null ) {
            immediateDescendants = new ArrayList<> ();
        }
        immediateDescendants.add( value);
    }

    public void addToImmediateDescendants(List<BmmClass> values ) {
        values.forEach(value -> addImmediatedescendant(value));
    }

    public void removeFromImmediateDescendant(BmmClass item ) {
        if (immediateDescendants != null ) {
            immediateDescendants.remove(item);
        }
    }
    public void removeFromImmediateDescendants( Collection <BmmClass> values ) {
        values.forEach(this::removeImmediateDescendant);
    }
    BmmClass getImmediateDescendants() {
        return this.immediateDescendants;
    }
    void setImmediateDescendants(BmmClass immediateDescendants) {
        this.immediateDescendants = immediateDescendants;
    }
    public List<BmmClass> immediateDescendants() {
        return Collections.unmodifiableList(this.immediateDescendants);
    }

/**
 * 
 * True if this definition overrides a class of the same name in an included schema.
 * cardinality: 1..1
 * 
*/
    public Boolean getIsOverride() {
        return is_override;
    }
    public void setIsOverride(Boolean value) {
        if (is_override == null ) {
            throw new NullPointerException(" is_override has cardinality NonNull, but is null")
        }
        this.is_override = is_override;
    }

/**
 * 
 * List of constants defined in this class.
 * cardinality: 0..1
 * 
*/

    public void putConstant(String key, BmmConstant value ) {
        if (constants == null ) {
            constants = new HashMap<> ();
        }
        constants.put( key, value);
    }

    public void putConstants(Map<String,BmmConstant> items ) {
        items.keySet().forEach(key -> putConstant(key, items.get(key)));
    }

    public BmmConstant getConstant(String key ) {
        if (constants == null ) {
            return null;
        }
        return constants.get( key);
    }

    public void removeConstant(String key ) {
        if (constants != null ) {
            constants.remove(key);
        }
    }
    public void removeConstants( Collection <String> keys ) {
        keys.forEach(this::removeConstant);
    }
    Map<String,BmmConstant> getConstants() {
        return this.constants;
    }
    void setConstants(Map<String,BmmConstant> constants) {
        this.constants = constants;
    }
    public Map<String,BmmConstant> constants() {
        return Collections.unmodifiableMap(this.constants);
    }

/**
 * 
 * List of functions defined in this class.
 * cardinality: 0..1
 * 
*/

    public void putFunction(String key, BmmFunction value ) {
        if (functions == null ) {
            functions = new HashMap<> ();
        }
        functions.put( key, value);
    }

    public void putFunctions(Map<String,BmmFunction> items ) {
        items.keySet().forEach(key -> putFunction(key, items.get(key)));
    }

    public BmmFunction getFunction(String key ) {
        if (functions == null ) {
            return null;
        }
        return functions.get( key);
    }

    public void removeFunction(String key ) {
        if (functions != null ) {
            functions.remove(key);
        }
    }
    public void removeFunctions( Collection <String> keys ) {
        keys.forEach(this::removeFunction);
    }
    Map<String,BmmFunction> getFunctions() {
        return this.functions;
    }
    void setFunctions(Map<String,BmmFunction> functions) {
        this.functions = functions;
    }
    public Map<String,BmmFunction> functions() {
        return Collections.unmodifiableMap(this.functions);
    }

/**
 * 
 * List of procedures defined in this class.
 * cardinality: 0..1
 * 
*/

    public void putProcedure(String key, BmmProcedure value ) {
        if (procedures == null ) {
            procedures = new HashMap<> ();
        }
        procedures.put( key, value);
    }

    public void putProcedures(Map<String,BmmProcedure> items ) {
        items.keySet().forEach(key -> putProcedure(key, items.get(key)));
    }

    public BmmProcedure getProcedure(String key ) {
        if (procedures == null ) {
            return null;
        }
        return procedures.get( key);
    }

    public void removeProcedure(String key ) {
        if (procedures != null ) {
            procedures.remove(key);
        }
    }
    public void removeProcedures( Collection <String> keys ) {
        keys.forEach(this::removeProcedure);
    }
    Map<String,BmmProcedure> getProcedures() {
        return this.procedures;
    }
    void setProcedures(Map<String,BmmProcedure> procedures) {
        this.procedures = procedures;
    }
    public Map<String,BmmProcedure> procedures() {
        return Collections.unmodifiableMap(this.procedures);
    }

/**
 * 
 * cardinality: 0..1
 * 
*/

    public void addToInvariant(BmmAssertion value ) {
        if (invariants == null ) {
            invariants = new ArrayList<> ();
        }
        invariants.add( value);
    }

    public void addToInvariants(List<BmmAssertion> values ) {
        values.forEach(value -> addInvariant(value));
    }

    public void removeFromInvariant(BmmAssertion item ) {
        if (invariants != null ) {
            invariants.remove(item);
        }
    }
    public void removeFromInvariants( Collection <BmmAssertion> values ) {
        values.forEach(this::removeInvariant);
    }
    BmmAssertion getInvariants() {
        return this.invariants;
    }
    void setInvariants(BmmAssertion invariants) {
        this.invariants = invariants;
    }
    public List<BmmAssertion> invariants() {
        return Collections.unmodifiableList(this.invariants);
    }

/**
 * 
 * Subset of procedures that may be used to initialise a new instance of an object, and whose execution will guarantee that class invariants are satisfied.
 * cardinality: 0..1
 * 
*/

    public void putCreator(String key, BmmProcedure value ) {
        if (creators == null ) {
            creators = new HashMap<> ();
        }
        creators.put( key, value);
    }

    public void putCreators(Map<String,BmmProcedure> items ) {
        items.keySet().forEach(key -> putCreator(key, items.get(key)));
    }

    public BmmProcedure getCreator(String key ) {
        if (creators == null ) {
            return null;
        }
        return creators.get( key);
    }

    public void removeCreator(String key ) {
        if (creators != null ) {
            creators.remove(key);
        }
    }
    public void removeCreators( Collection <String> keys ) {
        keys.forEach(this::removeCreator);
    }
    Map<String,BmmProcedure> getCreators() {
        return this.creators;
    }
    void setCreators(Map<String,BmmProcedure> creators) {
        this.creators = creators;
    }
    public Map<String,BmmProcedure> creators() {
        return Collections.unmodifiableMap(this.creators);
    }

/**
 * 
 * Subset of creators that create a new instance from a single argument of another type.
 * cardinality: 0..1
 * 
*/

    public void putConverter(String key, BmmProcedure value ) {
        if (converters == null ) {
            converters = new HashMap<> ();
        }
        converters.put( key, value);
    }

    public void putConverters(Map<String,BmmProcedure> items ) {
        items.keySet().forEach(key -> putConverter(key, items.get(key)));
    }

    public BmmProcedure getConverter(String key ) {
        if (converters == null ) {
            return null;
        }
        return converters.get( key);
    }

    public void removeConverter(String key ) {
        if (converters != null ) {
            converters.remove(key);
        }
    }
    public void removeConverters( Collection <String> keys ) {
        keys.forEach(this::removeConverter);
    }
    Map<String,BmmProcedure> getConverters() {
        return this.converters;
    }
    void setConverters(Map<String,BmmProcedure> converters) {
        this.converters = converters;
    }
    public Map<String,BmmProcedure> converters() {
        return Collections.unmodifiableMap(this.converters);
    }

/**
 * 
 * List of feature groups in this class.
 * cardinality: 0..1
 * 
*/

    public void addToFeatureGroup(BmmFeatureGroup value ) {
        if (featureGroups == null ) {
            featureGroups = new ArrayList<> ();
        }
        featureGroups.add( value);
    }

    public void addToFeatureGroups(List<BmmFeatureGroup> values ) {
        values.forEach(value -> addFeaturegroup(value));
    }

    public void removeFromFeatureGroup(BmmFeatureGroup item ) {
        if (featureGroups != null ) {
            featureGroups.remove(item);
        }
    }
    public void removeFromFeatureGroups( Collection <BmmFeatureGroup> values ) {
        values.forEach(this::removeFeatureGroup);
    }
    BmmFeatureGroup getFeatureGroups() {
        return this.featureGroups;
    }
    void setFeatureGroups(BmmFeatureGroup featureGroups) {
        this.featureGroups = featureGroups;
    }
    public List<BmmFeatureGroup> featureGroups() {
        return Collections.unmodifiableList(this.featureGroups);
    }

/*=========================================================*/
/* * FUNCTIONS * */
/*=========================================================*/

/**
 * 
 * Generate a type object that represents the type for which this class is the definer.
 * cardinality: 1..1 (abstract)
 * 
*/
    public abstract BmmModelType  type();

/**
 * 
 * List of all inheritance parent class names, recursively.
 * cardinality: 0..1
 * 
*/
    public abstract List<String>  allAncestors();

/**
 * 
 * Compute all descendants by following immediate_descendants.
 * cardinality: 0..1
 * 
*/
    public abstract List<String>  allDescendants();

/**
 * 
 * List of names of immediate supplier classes, including concrete generic parameters, concrete descendants of abstract statically defined types, and inherited suppliers.
 * (Where generics are unconstrained, no class name is added, since logically it would be Any and this can always be assumed anyway).
 * This list includes primitive types.
 * cardinality: 0..1
 * 
*/
    public abstract List<String>  suppliers();

/**
 * 
 * Same as suppliers minus primitive types, as defined in input schema.
 * cardinality: 0..1
 * 
*/
    public abstract List<String>  suppliersNonPrimitive();

/**
 * 
 * List of names of all classes in full supplier closure, including concrete generic parameters; (where generics are unconstrained, no class name is added, since logically it would be Any and this can always be assumed anyway).
 * This list includes primitive types.
 * cardinality: 0..1
 * 
*/
    public abstract List<String>  supplierClosure();

/**
 * 
 * Fully qualified package name, of form: package.package.
 * cardinality: 1..1
 * 
*/
    public abstract String  packagePath();

/**
 * 
 * Fully qualified class name, of form: package.package.CLASS with package path in lower-case and class in original case.
 * cardinality: 1..1
 * 
*/
    public abstract String  classPath();

/**
 * 
 * True if this class is designated a primitive type within the overall type system of the schema.
 * Set from schema.
 * cardinality: 1..1
 * 
*/
    public abstract Boolean  isPrimitive();

/**
 * 
 * True if this class is abstract in its model.
 * Value provided from an underlying data property set at creation or construction time.
 * cardinality: 1..1
 * 
*/
    public abstract Boolean  isAbstract();

/**
 * 
 * List of all feature definitions introduced in this class.
 * cardinality: 0..1
 * 
*/
    public abstract List<BmmClassFeature>  features();

/**
 * 
 * Consolidated list of all feature definitions from this class and all inheritance ancestors.
 * cardinality: 0..1
 * 
*/
    public abstract List<BmmClassFeature>  flatFeatures();

/**
 * 
 * List of all properties due to current and ancestor classes, keyed by property name.
 * cardinality: 0..1
 * 
*/
    public abstract List<BmmProperty>  flatProperties();

/*=========================================================*/
/* * CONSTANTS * */
/*=========================================================*/

/**
 * 
 * True if this class represents a type considered to be primitive in the type system, i.e.
 * any typically built-in or standard library type such as String, Date, Hash<K,V> etc.
 * 
*/
    final Boolean {default isPrimitive = false};

/**
 * 
 * True if this class is marked as abstract, i.e.
 * direct instances cannot be created from its direct type.
 * 
*/
    final Boolean {default isAbstract = false};

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
