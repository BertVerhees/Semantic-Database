package nl.rosa.semanticdatabase.bmm.classes;

import nl.rosa.semanticdatabase.bmm.literal_values.BmmIntegerValue;

/**
 * 
 * #Generated: 2020-11-19T08:28:08.518+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Integer-based enumeration meta-type.
 * 
*/
public class BmmEnumerationInteger extends BmmEnumeration {

    //***** BmmEnumerationInteger *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * Optional list of specific values.
 * Must be 1:1 with item_names list.
 * cardinality: 0..1 (redefined)
 * 
*/
    private List<BmmIntegerValue> itemValues;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * Optional list of specific values.
 * Must be 1:1 with item_names list.
 * cardinality: 0..1 (redefined)
 * 
*/

    public void addToItemValue(BmmIntegerValue value ) {
        if (itemValues == null ) {
            itemValues = new ArrayList<> ();
        }
        itemValues.add( value);
    }

    public void addToItemValues(List<BmmIntegerValue> values ) {
        values.forEach(value -> addItemvalue(value));
    }

    public void removeFromItemValue(BmmIntegerValue item ) {
        if (itemValues != null ) {
            itemValues.remove(item);
        }
    }
    public void removeFromItemValues( Collection <BmmIntegerValue> values ) {
        values.forEach(this::removeItemValue);
    }
    BmmIntegerValue getItemValues() {
        return this.itemValues;
    }
    public BmmEnumerationInteger setItemValues(BmmIntegerValue itemValues) {
        this.itemValues = itemValues;
        return this;
    }
    public List<BmmIntegerValue> itemValues() {
        return Collections.unmodifiableList(this.itemValues);
    }

    //***** BmmEnumerationInteger *****

/*=========================================================*/
/* * BUILD PATTERN AND CONSTRUCTOR * */
/*=========================================================*/

    public BmmEnumerationInteger build() {
        return new BmmEnumerationInteger(
            itemValues,
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

    public BmmEnumerationInteger(
            List<BmmIntegerValue> itemValues,
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
        this.itemValues = itemValues;
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
