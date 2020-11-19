package nl.rosa.semanticdatabase.bmm.classes;

import nl.rosa.semanticdatabase.foundation_types.primitive_types.String;
import nl.rosa.semanticdatabase.bmm.literal_values.BmmPrimitiveValue;

/**
 * 
 * #Generated: 2020-11-19T08:28:08.518+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Definition of an enumeration class, understood as a class whose value range is constrained extensionally, i.e.
 * by an explicit enumeration of named singleton instances.
 * Only one inheritance ancestor is allowed in order to provide the base type to which the range constraint is applied.
 * The common notion of a set of literals with no explicit defined values is represented as the degenerate subtype BMM_ENUMERATION_INTEGER, whose values are 0, 1, …​
 * 
*/
public class BmmEnumeration extends BmmSimpleClass {

    //***** BmmEnumeration *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * The list of names of the enumeration.
 * If no values are supplied, the integer values 0, 1, 2, …​ are assumed.
 * cardinality: 0..1
 * 
*/
    private List<String> itemNames;

/**
 * 
 * Optional list of specific values.
 * Must be 1:1 with item_names list.
 * cardinality: 0..1
 * 
*/
    private List<BmmPrimitiveValue> itemValues;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * The list of names of the enumeration.
 * If no values are supplied, the integer values 0, 1, 2, …​ are assumed.
 * cardinality: 0..1
 * 
*/

    public void addToItemName(String value ) {
        if (itemNames == null ) {
            itemNames = new ArrayList<> ();
        }
        itemNames.add( value);
    }

    public void addToItemNames(List<String> values ) {
        values.forEach(value -> addItemname(value));
    }

    public void removeFromItemName(String item ) {
        if (itemNames != null ) {
            itemNames.remove(item);
        }
    }
    public void removeFromItemNames( Collection <String> values ) {
        values.forEach(this::removeItemName);
    }
    String getItemNames() {
        return this.itemNames;
    }
    public BmmEnumeration setItemNames(String itemNames) {
        this.itemNames = itemNames;
        return this;
    }
    public List<String> itemNames() {
        return Collections.unmodifiableList(this.itemNames);
    }

/**
 * 
 * Optional list of specific values.
 * Must be 1:1 with item_names list.
 * cardinality: 0..1
 * 
*/

    public void addToItemValue(BmmPrimitiveValue value ) {
        if (itemValues == null ) {
            itemValues = new ArrayList<> ();
        }
        itemValues.add( value);
    }

    public void addToItemValues(List<BmmPrimitiveValue> values ) {
        values.forEach(value -> addItemvalue(value));
    }

    public void removeFromItemValue(BmmPrimitiveValue item ) {
        if (itemValues != null ) {
            itemValues.remove(item);
        }
    }
    public void removeFromItemValues( Collection <BmmPrimitiveValue> values ) {
        values.forEach(this::removeItemValue);
    }
    BmmPrimitiveValue getItemValues() {
        return this.itemValues;
    }
    public BmmEnumeration setItemValues(BmmPrimitiveValue itemValues) {
        this.itemValues = itemValues;
        return this;
    }
    public List<BmmPrimitiveValue> itemValues() {
        return Collections.unmodifiableList(this.itemValues);
    }

/*=========================================================*/
/* * FUNCTIONS * */
/*=========================================================*/

/**
 * 
 * Map of item_names to item_values (stringified).
 * cardinality: 1..1
 * 
*/
    public Map<String, String>  nameMap() {
        Map<String, String>  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

    //***** BmmEnumeration *****

/*=========================================================*/
/* * BUILD PATTERN AND CONSTRUCTOR * */
/*=========================================================*/

    public BmmEnumeration build() {
        return new BmmEnumeration(
            itemNames,
            itemValues,
            ancestors,
            package,
            properties,
            sourceSchemaId,
            immediateDescendants,
            isOverride,
            constants,
            functions,
            procedures,
            invariants,
            creators,
            converters,
            featureGroups,
            scope,
            name,
            documentation,
            scope,
            extensions
        );
    }

    public BmmEnumeration(
            List<String> itemNames,
            List<BmmPrimitiveValue> itemValues,
            Map<String,BmmModelType> ancestors,
            BmmPackage package,
            Map<String,BmmProperty> properties,
            String sourceSchemaId,
            List<BmmClass> immediateDescendants,
            Boolean isOverride,
            Map<String,BmmConstant> constants,
            Map<String,BmmFunction> functions,
            Map<String,BmmProcedure> procedures,
            List<BmmAssertion> invariants,
            Map<String,BmmProcedure> creators,
            Map<String,BmmProcedure> converters,
            List<BmmFeatureGroup> featureGroups,
            BmmModel scope,
            String name,
            Map<String, Any> documentation,
            BmmDeclaration scope,
            Map<String, Any> extensions
    ){
        if ( package == null ) {
            throw new NullPointerException("Property:package has cardinality NonNull, but is null");
        }
        if ( sourceSchemaId == null ) {
            throw new NullPointerException("Property:sourceSchemaId has cardinality NonNull, but is null");
        }
        if ( isOverride == null ) {
            throw new NullPointerException("Property:isOverride has cardinality NonNull, but is null");
        }
        if ( scope == null ) {
            throw new NullPointerException("Property:scope has cardinality NonNull, but is null");
        }
        if ( name == null ) {
            throw new NullPointerException("Property:name has cardinality NonNull, but is null");
        }
        if ( scope == null ) {
            throw new NullPointerException("Property:scope has cardinality NonNull, but is null");
        }
        this.itemNames = itemNames;
        this.itemValues = itemValues;
        this.ancestors = ancestors;
        this.package = package;
        this.properties = properties;
        this.sourceSchemaId = sourceSchemaId;
        this.immediateDescendants = immediateDescendants;
        this.isOverride = isOverride;
        this.constants = constants;
        this.functions = functions;
        this.procedures = procedures;
        this.invariants = invariants;
        this.creators = creators;
        this.converters = converters;
        this.featureGroups = featureGroups;
        this.scope = scope;
        this.name = name;
        this.documentation = documentation;
        this.scope = scope;
        this.extensions = extensions;
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
