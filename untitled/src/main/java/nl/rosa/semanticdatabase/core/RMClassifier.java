package nl.rosa.semanticdatabase.referencemodel.core;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Default created on 1-5-2020
 */

@Getter
@Setter
public class RMClassifier extends RMModelElement {
    /**
     * Formal string form of the type as per UML.
     */
    private String typeName;
    /**
     * Generate a type category of main target type from Type_category_xx values.
     *
     */
    private String typeCategory;
    /**
     * Signature form of the type, which for generics includes generic parameter constrainer nl.rosa.semanticdatabase.bmm.model.types E.g. Interval&lt;T:Ordered&gt;
     */
    private String typeSignature;
    /**
     * Name of the this type in form allowing other type to be RT-conformance tested against it; 'RT' conformance means
     * 'relation-target' conformance, which abstracts away container nl.rosa.semanticdatabase.bmm.model.types like List&lt;&gt;, Set&lt;&gt; etc and compares the
     * dynamic type with the relation target type in the UML sense, i.e. regardless of whether there is single or
     * multiple containment.
     *
     */
    private String conformanceTypeName;
    /**
     * Main design class for this type, from which properties etc can be extracted.
     */
    private RMClass baseClass;
    /**
     * Completely flattened list of type names, flattening out all generic parameters.
     */
    private List<String> flattenedTypeList;
}
